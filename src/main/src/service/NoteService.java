package main.src.service;

import java.io.Serializable;

import main.src.entity.Note;

public interface NoteService {
	public Serializable save(Note note);
	public void persist(Note note);
	public void delete(int id);
	public void update(Note note);
	public Note get(int id);
	public void recover(int id);
}
