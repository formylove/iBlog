package main.src.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.CommentDao;
import main.src.entity.Comment;
import main.src.service.CommentService;
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Resource(name = "commentDaoHibernate4")
	private CommentDao commentDao;
	
	public CommentServiceImpl() {
	}

	public int save(Comment comment) {
		return commentDao.save(comment);
	}

	@Override
	public void persist(Comment comment) {
		commentDao.persist(comment);
	}
	
	@Override
	public void delete(int id) {
		Comment c = get(id); 
		delete(c);
	}

	@Override
	public void delete(Comment comment) {
		commentDao.delete(comment);
	}
	@Override
	public void update(Comment comment) {
		commentDao.update(comment);
	}
	@Override
	public Comment remove(int id) {
		Comment comment = get(id);
		if(null != comment){
			comment.setDel_flag(true);
			commentDao.update(comment);
		}
		return comment;
	}

	@Override
	public Comment get(int id) {
		return commentDao.get(id);
	}

	@Override
	public void recover(int id) {
		Comment comment = get(id);
		if(null != comment){
			comment.setDel_flag(false);
			commentDao.update(comment);
		}
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}




}
