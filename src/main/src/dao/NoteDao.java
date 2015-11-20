package main.src.dao;

import java.io.Serializable;

import main.src.dao.common.BaseDao;
import main.src.entity.Note;
public interface NoteDao extends BaseDao<Note>
{
	// 根据ID加载实体
	Note get(Serializable id);
}
