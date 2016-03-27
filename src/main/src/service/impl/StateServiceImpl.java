package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.StateDao;
import main.src.entity.gallery.City;
import main.src.entity.gallery.State;
import main.src.service.StateService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("stateService")
@Transactional
public class StateServiceImpl implements StateService {
	
	@Resource(name = "stateDaoHibernate4")
	private StateDao stateDao;
	
	public StateServiceImpl() {
	}

	public int save(State state) {
		State o = get(state.getName());
		if(o == null){
			return stateDao.save(state);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(State state) {
		stateDao.persist(state);
	}
	
	@Override
	public void delete(int id) {
		State n = get(id); 
		delete(n);
	}

	@Override
	public void delete(State state) {
		stateDao.delete(state);
	}
	@Override
	public void update(State state) {
		stateDao.update(state);
	}
	@Override
	public State remove(int id) {
		State state = get(id);
		return state;
	}

	@Override
	public State get(int id) {
		return stateDao.get(id);
	}
	@Override
	public State get(String name) {
		String hql ="from State where name=:name";
		Session s = stateDao.getSession();
		State state = (State)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return state;
	}

	@Override
	public void recover(int id) {
	}

	public StateDao getStateDao() {
		return stateDao;
	}

	public void setStateDao(StateDao statedao) {
		this.stateDao = statedao;
	}
	
	@Override
	public List<State> getZhonghua() {
		String hql ="from State s where s.nation.zhonghua = 1";
		Session s = stateDao.getSession();
		List<State> states = (List<State>)s.createQuery(hql).list();
		return states;
	}
	@Override
	public JSONArray getTree() {
		JSONArray tree = new JSONArray();
		String hql0 = "from State s where s.nation.zhonghua = 0 order by s.nation ";
		Session s = stateDao.getSession();
		List<State> cs = s.createQuery(hql0).list();
		////////////////////////zhonghua////////////////////
		JSONObject zhonghua = new JSONObject();
		zhonghua.accumulate("text", "中华");
		zhonghua.accumulate("state", "closed");
		JSONArray yanhuang = new JSONArray();
		List<State> zh = getZhonghua();
		if(zh !=null && zh.size() > 0){
			for(State state: zh){
				JSONObject zisun = new JSONObject();
				zisun.accumulate("id", state.getId());
				zisun.accumulate("text", state.getName());
				yanhuang.add(zisun);
			}
			zhonghua.accumulate("children", yanhuang);
			tree.add(zhonghua);
		}
		////////////////////////continent//////////////////
		JSONObject branch = null;
		JSONArray children = null;
		String nationName = ""; 
		for(State state : cs){
			if(!state.getNation().getName().equals(nationName)){
				if(children != null){
					branch.accumulate("children", children);//必须先填满值才能add
					tree.add(branch);
				}
				nationName = state.getNation().getName();
				children = new JSONArray();
				branch = new JSONObject();
				branch.accumulate("text", nationName);
				branch.accumulate("state", "closed");
			}
				JSONObject child = new JSONObject();
				child.accumulate("id", state.getId());
				child.accumulate("text", state.getName());
				children.add(child);
		}
		if(children != null){
			branch.accumulate("children", children);
			tree.add(branch);
		}
		return tree;
	}
}
