package main.src.service;

import main.src.entity.gallery.item.Scenery;
import main.src.service.base.BaseService;

public interface SceneryService extends BaseService<Scenery>{
	public Scenery get(String name);
}
