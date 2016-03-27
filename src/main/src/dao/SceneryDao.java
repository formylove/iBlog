package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.gallery.item.Scenery;

public interface SceneryDao extends BaseDao<Scenery>{
	Scenery get(int id);
}
