package com.netmed.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.*;

/**类<code>ExpeRegiDAO</code>
 * 封装对表expe_regi的数据库操作
 * 最后改动时间2015-05-10
 * @author 远客
 * @version 1.0
 */
public class ExpeRegiDAO {
	
	/**方法<code>getExpeinfoById</code>
	 * 通过专家的expe_id来获取对应的对象
	 * @param expeId
	 * @return ExpeRegi
	 */
	public ExpeRegi getExpeinfoById(String expeId) {
		Session session=HibernateSessionFactory.getSession();
		ExpeRegi obj=(ExpeRegi) session.get(ExpeRegi.class, expeId);
		session.close();
		return obj;
	}
	
	/**方法<code>checkLogin</code>
	 * 专家登录检查，合法返回true，否则返回false
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public int checkLogin(String username,String password){
		System.out.println("进入ExpeRegiDAO--checkLogin()--登录检查:0正确,1用户名为空,2其他错误");
		ExpeRegi expe=getExpeinfoById(username);
		System.out.println("专家名："+username);
		System.out.println("密    码："+password);
		if(expe==null){
			return 1;
		}else{
			if(expe.getExpePass().equals(password)){
				System.out.println("success:"+expe.getExpePass());
				expe.setState(Boolean.TRUE);
				UpdateExpeRegi(expe);
				return 0;
				}
			else{
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
		/**通过专家id查询专家对象**/
		ExpeRegi expe=getExpeinfoById(id);
		if(expe==null) return false;
		
		/**如果专家对象非空则设置专家状态**/
		Session session=HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		expe.setState(state);
		session.update(expe);
		tx.commit();    //提交事务。
		session.close();
		return true;
	}
	
	public boolean regiExpe(String username,String realname,
			String password,Boolean sex,String id_card_numb,
			String email,String phone,String telephone,
			String referrer) {
		
		ExpeRegi obj=getExpeinfoById(username);
		if(obj!=null) return false;   //判断数据库中是否已经存在，若存在则返回false
		Session session=HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		obj=new ExpeRegi(username,realname,password,
				sex,id_card_numb,email,phone,telephone,referrer);
		session.save(obj);//保存对象到数据库
		tx.commit();//提交事务。
		session.close();
		return true;
	}
	
	/**
	 * 对专家修改信息更新保存
	 * @param expe
	 * @return 更新成功则返回true
	 */
	public boolean UpdateExpeRegi(ExpeRegi expe){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(expe);
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
