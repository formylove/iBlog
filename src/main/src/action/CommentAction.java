package main.src.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import main.src.common.NetStatusManager;
import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.Comment;
import main.src.entity.User;
import main.src.service.CommentService;
import main.src.service.UserService;

public class CommentAction {
	List<Comment> comments;
	Comment comment;
	String target_id;
	String device;
	User user;
	String content;
	String article_id;
	String append;
	String message;
	int comment_id;
	String date;

	public String saveComment() throws UnsupportedEncodingException{
		int id=CommentService.generateId();
		Map<String,Object> data=new HashMap<String,Object>();	
		data.put("id", id);
		data.put("target", article_id);
		data.put("append", append);
		data.put("content", message);
		data.put("ip", NetStatusManager.getIP());
		data.put("city", (new NetStatusManager()).getCountry());
		data.put("create_date", TimeManager.getDate());
		data.put("create_time", TimeManager.getTime());
		SqlUtils.executeInsert(data, "comment");
		comment = CommentService.getComment(id);
		return "conveycomments";
	}
	public String addComment() throws UnsupportedEncodingException{
		
		Comment comment = new Comment(target_id,0);
		comment.setContent(content);
		comment.setDev_name(device);
		System.out.println("content:"+content);
		System.out.println("target_id:"+target_id);
		System.out.println("device:"+device);
		System.out.println("user:"+user.getNick_name());
		date = comment.getCreate_date();
		return "success";
	}

public String loadComments(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=Integer.parseInt(request.getParameter("id"));
	comments=CommentService.getCommentBundle(diaryId,true);
	return "conveycomments";
}

public String deleteComments(){
CommentService.deleteComment(comment_id);
	return "conveycomments";
}

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTarget_id() {
	return target_id;
}
public void setTarget_id(String target_id) {
	this.target_id = target_id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

public Comment getComment() {
	return comment;
}

public void setComment(Comment comment) {
	this.comment = comment;
}

public String getDevice() {
	return device;
}
public void setDevice(String device) {
	this.device = device;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getArticle_id() {
	return article_id;
}

public void setArticle_id(String article_id) {
	this.article_id = article_id;
}

public String getAppend() {
	return append;
}

public void setAppend(String append) {
	this.append = append;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public int getComment_id() {
	return comment_id;
}

public void setComment_id(int comment_id) {
	this.comment_id = comment_id;
}



}
