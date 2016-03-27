package main.src.action;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import main.src.common.FileUtils;
import main.src.common.MusicUtils;
import main.src.entity.Music;
import main.src.service.MusicService;

public class DownloadAction extends ActionSupport{
	@Resource(name="musicService")
	private MusicService musicService;
	private String targetName;
	private String mime;
	private Integer id;
	private String type;
	public InputStream getTarget() throws IOException{//默认入口,不行要制定方法
		Music music = null;;
		if("music".equals(type)){
			music = musicService.get(id);
			mime = ServletActionContext.getServletContext().getMimeType(music.getUrl());
			targetName = music.getName();
			InputStream is = ServletActionContext.getServletContext().getResourceAsStream("music/" + music.getUrl());//相对位置
			return is;
		}
		return null;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MusicService getMusicService() {
		return musicService;
	}
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
