package cn.jingjie.zuo.advanced;

import java.util.TreeMap;

// TreeMap��TreeSet  ��������ƽ���������������ײ��Ǻ����
public class AboutTreeMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(5, "wu");
		treeMap.put(10, "shi");
		treeMap.put(30, "sanshi");
		treeMap.put(20, "ershi");
		treeMap.put(1, "yi");
		
		System.out.println(treeMap.get(5));
		// �õ���С��key
		System.out.println(treeMap.firstKey());
		// �õ�����key
		System.out.println(treeMap.lastKey());
		// �õ�������ֵС�����key
		System.out.println(treeMap.ceilingKey(20));
		// �õ�������ֵ������key
		System.out.println(treeMap.floorKey(5));
		System.out.println(treeMap.containsKey(5));
	}
}
