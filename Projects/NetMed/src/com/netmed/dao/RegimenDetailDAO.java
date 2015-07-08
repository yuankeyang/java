package com.netmed.dao;

import org.hibernate.Session;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;

/**
 * @author Administrator
 * 输入参数：养生品ID
 * 输出参数：养生品详情
 * 05-17
 */
public class RegimenDetailDAO {
	
	/**
	 * 通过保健食品id查询保健食品对象
	 * @param mediId
	 * @return 保健食品对象
	 */
	public HealFood FindHealFoodById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		HealFood healFood=(HealFood) session.get(HealFood.class, mediId);
	    session.close();
		return healFood;
	}
	
	/**
	 * 通过复方id查询复方对象
	 * @param mediId
	 * @return 复方对象
	 */
	public ChinRegiComp FindChinRegiCompById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		ChinRegiComp comp=(ChinRegiComp) session.get(ChinRegiComp.class, mediId);
	    session.close();
		return comp;
	}
	
	/**
	 * 通过浴方id查询浴方对象
	 * @param mediId
	 * @return 浴方对象
	 */
	public ChinMediBath FindMediBathById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		ChinMediBath bath=(ChinMediBath) session.get(ChinMediBath.class, mediId);
	    session.close();
		return bath;
	}
	
	/**
	 * 通过按摩方id查询按摩方对象
	 * @param mediId
	 * @return 按摩方对象
	 */
	public MassPres FindMassPresById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		MassPres mass=(MassPres) session.get(MassPres.class, mediId);
	    session.close();
		return mass;
	}
	
	/**
	 * 通过医疗器械id查询医疗器械对象
	 * @param mediId
	 * @return 医疗器械对象
	 */
	public HomeMediEqui FindMediEquiById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		HomeMediEqui equi=(HomeMediEqui) session.get(HomeMediEqui.class, mediId);
	    session.close();
		return equi;
	}


}
