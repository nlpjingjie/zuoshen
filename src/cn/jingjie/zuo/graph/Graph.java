package cn.jingjie.zuo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {// ͼ�Ľṹ�� �������ж���ļ��������бߵļ���
	public Map<Integer, Node> nodes;
	public Set<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
