package test.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import main.src.common.Log;

public class Spring09 {

	public static void main(String[] args) throws  Exception {
		Resource rs = new ClassPathResource("struts.xml");
		Log.print("ClassPathResource-xml", rs.getFilename());
		Log.print("ClassPathResource-exists", rs.exists());
		rs = new FileSystemResource("d:/x.xml");
		Log.print("FileSystemResource-xml", rs.getFilename());
		Log.print("FileSystemResource-exists", rs.exists());
		

}

}
