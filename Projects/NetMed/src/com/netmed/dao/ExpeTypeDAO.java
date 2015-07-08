package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpeType;
import com.netmed.pojo.ExpeTypeComp;

/**
 * 专家类型DAO,保存专家类型信息
 * @author Administrator
 * 06-01
 */
public class ExpeTypeDAO {

	/**
	 * 因为一个专家可能有多个类型,所以将每个注册专家的类型保存在专家类型表中
	 * @param experegi
	 * @param expetypecomp
	 * @return 专家类型id
	 */
	public int SaveExpeType(ExpeRegi experegi,ExpeTypeComp expetypecomp){
		ExpeType et=new ExpeType(experegi, expetypecomp);
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(et);
		tran.commit();
		session.close();
		return et.getId();
	}
	
	/**
	 * 通过专家类型ID查找相应的专家
	 * @param typeId
	 * @return 专家列表
	 */
	public List<ExpeType> FindExpertByTypeId(int typeId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ExpeType.class);
		criteria.add(Restrictions.eq("expeTypeComp.expeTypeId", typeId));
		criteria.addOrder(Order.desc("expeRegi.expeId"));    /**根据等级排名,为什么不能通过外键排序**/
		List<ExpeType> expertList=criteria.list();
		session.close();
		return expertList;
	}
	
	/**
	 * 查找养生专家
	 * @return 养生专家列表
	 */
	public List<ExpeType> FindRegimenExpert(){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ExpeType.class);
		criteria.add(Restrictions.or
				(Restrictions.eq("expeTypeComp.expeTypeId", 3),Restrictions.or
						(Restrictions.eq("expeTypeComp.expeTypeId", 4),Restrictions.or
								(Restrictions.eq("expeTypeComp.expeTypeId", 5),Restrictions.eq("expeTypeComp.expeTypeId", 6)))));
		List<ExpeType> expertList=criteria.list();
		session.close();
		return expertList;
	}
	
}
