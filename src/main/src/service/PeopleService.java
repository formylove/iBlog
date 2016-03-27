package main.src.service;

import main.src.entity.gallery.People;
import main.src.service.base.BaseService;

public interface PeopleService extends BaseService<People>{
	public People get(String name);
}
