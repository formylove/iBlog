package main.src.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.common.Log;
import main.src.dao.NoteDao;
import main.src.entity.Note;
import main.src.service.NoteService;
@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Resource(name = "noteDaoHibernate4")
	private NoteDao noteDao;
	
	public NoteServiceImpl() {
	}

	@Override
	public Serializable save(Note note) {
		return noteDao.save(note);
	}

	@Override
	public void persist(Note note) {
		noteDao.persist(note);
	}
	
	@Override
	public void delete(int id) {
	}

	@Override
	public void update(Note note) {
	}

	@Override
	public Note get(int id) {
		return noteDao.get(id);
	}

	@Override
	public void recover(int id) {
	}

	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}



}
