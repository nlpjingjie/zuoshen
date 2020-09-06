package cn.jingjie.zuo;


public class code_13_Array_Stack_Queue {
	// 使用数组实现栈
	public static class ArrayStack {
		private Integer[] arr;
		private Integer index;
		
		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less 0");
			}
			arr = new Integer[initSize];
			index = 0;
		}
		
		public Integer peek() {
			if (index == 0) {
				return null;
			}
			return arr[index - 1];
		}
		
		public void push(Integer value) {
			if (index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			arr[index++] = value;
		}
		
		public Integer pop() {
			if (index == 0) {
				throw new ArrayIndexOutOfBoundsException("The stack is empty");
			}
			return arr[--index];
		}
	}
	
	
	// 使用数组实现队列
	public static class ArrayQueue{
		private Integer[] arr;
		private Integer index;
		private Integer start;
		private Integer size;
		
		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The initSize is less 0");
			}
			arr = new Integer[initSize];
			index = 0;
			start = 0;
			size = 0;
		}
		
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[start];
		}
		
		public void push(Integer value) {
			if (size == arr.length){
				throw new IllegalArgumentException("The queue is full");
			}
			size++;
			arr[index] = value;
			index = index == arr.length - 1 ? 0:index+1;
		}
		
		public Integer pop() {
			if (start == index) {
				throw new IllegalArgumentException("The queue is null");
			}
			size--;
			int tmp = start;
			start = start == arr.length-1 ? 0:start+1;
			return arr[tmp];
		}
	}
	
	public static void main(String[] args) {
		ArrayStack a1 = new ArrayStack(5);
		ArrayQueue a2 = new ArrayQueue(5);
		a1.push(5);
		a1.push(6);
		a2.push(5);
		a2.push(6);
		System.out.println(a1.peek());
		a1.pop();
		System.out.println(a1.peek());
		System.out.println(a2.peek());
		a2.pop();
		System.out.println(a2.peek());
	}
}
