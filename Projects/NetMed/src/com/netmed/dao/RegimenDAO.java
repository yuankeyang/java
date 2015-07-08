package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;

/**
 * 养生数据库查询，从与养生有关的多张表(保健食品,养生复方， 浴方，按摩方，医疗器械)进行查询
 * @author Administrator 
 * 05-20
 */
public class RegimenDAO {

	/**
	 * 根据输入关键词查找保健食品
	 * @param inputStr
	 * @return 保健食品列表
	 */
	public List<HealFood> queryHealFood(String inputStr) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(HealFood.class);
		/** 3个条件：保健食品id，保健食品名，功效 **/
		criteria.add(
				Restrictions.or(Restrictions.eq("healFoodId", inputStr),
			    Restrictions.or(Restrictions.ilike("healFoodName", inputStr,MatchMode.START), 
			    Restrictions.ilike("function", inputStr,MatchMode.ANYWHERE))));
		List<HealFood> healFood = criteria.list();
		session.close();
		return healFood;
	}

	/**
	 * 根据输入关键词查找养生复方 
	 * @param inputStr
	 * @return 养生复方列表
	 */
	public List<ChinRegiComp> queryChinRegiComp(String inputStr) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ChinRegiComp.class);
		/** 3个条件：养生复方id，养生复方名，适用人群 **/
		criteria.add(
				Restrictions.or(Restrictions.eq("compId", inputStr),
			    Restrictions.or(Restrictions.ilike("compName", inputStr,MatchMode.START), 
			    Restrictions.ilike("apprCrow", inputStr,MatchMode.ANYWHERE))));
		List<ChinRegiComp> regiComp = criteria.list();
		session.close();
		return regiComp;
	}

	/**
	 * 根据输入关键词查找浴方
	 * @param inputStr
	 * @return 浴方列表
	 */
	public List<ChinMediBath> queryChinMediBath(String inputStr) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(ChinMediBath.class);
		/** 3个条件：浴方id，浴方名，适应症 **/
		criteria.add(
				Restrictions.or(Restrictions.eq("bathId", inputStr),
			    Restrictions.or(Restrictions.ilike("bathName", inputStr,MatchMode.START), 
			    Restrictions.ilike("symptom", inputStr,MatchMode.ANYWHERE))));
		List<ChinMediBath> mediBath = criteria.list();
		session.close();
		return mediBath;
	}

	/**
	 * 根据输入关键词查找按摩方
	 * @param inputStr
	 * @return 按摩方列表
	 */
	public List<MassPres> queryMassPres(String inputStr) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(MassPres.class);
		/** 3个条件：按摩方id，按摩方名，功效 **/
		criteria.add(
				Restrictions.or(Restrictions.eq("massId", inputStr),
			    Restrictions.or(Restrictions.ilike("massName", inputStr,MatchMode.START), 
			    Restrictions.ilike("function", inputStr,MatchMode.ANYWHERE))));
		List<MassPres> massPres = criteria.list();
		session.close();
		return massPres;
	}

	/**
	 * 根据输入关键词查找医疗器械
	 * @param inputStr
	 * @return 医疗器械列表
	 */
	public List<HomeMediEqui> queryHomeMediEqui(String inputStr) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(HomeMediEqui.class);
		/** 3个条件：医疗器械id，医疗器械名，功效 **/
		criteria.add(
				Restrictions.or(Restrictions.eq("prodId", inputStr),
			    Restrictions.or(Restrictions.ilike("prodName", inputStr,MatchMode.ANYWHERE), 
			    Restrictions.ilike("function", inputStr,MatchMode.ANYWHERE))));
		List<HomeMediEqui> mediEqui = criteria.list();
		session.close();
		return mediEqui;
	}

}
