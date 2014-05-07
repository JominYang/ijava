package me.jomin.rpc.op;


public class RemoteEcho implements IEcho{
	public String echo(String echo) {
		return "from remote:"+echo;
	}
}
