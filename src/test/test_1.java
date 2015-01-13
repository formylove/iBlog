package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import main.src.entity.User;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class test_1 {

	public static void main(String[] args) {
		String a="dd" ;
		String url="jdbc:mysql://localhost:3306/irestaurant";
		String Driver="com.mysql.jdbc.Driver";
		String user="hachi";
		String password="0606";
		Connection cnn=null;
		DbUtils.loadDriver(Driver);
		
		try {
			cnn=DriverManager.getConnection(url,user,password);
			QueryRunner qr=new QueryRunner();
			@SuppressWarnings("unchecked")
			List ls=qr.query(cnn, "select * from user", new BeanListHandler<User>(User.class));
			
				System.out.println(((User)ls.get(0)).getAuthority());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
