package main.src.service;

import main.src.entity.essay.Essay;
import main.src.service.base.BaseService;

public interface EssayService extends BaseService<Essay>{
	public void read(int id);
	public void like(int id);
	public void undoLike(int id);
	public boolean hasExisted(String title);
	public Essay get(String title);
}

