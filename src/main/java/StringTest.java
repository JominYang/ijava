import org.junit.Test;

public class StringTest {

	@Test
	public void test1() throws Exception {
		String a = "aaa";
		String b = new String("aaa");//其实有两个String对象产生
		a += "bbb";//底层使用StringBuilder的append()实现
		
		//1、startsWith endsWith
		
		//2、equals，Object的equals为引用同一个对象才会true，不同类的对象equals一定为false
		
		
		//3、equalsIgnoreCase
		
		//4、getByte, new String(byte[] bytes)
		String param = "中文test";
		param = new String(param.getBytes("UTF-8"), "ISO-8859-1");//中文乱码
		
		//这里使用ISO-8859-1这种不支持中文的字符集编码，因为在JVM中，任何String都是一个unicode字符串
		param = new String(param.getBytes("ISO-8859-1"), "UTF-8");//正常
		
		//5、indexOf、lastIndexOf、substring
		
		//6、relaceAll 正则替换
		
		//7、split、trim
		
		//8、常量池
		String param1 = "Rose";
		String param2 = "Rose";
		String param3 = "Ro" + "se";
		System.out.println(param1 == param2); //true
		System.out.println(param1 == param3); //true
		
		
		String param4 = "Ro";
		String param5 = "Ro";
		String param6 = "Ro" + "se";//字符串常量，编译时就能确定
		
		param5 += "se"; //运行时使用StringBuilder实现
		param6 = param6 + "se";//同上
	}
	
	@Test
	public void test2() {
		String p1 = "Rose";
		String p2 = new String("Rose");
		String p3 = new String("Rose");
		
		
		System.out.println(p1 = p2);//false
		System.out.println(p1 = p3);//false
		
		//intern 如果常量池中有此字符串对象，则返回池中此对象的引用，如果没有，则加入池中，返回引用
		p2.intern();
		p3 = p3.intern();
		
		System.out.println(p1 == p2); //false
		System.out.println(p1 == p3);//true
		System.out.println(p1 == p2.intern());//true
	}
}
