package TestAbout;


public class TestAboutInnerClass {
	public static void main(String[] args) {
		// �޷�����ʹ��
//		Bean1 bean11 = new Bean1();
		
		TestAboutInnerClass test = new TestAboutInnerClass();
		TestAboutInnerClass.Bean1 bean1 = test.new Bean1();
		bean1.I++;
		System.out.println(bean1.I+": ���ⲿ��main������ʹ�ó�Ա�ڲ���");
		
		// ����ֱ��new
		Bean2 bean2 = new Bean2();
		bean2.J++;
		System.out.println(bean2.J+": ���ⲿ��main������ʹ�þ�̬�ڲ���");
		
		// Ҳ��������  ����.��̬�ڲ�������
//		TestAboutInnerClass.Bean2 bean23 = new TestAboutInnerClass.Bean2(); 
		
		Bean bean = new Bean();
		Bean.Bean3 bean3 = bean.new Bean3();
		bean3.K++;
		System.out.println(bean3.K+": ���ⲿ����ʹ�ó�Ա�ڲ���");
		
		
		Bean.Bean4 bean4 = new Bean.Bean4();
		bean4.L++;
		System.out.println(bean4.L+": ���ⲿ����ʹ�þ�̬�ڲ���");
		
		test.testInner();
		
	}
	
	void testInner() {
		Bean1 bean11 = new Bean1();
		bean11.I++;
		System.out.println(bean11.I+": ���ⲿ����ͨ������ʹ�ó�Ա�ڲ���");
		
		Bean2 bean22 = new Bean2();
		bean22.J++;
		System.out.println(bean22.J+": ���ⲿ����ͨ������ʹ�þ�̬�ڲ���");
	}
	
	class Bean1 {
		public int I=0;
	}
	
	static class Bean2{
		public int J=0;
	}
}

class Bean{
	class Bean3{
		public int K=0;
	}
	
	static class Bean4{
		public int L=0;
	}
}