package WrittenTest;

import java.util.HashMap;
import java.util.Scanner;


/*模拟找钱，贪心，先拿大钱找
 * 
 * 假设咖啡卖 5 元，每个客户可能给你 5、10、20 元的纸币，
初始情况下你没有任何纸币，问是否能够找零。
如果能找零就输出 true，总用户数， 否则输出 false,失败的用户index。
例如：
5,5,5,10 => true,4
10,10 => false,1
*/
public class Huawei1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 
		while(in.hasNextLine()) {
			String[] str = in.nextLine().split(",");
			HashMap<Integer, Integer> map = new HashMap<>();
			
			int index = 0;
			int money = 0;
			boolean flag = true;
			for(int i=0; i < str.length; i++) {
				money = Integer.parseInt(str[i]);
				if(money != 5 && money != 10 && money != 20) {
					index = i;
					flag = false;
					break;
				}
				
				if(money == 10) {
					if(map.containsKey(5) && map.get(5) >= 1) {
						map.put(5, map.get(5) - 1);
						index = i;
					}else {
						index = i;
						flag = false;
						break;
					}
					map.put(10, map.getOrDefault(10, 0) + 1);
				}else if(money == 20) {
					if(map.containsKey(10) && map.containsKey(5) && map.get(10) >= 1 && map.get(5) >= 1) {
						map.put(10, map.get(10) - 1);
						map.put(5, map.get(5) - 1);
					}else if(map.containsKey(5) && map.get(5) >= 3) {
						map.put(5, map.get(5) - 3);
					}else {
						index = i;
						flag = false;
						break;
					}
					index = i;
				}else {
					map.put(5, map.getOrDefault(5, 0) + 1);
					index = i;
				}
			}
			System.out.print(flag + "," + (index+1));
		}
	}

}
