package com.netmed.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;
/**
 * 类<code>MembRegiDAO</code>
 * 封装的对表memb_regi的操作
 * 最后改动时间2015-05-10
 * @author yang
 * @version 1.0
 *
 */
public class MembRegiDAO {
	
	/**方法<code>regiMemb</code>
	 * 保存对象到数据库，返回会员的memb_id
	 * @param un
	 * @param mail
	 * @param sex
	 * @param pwd
	 * @return boolean
	 */
	public boolean regiMemb(String un,String mail,Boolean sex,String pwd) {
		MembRegi obj=getMembinfoById(un);
		if(obj!=null) return false;//判断数据库中是否已经存在
		Session session=HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Integer init1=new Integer(0);
		Long init2=new Long(0);
		MembRegi memb_regi=new MembRegi(un, pwd, sex, mail,init1, init1, init2);
		session.save(memb_regi);//保存对象到数据库
		tx.commit();//提交事务。
		session.close();
		return true;
	}
	/**方法<code>getMembinfoById</code>
	 * 通过会员的memb_id来获取对应的对象
	 * @param memb_id
	 * @return MembRegi
	 * @see MembRegi
	 */
	public MembRegi getMembinfoById(String memb_id){
		Session session=HibernateSessionFactory.getSession();
		MembRegi memb=(MembRegi) session.get(MembRegi.class, memb_id);
		session.close();
		return memb;
	}
	/**方法<code>checkLogin</code>
	 * 用户登录检查，合法返回true，否则返回false
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public int checkLogin(String username,String password){
		System.out.println("进入MembRegiDAO--checkLogin()---登录检查：0正确,1用户空,其他2");
		MembRegi memb=getMembinfoById(username);
		System.out.println("会员信息："+memb);
		if(memb==null){
			return 1;
		}else{
			if(memb.getMembPass().equals(password)){
				return 0;
				}
			else{
//				System.out.println(memb.getMembPass());
				return 2;
				}
		}
	}
	/**方法<code>setState</code>
	 * 设置登录状态
	 * @param id
	 * @param state
	 * @return boolean
	 */
	public boolean setState(String id,Boolean state){
		System.out.println("进入MembRegiDAO---setState:设置会员状态--->在线");
		MembRegi memb=getMembinfoById(id);
		if(memb==null) return false;
		System.out.println("用户："+memb.getMembId());
		Session session=HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		memb.setState(state);
		session.update(memb);
		tx.commit();//提交事务。
		session.close();
		return true;
	}
	
		
		/**
		 * 判断会员是否在线
		 * @param memb_id
		 * @return boolean
		 */
		public boolean isOnline(String memb_id){
			 String hql="select state from MembRegi m where m.membId=:name";
			 Session session=HibernateSessionFactory.getSession();
			 Query query=session.createQuery(hql);
			 query.setParameter("name", memb_id);
			 List list=query.list();
			 session.close();
			 if(list.size()!=0){
				 if(list.get(0).equals(true))
					  return true;
			 }	 
			 return false;	 
			 
		 }	
		
		/**
		 * 对会员的修改信息进行保存
		 * @param memb
		 * @return 保存修改成功则返回true
		 */
		public boolean UpdateMembRegi(MembRegi memb){
			Session session=HibernateSessionFactory.getSession(); 
			try{
				Transaction tran=session.beginTransaction();
				session.update(memb);
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
		 * 通过会员ID查询积分
		 * @param membId
		 * @return 会员积分
		 */
		public int getMemberCredit(String membId){
			Session session=HibernateSessionFactory.getSession();
			MembRegi member=(MembRegi) session.get(MembRegi.class, membId);
			session.close();
			return member.getCredit();
		}
		
		
}
