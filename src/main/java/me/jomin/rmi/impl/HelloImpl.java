package me.jomin.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import me.jomin.rmi.iface.IHello;

/**
 * 实现类要实现Serializable接口，这里通过继承UnicastRemoteObject间接实现
 * 构造方法要抛出RemoteException，所以要显示指定
 * @author YANGMING663
 * 2013年12月4日
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

	private static final long serialVersionUID = 1L;

	protected HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello(String name) throws RemoteException {
		return "Welcome, " + name;
	}

	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}

}
