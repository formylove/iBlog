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

	public Serializable save(Note note) {
		return noteDao.save(note);
	}

	@Override
	public void persist(Note note) {
		noteDao.persist(note);
	}
	
	@Override
	public void delete(int id) {
		Note n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Note note) {
		noteDao.delete(note);
	}
	@Override
	public void update(Note note) {
		noteDao.update(note);
	}
	@Override
	public void remove(int id) {
		Note note = get(id);
		if(null != note){
			note.setDel_flag(true);
			noteDao.update(note);
		}
	}

	@Override
	public Note get(int id) {
		return noteDao.get(id);
	}

	@Override
	public void recover(int id) {
		Note note = get(id);
		if(null != note){
			note.setDel_flag(false);
			noteDao.update(note);
		}
	}

	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}




}
