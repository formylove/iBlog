package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import main.src.common.MsgConstants;
import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.Diary;
import main.src.service.CategoryService;
import main.src.service.DiaryService;

import org.apache.struts2.ServletActionContext;
public class DiaryAction {
Diary diary;
String editor;
String title;
String label;
String category;
String original_link;
boolean isOriginal;



public String saveDiary() throws NumberFormatException, UnsupportedEncodingException{
if(null == original_link){
	Map<String,Object> data=new HashMap<String,Object>();
	data.put("title", title);
	data.put("label", label);
	data.put("category", category);
	data.put("content", editor);
	data.put("original_flag", isOriginal);
	data.put("create_date", TimeManager.getDate());
	data.put("create_time", TimeManager.getTime());
	SqlUtils.executeInsert(data, "diary");
}else{
}
	return MsgConstants.SUCCESS;
}

public String loadDiary(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int diaryId=Integer.parseInt(request.getParameter("id"));
	diary=DiaryService.getDiary(diaryId);
	category=CategoryService.getCategoryName(diary.getCategory());
	return "diarypage";
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

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
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
