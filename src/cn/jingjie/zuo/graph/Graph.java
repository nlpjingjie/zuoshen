package cn.jingjie.zuo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {// 图的结构， 包括所有顶点的集合与所有边的集合
	public Map<Integer, Node> nodes;
	public Set<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
