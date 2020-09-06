package cn.jingjie.zuo.graph;

public class GraphGenerator {// ͼ�����������������Զ�����һ��ͼ�����ݸ�ʽweight\from\to����Ԫ�����
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		
		for(int i=0; i < matrix.length; i++) {// �������ݾ���ÿһ�����ݰ���Ȩ�أ���ʼ���㣬Ŀ�궥��
			int weight = matrix[i][0]; // Ȩ��
			int from = matrix[i][1]; // ��ʼ����
			int to = matrix[i][2]; // Ŀ�궥��
			
			// ��ͼ����ӽڵ�
			if(!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if(!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			// ������
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			// ����ڵ�ĳ���ȣ��ڽӵ���ڽӱߣ���ͼ����ӱ�
			fromNode.out++;
			toNode.in++;
			fromNode.nexts.add(toNode);
			fromNode.edge.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}
	
}
