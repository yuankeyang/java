package com.netmed.dao;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;

/**
 * 问药DAO操作，同时操作多张表：西药表，方剂，中药材，中成药
 * @author Administrator 
 * 05-16
 */
public class MedicineDAO {

	/**
	 * 根据关键词查询西药 
	 * @return 西药列表
	 * */
	public List<WestMedi> queryWestMedi(String inputStr) {
		
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(WestMedi.class);
		/** 3个条件 :西药id，西药名，适应症**/
		LogicalExpression condition = Restrictions.or(Restrictions.eq(
				"westMediId", inputStr), Restrictions.ilike("westMediName",
				inputStr, MatchMode.START));
		criteria.add(Restrictions.or(condition, Restrictions.ilike(
				"symptom", inputStr, MatchMode.ANYWHERE)));
		List<WestMedi> westMediList = criteria.list();
		session.close();
		return westMediList;
	}

	/**
	 * 根据关键词查询方剂
	 * @param inputStr
	 * @return 方剂列表
	 */
	public List<Prescription> queryPrescription(String inputStr) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Prescription.class);
		/**3个字段查询：方剂id，方名，主治功效*/
		criteria.add(
				Restrictions.or(Restrictions.eq("presId", inputStr),
			    Restrictions.or(Restrictions.ilike("presName", inputStr,MatchMode.START), 
			    Restrictions.ilike("majorFunction", inputStr,MatchMode.ANYWHERE))));
		List<Prescription> prescripList = criteria.list();
		session.close();
		return prescripList;
	}

	/**
	 * 根据关键词查询中药材
	 * @param inputStr
	 * @return 中药材列表
	 */
	public List<ChinMediMate> queryChinMediMate(String inputStr) {

		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ChinMediMate.class);
		/**3个字段查询：中药材id，中药材名，主治功效*/
		criteria.add(
				Restrictions.or(Restrictions.eq("mediMateId", inputStr),
			    Restrictions.or(Restrictions.ilike("mediMateName", inputStr,MatchMode.START), 
			    Restrictions.ilike("majorFunction", inputStr,MatchMode.ANYWHERE))));
		List<ChinMediMate> mediMateList  = criteria.list();
		session.close();
		return mediMateList;
	}

	/**
	 * 根据关键词查询中成药
	 * @param inputStr
	 * @return 中成药列表
	 */
	public List<ChinPateMedi> queryChinPateMedi(String inputStr) {

		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ChinPateMedi.class);
		/**3个字段查询：中成药id，中成药名，功效*/
		criteria.add(
				Restrictions.or(Restrictions.eq("pateMediId", inputStr),
			    Restrictions.or(Restrictions.ilike("pateMediName", inputStr,MatchMode.START), 
			    Restrictions.ilike("function", inputStr,MatchMode.ANYWHERE))));
		List<ChinPateMedi> pateMediList = criteria.list();
		/**criteria.setMaxResults(10); 控制查询数目, 最多返回10条记录  **/
		session.close();
		return pateMediList;
	}

}
