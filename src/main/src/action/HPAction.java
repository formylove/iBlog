package main.src.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.Music;
import main.src.entity.Poster;
import main.src.entity.essay.Essay;
import main.src.service.EssayService;
import main.src.service.MusicService;
import main.src.service.PosterService;

public class HPAction {
	@Resource(name="posterService")
	private PosterService posterService;
	@Resource(name="musicService")
	private MusicService musicService;
	@Resource(name="essayService")
	private EssayService essayService;
	List<Poster> posters;
	List<Essay> essays;
	List<Music>  musics;
	public String load(){
		posters = posterService.list();
		essays = essayService.getHomepageList();
		musics = musicService.getHomepageList();
		System.out.println("hp action");
		return MsgConstants.HOMEPAGE;
	}
	@JSON(serialize=false)
	public PosterService getPosterService() {
		return posterService;
	}
	public void setPosterService(PosterService posterService) {
		this.posterService = posterService;
	}
	@JSON(serialize=false)
	public MusicService getMusicService() {
		return musicService;
	}
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}
	@JSON(serialize=false)
	public EssayService getEssayService() {
		return essayService;
	}
	public void setEssayService(EssayService essayService) {
		this.essayService = essayService;
	}
	@JSON(serialize=false)
	public List<Poster> getPosters() {
		return posters;
	}
	public void setPosters(List<Poster> posters) {
		this.posters = posters;
	}
	@JSON(serialize=false)
	public List<Essay> getEssays() {
		return essays;
	}
	public void setEssays(List<Essay> essays) {
		this.essays = essays;
	}
	@JSON(serialize=false)
	public List<Music> getMusics() {
		return musics;
	}
	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	

	
}
