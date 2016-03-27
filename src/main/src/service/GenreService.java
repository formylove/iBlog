package main.src.service;

import main.src.entity.Genre;
import main.src.entity.Opus;
import main.src.service.base.BaseService;

public interface GenreService extends BaseService<Genre>{
	public Genre get(String name);
	void injectGenres(Opus opus, String[] genres);
}
