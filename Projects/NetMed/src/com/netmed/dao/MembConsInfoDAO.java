package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.MembConsInfo;

/**
 * @author admin
 * 离线咨询表DAO
 * 05-12
 */
public class MembConsInfoDAO {
	
	    /**
	     * 新建一条离线咨询
	     * @param consult
	     */
		public void AddConsult(MembConsInfo consult){
			Session session=HibernateSessionFactory.getSession();
			Transaction tran=session.beginTransaction();
			session.save(consult);
			tran.commit();		
			session.close();
		}
		
		/**
		 * 更新一份离线咨询记录
		 * @param consult
		 * @return 离线咨询id 
		 */
		public int UpdateConsult(MembConsInfo consult){
			Session session=HibernateSessionFactory.getSession();
			Transaction tran=session.beginTransaction();
			session.update(consult);
			tran.commit();
			session.close();
			return consult.getConsId(); 
		}
		
		/**
		 * 根据离线咨询ID查询离线咨询
		 * @param id
		 * @return 离线咨询对象
		 */
		public MembConsInfo FindInfoById(int id){
			Session session=HibernateSessionFactory.getSession();
			MembConsInfo info=(MembConsInfo) session.get(MembConsInfo.class, id);
			session.close();
			return info;
		}
		
		/**
		 * 通过专家id查询已处理的离线咨询记录
		 * 根据咨询时间前后排序,越近越靠前
		 * @param expertId
		 * @return 离线咨询列表
		 */
		public List<MembConsInfo> FindInfoByExpertIdYiDu(String expertId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MembConsInfo.class);
			criteria.add(Restrictions.and(Restrictions.eq("expeRegi.expeId", expertId),Restrictions.eq("state",true)));
			criteria.addOrder(Order.desc("consTime"));
			List<MembConsInfo> membConsultInfo=criteria.list();
			session.close();
			return membConsultInfo;
		}
		
		/**
		 * 通过专家id查询未处理的离线咨询记录
		 * 根据咨询时间前后排序,越近越靠前
		 * @param expertId
		 * @return 离线咨询列表
		 */
		public List<MembConsInfo> FindInfoByExpertIdWeiDu(String expertId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MembConsInfo.class);
			criteria.add(Restrictions.and(Restrictions.eq("expeRegi.expeId", expertId),Restrictions.eq("state",false)));
			criteria.addOrder(Order.desc("consTime"));
			List<MembConsInfo> membConsultInfo=criteria.list();
			session.close();
			return membConsultInfo;
		}
		
		/**
		 * 通过会员id查询未处理的离线咨询记录
		 * 根据咨询时间前后排序,越近越靠前
		 * @param memberId
		 * @return 离线咨询列表
		 */
		public List<MembConsInfo> FindInfoByMemberIdWeiDu(String memberId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MembConsInfo.class);
			criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", memberId),Restrictions.eq("state",false)));
			criteria.addOrder(Order.desc("consTime"));
			List<MembConsInfo> membConsultInfo=criteria.list();
			session.close();
			return membConsultInfo;
		}
		
		/**
		 * 通过会员id查询已处理的离线咨询记录
		 * 根据咨询时间前后排序,越近越靠前
		 * @param memberId
		 * @return 离线咨询列表
		 */
		public List<MembConsInfo> FindInfoByMemberIdYiDu(String memberId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MembConsInfo.class);
			criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", memberId),Restrictions.eq("state",true)));
			criteria.addOrder(Order.desc("consTime"));
			List<MembConsInfo> membConsultInfo=criteria.list();
			session.close();
			return membConsultInfo;
		}
		
		/**
		 * 根据离线咨询id判断会员有无上传附件
		 * @param id
		 * @return 如有附件则返回true
		 */
		public boolean isHaveFile(int id){
			Session session=HibernateSessionFactory.getSession();
			MembConsInfo consult=(MembConsInfo) session.get(MembConsInfo.class, id);
			if(consult.getFilenames()==null){
				session.close();
				return false;
			}
			else{
				session.close();
				return true;
			}
		}

}
