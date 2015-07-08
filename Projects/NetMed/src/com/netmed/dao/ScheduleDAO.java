package com.netmed.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.Schedule;

/**
 * 专家日程表DAO
 * @author Administrator
 * 05-28
 */
public class ScheduleDAO {
	
	/**
	 * 通过专家id获取其日程安排
	 * @param expeId
	 * @return 日程安排列表
	 */
	public List<Schedule> getScheludeData(String expeId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Schedule.class);
		criteria.add(Restrictions.eq("expeRegi.expeId", expeId));
		List<Schedule> schedules = criteria.list();
		session.close();
	    return schedules;
	}
	
	/**
	 * 保存专家撰写的日程安排信息
	 * @param title
	 * @param expe_id
	 * @param content
	 * @param start
	 * @param end
	 * @return 日程id
	 */
	public Integer saveScheduleData(String title,String expe_id,
		String content,Timestamp start,Timestamp end){
		ExpeRegiDAO expedao=new ExpeRegiDAO();
		ExpeRegi expe=expedao.getExpeinfoById(expe_id);
		Session session=HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Schedule sd=new Schedule(expe,title,content,start,end);
		session.save(sd);
		tx.commit();
		session.close();
		return sd.getId();
	}
	
	public boolean deleteScheduleData(){
		return true;
	}
	public boolean updateScheduleData(){
		return true;
	}
}
