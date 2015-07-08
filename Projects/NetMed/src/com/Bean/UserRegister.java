package com.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeRegiDAO;
import com.netmed.dao.MembRegiDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembRegi;

public class UserRegister {
	private db_manager dbmanager;
	private UserBean userBean;
	public void setUserBean(UserBean userBean) {
		this.userBean=userBean;
	}
	public UserRegister() {
		// TODO Auto-generated constructor stub
		dbmanager=new db_manager();
	}
	public boolean register() {
		String sql="INSERT INTO memb_regi(memb_id,memb_pass,memb_emai,memb_sex) VALUES ('"
				+userBean.getUser_name()+"','"+userBean.getPassword()+"','"+userBean.getUser_email()+"',"+userBean.getSex()+")";
		//dbmanager.query(sql);
		if(dbmanager.update(sql)==1) {
			dbmanager.dbclose();
			return true;
			}
		else{
			dbmanager.dbclose();
			return false;
		}
	}
	
	public boolean uploadImg(String url,String id){
		
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
		MembRegi memb = dao.getMembinfoById(id);
		memb.setHeadImg(url);
		dao.UpdateMembRegi(memb);
		return true;
//		String sql="update `netmed`.memb_regi set head_img='"+url+"' where memb_id = '"+id+"'";
//		//dbmanager.query(sql);
//		int result=dbmanager.update(sql);
//		if(result==1) {
//			dbmanager.dbclose();
//			return true;
//			}
//		else{
//			dbmanager.dbclose();
//			return false;
//		}
	}
}
