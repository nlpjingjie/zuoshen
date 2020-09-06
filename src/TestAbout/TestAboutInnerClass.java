package TestAbout;


public class TestAboutInnerClass {
	public static void main(String[] args) {
		// 无法这样使用
//		Bean1 bean11 = new Bean1();
		
		TestAboutInnerClass test = new TestAboutInnerClass();
		TestAboutInnerClass.Bean1 bean1 = test.new Bean1();
		bean1.I++;
		System.out.println(bean1.I+": 在外部类main函数中使用成员内部类");
		
		// 可以直接new
		Bean2 bean2 = new Bean2();
		bean2.J++;
		System.out.println(bean2.J+": 在外部类main函数中使用静态内部类");
		
		// 也可以这样  类名.静态内部类类名
//		TestAboutInnerClass.Bean2 bean23 = new TestAboutInnerClass.Bean2(); 
		
		Bean bean = new Bean();
		Bean.Bean3 bean3 = bean.new Bean3();
		bean3.K++;
		System.out.println(bean3.K+": 在外部类外使用成员内部类");
		
		
		Bean.Bean4 bean4 = new Bean.Bean4();
		bean4.L++;
		System.out.println(bean4.L+": 在外部类外使用静态内部类");
		
		test.testInner();
		
	}
	
	void testInner() {
		Bean1 bean11 = new Bean1();
		bean11.I++;
		System.out.println(bean11.I+": 在外部类普通函数中使用成员内部类");
		
		Bean2 bean22 = new Bean2();
		bean22.J++;
		System.out.println(bean22.J+": 在外部类普通函数中使用静态内部类");
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