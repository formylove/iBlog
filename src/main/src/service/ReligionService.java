package main.src.service;

import main.src.entity.gallery.Religion;
import main.src.service.base.BaseService;

public interface ReligionService extends BaseService<Religion>{
	public Religion get(String name);
}
