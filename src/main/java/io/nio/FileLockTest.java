package io.nio;

import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws Exception  {
		FileChannel channel = new FileInputStream("").getChannel();
		
		FileLock lock = channel.tryLock();
		
		Thread.sleep(10000);
		
		lock.release();
	}
}
