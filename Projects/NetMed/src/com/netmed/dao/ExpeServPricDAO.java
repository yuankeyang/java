package com.netmed.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpeServPric;

/**
 * 专家服务价格表，读取专家服务价格
 * @author Administrator
 *
 */
public class ExpeServPricDAO {
	
	/**
	 * 根据专家类型和等级读取服务价格，可能有多个
	 */
	public List<ExpeServPric> getPriceByTypeAndRank(int type,int rank){
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ExpeServPric.class);
		criteria.add(Restrictions.and(Restrictions.eq(
				"expeTypeComp.expeTypeId", type),Restrictions.eq(
						"expeRank", rank)));
		List<ExpeServPric> priceList=criteria.list();
		session.close();
		return priceList;
	}

}
