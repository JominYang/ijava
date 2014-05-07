package io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransformTest {

	public static void main(String[] args) throws Exception {
		
		Charset cn = Charset.forName("UTF-8");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		
		CharBuffer charBuffer = CharBuffer.allocate(10);
		charBuffer.put("七");
		charBuffer.put("个");
		charBuffer.put("苹");
		charBuffer.flip();
		
		ByteBuffer byteBuffer = cnEncoder.encode(charBuffer);
//		ByteBuffer encodeBuffer = cn.encode(charBuffer);
		
		System.out.println(cnDecoder.decode(byteBuffer));
//		System.out.println(cn.decode(encodeBuffer));
		
	}
}
