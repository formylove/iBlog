package test.tools;

import java.util.ArrayList;
import java.util.List;

import main.src.common.Log;
import main.src.entity.User;

public class testGeneric {
	public static void main(String[] args) throws Exception {
		List<User> us = new ArrayList<User>();
		Log.print("Class", us.getClass());
		Log.print("equal", us instanceof ArrayList);
		//泛型不算类型
//		Log.print("equal", us instanceof ArrayList<User>);
	}
}
}
