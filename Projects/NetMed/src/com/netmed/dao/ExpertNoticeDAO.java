package com.netmed.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpertNotice;

/**
 * 专家发表新公告
 * @author Administrator
 * 05-19
 */
public class ExpertNoticeDAO 
{
	/**
	 * 专家新写的一个公告
	 * @param gonggao
	 * @return 公告id
	 */
	public int NewGongGao(ExpertNotice gonggao){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(gonggao);
		tran.commit();		
		session.close();
		return gonggao.getId();
	}
}
