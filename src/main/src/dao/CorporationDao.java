package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Music;
import main.src.entity.gallery.Corporation;

public interface CorporationDao extends BaseDao<Corporation>{
	Corporation get(int id);
}
