package cn.jingjie.zuo;

// 0-1�������⣬��n����Ʒ��ÿ����Ʒ������w����ֵv,��һ���̶������ı���V,�󱳰�����������Ʒ������ֵ��
public class KnapSack {
	public static int knapSack(int[] volume, int[] value, int bVo) {
		return process(volume, value, bVo, 0, 0);
	}

	private static int process(int[] volume, int[] value, int bVo, int curVo, int i) {
		if(curVo > bVo || i == volume.length) {
			return 0;
		}
		// ��������жϣ��ͻ���ǰ�Ѽ�ֵ���ϵ��´���
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
