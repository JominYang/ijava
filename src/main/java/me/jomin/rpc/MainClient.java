package me.jomin.rpc;

import me.jomin.rpc.op.IEcho;

public class MainClient {
	public static void main(String[] args) {
		/*
		 * 使用RPC.getProxy生成接口Echo的代理实现类
		 * 然后就可以像使用本地的程序一样来调用Echo中的echo方法
		 * 在分发代码时，只需要将接口分发给客户端使用
		 */
		IEcho echo = RPC.getProxy(IEcho.class, "127.0.0.1", 20382);
		System.out.println(echo.echo("hello,hello"));
		System.out.println(echo.echo("hellow,rod"));
		System.out.println(echo.echo("hellow,rod"));
		System.out.println(echo.echo("hellow,rod"));
		System.out.println(echo.echo("hellow,rod"));
		System.out.println(echo.echo("hellow,rod"));
	}
}
