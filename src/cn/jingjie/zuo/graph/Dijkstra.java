package cn.jingjie.zuo.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// �Ͽ�˹������Դ��С·���㷨
public class Dijkstra {
	
	/*��һ��map���ϸ��¸����ڵ㵽Դ�ڵ����̾��롣
	 * ��map���ó�����set�е��ҵ�Դ�ڵ����·���Ľڵ�
	 * �¼���Ķ����Ƿ���Ե����������㲢�ҿ���ͨ���ö��㵽���������·�������Ƿ��Դ��ֱ�ӵ���̡�
	��һ��set�洢�Ѿ����µ�Դ�ڵ����·���Ľڵ�*/
	
	// ���ظ����㼰��Դ�ڵ㣨ѡ�����ʼ�ڵ㣩�ľ���
	public static HashMap<Node, Integer> dijkstra(Node head) {
		// ���ڸ��ºʹ洢�����㼰�䵽Դ�ڵ����̾���
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(head, 0);
		Set<Node> selectedNodes = new HashSet<Node>();
		
		// �ó����·���ĵ�
		Node minDistance = getMinDistanceAndNotInSelectedNodes(distanceMap, selectedNodes);
		while(minDistance != null) {
			Integer distance = distanceMap.get(minDistance);
			for(Edge e:minDistance.edge) {
				Node to = e.to;
				// ��һ�α�����ӵ���Դ�ڵ�ֱ�ӵ��ڽӵ�ľ���
				// ����distanceMap����ӣ��ڣ�����¾��롣
				if(!distanceMap.containsKey(to)) {
					distanceMap.put(to, distance + e.weight);
				}
				// ֱ�������С·���ĸ�����
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
	
	// �����·���ĵ��ʱ��ÿ�ζ�Ҫ����distanceMap���ҳ���Сֵ��
	// ʹ�ö��Ż�Dijkstra�㷨
	
	// ��֯���ݽṹ�������ڵ�͵�Դ�ڵ�ľ���
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
//		// �ó����·���ĵ�,��һ�ο϶�����head�Լ�
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
