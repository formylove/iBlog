package test;


import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class AutoDetectCharset {
	
	/**
	 * 娴嬭瘯杈撳叆瀛楄妭娴佹槸鍚﹁兘澶熶娇鐢ㄦ寚瀹氱殑瀛楃闆嗚В鐮併�
	 */
	public static boolean canDecode(InputStream input, Charset charset) throws IOException {
		ReadableByteChannel channel = Channels.newChannel(input);
		CharsetDecoder decoder = charset.newDecoder();

		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		CharBuffer charBuffer = CharBuffer.allocate(1024);
	
		boolean endOfInput = false;
		while (!endOfInput) {
			int n = channel.read(byteBuffer);
			byteBuffer.flip(); // flip so it can be drained
			
			endOfInput = (n == -1);
			CoderResult coderResult = decoder.decode(byteBuffer, charBuffer, endOfInput);
			charBuffer.clear();
			if (coderResult == CoderResult.OVERFLOW) {
				while (coderResult == CoderResult.OVERFLOW) {
					coderResult = decoder.decode(byteBuffer, charBuffer, endOfInput);
					charBuffer.clear();
				}
			}
			if (coderResult.isError()) {
				return false;
			}
			byteBuffer.compact(); // compact so it can be refilled
		}
		CoderResult coderResult;
		while ((coderResult = decoder.flush(charBuffer)) == CoderResult.OVERFLOW) {
			charBuffer.clear();
		}
		if (coderResult.isError()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 浣跨敤鎸囧畾鐨勫瓧绗﹂泦瑙ｇ爜瀛楄妭杈撳叆娴侊紝骞跺皢瀹冨啓鍏ュ埌瀛楃杈撳嚭娴佷腑锛屽鏋滃彂鐢熻В鐮侀敊璇垯杩斿洖false锛屽惁鍒欒繑鍥瀟rue锛�	 * 杈撳叆涓殑鏃犳晥瀛楄妭搴忓垪灏嗚蹇界暐銆�	 */
	public static boolean decode(InputStream input, Writer output, Charset charset) throws IOException {
		ReadableByteChannel channel = Channels.newChannel(input);
		CharsetDecoder decoder = charset.newDecoder();

		ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
		CharBuffer charBuffer = CharBuffer.allocate(1024);
	
		boolean endOfInput = false;
		boolean error = false;
		while (!endOfInput) {
			int n = channel.read(byteBuffer);
			byteBuffer.flip(); // flip so it can be drained
			
			endOfInput = (n == -1);
			CoderResult coderResult = decoder.decode(byteBuffer, charBuffer, endOfInput);
			error = drainCharBuffer(error, byteBuffer, charBuffer, coderResult, output);
			if (coderResult != CoderResult.UNDERFLOW) {
				while (coderResult != CoderResult.UNDERFLOW) {
					coderResult = decoder.decode(byteBuffer, charBuffer, endOfInput);
					error = drainCharBuffer(error, byteBuffer, charBuffer, coderResult, output);
				}
			}
			byteBuffer.compact(); // compact so it can be refilled
		}
		CoderResult coderResult;
		while ((coderResult = decoder.flush(charBuffer)) != CoderResult.UNDERFLOW) {
			error = drainCharBuffer(error, byteBuffer, charBuffer, coderResult, output);
		}
		error = drainCharBuffer(error, byteBuffer, charBuffer, coderResult, output);
		
		output.flush();
		return !error;
	}
	
	private static boolean drainCharBuffer(boolean error, ByteBuffer byteBuffer, 
			CharBuffer charBuffer, CoderResult coderResult, Writer output) throws IOException {
		// write charBuffer to output
		charBuffer.flip();
		if (charBuffer.hasRemaining())
			output.write(charBuffer.toString());
		charBuffer.clear();
		
		if (coderResult.isError()) {
			error = true;
			byteBuffer.position(byteBuffer.position() + coderResult.length()); // ignore invalid byte sequence
		}
		return error;
	}
	
	
	public static void main(String[] args) throws IOException {
		String s = "????????????????";
		
		byte[] utf8Bytes = s.getBytes(Charset.forName("utf-8"));
		byte[] gbkBytes = s.getBytes(Charset.forName("gbk"));
		CharArrayWriter writer = new CharArrayWriter();
		System.out.println(canDecode(new ByteArrayInputStream(utf8Bytes), Charset.forName("utf-8")));
		System.out.println(decode(new ByteArrayInputStream(utf8Bytes), writer, Charset.forName("utf-8")));
		System.out.println(writer.toString());
		writer = new CharArrayWriter();
		System.out.println(canDecode(new ByteArrayInputStream(gbkBytes), Charset.forName("utf-8")));
		System.out.println(decode(new ByteArrayInputStream(gbkBytes), writer, Charset.forName("utf-8")));
		System.out.println(writer.toString());
		writer = new CharArrayWriter();
		System.out.println(canDecode(new ByteArrayInputStream(utf8Bytes), Charset.forName("gbk")));
		System.out.println(decode(new ByteArrayInputStream(utf8Bytes), writer, Charset.forName("gbk")));
		System.out.println(writer.toString());
		writer = new CharArrayWriter();
		System.out.println(canDecode(new ByteArrayInputStream(gbkBytes), Charset.forName("gbk")));
		System.out.println(decode(new ByteArrayInputStream(gbkBytes), writer, Charset.forName("gbk")));
		System.out.println(writer.toString());
		
		FileInputStream fis = new FileInputStream("src/test/AutoDetectCharset.java");
		System.out.println(decode(fis, new OutputStreamWriter(System.out), Charset.forName("utf-8")));
	}
}
