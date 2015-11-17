package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.common.StrUtils;
import main.src.entity.Genre;
import main.src.entity.Opus;
import main.src.entity.essay.Essay;
import main.src.service.EssayService;
import main.src.service.NoteService;
public class NoteAction {
Essay essay;
Essay notes;
Opus opus;
int id;
List<Genre> genres;
private float w;
private float h;
private float x;
private float y;
@SuppressWarnings("static-access")
Map<String, String> nation = (new MsgConstants()).ISO31661ALPHA3;
Map<String, String> dynastys = MsgConstants.DYNASTY;
Map<String, String> authority = MsgConstants.AUTHORITY;
Map<String, String> rate = MsgConstants.RATE;
String title;
String cover;
NoteService noteService;
boolean hasExisted;
//essay list
List<Essay> essays;
List<Essay> recommendations;
int page;
int pages;
String[] category;
public String listNote(){
	notes = (Essay) EssayService.getOnePage(page, category, null, false);
	recommendations = EssayService.getRecommendation(category);
	pages = EssayService.getPageCnt(false,category);
	return MsgConstants.Essays;
}
public String saveNote() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    	if(!StrUtils.isEmpty(cover)){
	    		opus.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	id = NoteService.saveNote(essay, opus);
	    }else{
	    	if(!opus.getCover().equals(cover)){
	    		ImageUtils.deleteImg(opus.getCover());
	    		opus.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	NoteService.updateNote(id, essay, opus);
	    }
		return MsgConstants.NOTEPAGE;
}

public String readNote(){
	    EssayService.readEssay(id);
	    return null;
}
public String loadNote(){
	essay=(Essay) EssayService.getEssay(id);
	opus=NoteService.getOpus(id);
	return MsgConstants.NOTEPAGE;
}

public String editNote(){
	if(id!=0){
		essay=EssayService.getEssay(id);
		opus = NoteService.getOpus(id);
	}
	genres = (List<Genre>) Genre.getAllGenre(false);
	return "editnote";
}

public String deleteNote(){
	NoteService.deleteNote(id);
	essay=EssayService.getEssay(id);
	opus = NoteService.getOpus(id);
	return MsgConstants.DELETED;
}

public String recoverNote(){
	NoteService.recoverNote(id);
	return MsgConstants.DONE;
}

public String hasExisted(){
	hasExisted = EssayService.hasExisted(title);
	return MsgConstants.DONE;
}
public String like(){
	EssayService.likeEssay(id);
	return MsgConstants.DONE;
}

public String undoLike(){
	EssayService.undoLikeEssay(id);
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
public void setCategory(String[] category) {
	this.category = category;
}
public Map<String, String> getRate() {
	return rate;
}
public void setRate(Map<String, String> rate) {
	this.rate = rate;
}
public Map<String, String> getAuthority() {
	return authority;
}
public void setAuthority(Map<String, String> authority) {
	this.authority = authority;
}

public Map<String, String> getDynastys() {
	return dynastys;
}
public void setDynastys(Map<String, String> dynastys) {
	this.dynastys = dynastys;
}
public Map<String, String> getNation() {
	return nation;
}
public void setNation(Map<String, String> nation) {
	this.nation = nation;
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
public void setGenres(List<Genre> genres) {
	this.genres = genres;
}
public Essay getEssay() {
	return essay;
}
public void setEssay(Essay essay) {
	this.essay = essay;
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
public List<Genre> getGenres() {
	return genres;
}
public void setGenre(List<Genre> genres) {
	this.genres = genres;
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
