package cn.jingjie.zuo.advanced;

import java.util.TreeMap;

// TreeMap、TreeSet  键的排序，平衡搜索二叉树，底层是红黑树
public class AboutTreeMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(5, "wu");
		treeMap.put(10, "shi");
		treeMap.put(30, "sanshi");
		treeMap.put(20, "ershi");
		treeMap.put(1, "yi");
		
		System.out.println(treeMap.get(5));
		// 拿到最小的key
		System.out.println(treeMap.firstKey());
		// 拿到最大的key
		System.out.println(treeMap.lastKey());
		// 拿到不比数值小的最近key
		System.out.println(treeMap.ceilingKey(20));
		// 拿到不比数值大的最近key
		System.out.println(treeMap.floorKey(5));
		System.out.println(treeMap.containsKey(5));
	}
}
