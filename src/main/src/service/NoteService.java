package main.src.service;


import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.service.base.BaseService;

public interface NoteService extends BaseService<Note>{

	void change(Note note,Opus opus);

	void read(int id);

	boolean hasExisted(String title);

	void like(int id);
	
	Note get(String title);

	void undoLike(int id);

}
