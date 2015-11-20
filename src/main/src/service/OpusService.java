package main.src.service;

import main.src.entity.Opus;

public interface OpusService {
	public void save(Opus opus);
	public void delete(int id);
	public void update(Opus note);
	public void get(int id);
	public void recover(int id);
}
