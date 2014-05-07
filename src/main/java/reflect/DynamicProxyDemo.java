package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
/**
 * 动态代理
 * 代理模式-代理对象与被代理对象实现相同的接口，调用者与代理对象交互，代理的存在对调用者是透明的。
 * @author jomin
 *
 */
interface CalculatorProtocol {
	public int add(int a, int b);

	public int subtract(int a, int b);
}

class Server implements CalculatorProtocol {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}
}

class CalculatorHandler implements InvocationHandler {//代理类

	private Object objOriginal;

	public CalculatorHandler(Object obj) {
		this.objOriginal = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 可添加预处理
		Object result = method.invoke(this.objOriginal, args);
		// 可添加后续处理
		return result;
	}

}

public class DynamicProxyDemo {
	public static void main(String[] args) {
		CalculatorProtocol server = new Server();//被代理类
		InvocationHandler handler = new CalculatorHandler(server);
		CalculatorProtocol client = (CalculatorProtocol) Proxy//代理对象
				.newProxyInstance(server.getClass().getClassLoader(), server
						.getClass().getInterfaces(), handler);
		/*
		 * 逻辑，调用代理对象的方法，访问InvocationHandler的invoke方法，在invoke方法中增加逻辑，然后调用被代理类的方法
		 */
		
		System.out.println(client.add(5, 6));
		System.out.println(client.subtract(4, 2));
	}
	
	/**
	 * 传入List接口的对象，返回的是List的代理对象，然后调用InvocationHandler的invoke方法，其中禁止add方法的访问
	 * 相当与AOP的原生实现，而不用使用AspectJ等框架
	 */
	public List getList(final List list) {
		return (List) Proxy.newProxyInstance(DynamicProxyDemo.class.getClassLoader(), new Class[]{ List.class }, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				if ("add".equals(method.getName())) {
					throw new UnsupportedOperationException();
				} else {
					return method.invoke(list, args);
					}		
				}
		});
	}
}
