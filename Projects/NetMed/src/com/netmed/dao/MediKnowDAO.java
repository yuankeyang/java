package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;


/**
 *  @author admin
 *  医学解释DAO
 *  操作具有医学词条的多张表(症状表，中医疾病，西医疾病)
 */
public class MediKnowDAO{
        
	/**
	 * 根据输入关键词查找症状Id
	 * @param inputStr
	 * @return 症状对象列表
	 */
	public List<SympSyno> querySympSyno(String inputStr){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(SympSyno.class);
		criteria.add(Restrictions.or(Restrictions.ilike("chinSympName", inputStr,MatchMode.ANYWHERE),Restrictions.ilike("synonymy",inputStr,MatchMode.ANYWHERE)));
		List<SympSyno> result=criteria.list();		
		session.close();	
		return result;		
	}
	 
	
	/**
	 * 根据输入关键词查找中医疾病Id
	 * @param inputStr
	 * @return 中医疾病对象列表
	 */
	public List<ChinDiseSyno> queryChinDiseSyno(String inputStr){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ChinDiseSyno.class);
		criteria.add(Restrictions.or(Restrictions.ilike("chinDiseName", inputStr,MatchMode.ANYWHERE),Restrictions.ilike("synonymy", inputStr,MatchMode.ANYWHERE)));
		List<ChinDiseSyno> result=criteria.list();
		session.close();
		return result;		
	}
	
	/**
	 * 根据输入关键词查找西医疾病Id
	 * @param inputStr
	 * @return 西医疾病对象列表
	 */
	public List<WestDiseSyno> queryWestDiseSyno(String inputStr){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(WestDiseSyno.class);
		criteria.add(Restrictions.or(Restrictions.ilike("westDiseName", inputStr,MatchMode.ANYWHERE),Restrictions.ilike("synonymy", inputStr,MatchMode.ANYWHERE)));
		List<WestDiseSyno> result=criteria.list();
		session.close();
		return result;		
	}
	
	/**
	 * 根据症状id查找医学解释
	 * @param sympId
	 * @return 医学解释列表
	 */
	public List<MediKnow> queryMediKnowBySympId(String sympId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MediKnow.class);
		criteria.add(Restrictions.eq("sympSyno.sympId", sympId));
		List<MediKnow> result=criteria.list();
		session.close();	
		return result;
	}
	
	/**
	 * 根据中医疾病id查找医学解释
	 * @param chinDiseId
	 * @return 医学解释列表
	 */
	public List<MediKnow> queryMediKnowByChinDiseId(String chinDiseId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MediKnow.class);
		criteria.add(Restrictions.eq("chinDiseSyno.chinDiseId", chinDiseId));
		List<MediKnow> result=criteria.list();
		session.close();	
		return result;
	}
	
	/**
	 * 根据西医疾病id查找医学解释
	 * @param westDiseId
	 * @return 医学解释列表
	 */
	public List<MediKnow> queryMediKnowByWestDiseId(String westDiseId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MediKnow.class);
		criteria.add(Restrictions.eq("westDiseSyno.westDiseId", westDiseId));
		List<MediKnow> result=criteria.list();
		session.close();	
		return result;
	}
	

}
