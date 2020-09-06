package cn.jingjie.zuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class code_31_UnionFind {// ���鼯��ʵ��O(1)���ж������ڵ��Ƿ���һ����ϣ����������ڵ㣬�ϲ��伯�ϡ�
	public static class Node{// ʲô����node����Ҫ
		public Node left;
		public Node right;
		public int value;
		
		public Node(int data) {
			this.value = data;
		}
	}
	public static class UnionFindSet{
		public HashMap<Node, Node> fatherMap;// ÿ���ڵ���丸�ڵ㣬����ڵ���ָ���Լ���
		public HashMap<Node, Integer> sizeMap;// size������¼���ϵĴ�С
		
		public UnionFindSet() {
			this.fatherMap = new HashMap<Node, Node>();
			this.sizeMap = new HashMap<Node, Integer>();
		}
		
		public void makeSets(List<Node> Nodes) {// ��ÿ���ڵ��Ϊ��Ӧ�Ĳ��鼯
			fatherMap.clear();
			sizeMap.clear();
			for(Node node:Nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		public Node findHead(Node a) {// ����һ���ڵ㣬�ҵ�����ڵ�Ĵ���ڵ㣬���ҽ����ϱ�ƽ��
			Node father = fatherMap.get(a);
			if(a != father) {// fatherΪ����ڵ�ʱֹͣ�ݹ飬��ʼ���ء�
				father = findHead(father);
			}
			fatherMap.put(a, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {// ����ڵ��Ƿ���ͬһ��
			return findHead(a) == findHead(b);
		}
		
		public void union(Node a, Node b) {// �������ڵ�ļ��Ϻϲ���һ��,����С��ָ�򼯺ϴ��
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
