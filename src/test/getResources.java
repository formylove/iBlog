package test;

import java.util.ResourceBundle;

public class getResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ResourceBundle rb=ResourceBundle.getBundle("main.resource.dbinfo");
System.out.println(rb.getString("url"));
	}

}
