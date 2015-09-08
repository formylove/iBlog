package main.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.entity.essay.CSDN;
import main.src.entity.essay.Essay;
import main.src.entity.essay.Zhidao;
import main.src.entity.essay.Zhihu;

public class EssayService {
	static final String TABLE_ESSAY="essay"; 
	static public Essay getEssay(int id){
		@SuppressWarnings("unchecked")
		List<Essay> diaries=getDiaries("id="+id);
		if(diaries.size()==1)
		{
			return diaries.get(0);
		}else{
			return null;
		}
	}
	
	static public int getLatestEssayId(){
		String sql="SELECT * from essay order by id DESC LIMIT 0,1";
		@SuppressWarnings("unchecked")
		List<Essay> diaries=(List<Essay>)SqlUtils.executeQuery(sql, null, Essay.class);
		if(diaries.size()==1)
		{
			return (diaries.get(0)).getId();
		}else{
			return 0;
		}
	}
	
	static public boolean hasExisted(String title){
		@SuppressWarnings("unchecked")
		List<Essay> diaries= getDiaries("title ='"+ title +"'");
		if(diaries.size()==1)
		{
			return true;
		}else{
			return false;
		}
	}
	
	static public boolean hasForwarded(String url){
		@SuppressWarnings("unchecked")
		List<Essay> diaries= getDiaries("original_link ='"+ url +"' and del_flag = 0");
		if(diaries.size()>=1)
		{
			return true;
		}else{
			return false;
		}
	}
	static public List<Essay> getDiaries(String condition){
		String sql="SELECT * from essay where " + condition;
		@SuppressWarnings("unchecked")
		List<Essay> diaries=(List<Essay>)SqlUtils.executeQuery(sql, null, Essay.class);
			return diaries;
	}
	
	static public int forward(String url){
		List<Essay> diaries = getDiaries("original_link= '"+url +"'");
		if(diaries.size() == 0){
			return loadForwardEssay(url);
		}else if(diaries.get(0).isDel_flag()){
			recoverEssay(url);
			return diaries.get(0).getId();
		}else{
			deleteEssay("original_link='"+url+"'");
			return 0;
		}
	}
	static public int loadForwardEssay(String url){
		url = url.toLowerCase();
		if(url.indexOf("zhihu")>=0){
			SqlUtils.executeInsert(new Zhihu(url));
		}else if(url.indexOf("zhidao.baidu")>=0){
			SqlUtils.executeInsert(new Zhidao(url));
		}else if(url.indexOf("blog.csdn.net")>=0){
			SqlUtils.executeInsert(new CSDN(url));
		}
         return EssayService.getLatestEssayId();
	}
	
	static public int deleteEssay(int id){
		String sql="update  essay set del_flag=1 where id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int recoverEssay(int id){
		String sql="update  essay set del_flag=0 where id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int recoverEssay(String url){
		String sql="update  essay set del_flag=0 where original_link='"+url+"'";
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int likeEssay(int id){
		String sql="UPDATE essay set favor_cnt = favor_cnt+1 WHERE id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int undoLikeEssay(int id){
		Essay essay = getEssay(id);
		if(essay.getFavor_cnt() != 0){
			String sql="UPDATE essay set favor_cnt = favor_cnt-1 WHERE id="+id;
			return SqlUtils.executeUpdate(sql, null);
		}
		return 0;
	}
	
	static public List<Essay> getDiaries(int start,int end){
		String sql="select * from essay limit start-1,end-start+1 where del_flag<>1";
		@SuppressWarnings("unchecked")
		List<Essay> diaries=(List<Essay>)SqlUtils.executeQuery(sql, new Object[]{start,end}, Essay.class);
		return diaries;
	}
	
	
	static public List<Essay> getDiaries4Page(int page,int pageSize){
		return getDiaries((page-1)*pageSize+1,page*pageSize);
	}
	
	@SuppressWarnings("unchecked")
	static public List<Essay> getAllDiaries(boolean withDel){
		String sql="select * from essay"+(withDel?"":"and del_flag<>1 ");
		return (List<Essay>) SqlUtils.executeQuery(sql,null,Essay.class);
	}
	
	static public int saveEssay(Map<String,Object> data){
		return SqlUtils.executeInsert(data, TABLE_ESSAY);
	}
	
	static public int saveEssay(Essay essay){
		System.out.println(essay.getClass().getSimpleName());
		return SqlUtils.executeInsert(essay);
	}
	
	static public int updateEssay(Map<String,Object> data,String condition){
		return SqlUtils.executeUpdate(data, TABLE_ESSAY, condition);
	}
	
	static public int updateEssay(String condition ,Essay essay){
		return SqlUtils.executeUpdate(condition, essay);
	}
	
	static public int deleteEssay(String condition){
		Map<String,Object> flag=new HashMap<String, Object>();
		flag.put("del_flag", 1);
		return updateEssay(flag,condition);
	}
	
	
}
