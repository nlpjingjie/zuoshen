package cn.jingjie.zuo.advanced;

import java.util.HashMap;
// δ��

// Least Frequently Used �������ʹ���㷨
// һ�ֻ���ṹ����СΪC��set(key,value)������¼(key,value)����ýṹ����������ʱ��������Ƶ����͵������û�����get(key)������key��Ӧ��valueֵ��
// map�������ݣ���λ˫������ά������
public class Code_11_LFU {
	// �ڵ�����˽ڵ㱻�����Ĵ���
	public static class Node{
		public int times;
		public Node up;
		public Node down;
		public String key;
		public Integer value;
		
		public Node(String k, Integer v) {
			key = k;
			value = v;
			up = null;
			down = null;
			times = 1;
		}
	}
	
//	// ����ָ��ǰ������������˫��������Ϊ��������������Ϣ�����ӽڵ��л�ȡ������Ϣ����û�нڵ��ʱ���Ӧ��ɾ����
	public static class NodeList{
		public Node head;
		public Node tail;
		public NodeList last;
		public NodeList next;
		
		// ��ʼ��ʱ��Ӧ�ô�����������Ϣ�Ľڵ�
		public NodeList(Node n) {
			this.head = n;
			this.tail = n;
		}
	}
	
	public static class LFUCache{
		public int size;
		public NodeList headList; // ָ��Ƶ����͵�����ı���
		public HashMap<String, Node> record;
		public HashMap<Node, NodeList> nodeToList;
		private int capacity;
		
		public LFUCache(int c) {
			capacity = c;
			record = new HashMap<>();
			nodeToList = new HashMap<>();
			headList = null;
			size = 0;
		}
		
		// 
		public void set(String s, Integer i) {
			// ���record���д˽ڵ㣬�˽ڵ�times+1,���˽ڵ������������ɾ������ӵ�Ƶ�θ���������У�ͬʱ����������Ӧ�Ĵ���
			if(record.containsKey(s)) {
				Node node = record.get(s);
				node.times++;
				NodeList nodeList = nodeToList.get(node);
				// �ƶ��ڵ㵽��������в�����Ӧ�Ĵ���
				move(nodeList, node);
			}else {
				Node node = new Node(s, i);
				record.put(s, node);
				// ͷ����Ϊ��˵�������л�û������
				if(headList == null) {
					NodeList newList = new NodeList(node);
					headList = newList;
					// ��node��nodeList�Ķ�Ӧ��ϵ��������
					nodeToList.put(node, newList);
				}
				// ��ͷ��Ƶ����͵������Ƿ��������¼���Ľڵ�
				else if(headList.head.times == 1) {
					// ���˽ڵ�ӵ�Ƶ����������ͷ��
					addNodeToHead(headList, node);
				}else {
					NodeList newList = new NodeList(node);
					nodeToList.put(node, newList);
					// ͷ����ָ���µ�����
					newList.next = headList.next;
					headList.next.last = newList;
					headList = newList;
				}
			}
		}
		
		// ��ȡԪ�أ�Ƶ�η����仯���ƶ��ڵ㵽��������в�����Ӧ�Ĵ���
		public Integer get(String s) {
			if(!record.containsKey(s)) {
				return null;
			}
			Node node = record.get(s);
			NodeList nodeList = nodeToList.get(node);
			move(nodeList, node);
			return node.value;
		}
		
		// 
		private void addNodeToHead(NodeList headList2, Node node) {
			// TODO Auto-generated method stub
			
		}

		private void move(NodeList nodeList, Node node) {
			// TODO Auto-generated method stub
			
		}
	}
}
