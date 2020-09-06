package cn.jingjie.zuo.graph;

public class GraphGenerator {// 图生成器，给出数据自动生成一张图，数据格式weight\from\to的三元组矩阵
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		
		for(int i=0; i < matrix.length; i++) {// 遍历数据矩阵，每一组数据包括权重，起始顶点，目标顶点
			int weight = matrix[i][0]; // 权重
			int from = matrix[i][1]; // 起始顶点
			int to = matrix[i][2]; // 目标顶点
			
			// 向图中添加节点
			if(!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if(!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			// 建立边
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			// 处理节点的出入度，邻接点和邻接边，向图中添加边
			fromNode.out++;
			toNode.in++;
			fromNode.nexts.add(toNode);
			fromNode.edge.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}
	
}
