package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// 运用单调栈。此题符合大根堆的性质，可以使用堆来解决。
// 数组中必须没有重复的元素。MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。包括MaxTree树在内且其中的每一颗子树上，值最大的节点都是树的头。
// 最优解：用单调递减栈，因为L, <x, <x....X, <x, <x, R, (L>X, R>X)  X能够给他父亲的，只能是L , R中的一个. 所以，这题变成了找左右两边第一个比X大的点，用单调递减栈；
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
		// 添加最大值是为了把栈中的所有元素包括最大值都拿出来
		for(int i=0; i <= arr.length; i++) {
			Node node = i == arr.length ? new Node(Integer.MAX_VALUE):new Node(arr[i]);
			// 处理
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
