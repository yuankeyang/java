package com.netmed.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ChinDiseSyno;

/**
 * 中医病名DAO
 * @author Administrator
 */
public class ChinDiseSynoDAO {
	
	/**
	 * 通过输入大类查询相应次级分类
	 * @param firstType,大类
	 * @return 中医病名对象
	 */
    public List<ChinDiseSyno> querySecondType(String firstType){ 	  
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ChinDiseSyno.class);
		criteria.add(Restrictions.ilike("chinDiseId",firstType,MatchMode.START));
		List<ChinDiseSyno> result=criteria.list();		
		session.close();
		return result;
    }

}
