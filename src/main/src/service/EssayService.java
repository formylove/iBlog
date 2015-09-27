package main.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.entity.essay.CNBlogs;
import main.src.entity.essay.CSDN;
import main.src.entity.essay.Douban;
import main.src.entity.essay.Essay;
import main.src.entity.essay.ITEye;
import main.src.entity.essay.Zhidao;
import main.src.entity.essay.Zhihu;
import main.src.entity.note.Opus;

public class EssayService {
	static final String TABLE_ESSAY="essay"; 
	static final int PERPAGE = 10; 
	
	static public Essay getEssay(int id){
		List<Essay> essays=getEssays("id="+id);
		if(essays.size()==1)
		{
			return essays.get(0);
		}else{
			return null;
		}
	}
	
	static public int getLatestEssayId(){
		String sql="SELECT * from essay order by id DESC LIMIT 0,1";
		@SuppressWarnings("unchecked")
		List<Essay> essays=(List<Essay>)SqlUtils.executeQuery(sql, null, Essay.class);
		if(essays.size()==1)
		{
			return (essays.get(0)).getId();
		}else{
			return 0;
		}
	}
	
	static public boolean hasExisted(String title){
		List<Essay> essays= getEssays("title ='"+ title +"'");
		if(essays.size()==1)
		{
			return true;
		}else{
			return false;
		}
	}
	
	static public boolean hasForwarded(String url){
		List<Essay> essays= getEssays("original_link ='"+ url +"' and del_flag = 0");
		if(essays.size()>=1)
		{
			return true;
		}else{
			return false;
		}
	}
	static public List<Essay> getEssays(String condition){
		String sql="SELECT * from essay where " + condition;
		@SuppressWarnings("unchecked")
		List<Essay> essays=(List<Essay>)SqlUtils.executeQuery(sql, null, Essay.class);
			return essays;
	}
	
	static public int forward(String url){
		List<Essay> essays = getEssays("original_link= '"+url +"'");
		if(essays.size() == 0){
			return loadForwardEssay(url);
		}else if(essays.get(0).isDel_flag()){
			recoverEssay(url);
			return essays.get(0).getId();
		}else{
			deleteEssay("original_link='"+url+"'");
			return 0;
		}
	}
	static public int loadForwardEssay(String url){
		url = url.toLowerCase();
		if(url.indexOf("zhihu")>=0){
			return SqlUtils.executeInsert(new Zhihu(url));
		}else if(url.indexOf("zhidao.baidu")>=0){
			return SqlUtils.executeInsert(new Zhidao(url));
		}else if(url.indexOf("blog.csdn.net")>=0){
			return SqlUtils.executeInsert(new CSDN(url));
		}else if(url.indexOf("iteye.com")>=0){
			return SqlUtils.executeInsert(new ITEye(url));
		}else if(url.indexOf("cnblogs.com")>=0){
			return SqlUtils.executeInsert(new CNBlogs(url));
		}else if(url.indexOf("douban.com")>=0){
			Douban douban = new Douban(url);
			int id = SqlUtils.executeInsert(douban);
			Opus opus = douban.getOpus();
			opus.setId(id);
			return SqlUtils.executeInsert(opus);
		}
         return 0;
	}
	
	static public int deleteEssay(int id){
		return SqlUtils.executeDelete(TABLE_ESSAY, "id="+id);
	}
	
	static public int recoverEssay(int id){
		return SqlUtils.executeRecovery(TABLE_ESSAY, "id="+id);
	}
	
	static public int recoverEssay(String url){
		String sql="update  essay set del_flag=0 where original_link='"+url+"'";
		return SqlUtils.executeUpdate(sql, null);
	}
	
	static public int likeEssay(int id){
		String sql="UPDATE essay set favor_cnt = favor_cnt+1 WHERE id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	/**
	 *¼ÇÂ¼ÔÄ¶Á´ÎÊý.<br/>
	 **/
	static public int readEssay(int id){
		String sql="UPDATE essay set read_cnt = read_cnt+1 WHERE id="+id;
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
	
	static public List<Essay> getEssays(int start,int end){
		String sql="select * from essay limit start-1,end-start+1 where del_flag<>1";
		@SuppressWarnings("unchecked")
		List<Essay> essays=(List<Essay>)SqlUtils.executeQuery(sql, new Object[]{start,end}, Essay.class);
		return essays;
	}
	
	
	static public List<Essay> getEssays4Page(int page,int pageSize){
		return getEssays((page-1)*pageSize+1,page*pageSize);
	}
	
	@SuppressWarnings("unchecked")
	static public List<Essay> getAllDiaries(boolean withDel){
		String sql="select * from essay"+(withDel?"":"and del_flag<>1 ");
		return (List<Essay>) SqlUtils.executeQuery(sql,null,Essay.class);
	}
	@SuppressWarnings("unchecked")
	static public List<Essay> getOnePage(int page,String[] categories,String Order,boolean withDel){
		if(page==0){page=1;}
		String condition = generateCondion(withDel, categories);
		String sql="select * from essay "+ condition + " order by id limit "+(page - 1) * PERPAGE +","+ PERPAGE;
		
		return (List<Essay>) SqlUtils.executeQuery(sql,null,Essay.class);
	}
	@SuppressWarnings("unchecked")
	static public List<Essay> getRecommendation(String[] categories){
		String sql="";
		for(String cat:categories){
			if(cat.equals("5002") || cat.equals("5003") || cat.equals("5005")){
				sql="select * from essay where category="+ cat + " order by read_cnt limit 0,5";
				break;
			}else if(cat.equals("5004") ){
				sql="select * from essay where category="+ cat + " order by favor_cnt,read_cnt desc limit 0,5";
				break;
			}else if(cat.equals("5000") || cat.equals("5001") || cat.equals("5006") ){
				sql="select * from essay where (category="+ categories[0] + " or category="+ categories[1] + ") order by read_cnt  desc limit 0,5";
				break;
			}
		}
		return (List<Essay>) SqlUtils.executeQuery(sql,null,Essay.class);
	}
	static public int getTotalCnt(boolean withDel,String[] categories){
		String condition = generateCondion(withDel, categories);
		String sql="select count(*) from essay "+ condition;
		int cnt = (int) SqlUtils.executeQueryForCount(sql, null);
		return cnt;
	}
	static public String generateCondion(boolean withDel,String[] categories){
		String condition = "where " + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
		if(categories != null){
			for(int i = 0;i<categories.length;i++){
				if(i==0){
					condition = condition + " and (category=" + categories[i];
				}else{
					condition = condition + " or category=" + categories[i];
				}
			}
			condition = condition + ")";
		}
		return condition;
	}
	static public int getPageCnt(boolean withDel,String[] categories){
		int cnt = getTotalCnt(withDel,categories);
		int pages = (cnt/PERPAGE)+1;
		return pages;
	}
	
	static public int saveEssay(Map<String,Object> data){
		return SqlUtils.executeInsert(data, TABLE_ESSAY);
	}
	
	static public int saveEssay(Essay essay){
		return SqlUtils.executeInsert(essay);
	}
	
	static public int updateEssay(Map<String,Object> data,String condition){
		return SqlUtils.executeUpdate(data, TABLE_ESSAY, condition);
	}
	
	static public int updateEssay(String condition ,Essay essay){
		return SqlUtils.executeUpdate(condition, essay);
	}
	static public int updateEssay(int id ,Essay essay){
		return SqlUtils.executeUpdate("id="+id, essay);
	}
	
	static public int deleteEssay(String condition){
		return SqlUtils.executeDelete(TABLE_ESSAY,condition);
	}
	
	
}
