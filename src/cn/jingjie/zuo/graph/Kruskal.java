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


// 要求无向图，不是处理不了有向图，是处理过后区分不了有向图
public class Kruskal {// 始终选择当前可用的最小边权的边，并实时判断两个点之间有没有间接联通。
	
	
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
		
		public void makeSets(Collection<Node> collection) {// 生成原始并查集
			fatherMap.clear();
			sizeMap.clear();
			for(Node node:collection) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		public Node findHead(Node n) { // 找到代表节点并且扁平化集合
			Node father = fatherMap.get(n);
			if(father != n) {
				father = findHead(father);
			}
			fatherMap.put(n, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) { // 判断是否在一个集合
			return findHead(a) == findHead(b);
		}
		
		public void union(Node a, Node b) { // 合并两个节点所代表的集合
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
	
	
	// 按边的权重大小比较
	public static class EdgeComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}

	
	public static Set<Edge> KruskalMST(Graph graph){ // Kruskal最小生成树算法
		UnionFindSet unionFind = new UnionFindSet(); // 使用并查集实时监测，两个节点是否已经连通
		unionFind.makeSets(graph.nodes.values()); // 生成并查集
		Queue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		for(Edge edge:graph.edges) {
			priorityQueue.offer(edge);
		}
		
		Set<Edge> result = new HashSet<>();
		while(!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll(); // 返回剩余边中权重最小的边
			if(!unionFind.isSameSet(edge.from, edge.to)) { // 边上的两个节点没有连通，加进结果集中
				result.add(edge);
				unionFind.union(edge.from, edge.to); // 加进之后合并两个节点的集合
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
