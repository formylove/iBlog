package test;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.Diary;

public class DBtest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

//		String sql="select * from diary";
//		List results=SqlUtils.executeQuery(sql, null);
//		String s=(String) ((Map)results.get(0)).get("content");r
//		System.out.println(s);
//		List<Diary> res=(List<Diary>)SqlUtils.executeQuery(sql,null, Diary.class);

		
//		System.out.println(results);
//		System.out.println(res.get(0).getLabel());
//		System.out.println(res.get(0).isDel_flag());
		String sql2="INSERT INTO `user` (`user_name`) VALUES ( ?)";
		Object[] params={"¹þ¹þ222"};
		SqlUtils.executeUpdate(sql2, params);
	}

}
