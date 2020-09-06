package cn.jingjie.zuo.advanced;

import java.util.HashMap;
// 未完

// Least Frequently Used ，最不经常使用算法
// 一种缓存结构，大小为C，set(key,value)：将记录(key,value)插入该结构。当缓存满时，将访问频率最低的数据置换掉。get(key)：返回key对应的value值。
// map查找数据，二位双向链表维持数据
public class Code_11_LFU {
	// 节点包括此节点被操作的次数
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
	
//	// 具有指向前后链表能力的双向链表。因为链表不包含次数信息，它从节点中获取次数信息，它没有节点的时候就应该删掉。
	public static class NodeList{
		public Node head;
		public Node tail;
		public NodeList last;
		public NodeList next;
		
		// 初始化时就应该传进带次数信息的节点
		public NodeList(Node n) {
			this.head = n;
			this.tail = n;
		}
	}
	
	public static class LFUCache{
		public int size;
		public NodeList headList; // 指向频次最低的链表的变量
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
			// 如果record中有此节点，此节点times+1,将此节点从所在链表中删除，添加到频次更大的链表中，同时对链表做相应的处理
			if(record.containsKey(s)) {
				Node node = record.get(s);
				node.times++;
				NodeList nodeList = nodeToList.get(node);
				// 移动节点到别的链表中并做相应的处理
				move(nodeList, node);
			}else {
				Node node = new Node(s, i);
				record.put(s, node);
				// 头链表为空说明缓存中还没有链表
				if(headList == null) {
					NodeList newList = new NodeList(node);
					headList = newList;
					// 将node和nodeList的对应关系保存下来
					nodeToList.put(node, newList);
				}
				// 看头部频次最低的链表，是否可以添加新加入的节点
				else if(headList.head.times == 1) {
					// 将此节点加到频次最低链表的头部
					addNodeToHead(headList, node);
				}else {
					NodeList newList = new NodeList(node);
					nodeToList.put(node, newList);
					// 头链表指向新的链表
					newList.next = headList.next;
					headList.next.last = newList;
					headList = newList;
				}
			}
		}
		
		// 获取元素，频次发生变化，移动节点到别的链表中并做相应的处理
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
