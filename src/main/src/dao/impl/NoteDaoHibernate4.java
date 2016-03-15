package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.NoteDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Note;
@Repository("noteDaoHibernate4")
public class NoteDaoHibernate4 extends BaseDaoHibernate4<Note> implements NoteDao 
{	
	public NoteDaoHibernate4() {
	}

	@Override
	public Note get(int id) {
		return get(Note.class,id);
	}
	//父类有了就不用再写了
}
