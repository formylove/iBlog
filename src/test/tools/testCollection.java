package test.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.src.common.Log;
import main.src.entity.User;

public class testCollection {
	public static void main(String[] args) throws IOException {
		List<User> users = new ArrayList<User>();
		Log.print("size", users.size());
}
}
