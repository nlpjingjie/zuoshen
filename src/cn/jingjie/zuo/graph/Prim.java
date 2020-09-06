package cn.jingjie.zuo.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Prim { // ������㿪ʼ������˵������ĵ�֮��Ȩ����С�ıߣ�����Щ�����ҵ�ͬ����������Ҫ��ıߣ�֪���������еĵ�
	
	public static class Edgecomparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}
	
	public static Set<Edge> primMST(Graph graph){
		Set<Node> nodeSet = new HashSet<>(); // ���������Ѿ������жϵĵ�
		Set<Edge> result = new HashSet<>(); // ����������
		Queue<Edge> priorityQueue = new PriorityQueue<>(new Edgecomparator()); // ��������Ȩֵ��С�ı�
		
		for(Node node:graph.nodes.values()) { // ��ֹ������ͨͼ�����������ɭ�֣����Ҳ�������������
			if(!nodeSet.contains(node)) { // ��node��ʼ����С������
				nodeSet.add(node); // ���жϹ��ĵ�ӽ�����
				for(Edge e:node.edge) { // node�������ڽӱ߼ӽ����ȼ�����
					priorityQueue.offer(e);
				}
				while(!priorityQueue.isEmpty()) { //  ��ʼ��Ȩ����С�ı�
					Edge edge = priorityQueue.poll(); // ����Ȩ����С�ı�
					Node to = edge.to;
					
					if(!nodeSet.contains(to)) { // ��֤û���������ǿ�����չ�ĵ�
						result.add(edge); // ������չ�ıߣ��ӽ������
						nodeSet.add(to);
						for(Edge e:to.edge) { // 
							priorityQueue.offer(e);
						}
					}
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
		Set<Edge> r = primMST(graph);
		for(Edge e:r) {
			System.out.println(e.weight + " " + e.from.value + " " + e.to.value);
		}
	}
}
