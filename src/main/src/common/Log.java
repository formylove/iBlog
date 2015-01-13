package main.src.common;

import javax.swing.JOptionPane;

public class Log {
	static int i=0;
	
public static String print(String tag,Object info){
	if(tag!=null){
		System.out.println(tag+" : "+info);
	}else{
		System.out.println((i++)+" : "+info);
	}
	return null;
}

public static String print(Object message){
		System.out.println((i++)+" : "+message);
	return null;
}

public static String achieve(String tag,Object initial){
return JOptionPane.showInputDialog(tag, initial);
}

public static String show(String tag,String message){
	if(tag==null)
		JOptionPane.showMessageDialog(null, (i++)+" : "+message);
	else{
		JOptionPane.showMessageDialog(null, tag+" : "+message);
	}
	return null;
}

}
