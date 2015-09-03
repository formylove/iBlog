package main.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.Diary;

public class DiaryService {
	static final String TABLE_DIARY="diary"; 
	static public Diary getDiary(int id){
		@SuppressWarnings("unchecked")
		List<Diary> diaries=getDiaries("id="+id);
		if(diaries.size()==1)
		{
			return diaries.get(0);
		}else{
			return null;
		}
	}
	
	static public int getLatestDiaryId(){
		String sql="SELECT * from diary order by id DESC LIMIT 0,1";
		@SuppressWarnings("unchecked")
		List<Diary> diaries=(List<Diary>)SqlUtils.executeQuery(sql, null, Diary.class);
		if(diaries.size()==1)
		{
			return (diaries.get(0)).getId();
		}else{
			return 0;
		}
	}
	
	static public boolean hasExisted(String title){
		@SuppressWarnings("unchecked")
		List<Diary> diaries= getDiaries("title ='"+ title +"'");
		if(diaries.size()==1)
		{
			return true;
		}else{
			return false;
		}
	}
	
	static public boolean hasForwarded(String url){
		@SuppressWarnings("unchecked")
		List<Diary> diaries= getDiaries("original_link ='"+ url +"' and del_flag = 0");
		if(diaries.size()==1)
		{
			return true;
		}else{
			return false;
		}
	}
	static public List<Diary> getDiaries(String condition){
		String sql="SELECT * from diary where " + condition;
		@SuppressWarnings("unchecked")
		List<Diary> diaries=(List<Diary>)SqlUtils.executeQuery(sql, null, Diary.class);
			return diaries;
	}
	
	static public boolean forward(String url){
		if(hasForwarded(url))
		{
			deleteDiary("original_link='"+url+"'");
			return false;
		}else if(getDiaries("original_link= '"+url +"' and del_flag = 1").size()>=1){
			recoverDiary(url);
		}else{
			loadForwardDiary(url);
		}
		return true;

	}
	static public String loadForwardDiary(String url){
		if(url.indexOf("zhihu")>=0){
			loadZhihu(url);
		}else if(url.indexOf("csdn")>=0){
			loadCSDN(url);
		}
         return null;
	}
	
	static public boolean loadZhihu(String url){
			Map<String,Object> data=new HashMap<String,Object>();
			data.put("original_link", url);
			data.put("content", "test");
			data.put("create_date", TimeManager.getDate());
			data.put("create_time", TimeManager.getTime());
			DiaryService.saveDiary(data);
		return true;
	}
	static public boolean loadCSDN(String url){
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("original_link", url);
		data.put("content", "test");
		data.put("create_date", TimeManager.getDate());
		data.put("create_time", TimeManager.getTime());
		DiaryService.saveDiary(data);
		return true;
	}
	
	
	static public int deleteDiary(int id){
		String sql="update  diary set del_flag=1 where id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int recoverDiary(int id){
		String sql="update  diary set del_flag=0 where id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int recoverDiary(String url){
		String sql="update  diary set del_flag=0 where original_link='"+url+"'";
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int likeDiary(int id){
		String sql="UPDATE diary set favor_cnt = favor_cnt+1 WHERE id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int undoLikeDiary(int id){
		Diary diary = getDiary(id);
		if(diary.getFavor_cnt() != 0){
			String sql="UPDATE diary set favor_cnt = favor_cnt-1 WHERE id="+id;
			return SqlUtils.executeUpdate(sql, null);
		}
		return 0;
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
	
	static public int saveDiary(Diary diary){
		System.out.println(diary.getClass().getSimpleName());
		return SqlUtils.executeInsert(diary);
	}
	
	static public int updateDiary(Map<String,Object> data,String condition){
		return SqlUtils.executeUpdate(data, TABLE_DIARY, condition);
	}
	
	static public int updateDiary(String condition ,Diary diary){
		return SqlUtils.executeUpdate(condition, diary);
	}
	
	static public int deleteDiary(String condition){
		Map<String,Object> flag=new HashMap<String, Object>();
		flag.put("del_flag", 1);
		return updateDiary(flag,condition);
	}
	
	
}
