package main.src.service;

import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.common.StrUtils;
import main.src.entity.Comment;

public class CommentService {

	static public Comment getComment(int id){
		String sql="select * from comment where id="+id;
		@SuppressWarnings("unchecked")
		List<Comment> Comments=(List<Comment>)SqlUtils.executeQuery(sql, null, Comment.class);
		return Comments.get(0);
	}
	
	static public List<Comment> getCommentBundle(int target,boolean isValid){

		String sql="select * from comment where target="+target+(isValid?" and del_flag<>1 ":"")+" order by id asc";
		@SuppressWarnings("unchecked")
		List<Comment> comments=(List<Comment>)SqlUtils.executeQuery(sql, null, Comment.class);
		return comments;
	}
	static public List<Comment> getCommentFromUser(int user_id,boolean isValid){
		String sql="select * from comment where user_id="+user_id+(isValid?" and del_flag<>1 ":"")+" order by id asc";
		@SuppressWarnings("unchecked")
		List<Comment> comments=(List<Comment>)SqlUtils.executeQuery(sql, null, Comment.class);
		return comments;
	}
	
	static public int deleteComment(int id){
		String sql="update comment set del_flag=1 where id="+id;
		return SqlUtils.executeUpdate(sql, null);
	}
	static public String getFloor(String target_id){
		String ceiling = SqlUtils.getField("SELECT SUBSTRING(MAX(id)+100 FROM 6 FOR 2) from `comment` WHERE id LIKE " + target_id + "'%'  ORDER BY id");
		return ceiling;
	}
	static public String getCellula(String target_id,int floor){
		String cellula = SqlUtils.getField("SELECT SUBSTRING(MAX(id)+1 FROM 8 FOR 2) from `comment` WHERE id LIKE " + target_id + StrUtils.zeroFill(floor,2) + "'%'  ORDER BY id");
		return cellula;
	}
	static public int getCurId(String target_id,int floor){
		int curId;
		if(floor == 0){
			curId = Integer.parseInt(target_id + getFloor(target_id) + "01");
		}else{
			curId = Integer.parseInt(target_id + StrUtils.zeroFill(floor,2) + getCellula(target_id,floor));
		}
		return curId;
	}
	
	static public List<Comment> getComments(int start,int end){
		String sql="select * from comment where del_flag<>1 limit start-1,end-start+1";
		@SuppressWarnings("unchecked")
		List<Comment> Comments=(List<Comment>)SqlUtils.executeQuery(sql, new Object[]{start,end}, Comment.class);
		return Comments;
	}
	
	
	static public List<Comment> getComments4Page(int page,int pageSize){
		return getComments((page-1)*pageSize+1,page*pageSize);
	}
	
	@SuppressWarnings("unchecked")
	static public List<Comment> getAllComments(boolean isValid){
		String sql="select * from comment"+(isValid?" and del_flag<>1 ":"");
		return (List<Comment>) SqlUtils.executeQuery(sql,null,Comment.class);
	}
	
	static public int getLatestId(){
		String sql="select * from comment order by id desc";
		return ((Comment)(SqlUtils.executeQuery(sql,null,Comment.class).get(0))).getId();
	}
	static public int generateId(){
		return getLatestId()+1;
	}
	static public int saveComment(Map<String,Object> data){
		return SqlUtils.executeInsert(data, "comment");
	}
	 
}
