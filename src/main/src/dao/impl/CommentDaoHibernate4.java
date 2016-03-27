package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.CommentDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Comment;
@Repository("commentDaoHibernate4")
public class CommentDaoHibernate4 extends BaseDaoHibernate4<Comment> implements CommentDao 
{	
	public CommentDaoHibernate4() {
	}

	@Override
	public Comment get(int id) {
		return get(Comment.class,id);
	}
	//父类有了就不用再写了
}
