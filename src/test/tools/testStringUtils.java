package test.tools;

import org.springframework.util.StringUtils;

public class testStringUtils {

	public testStringUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StringUtils.quoteIfString("sdfasdf"));
		System.out.println(StringUtils.unqualify("asfdffasfad", 'a'));

	}

}
