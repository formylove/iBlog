package main.src.dao;

import java.io.Serializable;

import main.src.dao.common.BaseDao;
import main.src.entity.Note;
public interface NoteDao extends BaseDao<Note>
{
	// ����ID����ʵ��
	Note get(Serializable id);
}
