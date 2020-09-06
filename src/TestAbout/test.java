package TestAbout;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;



public class test {
	
//	public static void main(String[] args) {
//		
//		int[] arr = {0, 1, 2, 5, 4, 6};
//		int a = find(arr);
//		System.out.println(a);
//	
//}
//
//	private static int find(int[] arr) {
//		Arrays.sort(arr);
//		for(int i=0; i<arr.length;i++) {
//			if(arr[i] != i) {
//				return i;
//			}
//		}
//		return -1;
//	}
	
	
//	public static int dToSum(int i){
//        if(i < 10){
//            return i;
//        }else{
//            return i%10 + dToSum(i/10);
//        }
//    }
//	
//	public static void main(String[] args) {
//		System.out.println(dToSum(19));
//	}
	
//	public static class myComparator implements Comparator<Integer>{
//		public int compare(Integer o1, Integer o2) {
//			return o2 - o1;
//		}
//	}
//	
//	public static void main(String[] args) {
////		PriorityQueue<Integer> q = new PriorityQueue<>(new myComparator());
//		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
//		for(int i=0; i < 10; i++) {
//			q.offer(i);
//		}
//		
//		for(int i = 0; i < 10; i++) {
//			System.out.println(q.poll());
//		}
//	}
	
	
	public static void main(String[] args) {
		int i = 1;
		int j = 8;
		String s = i +""+j;
		System.out.println(s);
		int m = Integer.parseInt(String.valueOf(s.charAt(0)));
		System.out.println(m);
	}
	
}