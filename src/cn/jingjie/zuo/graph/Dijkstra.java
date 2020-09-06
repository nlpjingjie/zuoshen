package cn.jingjie.zuo.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// 迪科斯彻，单源最小路径算法
public class Dijkstra {
	
	/*用一个map不断更新各个节点到源节点的最短距离。
	 * 从map中拿出不在set中的且到源节点最短路径的节点
	 * 新加入的顶点是否可以到达其他顶点并且看看通过该顶点到达其他点的路径长度是否比源点直接到达短。
	用一个set存储已经更新到源节点最短路径的节点*/
	
	// 返回各个点及到源节点（选择的起始节点）的距离
	public static HashMap<Node, Integer> dijkstra(Node head) {
		// 用于更新和存储各个点及其到源节点的最短距离
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(head, 0);
		Set<Node> selectedNodes = new HashSet<Node>();
		
		// 拿出最短路径的点
		Node minDistance = getMinDistanceAndNotInSelectedNodes(distanceMap, selectedNodes);
		while(minDistance != null) {
			Integer distance = distanceMap.get(minDistance);
			for(Edge e:minDistance.edge) {
				Node to = e.to;
				// 第一次遍历添加的是源节点直接到邻接点的距离
				// 不在distanceMap，添加，在，则更新距离。
				if(!distanceMap.containsKey(to)) {
					distanceMap.put(to, distance + e.weight);
				}
				// 直达和沿最小路径哪个更近
				distanceMap.put(to, Math.min(distance + e.weight, distanceMap.get(to)));
			}
			selectedNodes.add(minDistance);
			minDistance = getMinDistanceAndNotInSelectedNodes(distanceMap, selectedNodes);
		}
		return distanceMap;
	}

	public static Node getMinDistanceAndNotInSelectedNodes(Map<Node, Integer> distanceMap, Set<Node> selectedNodes) {
		Node minNode = null;
		Integer minDistance = Integer.MAX_VALUE;
		for(Node n:distanceMap.keySet()) {
			if(!selectedNodes.contains(n) && minDistance > distanceMap.get(n)) {
				minDistance = distanceMap.get(n);
				minNode = n;
			}
		}
		return minNode;
	}
	
	// 拿最短路径的点的时候，每次都要遍历distanceMap，找出最小值。
	// 使用堆优化Dijkstra算法
	
	// 组织数据结构，包括节点和到源节点的距离
	public static class NodeDistance{
		public Node node;
		public Integer distance;
		
		public NodeDistance(Node n, Integer d) {
			node = n;
			distance = d;
		}
	}
	
	public static class DisComparator implements Comparator<NodeDistance>{
		@Override
		public int compare(NodeDistance o1, NodeDistance o2) {
			return o1.distance - o2.distance;
		}
	}
	
//	public static HashMap<Node, Integer> dijkstra2(Node head) {
//		HashMap<Node, Integer> distanceMap = new HashMap<>();
//		distanceMap.put(head, 0);
//		Set<Node> selectedNodes = new HashSet<>();
//		
//		// 拿出最短路径的点,第一次肯定就是head自己
//		Node minDistance = head;
//		while(minDistance != null) {
//			PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>(new DisComparator());
//			for(Edge e:minDistance.edge) {
//				Integer distance = distanceMap.get(minDistance);
//				Node to = e.to;
//				if(!distanceMap.containsKey(to)) {
//					distanceMap.put(to, distance + e.weight);
//					priorityQueue.offer(new NodeDistance(to, distance + e.weight));
//				}else {
//					distanceMap.put(to, Math.min(distance + e.weight, distanceMap.get(to)));
//					priorityQueue.offer(new NodeDistance(to, Math.min(distance + e.weight, distanceMap.get(to))));
//				}
//			}
//			selectedNodes.add(minDistance);
//			
//			Node n = priorityQueue.poll().node;
//			while(selectedNodes.contains(n)) {
//				n = priorityQueue.poll().node;
//			}
//			minDistance = n;
//		}
//		return distanceMap;
//	}
	
	
	public static void main(String[] args) {
		Integer[][] matrix = {{1, 3, 5},
			 	  {2, 4, 6},
			 	  {3, 5, 4},
			 	  {2, 6, 7},
			 	  {1, 3, 6},
			 	  {2, 4, 7}};
		Graph graph = GraphGenerator.createGraph(matrix);
		Node f = graph.nodes.get(3);
		// System.out.println(f.value);
		HashMap<Node, Integer> reslut = dijkstra(graph.nodes.get(3));
		for(Node r:reslut.keySet()) {
			Integer d = reslut.get(r);
			System.out.println("Last distance:from " + f.value + " to " + r.value + ": " + d);
		}
//		HashMap<Node, Integer> reslut = dijkstra2(graph.nodes.get(3));
//		for(Node r:reslut.keySet()) {
//			Integer d = reslut.get(r);
//			System.out.println("Last distance:from " + f.value + " to " + r.value + ": " + d);
//		}
	}
}
