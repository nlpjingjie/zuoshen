package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// 运用单调栈
/*一个数组中的数字组成环形山，数值为山高
1 2 4 5 3
规则，烽火传递：
相邻之间的两座山必能看到烽火，
非相邻的山之间有一边的山高都 <= 这两个非相邻山的山高，则这两座山能相互看到烽火。*/

// 找到所有可见山峰对。
// 1.明确说明没有重复数据，思路设想找到环形山的最高及次高对于剩余的元素（假设数据大小不重复），对于每一个元素，都能找到两对山峰对，有（n-2）*2对山峰对，总数再加上1。
// 2.有重复数据，用单调栈，局部处理用到了1的公式，如下：
public class Code_06_Craters {
	public static class Data{
		public int index;
		public int count;
		
		public Data(int v) {
			index = v;
			count = 1;
		}
	}
	
	public static int getCratersPairs(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return 0;
		}
		// 找到数组中的最大值的索引
		int maxIndex = 0;
		for(int i=0; i < arr.length; i++) {
			maxIndex = arr[maxIndex] > arr[i] ? maxIndex:i;
		}
		// System.out.println(arr[maxIndex]);
		int res = 0;
		// 单调递减栈
		Deque<Data> stack = new LinkedList<>();
		stack.push(new Data(maxIndex));
		for(int i = maxIndex + 1; i != maxIndex; i++ ) {
			// 设置环形
			if(i == arr.length) {
				i = 0;
			}
			
			Data data = new Data(i);
			while(!stack.isEmpty() && arr[data.index] > arr[stack.peek().index]) {
				Data curData = stack.pop();
				int count = curData.count;
				res += (count*(count - 1)/2) + count*2;
			}
			if(arr[data.index] == arr[stack.peek().index]) {
				stack.peek().count++;
			}else {
				stack.push(data);
			}
		}
		
		/*单调栈：从大到小排序
		从任意一个最大值开始，以一个方向旋转，进行入栈操作
		当一个数被弹出栈时，他找到了2个可以相互看到山，即，将入栈的和他下面的
		当将入栈数与栈顶相等，则将两个数的信息共同记录在同一个栈位置，
		当弹出某个数为n条记录时，即在同一个位置记录了n次某个数，比如，有连续n个4入栈，则在相同位置记录n次4
		此时它弹出时，能看到的山为：Cn2 + n * 2次其中Cn2[n个4之间相互组合] + n * 2[n个4与他两边的高山组合]，
		当将遍历完数组后，栈中剩余的数弹出时：
		对于倒数第i > 2个剩余数弹出时，他能看到的山为：Cn2 + n * 2
		对于倒数第二个剩余数弹出时，
		若最后一个数为 > 1个记录他能看到的山为：Cn2 + n * 2
		若最后一个数为 == 1个记录他能看到的山为：Cn2 + n * 1, 因为这是一个环。
		对于倒数第1个剩余数弹出时，他能看到的山为：Cn2*/
		
		while(!stack.isEmpty()) {
			Data curData = stack.pop();
			int count = curData.count;
			// 分情况讨论
			if(stack.size() >= 2) {
				res += (count*(count - 1)/2) + count*2;
			}else if(stack.size() == 1) {
				if(stack.peek().count > 1) {
					res += (count*(count - 1)/2) + count*2;
				}else {
					res += (count*(count - 1)/2) + count;
				}
			}else {
				res += (count*(count - 1)/2);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 3};
		System.out.println(getCratersPairs(arr));
	}
}
