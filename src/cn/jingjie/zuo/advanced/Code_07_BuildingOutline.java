package cn.jingjie.zuo.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

// 使用平衡搜索二叉树
// 大楼轮廓。核心思想，记录高度发生变化的位置及高度
public class Code_07_BuildingOutline {
	// 用来保存大楼数据的拆分数据
	public static class Node{
		public boolean isUp;
		public int position;
		public int h;
		
		public Node(boolean isUp, int position, int h) {
			this.isUp = isUp;
			this.position = position;
			this.h = h;
		}
	}
	
	public static class nodeComparator implements Comparator<Node>{
		public int compare(Node o1, Node o2) {
			if(o1.position != o2.position) {
				return o1.position - o2.position;
			}
			// 如果位置相同,方向不同，up的排在前面,
			if(o1.isUp != o2.isUp) {
				return o1.isUp ? -1:1;
			}
			// 方向相同按照自然顺序
			return 0;
		}
	}
	
	public static List<List<Integer>> buildingOutline(int[][] matrix) {
		// 拆分大楼数据，如[1, 3, 3]拆为类似[1, 3, 上]和[3, 3, 下]
		Node[] nodes = new Node[matrix.length*2];
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				nodes[i*2] = new Node(true, matrix[i][0], matrix[i][2]);
				nodes[i*2 + 1] = new Node(false, matrix[i][1], matrix[i][2]);
			}
		}
		Arrays.sort(nodes, new nodeComparator());
		// 存放高度和高度出现的次数
		TreeMap<Integer, Integer> htTreeMap = new TreeMap<>();
		// 存放每个位置的最高大楼高度
		TreeMap<Integer, Integer> pmTreeMap = new TreeMap<>();
		for(Node node:nodes) {
			if(node.isUp) {
				if(!htTreeMap.containsKey(node.h)) {
					htTreeMap.put(node.h, 1);
				}else {
					htTreeMap.put(node.h, 1+htTreeMap.get(node.h));
				}
			}else {
				if(htTreeMap.get(node.h) == 1) {
					htTreeMap.remove(node.h);
				}else {
					htTreeMap.put(node.h, htTreeMap.get(node.h) - 1);
				}
			}
			
			if(htTreeMap.isEmpty()) {
				pmTreeMap.put(node.position, 0);
			}else {
				pmTreeMap.put(node.position, htTreeMap.lastKey());
			}
		}
		
		List<List<Integer>> res = new ArrayList<>();
		Integer preHeight = 0;
		Integer start = 0;
		for(Integer pos:pmTreeMap.keySet()) {
			Integer curHeight = pmTreeMap.get(pos);
			// 高度发生变化，才可能出现轮廓变化
			if(curHeight != preHeight) {
				// 前高不是0，才能拿到一组大楼的轮廓数据
				if(preHeight != 0) {
					List<Integer> outlineData = new ArrayList<>();
					outlineData.add(start);
					outlineData.add(pos);
					outlineData.add(preHeight);
					res.add(outlineData);
				}
				// 更新一个大楼轮廓的起始位置和高度
				start = pos;
				preHeight = curHeight;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 3}, 
						  {2, 4, 4},
						  {5, 6, 1}};
		List<List<Integer>> res = buildingOutline(matrix);
		for(List<Integer> l:res) {
			// 将list变为普通的数组
			Integer[] ll = l.toArray(new Integer[3]);
			System.out.println(Arrays.toString(ll));
		}
	}
}
