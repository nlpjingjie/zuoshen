package cn.jingjie.zuo.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Prim { // 从任意点开始，找与此点相连的点之间权重最小的边，在这些点中找到同样符合上述要求的边，知道涵盖所有的点
	
	public static class Edgecomparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}
	
	public static Set<Edge> primMST(Graph graph){
		Set<Node> nodeSet = new HashSet<>(); // 用来保存已经经过判断的点
		Set<Edge> result = new HashSet<>(); // 用来保存结果
		Queue<Edge> priorityQueue = new PriorityQueue<>(new Edgecomparator()); // 用来返回权值最小的边
		
		for(Node node:graph.nodes.values()) { // 防止不是连通图（即输入的是森林），找不到孤立点的情况
			if(!nodeSet.contains(node)) { // 从node开始找最小生成树
				nodeSet.add(node); // 将判断过的点加进集合
				for(Edge e:node.edge) { // node的所有邻接边加进优先级队列
					priorityQueue.offer(e);
				}
				while(!priorityQueue.isEmpty()) { //  开始找权重最小的边
					Edge edge = priorityQueue.poll(); // 弹出权重最小的边
					Node to = edge.to;
					
					if(!nodeSet.contains(to)) { // 保证没遇到过，是可以拓展的点
						result.add(edge); // 可以拓展的边，加进结果集
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
