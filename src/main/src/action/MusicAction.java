package main.src.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.EntityUtils;
import main.src.common.FileUtils;
import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.common.MusicUtils;
import main.src.entity.Music;
import main.src.service.MusicService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MusicAction {
	@Resource(name="musicService")
	private MusicService musicService;
	Music music = null;
	int id;
	private float w;
	private float h;
	private float x;
	private float y;
	private String cover;
	private String deletedMusic;
	private File musicFile;
	private String musicFileContentType;
	private String musicFileFileName;
	private JSONArray tree;
	public String list() {
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, IOException{
	    if(id==0){
	    	if(StringUtils.isNotEmpty(musicFileFileName)){
	    		String UUIDName = MusicUtils.save(musicFile, FileUtils.getFileSuffix(musicFileFileName));
	    		music.setUrl(UUIDName + FileUtils.getFileSuffix(musicFileFileName));
	    	}
	    		if(StringUtils.isNotEmpty(cover)){
	    			music.setCover(ImageUtils.cut(cover, w, h, x, y));
	    		}
	    		id = musicService.save(music);
	    		music.setId(id);
	    }else{
	    	if(StringUtils.isNotEmpty(musicFileFileName)){
	    		MusicUtils.delete(music.getUrl());
	    		String UUIDName = MusicUtils.save(musicFile, FileUtils.getFileSuffix(musicFileFileName));
	    		music.setUrl(UUIDName + FileUtils.getFileSuffix(musicFileFileName));
	    	}
	    	if(!music.getCover().equals(cover)){
	    		ImageUtils.deleteImg(music.getCover());
	    		music.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	musicService.update(music);
	    }
		return MsgConstants.DISPLAY;
}
	
public String load(){
	music = musicService.get(id);
	return MsgConstants.DISPLAY;
}

public String tree(){
	tree = musicService.getTree();
	System.out.println(tree);
	return MsgConstants.DONE;
}
public String edit(){
	music = null;
	if(id!=0){
		music = musicService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	music = musicService.delete(deletedMusic);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public MusicService getMusicService() {
	return musicService;
}
public void setMusicService(MusicService musicService) {
	this.musicService = musicService;
}
public void setX(float x) {
	this.x = x;
}
public Music getMusic() {
	return music;
}
public void setMusic(Music music) {
	this.music = music;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getDeletedMusic() {
	return deletedMusic;
}
public void setDeletedMusic(String deletedMusic) {
	this.deletedMusic = deletedMusic;
}
public JSONArray getTree() {
	return tree;
}
public void setTree(JSONArray tree) {
	this.tree = tree;
}
public float getX() {
	return x;
}
public float getY() {
	return y;
}
public void setY(float y) {
	this.y = y;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public File getMusicFile() {
	return musicFile;
}
public void setMusicFile(File musicFile) {
	this.musicFile = musicFile;
}
public void setMusicFile(File[] musicFile) {
	this.musicFile = musicFile[0];
}
public String getMusicFileContentType() {
	return musicFileContentType;
}
public void setMusicFileContentType(String musicFileContentType) {
	this.musicFileContentType = musicFileContentType;
}
public void setMusicFileContentType(String[] musicFileContentType) {
	this.musicFileContentType = musicFileContentType[0];
}
public String getMusicFileFileName() {
	return musicFileFileName;
}
public void setMusicFileFileName(String musicFileFileName) {
	this.musicFileFileName = musicFileFileName;
}
public void setMusicFileFileName(String[] musicFileFileName) {
	this.musicFileFileName = musicFileFileName[0];
}
	
}
