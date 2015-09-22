package main.src.service;

import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.entity.Genre;
import main.src.entity.essay.Essay;
import main.src.entity.note.Opus;

public class NoteService {
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
}
