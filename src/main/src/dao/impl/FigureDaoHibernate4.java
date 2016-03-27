package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.FigureDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.item.Figure;
@Repository("figureDaoHibernate4")
public class FigureDaoHibernate4 extends BaseDaoHibernate4<Figure> implements FigureDao 
{	
	public FigureDaoHibernate4() {
	}

	@Override
	public Figure get(int id) {
		return get(Figure.class,id);
	}
	//父类有了就不用再写了
}
