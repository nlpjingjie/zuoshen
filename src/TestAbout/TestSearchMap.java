package TestAbout;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class TestSearchMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("����", 123);
		map.put("�ϳ�", 234);
		map.put("����", 345);
		map.put("����", 567);
		map.put("��֣", 234);
		
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
		// ���ֵ䰴�ռ���ֵ��������
		/*
		 ��entrySetת��ΪList,
		Ȼ����д�Ƚ����Ƚϼ���.
		����ʹ��List.sort(comparator),
		Ҳ����ʹ��Collections.sort(list,comparator)
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
