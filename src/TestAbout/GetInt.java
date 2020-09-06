package TestAbout;


import java.util.regex.Pattern;

public class GetInt {
   public static void main(String[] args) {
       String content = "-love2.3next234csdn3423javaeye";
       //正则表达式，用于匹配非数字串，+号用于匹配出多个非数字串
       String regEx="[^0-9]+"; 
       Pattern pattern = Pattern.compile(regEx);
       //用定义好的正则表达式拆分字符串，把字符串中的数字留出来
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
