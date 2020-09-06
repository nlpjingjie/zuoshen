package cn.jingjie.zuo.graph;

public class Edge {// 图的边，包括权重，起始节点和目标节点
	public int weight;
	public Node from;
	public Node to;
	
	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}
}
