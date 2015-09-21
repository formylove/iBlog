package main.src.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import main.src.entity.essay.Essay;

public class SqlUtils {
	static String url = null;
	static String Driver = null;
	static String user = null;
	static String password = null;
	static Connection cnn = null;
	static {
		Driver = MessageUtils.getMessageFromDbInfo("Driver");
		url = MessageUtils.getMessageFromDbInfo("url");
		DbUtils.loadDriver(Driver);
		System.out.println("*****************************dbutil*********************************");
	}

	public static Connection getConnection() throws SQLException {
		cnn = DriverManager.getConnection(url);
		return cnn;
	}

	// 统计查询器
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static long stat(String sql, Object... params) {
		QueryRunner qr = new QueryRunner();
		final ScalarHandler _g_scaleHandler = new ScalarHandler() {

			@Override
			public Object handle(ResultSet rs) throws SQLException {
				Object obj = super.handle(rs);
				if (obj instanceof BigInteger)
					return ((BigInteger) obj).longValue();
				return obj;
			}
		};

		try {

			Number num = (Number) qr.query(getConnection(), sql,
					_g_scaleHandler, params);
			return (num != null) ? num.longValue() : -1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	// 类查询器
	public static List<?> executeQuery(String sql, Object[] params, Class entity) {
		List<Map<String, Object>> result = null;
		QueryRunner qr = new QueryRunner();
		try {
			if (null == cnn) {
				cnn = getConnection();
			}
			result = qr.query(cnn, sql, new MapListHandler(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return MaptoBean(result, entity);
	}

	// 字段查询器
	public static List<Map<String, Object>> executeQuery(String sql,
			Object[] params) {
		List<Map<String, Object>> result = null;
		try {
			if (null == cnn) {
				cnn = getConnection();
			}
			QueryRunner qr = new QueryRunner();
			if (params == null || params.length == 0)
				result = qr.query(cnn, sql, new MapListHandler());
			else
				result = qr.query(cnn, sql, new MapListHandler(), params);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	// 字段查询器
	@SuppressWarnings("unchecked")
	public static int executeQueryForCount(String sql, Object[] params) {
		int result = -1;
		try {
			if (null == cnn) {
				cnn = getConnection();
			}
			QueryRunner qr = new QueryRunner();
			if (params == null || params.length == 0)
				result = (int)(long)qr.query(cnn, sql, new ScalarHandler());
			else
				result = (int)qr.query(cnn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// update
	public static int executeUpdate(String sql, Object[] params) {
		int count = 0;
		try {
			if (null == cnn) {
				cnn = getConnection();
			}
			QueryRunner qr = new QueryRunner();
			count = qr.update(cnn, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public static int executeInsert(Map<String, Object> data, String tableName) {
		String columns = "";
		String values = "";
		for (Entry<String, Object> datum : data.entrySet()) {
			if(null==datum.getValue() || "undefined".equalsIgnoreCase(datum.getValue().toString()) || "".equalsIgnoreCase(datum.getValue().toString()))
			{
				continue;
			}
			columns =columns + datum.getKey() + ",";
			if(datum.getValue().getClass()==String.class){
				values =values + "'" + datum.getValue() + "',";
			}
			else{
				values =values + datum.getValue() + ",";
			}
		}
		columns = columns.substring(0, columns.length() - 1);
		values = values.substring(0, values.length() - 1);
		String sql = "insert into " + tableName + "(" + columns + ")" 	+ "values(" + values + ")";
		executeUpdate(sql, null);
		return getLatatestId();
	}
	
	public static int executeInsert(Object entity) {
		String columns = "";
		String values = "";
		@SuppressWarnings("rawtypes")
		Class class_ = entity.getClass();
		for(Field field:class_.getFields()){
			if(field.getType() == String.class){
				try {
					if(null == BeanUtils.getProperty(entity, field.getName()) || "".equalsIgnoreCase(BeanUtils.getProperty(entity, field.getName())))
					{
						continue;
					}else{
						columns =columns + field.getName() + ",";
						values =values + "'" +BeanUtils.getProperty(entity, field.getName()) + "',";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				columns =columns + field.getName() + ",";
				try {
					values =values + BeanUtils.getProperty(entity, field.getName()) + ",";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		String tableName = null;
		if(class_.getSuperclass() == Object.class){
			tableName = class_.getSimpleName();
		}else{
			tableName = class_.getSuperclass().getSimpleName();
		}
		
		columns = columns.substring(0, columns.length() - 1);
		values = values.substring(0, values.length() - 1);
		String sql = "insert into " + tableName + " (" + columns + ")" 	+ " values(" + values + ")";
		Log.print("insert sql: ", sql);
		executeUpdate(sql, null);
		return getLatatestId();
	}
	// bean转换器
	@SuppressWarnings("unchecked")
	public static List<Object> MaptoBean(List<Map<String, Object>> resultSet,
			Class entity) {
		Object obj = null;
		try {

			obj = ConstructorUtils.invokeExactConstructor(entity, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 存放返回对象
		List<Object> beans = new ArrayList<Object>();
		if (null != resultSet) {
			for (Map<String, Object> result : resultSet) {
				try {

					obj = ConstructorUtils.invokeExactConstructor(entity, null);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Map.Entry<String, Object> entry : result.entrySet()) {

					String key = entry.getKey();
					Object value = entry.getValue();
					try {
						BeanUtils.setProperty(obj, key.toLowerCase(), value);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				beans.add(obj);
			}
		}
		return beans;
	}

	public static int executeUpdate(Map<String, Object> data, String tableName,String condition) {
		String sql = "update " + tableName + " set ";
		for (Entry<String, Object> datum : data.entrySet()) {
			if(null==datum.getValue() || "undefined".equalsIgnoreCase(datum.getValue().toString()) || "".equalsIgnoreCase(datum.getValue().toString()))
			{
				continue;
			}
			if(datum.getValue().getClass()==String.class)
			{
				sql = sql + datum.getKey() + "='" + datum.getValue() + "',";
			}else{
				sql = sql + datum.getKey() + "=" + datum.getValue() + ",";
			}
		}
		sql = sql.substring(0, sql.length() - 1)+" where "+condition;
		Log.print(sql);
		return executeUpdate(sql, null);
	}
	
	public static int executeUpdate(String condition ,Object entity) {
			Class class_ = entity.getClass();
			String tableName = null;
			if(class_.getSuperclass() == Object.class){
				tableName = class_.getSimpleName();
			}else{
				tableName = class_.getSuperclass().getSimpleName();
			}
			String sql = "update " + tableName + " set ";
			for(Field field:class_.getFields()){
				if(field.getType() == String.class){
					try {
						if(null == BeanUtils.getProperty(entity, field.getName()) || "".equalsIgnoreCase(BeanUtils.getProperty(entity, field.getName())))
						{
							continue;
						}else{
							sql = sql + field.getName() + "='" + BeanUtils.getProperty(entity, field.getName()) + "',";
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					try {
						sql = sql + field.getName() + "=" + BeanUtils.getProperty(entity, field.getName()) + ",";
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			sql = sql.substring(0, sql.length() - 1)+" where "+condition;
			Log.print(sql);
			return executeUpdate(sql, null);
	}

	
	
	
	
	
	public static int executeDelete(String tableName,String condition) {
		String sql="delete from "+tableName+" where "+condition;
		return executeUpdate(sql, null);
	}
	
	public static int getLatatestId()  {
		
		String sql="SELECT LAST_INSERT_ID()";
		Statement st;
		ResultSet rs;
		try {
			st = cnn.createStatement();
			if(st.execute(sql)){
				rs = st.getResultSet();
				rs.next();
				System.out.println("latestId:  "+rs.getInt(1));
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	public static void main(String args[]) {
Map<String,Object> data=new HashMap<String, Object>();
data.put("name", "知乎");
data.put("del_flag", 1);
data.put("level", 7);

Log.show(null, ""+executeInsert(data, "category"));
Log.show(null, ""+executeUpdate(data, "category","id=3001"));
Log.show(null, ""+executeDelete("category","id=3001"));
	}
}
