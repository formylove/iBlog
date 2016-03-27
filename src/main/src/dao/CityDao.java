package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Music;
import main.src.entity.gallery.City;

public interface CityDao extends BaseDao<City>{
	City get(int id);
}
