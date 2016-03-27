package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.ShareDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
@Repository("shareDaoHibernate4")
public class ShareDaoHibernate4 extends BaseDaoHibernate4<Object> implements ShareDao {

}
