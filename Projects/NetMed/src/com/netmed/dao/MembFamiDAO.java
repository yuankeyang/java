package com.netmed.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.MembFami;

/**
 * 会员家属DAO
 * @author Administrator
 * 05-20
 */
public class MembFamiDAO {

	/**
	 * 会员新增一位家属信息
	 * @param family
	 * @return 成功返回ID，失败返回0
	 */
	public int NewFamily(MembFami family){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		int flag=0;
		try{
			session.save(family);
			tran.commit();
			session.close();
			flag=family.getFamiId();
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			flag=0;
			
		}
		return flag;
	}
	
	/**
	 * 更新家属信息
	 * @param family
	 * @return 更新成功则返回true
	 */
    public boolean updateFamily(MembFami family){
    	Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(family);
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
     * 删除家属记录
     * @param family
     * @return 删除成功则返回true
     */
   public boolean deleteFamily(MembFami family){
	   Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.delete(family);
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
    * 通过会员ID查询家属记录
    * @param membId
    * @return 家属列表
    */
	public List<MembFami> findDetailByMembId(String membId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MembFami.class);
		criteria.add(Restrictions.eq("membRegi.membId", membId));
		List<MembFami> familyList=criteria.list();
		session.close();
		return  familyList;
	}
	
	/**
	 * 通过家属记录ID，查询家属记录详情
	 * @param id
	 * @return 家属对象
	 */
	 public MembFami findDetailById(int id){
		 Session session=HibernateSessionFactory.getSession();
		 MembFami family=(MembFami) session.get(MembFami.class, id);
		 session.close();
		 return family;
	   }
	
}
