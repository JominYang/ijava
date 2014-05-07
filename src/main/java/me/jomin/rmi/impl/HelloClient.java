package me.jomin.rmi.impl;

import java.rmi.Naming;

import me.jomin.rmi.iface.IHello;

/**
 * Java RMI -- 面向对象的JAVA RPC
 * - 允许方法返回 Java 对象以及基本数据类型
 * - RPC不支持对象的概念，传送到 RPC服务的消息由外部数据表示 (External Data Representation, XDR)语言表示
 * 
 * - JMS是一种允许应用程序创建、发送、接受和读取消息的Java API
 * - 采用JMS，对象是在物理上被异步从网络的某个JVM上直接移动到另一个JVM上
 * - 采用RMI 对象是绑定在本地JVM中，只有函数参数和返回值是通过网络传送的
 * 
 * - RMI底层协议为TCP/IP,RPC底层协议为UDP/TCP
 * - RMI是SUN公司定义的一个JAVA分布式框架,仅支持JAVA;而RPC是一个网络协议,支持多语言
 * 
 * @author YANGMING663
 * 2013年12月4日
 */
public class HelloClient {
	
	public static void main(String[] args) {
		try {
			//在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
			IHello rhello = (IHello) Naming.lookup("rmi://localhost:6789/RHello");
			System.out.println(rhello.sayHello("哈哈"));
			System.out.println(rhello.sum(1, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
