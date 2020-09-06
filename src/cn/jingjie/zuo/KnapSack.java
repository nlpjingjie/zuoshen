package cn.jingjie.zuo;

// 0-1背包问题，有n种物品，每种物品有重量w、价值v,给一个固定容量的背包V,求背包所能容纳物品的最大价值。
public class KnapSack {
	public static int knapSack(int[] volume, int[] value, int bVo) {
		return process(volume, value, bVo, 0, 0);
	}

	private static int process(int[] volume, int[] value, int bVo, int curVo, int i) {
		if(curVo > bVo || i == volume.length) {
			return 0;
		}
		// 如果不先判断，就会提前把价值加上导致错误
		if(curVo + volume[i] <= bVo) {
			return Math.max(value[i] + process(volume, value, bVo, curVo + volume[i], i+1), process(volume, value, bVo, curVo, i+1));
		}
		return process(volume, value, bVo, curVo, i+1);
	}
	
	public static void main(String[] args) {
		int[] vo = {2, 4, 1, 5, 6};
		int[] va = {1, 4, 2, 4, 2};
		
		System.out.println(knapSack(vo, va, 4));
	}
}
