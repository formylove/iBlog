package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.Genre;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.entity.essay.Essay;
import main.src.service.EssayService;
import main.src.service.GenreService;
import main.src.service.NoteService;
import main.src.service.OpusService;
public class NoteAction {
@Resource(name="noteService")
private NoteService noteService;
@Resource(name="opusService")
private OpusService opusService;
@Resource(name="genreService")
private GenreService genreService;
Note note;
Essay notes;
Opus opus;
int id;
List<Genre> genres;
String genre[];
private float w;
private float h;
private float x;
private float y;
private Properties authority = MsgConstants.AUTHORITY;
private Properties rate = MsgConstants.RATE;
private String title;
private String cover;
private String music;
private boolean hasExisted;
//essay list
private List<Essay> essays;
private List<Essay> recommendations;
private int page;
private int pages;
private String[] category;
public String listNote(){
//	notes = (Essay) EssayService.getOnePage(page, category, null, false);
//	recommendations = EssayService.getRecommendation(category);
//	pages = EssayService.getPageCnt(false,category);
	return MsgConstants.LIST;
}
public String saveNote() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    	if(StringUtils.isNotEmpty(cover)){
	    		opus.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	note.setOpus(opus);
	    	opusService.save(opus);
	    	id = noteService.save(note);
	    	genreService.injectGenres(opus, genre);
	    }else{
	    	if(!opus.getCover().equals(cover)){
	    		ImageUtils.deleteImg(opus.getCover());
	    		opus.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	genreService.injectGenres(opus, genre);
	    	noteService.change(note,opus);
	    }
		return MsgConstants.DISPLAY;
}

public String readNote(){
		noteService.read(id);
	    return null;
}
public String loadNote(){
	note = noteService.get(id);
	opus = note.getOpus();
	return MsgConstants.DISPLAY;
}

public String editNote(){
	if(id!=0){
		note = noteService.get(id);
		opus = note.getOpus();
	}
	genres = (List<Genre>) genreService.getAll(false);
	return "editnote";
}

public String deleteNote(){
	note = noteService.remove(id);
	opus = note.getOpus();
	return null;
}

public String recoverNote(){
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
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String[] getCategory() {
	return category;
}
public float getW() {
	return w;
}
public void setW(float w) {
	this.w = w;
}
public float getH() {
	return h;
}
public void setH(float h) {
	this.h = h;
}
public float getX() {
	return x;
}
public void setX(float x) {
	this.x = x;
}
public float getY() {
	return y;
}
public void setY(float y) {
	this.y = y;
}
public Essay getNotes() {
	return notes;
}
public void setNotes(Essay notes) {
	this.notes = notes;
}
public Opus getOpus() {
	return opus;
}
public void setOpus(Opus opus) {
	this.opus = opus;
}
//////////
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
public List<Essay> getEssays() {
	return essays;
}
public void setEssays(List<Essay> essays) {
	this.essays = essays;
}

public void setHasExisted(boolean hasExisted) {
	this.hasExisted = hasExisted;
}

public boolean isHasExisted() {
	return hasExisted;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}
