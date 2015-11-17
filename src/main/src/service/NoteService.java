package main.src.service;

import main.src.entity.Note;

public interface NoteService {
	public void save(Note note);
	public void delete(int id);
	public void update(Note note);
	public Note get(int id);
	public void recover(int id);
}
