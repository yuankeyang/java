package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.SleepRecords;

/**
 * 睡眠记录DAO,对睡眠记录进行增删查改
 * @author Administrator
 * 06-04
 */
public class SleepRecordDAO {

	/**
	 * 新增睡眠记录
	 * @param sleepRecord
	 * @return 睡眠记录id
	 */
	public int NewSleepRecord(SleepRecords sleepRecord){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		try{
			session.save(sleepRecord);
			tran.commit();		
			session.close();
			return sleepRecord.getSleepRecordId();
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return 0;
		}
	}
	
	/**
	 * 根据会员ID查找睡眠表记录
	 * @param membId
	 * @return 睡眠记录列表
	 */
	public List<SleepRecords> FindInfoByMembId(String membId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(SleepRecords.class);
		criteria.add(Restrictions.eq("membRegi.membId", membId));
		List<SleepRecords> infoList=criteria.list();
		session.close();
		return infoList;
	}
	
	/**
	 * 根据睡眠记录ID查询睡眠相应信息
	 * @param id
	 * @return 睡眠记录对象
	 */
	public SleepRecords FindInfoById(int id){
		Session session=HibernateSessionFactory.getSession();
		SleepRecords info=(SleepRecords) session.get(SleepRecords.class, id);
		session.close();
		return info;
	} 
	
	/**
	 * 删除睡眠记录
	 * @param sleepRecord
	 * @return 删除成功则返回true
	 */
	public boolean deleteSleepRecord(SleepRecords sleepRecord){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.delete(sleepRecord);
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
	 * 修改睡眠记录
	 * @param sleepRecord
	 * @return 修改成功则返回true
	 */
	public boolean UpdateSleepRecord(SleepRecords sleepRecord){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(sleepRecord);
			tran.commit();
			session.close();
			return true; 
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}
	}
}
