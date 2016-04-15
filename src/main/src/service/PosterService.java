package main.src.service;

import java.util.List;

import main.src.entity.Poster;
import main.src.service.base.BaseService;

public interface PosterService extends BaseService<Poster>{
	public Poster get(String name);
	List<Poster> list();
	public void updateOrder(int before,int after);
}
