package main.src.service;

import main.src.entity.Opus;
import main.src.service.base.BaseService;

public interface OpusService extends BaseService<Opus>{
	public boolean hasExisted(String name);
	public Opus get(String name);
}
