package com.netmed.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.*;
import com.netmed.pojo.*;

/**
 * @author administrator
 * 中医标准证名表的DAO操作
 * 05-09
 */
public class SyndSynoDAO {
	
      
	
	/**
	 *  搜索某一大类下的第二类,输入参数为第一大类的编号
	 * @param firstType
	 * @return 证对象列表
	 */
     public List<SyndSyno> querySecondType(String firstType){ 	  
  		Session session=HibernateSessionFactory.getSession();
  		Criteria criteria=session.createCriteria(SyndSyno.class);
  		criteria.add(Restrictions.ilike("syndId",firstType,MatchMode.START));
  		List<SyndSyno> result=criteria.list();		
  		session.close();
  		return result;
      }
      
      
}
