package main.src.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.NoteDao;
import main.src.dao.OpusDao;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.service.NoteService;
@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Resource(name = "noteDaoHibernate4")
	private NoteDao noteDao;
	@Resource(name = "opusDaoHibernate4")
	private OpusDao opusDao;
	
	public NoteServiceImpl() {
	}

	public int save(Note note) {
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
	public void change(Note note,Opus opus) {
		Note note_original = get(note.getId());
		note.setComments(note_original.getComments());
		if(note.getMusic() == null){
			note.setMusic(note_original.getMusic());
		}
		if(note.getOpus() == null){
			note.setOpus(note_original.getOpus());
		}
		note.setFavor_cnt(note_original.getFavor_cnt());
		note.setRead_cnt(note_original.getRead_cnt());
		noteDao.update(note_original);
		Opus opus_original = note_original.getOpus();
		opus.setId(opus_original.getId());
		if(opus.getGenres().size() == 0){
			opus.setGenres(opus_original.getGenres());
		}
		opusDao.update(opus);
	}
	@Override
	public Note remove(int id) {
		Note note = get(id);
		if(null != note){
			note.setDel_flag(true);
			noteDao.update(note);
		}
		return note;
	}
	@Override
	public void read(int id) {
		Note note = get(id);
		if(null != note){
			note.setRead_cnt(note.getRead_cnt() + 1);
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

	@Override
	public boolean hasExisted(String title) {
		
		return false;
	}

	@Override
	public void like(int id) {
		Note note = get(id);
		if(null != note){
			note.setFavor_cnt(note.getFavor_cnt() + 1);
			noteDao.update(note);
		}
	}

	@Override
	public void undoLike(int id) {
		Note note = get(id);
		if(null != note && note.getFavor_cnt() > 0){
			note.setFavor_cnt(note.getFavor_cnt() - 1);
			noteDao.update(note);
		}
	}




}
