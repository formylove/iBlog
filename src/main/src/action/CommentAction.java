package main.src.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.Comment;
import main.src.entity.User;
import main.src.service.CommentService;
import main.src.service.UserService;
import net.sf.json.JSONObject;

public class CommentAction {
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "commentService")
	private CommentService commentService;
	List<Comment> comments;
	Comment comment;
	User user;
	String content;
	boolean good = true;
	int page;
	String message;
	JSONObject jComments;
	public String save() throws UnsupportedEncodingException{
//		int id=CommentService.generateId();
//		Map<String,Object> data=new HashMap<String,Object>();	
//		data.put("id", id);
//		data.put("target", article_id);
//		data.put("append", append);
//		data.put("content", message);
//		data.put("ip", NetStatusManager.getIP());
//		data.put("city", (new NetStatusManager()).getCountry());
//		data.put("create_date", TimeManager.getDate());
//		data.put("create_time", TimeManager.getTime());
//		SqlUtils.executeInsert(data, "comment");
//		comment = CommentService.getComment(id);
		return "conveycomments";
	}
	public String add() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		User user= userService.getcurLoginUser(request);
		if(user != null){
			comment.setPublisher(user);
			good = commentService.add(comment);
			message = (good?"":"回复的对象可能已被删除");
		}else{
			message="请先未登录";
			good = false;
		}
		return MsgConstants.SUCCESS;
	}

public String load(){
	jComments = commentService.getPage(page,comment);
	System.out.println(jComments);
	return MsgConstants.DONE;
}

public String deleteComments(){
	return "conveycomments";
}

public JSONObject getJComments() {//get 函数命名一定要讲究啊啊啊 啊
	return jComments;
}
public void setJComments(JSONObject jComments) {
	this.jComments = jComments;
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

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public boolean isGood() {
	return good;
}
public void setGood(boolean good) {
	this.good = good;
}

public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
@JSON(serialize=false)
public UserService getUserService() {
	return userService;
}
@JSON(serialize=false)
public CommentService getCommentService() {
	return commentService;
}
public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}
public void setCommentService(CommentService commentService) {
	this.commentService = commentService;
}



}
