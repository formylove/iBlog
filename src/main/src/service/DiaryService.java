package main.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.entity.Diary;

public class DiaryService {
	static final String TABLE_DIARY="diary"; 
	static public Diary getDiary(int id){
		String sql="select * from diary where id="+id;
		@SuppressWarnings("unchecked")
		List<Diary> diaries=(List<Diary>)SqlUtils.executeQuery(sql, null, Diary.class);
		return diaries.get(0);
	}
	
	static public int deleteDiary(int id){
		String sql="update  diary set del_flag=1 where id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public List<Diary> getDiaries(int start,int end){
		String sql="select * from diary limit start-1,end-start+1 where del_flag<>1";
		@SuppressWarnings("unchecked")
		List<Diary> diaries=(List<Diary>)SqlUtils.executeQuery(sql, new Object[]{start,end}, Diary.class);
		return diaries;
	}
	
	
	static public List<Diary> getDiaries4Page(int page,int pageSize){
		return getDiaries((page-1)*pageSize+1,page*pageSize);
	}
	
	@SuppressWarnings("unchecked")
	static public List<Diary> getAllDiaries(boolean del_flag){
		String sql="select * from diary"+(del_flag?"":"and del_flag<>1 ");
		return (List<Diary>) SqlUtils.executeQuery(sql,null,Diary.class);
	}
	
	static public int saveDiary(Map<String,Object> data){
		return SqlUtils.executeInsert(data, TABLE_DIARY);
	}
	
	static public int updateDiary(Map<String,Object> data,String condition){
		return SqlUtils.executeUpdate(data, TABLE_DIARY, condition);
	}
	
	static public int deleteDiary(String condition){
		Map<String,Object> flag=new HashMap<String, Object>();
		flag.put("del_flag", 1);
		return updateDiary(flag,condition);
	}
	
	
}
