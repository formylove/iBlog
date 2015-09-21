package main.src.service;

import main.src.common.SqlUtils;
import main.src.entity.essay.Essay;
import main.src.entity.note.Opus;

public class NoteService {
	static public int saveNote(Essay essay,Opus opus){
		int id = SqlUtils.executeInsert(essay);
		opus.setId(id);
		SqlUtils.executeInsert(opus);
		return id;
	}
}
