package cn.jingjie.zuo.graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS { // ͼ�������������������Դ�ڵ㣬��һ��·���ߵ�ͷ��·���ϵĽڵ�ע���ж�֮��ѹջ��Ϊ�˻��ݣ��ҵ����·��
	public static void dfs(Node head) {
		if(head == null){
			return;
		}
		Deque<Node> stack = new LinkedList<>();
		Set<Node> set = new HashSet<>();
		stack.push(head);
		set.add(head);
		System.out.print(head.value + " ");
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			for(Node next:cur.nexts) { // ���ڽӵ�ѡ��һ��·�����ߵ�ͷû���ٽӵ㿪ʼ��������һ���ڵ�������ڽӵ�
				if(!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.print(next.value + " ");
					break; // ���ٽӵ�ѡ��һ��û���жϹ��Ľڵ�(ѡ����һ������)�������ڽӵ�ѡ����������ڵ���
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
		dfs(head);
	}
}
