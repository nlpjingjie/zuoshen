package cn.jingjie.zuo.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


// Ҫ������ͼ�����Ǵ���������ͼ���Ǵ���������ֲ�������ͼ
public class Kruskal {// ʼ��ѡ��ǰ���õ���С��Ȩ�ıߣ���ʵʱ�ж�������֮����û�м����ͨ��
	
	
/*	public static class Node{
		public Integer value;
		
		public Node(Integer data) {
			value = data;
		}
	}*/
	
	
	public static class UnionFindSet {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> sizeMap;
		
		public UnionFindSet() {
			this.fatherMap = new HashMap<Node, Node>();
			this.sizeMap = new HashMap<Node, Integer>();
		}
		
		public void makeSets(Collection<Node> collection) {// ����ԭʼ���鼯
			fatherMap.clear();
			sizeMap.clear();
			for(Node node:collection) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		public Node findHead(Node n) { // �ҵ�����ڵ㲢�ұ�ƽ������
			Node father = fatherMap.get(n);
			if(father != n) {
				father = findHead(father);
			}
			fatherMap.put(n, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) { // �ж��Ƿ���һ������
			return findHead(a) == findHead(b);
		}
		
		public void union(Node a, Node b) { // �ϲ������ڵ�������ļ���
			Node headA = findHead(a);
			Node headB = findHead(b);
			if(headA != headB) {
				Integer sizeOfA = sizeMap.get(a);
				Integer sizeOfB = sizeMap.get(b);
				if(sizeOfA >= sizeOfB) {
				fatherMap.put(headB, headA);
				sizeMap.put(headA, sizeMap.get(headA) + sizeMap.get(headB));
				}else {
					fatherMap.put(headA, headB);
					sizeMap.put(headB, sizeMap.get(headA) + sizeMap.get(headB));
				}
			}
			
		}
	}
	
	
	// ���ߵ�Ȩ�ش�С�Ƚ�
	public static class EdgeComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}

	
	public static Set<Edge> KruskalMST(Graph graph){ // Kruskal��С�������㷨
		UnionFindSet unionFind = new UnionFindSet(); // ʹ�ò��鼯ʵʱ��⣬�����ڵ��Ƿ��Ѿ���ͨ
		unionFind.makeSets(graph.nodes.values()); // ���ɲ��鼯
		Queue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		for(Edge edge:graph.edges) {
			priorityQueue.offer(edge);
		}
		
		Set<Edge> result = new HashSet<>();
		while(!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll(); // ����ʣ�����Ȩ����С�ı�
			if(!unionFind.isSameSet(edge.from, edge.to)) { // ���ϵ������ڵ�û����ͨ���ӽ��������
				result.add(edge);
				unionFind.union(edge.from, edge.to); // �ӽ�֮��ϲ������ڵ�ļ���
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
		Set<Edge> r = KruskalMST(graph);
		for(Edge e:r) {
			System.out.println(e.weight + " " + e.from.value + " " + e.to.value);
		}
	}
}
