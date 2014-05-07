package io.nio;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		//创建
		CharBuffer buff = CharBuffer.allocate(8);
		
		//放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c');
		
		//调用flip()方法，准备读取
		buff.flip();
		System.out.println(buff.get());
		
		buff.clear();
	}
}
