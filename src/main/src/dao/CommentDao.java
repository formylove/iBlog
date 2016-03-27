package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Comment;

public interface CommentDao extends BaseDao<Comment>{
	Comment get(int id);
}
