package cn.jingjie.zuo.graph;

import java.util.ArrayList;

public class Node {// 图的节点，包括值，出入度，邻接点，邻接边
	public int value;
	public int in;
	public int out;
	
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edge;
	public Node(int data) {
		value = data;
		in = 0;
		out  = 0;
		nexts = new ArrayList<>();
		edge = new ArrayList<>();
	}
}
