package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.gallery.item.Figure;

public interface FigureDao extends BaseDao<Figure>{
	Figure get(int id);
}
