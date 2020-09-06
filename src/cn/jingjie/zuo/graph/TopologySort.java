package cn.jingjie.zuo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {// 图的拓扑排序,需要所有节点及其入度，根据入度的值是否为0判断该节点是否是下一个要加进列表的节点
	public static List<Node> topologySort(Graph graph){ // 对整张图的节点进行拓扑排序 
		HashMap<Node, Integer> inMap = new HashMap<>(); // 存放节点及入度的信息
		Queue<Node> zeroIn = new LinkedList<Node>(); // 存放入度为0的节点
		
		for(Node node:graph.nodes.values()) {  // 遍历取图中所有的节点，values方法可以取map中的所有值
			inMap.put(node,node.in);
			if(node.in == 0) {
				zeroIn.offer(node);
			}
		}
		
		List<Node> result = new ArrayList<>(); // 用来存放排序结果
		while(!zeroIn.isEmpty()) {
			Node cur = zeroIn.poll();
			result.add(cur);
			for(Node node:cur.nexts){// 将邻接点的入度值减1，如果为0，继续放进zeroIn中
				inMap.put(node, --node.in);
				if(node.in == 0) {
					zeroIn.offer(node);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Integer[][] matrix = {{1, 3, 5},
						 	  {2, 4, 6},
						 	  {3, 5, 4},
						 	  {2, 6, 7},
						 	  {1, 3, 6},
						 	  {2, 4, 7}};
		Graph graph = GraphGenerator.createGraph(matrix);
		List<Node> r = topologySort(graph);
		for(Node n:r) {
			System.out.print(n.value + " ");
		}
	}
}
