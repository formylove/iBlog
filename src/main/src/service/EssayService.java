package main.src.service;

import java.util.List;

import main.src.entity.essay.Essay;
import main.src.service.base.BaseService;

public interface EssayService extends BaseService<Essay>{
	public void read(int id);
	public void like(int id);
	public void undoLike(int id);
	public boolean hasExisted(String title);
	public Essay get(String title);
	List<Essay> getOnePage(int page,int category);
	public int getPageCnt(int category);
	public List<Essay> getHomepageList();
}

