package cn.jingjie.zuo.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {// ͼ�Ŀ����������
	public static void bfs(Node node) { // ����һ��Դ�ڵ㣬�����ڽӵ�ʹ�ö��мӽ�����ʹ��set�жϽڵ��Ƿ��Ѿ��жϹ�
		if(node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		Set<Node> set = new HashSet<>();
		queue.offer(node); // ��Դ�ڵ�ӽ�����
		set.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.print(cur.value + " ");
			for(Node next:cur.nexts) {
				if(!set.contains(next)) { // ����ڵ�û���жϹ��ӽ�����
					queue.offer(next);
					set.add(next); // �ӽ����еĽڵ�Ҫ�Ž�set��
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
