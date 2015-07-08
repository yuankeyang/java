package com.netmed.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ChinDiagDise;
import com.netmed.pojo.ChinDiagSynd;

/**
 * 离线咨询的辨病和病证结果DAO
 * @author Administrator
 * 05-20
 */
public class DiagResultDAO {
	
	/**
	 * 新建辩证结果
	 * @param syndrome
	 * @return 布尔型,成功则返回true
	 */
	public boolean NewSyndrome(ChinDiagSynd syndrome){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.save(syndrome);
			tran.commit();	
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}		
		
	}
	
	/**
	 * 新建辨病结果
	 * @param syndrome
	 * @return 布尔型,成功则返回true
	 */
	public boolean NewDisease(ChinDiagDise disease){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.save(disease);
			tran.commit();	
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}		
		
	}
	
	/**
	 * 修改辩证结果
	 * @param syndrome
	 * @return 布尔型,成功则返回true
	 */
	public boolean UpdateDisease(ChinDiagDise syndrome){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(syndrome);
			tran.commit();	
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}		
		
	}
	
	/**
	 * 修改辨病结果
	 * @param disease
	 * @return 布尔型,成功则返回true
	 */
	public boolean UpdateSyndrome(ChinDiagSynd disease){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(disease);
			tran.commit();	
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}		
		
	}
	
	/**
	 * 通过离线咨询ID获取辩证结果
	 * @param consultId
	 * @return 辩证结果列表
	 */
	public List<ChinDiagSynd> getSyndbyConsultId(int consultId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ChinDiagSynd.class);
		criteria.add(Restrictions.eq("membConsInfo.consId", consultId));
		List<ChinDiagSynd> syndList=criteria.list();
		session.close();
		return syndList;
	}
	
	/**
	 * 通过离线咨询ID获取辨病结果
	 * @param consultId
	 * @return 辨病结果列表
	 */
	public List<ChinDiagDise> getDisebyConsultId(int consultId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ChinDiagDise.class);
		criteria.add(Restrictions.eq("membConsInfo.consId", consultId));
		List<ChinDiagDise> diseList=criteria.list();
		session.close();
		return diseList;
	}

}
