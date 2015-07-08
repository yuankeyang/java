package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpertDiary;

/**
 * 专家日记DAO,对日记的增删改查
 * @author Administrator
 * 05-15
 */
public class ExpertDiaryDAO {
	

	/**
     * 专家新写的一篇日记
     * @param diary
     * @return 新建成功返回日记id
     */
	public int NewDiary(ExpertDiary diary){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(diary);
		tran.commit();		
		session.close();
		return diary.getId();
	}
	
	 /**
     * 专家删除一篇日记
     * @param diary
     * @return 刪除成功返回true
     */
	public boolean DeleteDiary(ExpertDiary diary){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.delete(diary);
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
     * 通过日记ID查询一篇日记
     * @param id
     * @return 日记对象
     */
	public ExpertDiary SelectDiary(int id){
		Session session=HibernateSessionFactory.getSession();
		ExpertDiary diary=(ExpertDiary) session.get(ExpertDiary.class, id);
		session.close();
		return diary;
	}
	
	/**
     * 专家 更新一篇日记
     * @param diary
     * @return 更新成功返回true
     */
	public boolean UpdateDiary(ExpertDiary diary){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(diary);
			tran.commit();
			session.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}
		
	}
	
	/**
     * 通过专家Id查找日记列表
     * @param expeId
     * @return 日记列表
     */
	public List<ExpertDiary> FindDiaryByExpeId(String expeId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ExpertDiary.class);
		criteria.add(Restrictions.eq("expeRegi.expeId", expeId));
	    criteria.addOrder(Order.desc("date"));        /**按日期排序*/
	    List<ExpertDiary> diaryList=criteria.list();
		session.close();
		return  diaryList;
	}

}
