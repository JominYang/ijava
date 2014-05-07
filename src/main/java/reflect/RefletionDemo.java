package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * 1、获取程序在运行时刻的内部结构
 * 2、对运行时刻的Java对象进行操作，可通过setAccessible绕过Java默认的访问控制检查
 * @author jomin
 */
public class RefletionDemo {

	public static void main(String[] args) throws Exception {
		//一般的反射处理
		Constructor<MyClass> constructor = MyClass.class.getConstructor(int.class);
		MyClass myClassReflect = constructor.newInstance(10);
		Method method = MyClass.class.getMethod("increase", int.class);
		method.invoke(myClassReflect, 5);
		Field field = MyClass.class.getField("_count");
		
		System.out.println(field.getInt(myClassReflect));
		
		//数组的反射
		Object array = Array.newInstance(String.class, 10);//new String[10]
		Array.set(array, 0, "Hello");//array[0] = "Hello"
		Array.set(array, 1, "World");
		System.out.println(Array.get(array, 0)); //array[0]
		
		//处理泛型
		//当声明了List<String>泛型类的域，虽然在运行时刻类型会变为原始的List，但是仍然可以通过反射来获取到实际的类型参数
	}
}

class MyClass {
	public int _count;
	public MyClass(int start) {
		_count = start;
	}
	public void increase(int step) {
		_count += step;
	}
}
