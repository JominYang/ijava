package me.jomin.rmi.iface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {

	public String sayHello(String name) throws RemoteException;
	public int sum(int a, int b) throws RemoteException;
}
