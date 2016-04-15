package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.common.TimeManager;
import main.src.dao.CommentDao;
import main.src.entity.Comment;
import main.src.service.CommentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
	
	public boolean add(Comment comment) {
		if(comment.getTarget() == null){
			comment.setFloor(1);
			comment.setUnit(getLastUnit(comment)+1);
		}else if(comment.getTarget().isDel_flag()){
			return false;
		}else{
			Comment target = get(comment.getTarget().getId());
			comment.setTarget(target);
			comment.setUnit(target.getUnit());
			comment.setFloor(getAttic(target)+1);
		}
		comment.setId(save(comment));
		return true;
	}
	
	public int getLastUnit(Comment comment) {
		int lastUnit = getLastUnit(getTableName(comment).toLowerCase(),getId(comment));
		return lastUnit;
	}
	public int getLastUnit(String type,int id) {
		int lastUnit;
		 synchronized(this) {  
			 Session s = commentDao.getSession();
			 Criteria c = s.createCriteria(Comment.class)
					 .add(Restrictions.eq(type+".id", id))//用字段名属性而不是数据库栏位
					 .add(Restrictions.eq("del_flag",false));
			 ProjectionList l = Projections.projectionList();
			 l.add(Property.forName("unit").max());
			 c.setProjection(l);
			  lastUnit = c.uniqueResult() == null? 0:(Integer) c.uniqueResult();
             }  
		return lastUnit;
	}
	public int getAttic(Comment target) {
		Session s = commentDao.getSession();
		Criteria c = s.createCriteria(Comment.class)
				.add(Restrictions.eq(getTableName(target).toLowerCase()+".id", getId(target)))//用字段名属性而不是数据库栏位
				.add(Restrictions.eq("del_flag", false))
				.add(Restrictions.eq("unit", target.getUnit()));
		ProjectionList l = Projections.projectionList();
		l.add(Property.forName("floor").max());
		c.setProjection(l);
		int attic = (int) c.uniqueResult();
		return attic;
	}
	public String getTableName(Comment comment) {
		if(comment.getEssay() != null){
			return "Essay";
		}else if(comment.getNote() != null){
			return "Note";
		}else{
			return "Music";
		}
	}
	public List<Comment> getOnePage(int total,int page,String appendence,int append_id) {
		String hql ="from Comment c where c." + appendence +".id = " + append_id
				+"and c.unit between " + (total - page*PAGESIZE + 1) + " and " + (total - (page -1)*PAGESIZE +1) 
				+" and c.del_flag = 0 order by c.unit desc,c.floor";
		 List<Comment> comments = commentDao.getSession().createQuery(hql).list();
			return comments;
	}
	public JSONObject getPage(int page,Comment comment){
		String type =getTableName(comment).toLowerCase();
        int id = getId(comment);
		int total = getLastUnit(type, id);
		int pages = total/PAGESIZE + (total%PAGESIZE == 0 ? 0:1);
		List<Comment> commentList = getOnePage(total, page, type, id);
		JSONObject comments = new JSONObject();
		JSONArray jComments = new JSONArray();
		comments.accumulate("pages", pages);
		for(Comment c:commentList){
			JSONObject jComment = new JSONObject();
			jComment.accumulate("id", c.getId());
			jComment.accumulate("floor", c.getFloor());
			jComment.accumulate("unit", c.getUnit());
			jComment.accumulate("content", c.getContent());
			jComment.accumulate("motto", c.getPublisher().getMotto());
			jComment.accumulate("publisher", c.getPublisher().getId());
			jComment.accumulate("name", c.getPublisher().getNick_name());
			jComment.accumulate("time", TimeManager.getTimeDif(c.getCreate_date(), c.getCreate_time()));
			jComment.accumulate("portrait", c.getPublisher().getPortrait());
			if(c.getFloor() > 1){
				jComment.accumulate("target_id", c.getTarget().getPublisher().getId());
				jComment.accumulate("target_name", c.getTarget().getPublisher().getNick_name());
			}else{
				jComment.accumulate("device", c.getDev_name());
			}
			jComments.add(jComment);
		}
		comments.accumulate("comments", jComments);
		return comments;
	}
	public int getId(Comment comment) {
		if(comment.getEssay() != null){
			return comment.getEssay().getId();
		}else if(comment.getNote() != null){
			return comment.getNote().getId();
		}else{
			return comment.getMusic().getId();
		}
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
