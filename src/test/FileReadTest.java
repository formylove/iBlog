package test;

import java.io.File;

public class FileReadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "webcontent/web-inf/hi.html";//��ȡ�������ļ�
		File f = new File(path);
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());
	}

}
