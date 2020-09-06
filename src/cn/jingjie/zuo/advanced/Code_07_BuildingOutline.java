package cn.jingjie.zuo.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

// ʹ��ƽ������������
// ��¥����������˼�룬��¼�߶ȷ����仯��λ�ü��߶�
public class Code_07_BuildingOutline {
	// ���������¥���ݵĲ������
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
			// ���λ����ͬ,����ͬ��up������ǰ��,
			if(o1.isUp != o2.isUp) {
				return o1.isUp ? -1:1;
			}
			// ������ͬ������Ȼ˳��
			return 0;
		}
	}
	
	public static List<List<Integer>> buildingOutline(int[][] matrix) {
		// ��ִ�¥���ݣ���[1, 3, 3]��Ϊ����[1, 3, ��]��[3, 3, ��]
		Node[] nodes = new Node[matrix.length*2];
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				nodes[i*2] = new Node(true, matrix[i][0], matrix[i][2]);
				nodes[i*2 + 1] = new Node(false, matrix[i][1], matrix[i][2]);
			}
		}
		Arrays.sort(nodes, new nodeComparator());
		// ��Ÿ߶Ⱥ͸߶ȳ��ֵĴ���
		TreeMap<Integer, Integer> htTreeMap = new TreeMap<>();
		// ���ÿ��λ�õ���ߴ�¥�߶�
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
			// �߶ȷ����仯���ſ��ܳ��������仯
			if(curHeight != preHeight) {
				// ǰ�߲���0�������õ�һ���¥����������
				if(preHeight != 0) {
					List<Integer> outlineData = new ArrayList<>();
					outlineData.add(start);
					outlineData.add(pos);
					outlineData.add(preHeight);
					res.add(outlineData);
				}
				// ����һ����¥��������ʼλ�ú͸߶�
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
			// ��list��Ϊ��ͨ������
			Integer[] ll = l.toArray(new Integer[3]);
			System.out.println(Arrays.toString(ll));
		}
	}
}
