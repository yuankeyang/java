package com.netmed.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.MemberAppointment;


/**
 * 会员预约信息处理
 * @author admin
 * 05-12
 */
public class MembAppointmentDAO {
	
	    /**
	     * 新建预约信息
	     * @param appointment
	     */
		public void AddAppoint(MemberAppointment appointment){
			Session session=HibernateSessionFactory.getSession();
			Transaction tran=session.beginTransaction();
			session.save(appointment);
			tran.commit();		
			session.close();
		}
		
		/**
		 * 对专家回复的预约信息进行更新保存
		 * @param appointment
		 * @return 预约id
		 */
		public int UpdateAppoint(MemberAppointment appointment){
			Session session=HibernateSessionFactory.getSession();
			Transaction tran=session.beginTransaction();
			session.update(appointment);
			tran.commit();
			session.close();
			return appointment.getId(); 
		}
		
		/**
		 * 根据预约ID查询预约表相应信息
		 * @param id
		 * @return 预约对象
		 */
		public MemberAppointment FindInfoById(int id){
			Session session=HibernateSessionFactory.getSession();
			MemberAppointment info=(MemberAppointment) session.get(MemberAppointment.class, id);
			session.close();
			return info;
		} 
		
		/**
		 * 根据专家ID查询已处理的预约
		 * @param expertId
		 * @return 预约列表
		 */
		public List<MemberAppointment> FindInfoByExpertIdYiDu(String expertId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MemberAppointment.class);
			criteria.add(Restrictions.and(Restrictions.eq("expeRegi.expeId", expertId),Restrictions.eq("state",true)));
			criteria.addOrder(Order.desc("appoTime"));
			List<MemberAppointment> membAppointInfo=criteria.list();
			session.close();
			return membAppointInfo;
		}
		
		/**
		 * 根据专家ID查询未处理的预约
		 * @param expertId
		 * @return 预约列表
		 */
		public List<MemberAppointment> FindInfoByExpertIdWeiDu(String expertId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MemberAppointment.class);
			criteria.add(Restrictions.and(Restrictions.eq("expeRegi.expeId", expertId),Restrictions.eq("state",false)));
			criteria.addOrder(Order.desc("appoTime"));
			List<MemberAppointment> membAppointInfo=criteria.list();
			session.close();
			return membAppointInfo;
		}
		
		/**
		 * 根据会员ID查询未处理的预约
		 * @param memberId
		 * @return 预约列表
		 */
		public List<MemberAppointment> FindInfoByMemberIdWeiDu(String memberId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MemberAppointment.class);
			criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", memberId),Restrictions.eq("state",false)));
			criteria.addOrder(Order.desc("appoTime"));
			List<MemberAppointment> membAppointInfo=criteria.list();
			session.close();
			return membAppointInfo;
		}
		
		/**
		 * 根据会员ID查询已处理的预约
		 * @param memberId
		 * @return 预约列表
		 */
		public List<MemberAppointment> FindInfoByMemberIdYiDu(String memberId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(MemberAppointment.class);
			criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", memberId),Restrictions.eq("state",true)));
			criteria.addOrder(Order.desc("appoTime"));
			List<MemberAppointment> membAppointInfo=criteria.list();
			session.close();
			return membAppointInfo;
		}
}
