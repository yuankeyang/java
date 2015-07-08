package com.netmed.dao;

import org.hibernate.Session;
import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;

/**
 * @author Administrator
 * 输入参数：药物ID
 * 输出参数：药物详情
 * 05-17
 */
public class MedicineDetailDAO {
	
	/**
	 * 通过西药id查询西药对象
	 * @param mediId
	 * @return 西药对象
	 */
	public WestMedi FindWestMediById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		WestMedi westMedi=(WestMedi) session.get(WestMedi.class, mediId);
	    session.close();
		return westMedi;
	}
	
	/**
	 * 通过方剂id查询方剂对象
	 * @param mediId
	 * @return 方剂对象
	 */
	public Prescription FindPrescripById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		Prescription pres=(Prescription) session.get(Prescription.class, mediId);
	    session.close();
		return pres;
	}
	
	/**
	 * 通过中药材id查询中药材对象
	 * @param mediId
	 * @return 中药材对象
	 */
	public ChinMediMate FindMediMateById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		ChinMediMate mediMate=(ChinMediMate) session.get(ChinMediMate.class, mediId);
	    session.close();
		return mediMate;
	}
	
	/**
	 * 通过中成药id查询中成药对象
	 * @param mediId
	 * @return 中成药对象
	 */
	public ChinPateMedi FindPateMediById(String mediId) {
		Session session = HibernateSessionFactory.getSession();
		ChinPateMedi pateMedi=(ChinPateMedi) session.get(ChinPateMedi.class, mediId);
	    session.close();
		return pateMedi;
	}

}
