package me.jomin.rpc.support;

import me.jomin.rpc.protocal.Invocation;

public interface IServer {
	public void stop();
	public void start();
	public void register(Class interfaceDefiner,Class impl);
	public void call(Invocation invo);
	public boolean isRunning();
	public int getPort();
}
