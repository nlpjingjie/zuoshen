package TestAbout;


import java.util.regex.Pattern;

public class GetInt {
   public static void main(String[] args) {
       String content = "-love2.3next234csdn3423javaeye";
       //������ʽ������ƥ������ִ���+������ƥ�����������ִ�
       String regEx="[^0-9]+"; 
       Pattern pattern = Pattern.compile(regEx);
       //�ö���õ�������ʽ����ַ��������ַ����е�����������
       String[] cs = pattern.split(content);
       String res = "";
       if(content.charAt(0) == '-') {
    	   res += "-";
       }
       for(String s:cs) {
    	   res += s;
       }
       System.out.println(Integer.parseInt(res));
   }
}
