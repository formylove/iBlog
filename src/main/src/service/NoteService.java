package main.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.entity.Genre;
import main.src.entity.essay.Essay;
import main.src.entity.note.Opus;

public class NoteService {
	static final String TABLE_NOTE="essay";
	static final String TABLE_OPUS="opus";
	
	static public Opus getOpus(int id){
		List<Opus> opuses=getOpuses("id="+id);
		if(opuses.size()>0)
		{
			return opuses.get(0);
		}else{
			return null;
		}
	}
	static public List<Opus> getOpuses(String condition){
		String sql="SELECT * from opus where " + condition;
		@SuppressWarnings("unchecked")
		List<Opus> opuses=(List<Opus>)SqlUtils.executeQuery(sql, null, Opus.class);
			return opuses;
	}
	static public int saveNote(Essay essay,Opus opus){
		int id = SqlUtils.executeInsert(essay);
		opus.setId(id);
		SqlUtils.executeInsert(opus);
		return id;
	}
	static public boolean isBookGenre(int id){
		String sql = "select * from genre where id = " + id;
		List<Map<String,Object>> genres = (List<Map<String,Object>>)SqlUtils.executeQuery(sql, null);
		String type = null;
		if(genres.size()>0){
			type = (String) genres.get(0).get("type");
		}
		return ("book".equals(type));
	}
	static public String getGenreName(int id){
		String sql = "select * from genre where id = " + id;
		List<Map<String,Object>> genres = (List<Map<String,Object>>)SqlUtils.executeQuery(sql, null);
		String type = null;
		if(genres.size()>0){
			type = (String) genres.get(0).get("name");
			return type;
		}
		return null;
	}
	static public int updateNote(String condition ,Essay note,Opus opus){
		SqlUtils.executeUpdate(condition, note);
		return SqlUtils.executeUpdate(condition, opus);
	}
	static public int updateNote(int id ,Essay note,Opus opus){
		return updateNote("id="+id, note,opus);
	}
	static public int deleteNote(String condition){
		       SqlUtils.executeDelete(TABLE_NOTE,condition);
		return SqlUtils.executeDelete(TABLE_OPUS,condition);
	}
	static public int recoverNote(String condition){
		SqlUtils.executeRecovery(TABLE_NOTE, condition);
		return SqlUtils.executeRecovery(TABLE_OPUS, condition);
	}
	static public int recoverNote(int id){
		SqlUtils.executeRecovery(TABLE_NOTE, "id="+id);
		return SqlUtils.executeRecovery(TABLE_OPUS, "id="+id);
	}
	static public int deleteNote(int id){
		return deleteNote("id="+id);
	}
}
