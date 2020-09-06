package TestAbout;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class TestSearchMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("老张", 123);
		map.put("老陈", 234);
		map.put("老马", 345);
		map.put("老李", 567);
		map.put("老郑", 234);
		
		for(String key:map.keySet()) {
			Integer value = map.get(key);
			System.out.println(key + ":" + value);
		}
		
		System.out.println();
		for(Map.Entry<String, Integer> entry:map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println(key + ":" + value);
		}
		
		
		System.out.println();
		// 给字典按照键和值进行排序
		/*
		 将entrySet转换为List,
		然后重写比较器比较即可.
		可以使用List.sort(comparator),
		也可以使用Collections.sort(list,comparator)
		*/
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if(o1.getValue() != o2.getValue()) {
					return o1.getValue() - o2.getValue();
				}else {
					return o1.getKey().compareTo(o2.getKey());
				}
			}
		});
		
		for(Map.Entry<String, Integer> m:list) {
			System.out.println(m.getKey() + ":" + m.getValue());
		}
	}
}
