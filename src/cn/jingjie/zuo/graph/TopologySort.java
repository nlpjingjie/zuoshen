package cn.jingjie.zuo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {// ͼ����������,��Ҫ���нڵ㼰����ȣ�������ȵ�ֵ�Ƿ�Ϊ0�жϸýڵ��Ƿ�����һ��Ҫ�ӽ��б�Ľڵ�
	public static List<Node> topologySort(Graph graph){ // ������ͼ�Ľڵ������������ 
		HashMap<Node, Integer> inMap = new HashMap<>(); // ��Žڵ㼰��ȵ���Ϣ
		Queue<Node> zeroIn = new LinkedList<Node>(); // ������Ϊ0�Ľڵ�
		
		for(Node node:graph.nodes.values()) {  // ����ȡͼ�����еĽڵ㣬values��������ȡmap�е�����ֵ
			inMap.put(node,node.in);
			if(node.in == 0) {
				zeroIn.offer(node);
			}
		}
		
		List<Node> result = new ArrayList<>(); // �������������
		while(!zeroIn.isEmpty()) {
			Node cur = zeroIn.poll();
			result.add(cur);
			for(Node node:cur.nexts){// ���ڽӵ�����ֵ��1�����Ϊ0�������Ž�zeroIn��
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
