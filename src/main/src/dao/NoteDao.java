package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Note;
public interface NoteDao extends BaseDao<Note>
{
	// ����ID����ʵ��
	Note get(int id);
}
