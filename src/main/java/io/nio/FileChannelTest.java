package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	public static void main(String[] args) throws Exception {
		File file = new File("FileChannelTest.java");
		
		//创建FileInputStream，以该文件输入流创建FileChannel
		FileChannel inChannel = new FileInputStream(file).getChannel();
		FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
		
		//将FileChannel中的数据全部映射成ByteBuffer
		MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		//使用UTF8字符集创建解码器
		Charset charset = Charset.forName("UTF-8");
		//直接将buffer中的数据全部输出
		outChannel.write(buffer);
		//再次调用buffer的clear()方法，复原limit和position位置
		buffer.clear();
		//创建解码器对象
		CharsetDecoder decoder = charset.newDecoder();
		//使用解码器将ByteBuffer转换成CharBuffer
		CharBuffer charBuffer = decoder.decode(buffer);
		//CharBuffer的toString()方法输出
		System.out.println(charBuffer);
		
		
		//RandomFileChannel
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		FileChannel randomChannel = raf.getChannel();
		ByteBuffer byteBuffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		//
		randomChannel.position(file.length());
		//将buffer中的所有数据输出
		randomChannel.write(buffer);
	}
}
