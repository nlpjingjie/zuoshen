package cn.jingjie.zuo.graph;

public class Edge {// ͼ�ıߣ�����Ȩ�أ���ʼ�ڵ��Ŀ��ڵ�
	public int weight;
	public Node from;
	public Node to;
	
	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}
}
