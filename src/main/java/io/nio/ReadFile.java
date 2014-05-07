package io.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 传统IO的方式使用NIO
 * "用竹筒反复取水"
 * @author jomin
 *
 */
public class ReadFile {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("");
		FileChannel channel = fis.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(64);
		
		while (channel.read(buffer) != -1) {
			//锁定buffer空白处
			buffer.flip();
			//创建解码器
			Charset charset = Charset.forName("UTF-8");
			CharsetDecoder newDecoder = charset.newDecoder();
			System.out.println(newDecoder.decode(buffer));
			
			buffer.clear();
		}
	}
}
