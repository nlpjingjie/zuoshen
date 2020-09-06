package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// ���õ���ջ��������ϴ���ѵ����ʣ�����ʹ�ö��������
// �����б���û���ظ���Ԫ�ء�MaxTree��һ�ö������������ÿһ��ֵ��Ӧһ���������ڵ㡣����MaxTree�����������е�ÿһ�������ϣ�ֵ���Ľڵ㶼������ͷ��
// ���Ž⣺�õ����ݼ�ջ����ΪL, <x, <x....X, <x, <x, R, (L>X, R>X)  X�ܹ��������׵ģ�ֻ����L , R�е�һ��. ���ԣ������������������ߵ�һ����X��ĵ㣬�õ����ݼ�ջ��
public class Code_06_MaxTree {
	public static class Node{
		public Node left;
		public Node right;
		public int value;
		
		public Node(int data) {
			value = data;
		}
	}
	
	public static Node maxTree(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		Deque<Node> stack = new LinkedList<>();
		// ������ֵ��Ϊ�˰�ջ�е�����Ԫ�ذ������ֵ���ó���
		for(int i=0; i <= arr.length; i++) {
			Node node = i == arr.length ? new Node(Integer.MAX_VALUE):new Node(arr[i]);
			// ����
			while(!stack.isEmpty() && stack.peek().value < node.value) {
				Node curNode = stack.pop();
				if(!stack.isEmpty() && node.value > stack.peek().value) {
					stack.peek().right = curNode;
				}else {
					node.left = curNode;
				}
			}
			stack.push(node);
		}
		
		return stack.pop().left;
	}
	
	private static void printTree(Node node) {
		if(node == null) {
			System.out.print("#" + " ");
			return;
		}
		System.out.print(node.value + " ");
		printTree(node.left);
		printTree(node.right);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3, 1, 4, 2};
		Node node = maxTree(arr);
		printTree(node);
	}
}
