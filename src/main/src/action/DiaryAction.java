package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import main.src.common.MsgConstants;
import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.Category;
import main.src.entity.Diary;
import main.src.service.CategoryService;
import main.src.service.DiaryService;
public class DiaryAction {
Diary diary;
String editor;
String title;
String author;
String label;
int categoryId;
int authority;
int music;
String original_link;
boolean isOriginal;
//edit diary
int id;
List<Category> categories;
boolean diaryCheckflag = false;
int test =0;
boolean hasExisted;
public String saveDiary() throws NumberFormatException, UnsupportedEncodingException{
	Map<String,Object> data=new HashMap<String,Object>();
		data.put("title", title);
		data.put("author", author);
		data.put("music", music);
		if(label!=null){
			data.put("label", label);
		}
		data.put("category", categoryId);
		data.put("content", editor);
		data.put("original_flag", isOriginal);
		if(original_link!=null){
			data.put("original_link", original_link);
		}
		data.put("authority", authority);
		if(id==0){//创建日志
			data.put("create_date", TimeManager.getDate());
			data.put("create_time", TimeManager.getTime());
			SqlUtils.executeInsert(data, "diary");
			int diaryId = DiaryService.getLatestDiaryId();
			diary=DiaryService.getDiary(diaryId);
		}else{//修改文章
			SqlUtils.executeUpdate(data, "diary", "id ="+id);
			diary=DiaryService.getDiary(id);
		}
		return MsgConstants.DIARYPAGE;
}

public String loadDiary(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int diaryId=Integer.parseInt(request.getParameter("id"));
	    diary=DiaryService.getDiary(diaryId);
	
	return MsgConstants.DIARYPAGE;
}

public String editDiary(){
	
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	diary=DiaryService.getDiary(diaryId);
	categories = CategoryService.getAllCategories(true);
	
	return "editdiary";
}

public String deleteDiary(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	DiaryService.deleteDiary(diaryId);
	diary = DiaryService.getDiary(diaryId);
	return MsgConstants.DELETED;
}

public String recoverDiary(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	DiaryService.recoverDiary(diaryId);
	return MsgConstants.RECOVERED;
}

public String hasExisted(){
	hasExisted = DiaryService.hasExisted(title);
	return MsgConstants.REDUPLICATIVE;
}
public String like(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	DiaryService.likeDiary(diaryId);
	return MsgConstants.LIKE;
}

public String undoLike(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	DiaryService.undoLikeDiary(diaryId);
	return MsgConstants.LIKE;
}


public boolean isDiaryCheckflag() {
	return diaryCheckflag;
}

public void setDiaryCheckflag(boolean diaryCheckflag) {
	this.diaryCheckflag = diaryCheckflag;
}

public int getTest() {
	return test;
}

public void setTest(int test) {
	this.test = test;
}

public void setHasExisted(boolean hasExisted) {
	this.hasExisted = hasExisted;
}

public boolean isHasExisted() {
	return hasExisted;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getAuthority() {
	return authority;
}

public void setAuthority(int authority) {
	this.authority = authority;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public List<Category> getCategories() {
	return categories;
}

public void setCategories(List<Category> categories) {
	this.categories = categories;
}

public Diary getDiary() {
	return diary;
}

public void setDiary(Diary diary) {
	this.diary = diary;
}

public String getEditor() {
	return editor;
}

public void setEditor(String editor) {
	this.editor = editor;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

public String getOriginal_link() {
	return original_link;
}

public void setOriginal_link(String original_link) {
	this.original_link = original_link;
}

public boolean isOriginal() {
	return isOriginal;
}

public void setOriginal(boolean isOriginal) {
	this.isOriginal = isOriginal;
}


}
