package cn.jingjie.zuo.advanced;

import java.util.HashMap;

// Least Recently Used ������δʹ��
// һ�ֻ���ṹ����СΪc  get��set O(1)ʱ�临�Ӷ� ÿ��ʹ��֮�����ȼ��ŵ���ߣ�����ӵ����ȼ���ߡ�
// ʹ��˫������ά�����ȼ���ʹ��map��������
public class Code_10_LRU {
	public static class Node{
		public String key;
		public Integer value;
		public Node last;
		public Node next;
		
		public Node(String k, Integer v) {
			key = k;
			value = v;
		}
	}
	
	public static class DoubleLinkedList{
		public Node head;
		public Node tail;
		
		public DoubleLinkedList(){
			head = null;
			tail = null;
		}
		
		// ��˫���������Ԫ��
		public void addNode(Node node) {
			if(node == null) {
				return;
			}
			if(this.head == null) {
				this.head = node;
				this.tail = node;
			}else {
				this.tail.next = node;
				node.last = this.tail;
				this.tail = node;
			}
		}
		// get��set�� ÿ��ʹ��֮�����ȼ��ŵ����
		public void moveNodeToTail(Node node) {
			// node ��β��
			if(this.tail == node) {
				return;
			}
			// node��ͷ��
			if(this.head == node) {
				this.head = node.next;
				this.head.last = null;
			}else { // node���м�
				node.next.last = node.last;
				node.last.next = node.next;
			}
			
			this.tail.next = node;
			node.next = null;
			node.last = this.tail;
			this.tail = node;
		}
		// �����������ƣ��Ƴ����δʹ�õ�Ԫ��
		public Node removeHead() {
			if(this.head == null) {
				return null;
			}
			Node res = this.head;
			if(this.head == this.tail) {
				this.head = null;
				this.tail = null;
			}else {
				this.head = this.head.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}
	}
	
	public static class MyCache{
		public HashMap<String, Node> map;
		public DoubleLinkedList dL;
		private int capacity;
		
		public MyCache(int c) {
			map = new HashMap<>();
			dL = new DoubleLinkedList();
			capacity = c;
		}
		
		// �򻺴������Ԫ��
		public void set(String k, Integer v) {
			if(map.containsKey(k)) {
				Node node = map.get(k);
				node.value = v;
				dL.moveNodeToTail(node);
			}else {
				Node node = new Node(k, v);
				map.put(k, node);
				dL.addNode(node);
				if(map.size() == capacity + 1) {
					Node unUsed = dL.removeHead();
					// ҲҪ��map��ɾ��
					map.remove(unUsed.key);
				}
			}
		}
		
		// �ӻ�����ȡԪ��
		public Integer get(String key) {
			if(map.containsKey(key)) {
				Node res = map.get(key);
				dL.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		MyCache cache = new MyCache(3);
		cache.set("haha", 1);
		cache.set("hello", 2);
		cache.set("C", 3);
		System.out.println(cache.get("C"));
		cache.set("D", 4);
		System.out.println(cache.get("haha"));
		System.out.println(cache.get("hello"));
		cache.set("E", 1);
	}
}
