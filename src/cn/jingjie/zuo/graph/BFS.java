package cn.jingjie.zuo.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {// 图的宽度优先搜索
	public static void bfs(Node node) { // 给定一个源节点，将其邻接点使用队列加进来，使用set判断节点是否已经判断过
		if(node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		Set<Node> set = new HashSet<>();
		queue.offer(node); // 把源节点加进队列
		set.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.print(cur.value + " ");
			for(Node next:cur.nexts) {
				if(!set.contains(next)) { // 如果节点没有判断过加进队列
					queue.offer(next);
					set.add(next); // 加进队列的节点要放进set中
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Integer[][] matrix = {{1, 3, 5},
						 	  {2, 4, 6},
						 	  {3, 5, 4},
						 	  {2, 6, 7},
						 	  {1, 3, 6},
						 	  {2, 4, 7}};
		Graph graph = GraphGenerator.createGraph(matrix);
		Node head = graph.nodes.get(3);
		bfs(head);
	}
}
