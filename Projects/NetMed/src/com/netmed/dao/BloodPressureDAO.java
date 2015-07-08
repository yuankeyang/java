package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.BlooPres;

/**
 *  @author Administrator
 *  血压DAO
 */
public class BloodPressureDAO {
	
	        /**
	         * 新建一条血压记录
	         * @param bloodPressure
	         * @return  返回一个整数，成功为非0
	         */
			public int NewBloodPressureRecord(BlooPres bloodPressure){
				Session session=HibernateSessionFactory.getSession();
				Transaction tran=session.beginTransaction();
				try{
					session.save(bloodPressure);
					tran.commit();		
					session.close();
					System.out.println("保存血压记录成功");
					return bloodPressure.getBlooPresId();
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("保存血压记录失败");
					return 0;
				}
				
			}
			
            /**
             * 更新修改血压记录
             * @param bloodPressure
             * @return  布尔型，修改成功返回true
             */
			public boolean UpdateBloodPressureRecord(BlooPres bloodPressure){
				Session session=HibernateSessionFactory.getSession();
				Transaction tran=session.beginTransaction();
				try{
					session.update(bloodPressure);
					tran.commit();
					session.close();
					return true; 
				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
			}
			
			/**
			 * 通过血压记录id查询血压记录
			 * @param id
			 * @return 血压记录对象
			 */
			public BlooPres FindInfoById(int id){
				Session session=HibernateSessionFactory.getSession();
				BlooPres bloodPressure=(BlooPres) session.get(BlooPres.class, id);
				session.close();
				return bloodPressure;
			} 
			
			/**
			 * 通过会员id查询血压记录
			 * @param membId
			 * @return 血压记录列表
			 */
			public List<BlooPres> FindInfoByMembId(String membId){
				Session session=HibernateSessionFactory.getSession();
				Criteria criteria=session.createCriteria(BlooPres.class);
				criteria.add(Restrictions.eq("membRegi.membId", membId));
				List<BlooPres> infoList=criteria.list();
				session.close();
				return infoList;
			}
			
			/**
			 * 删除某条血压记录
			 * @param bloodPressure
			 * @return 布尔型，删除成功返回true
			 */
			public boolean deleteBloodPressureRecord(BlooPres bloodPressure){
				Session session=HibernateSessionFactory.getSession();
				Transaction tran=session.beginTransaction();
				try{
					session.delete(bloodPressure);
					tran.commit();
					session.close();
					return true;  
				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
			}

}
