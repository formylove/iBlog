package main.src.dao.impl;


import org.springframework.stereotype.Repository;

import main.src.dao.MusicDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Music;
@Repository("musicDaoHibernate4")
public class MusicDaoHibernate4 extends BaseDaoHibernate4<Music> implements MusicDao 
{	
	public MusicDaoHibernate4() {
	}

	@Override
	public Music get(int id) {
		return get(Music.class,id);
	}
	//父类有了就不用再写了
}
