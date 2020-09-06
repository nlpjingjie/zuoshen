package cn.jingjie.zuo.graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS { // 图的深度优先搜索，给出源节点，找一条路径走到头，路径上的节点注意判断之后压栈，为了回溯，找到别的路径
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
			for(Node next:cur.nexts) { // 从邻接点选出一条路径，走到头没有临接点开始回溯找上一个节点的其他邻接点
				if(!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.print(next.value + " ");
					break; // 从临接点选出一个没有判断过的节点(选择了一条方向)，跳出邻接点选择，沿着这个节点走
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
