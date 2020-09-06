package cn.jingjie.zuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class code_31_UnionFind {// 并查集，实现O(1)的判断两个节点是否是一个结合，给出两个节点，合并其集合。
	public static class Node{// 什么样的node不重要
		public Node left;
		public Node right;
		public int value;
		
		public Node(int data) {
			this.value = data;
		}
	}
	public static class UnionFindSet{
		public HashMap<Node, Node> fatherMap;// 每个节点和其父节点，代表节点是指向自己的
		public HashMap<Node, Integer> sizeMap;// size用来记录集合的大小
		
		public UnionFindSet() {
			this.fatherMap = new HashMap<Node, Node>();
			this.sizeMap = new HashMap<Node, Integer>();
		}
		
		public void makeSets(List<Node> Nodes) {// 将每个节点改为对应的并查集
			fatherMap.clear();
			sizeMap.clear();
			for(Node node:Nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		public Node findHead(Node a) {// 根据一个节点，找到这个节点的代表节点，并且将集合扁平化
			Node father = fatherMap.get(a);
			if(a != father) {// father为代表节点时停止递归，开始返回。
				father = findHead(father);
			}
			fatherMap.put(a, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {// 代表节点是否是同一个
			return findHead(a) == findHead(b);
		}
		
		public void union(Node a, Node b) {// 将两个节点的集合合并在一起,集合小的指向集合大的
			Node headA = findHead(a);
			Node headB = findHead(b);
			if(headA != headB) {
				if(sizeMap.get(headA) >= sizeMap.get(headB)) {
					fatherMap.put(headB, headA);
					sizeMap.put(headA, sizeMap.get(headA)+sizeMap.get(headB));
				}else {
					fatherMap.put(headA, headB);
					sizeMap.put(headB, sizeMap.get(headA)+sizeMap.get(headB));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(6);
		Node n3 = new Node(4);
		Node n4 = new Node(8);
		Node n5 = new Node(9);
		Node n6 = new Node(2);
		Node n7 = new Node(1);
		Node n8 = new Node(5);
		Node n9 = new Node(7);
		List<Node> list = new ArrayList<>();
		list.add(n1);
		list.add(n2);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		list.add(n7);
		list.add(n8);
		list.add(n9);
		UnionFindSet unionFindSet = new UnionFindSet();
		unionFindSet.makeSets(list);
		System.out.println("n8 and n9 isSameSet:" + unionFindSet.isSameSet(n8, n9));
		System.out.println(unionFindSet.sizeMap.get(n8));
		unionFindSet.union(n8, n9);
		System.out.println("n8 and n9 isSameSet:" + unionFindSet.isSameSet(n8, n9));
		System.out.println(unionFindSet.fatherMap.get(n9).value);
		System.out.println(unionFindSet.sizeMap.get(n8));
	}
}
