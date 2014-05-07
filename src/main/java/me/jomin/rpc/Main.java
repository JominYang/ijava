package me.jomin.rpc;

import me.jomin.rpc.op.IEcho;
import me.jomin.rpc.op.RemoteEcho;
import me.jomin.rpc.support.IServer;

public class Main {
	public static void main(String[] args) {
		IServer server = new RPC.RPCServer();
		server.register(IEcho.class, RemoteEcho.class);
		server.start();
	}

}
