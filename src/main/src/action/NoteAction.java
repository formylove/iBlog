
package main.src.action;


import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import main.src.common.MsgConstants;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.entity.essay.Essay;
import main.src.service.NoteService;
public class NoteAction {
@Resource(name="noteService")
private NoteService noteService;
Note note;
Opus opus;
int id;
private Properties authority = MsgConstants.AUTHORITY;
private String title;
private boolean hasExisted;
//essay list
private List<Essay> essays;
private List<Essay> recommendations;
private int page;
private int pages;
private String[] category;
Properties authorities = (new MsgConstants()).AUTHORITY;
public String listNote(){
//	notes = (Essay) EssayService.getOnePage(page, category, null, false);
//	recommendations = EssayService.getRecommendation(category);
//	pages = EssayService.getPageCnt(false,category);
	return MsgConstants.LIST;
}
public String save(){
    if(id==0){
    		id = noteService.save(note);
    		note.setId(id);
    }else{
    	noteService.update(note);
    }
	return MsgConstants.DISPLAY;
}
public String read(){
		noteService.read(id);
	    return null;
}
public String load(){
	note = noteService.get(id);
	opus = note.getOpus();
	return MsgConstants.DISPLAY;
}

public String edit(){
	authorities = MsgConstants.AUTHORITY;
	note = null;
	if(id!=0){
		note = noteService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delet(){
	note = noteService.remove(id);
	return null;
}

public String recover(){
	noteService.recover(id);
	return MsgConstants.DONE;
}

public String hasExisted(){
	hasExisted = noteService.hasExisted(title);
	return MsgConstants.DONE;
}
public String like(){
	noteService.like(id);
	return MsgConstants.DONE;
}

public String undoLike(){
	noteService.undoLike(id);
	return MsgConstants.DONE;
}
public NoteService getNoteService() {
	return noteService;
}
public void setNoteService(NoteService noteService) {
	this.noteService = noteService;
}
public Note getNote() {
	return note;
}
public void setNote(Note note) {
	this.note = note;
}
public Opus getOpus() {
	return opus;
}
public void setOpus(Opus opus) {
	this.opus = opus;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Properties getAuthority() {
	return authority;
}
public void setAuthority(Properties authority) {
	this.authority = authority;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public boolean isHasExisted() {
	return hasExisted;
}
public void setHasExisted(boolean hasExisted) {
	this.hasExisted = hasExisted;
}
public List<Essay> getEssays() {
	return essays;
}
public void setEssays(List<Essay> essays) {
	this.essays = essays;
}
public List<Essay> getRecommendations() {
	return recommendations;
}
public void setRecommendations(List<Essay> recommendations) {
	this.recommendations = recommendations;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public String[] getCategory() {
	return category;
}
public void setCategory(String[] category) {
	this.category = category;
}
public Properties getAuthorities() {
	return authorities;
}
public void setAuthorities(Properties authorities) {
	this.authorities = authorities;
}

}
