package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.MembArchInfo;

/**
 * @author Administrator
 * 05-20
 * 会员电子健康档案DAO
 */
public class MembArchInfoDAO {
	
	/**
	 * 新建一份电子健康档案
	 * @param info
	 * @return 新建成功则返回电子健康档案id
	 */
	public int NewMembArchInfo(MembArchInfo info){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		int flag=0;
		try{
			session.save(info);
			tran.commit();
			session.close();
			flag=info.getArchId();
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			flag=0;
			
		}
		return flag;
	}
	
	/**
	 * 更新一份电子健康档案
	 * @param info
	 * @return 修改成功则返回true
	 */
    public boolean updateMembArchInfo(MembArchInfo info){
    	Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(info);
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
     * 删除电子健康病历信息
     * @param info
     * @return 删除成功则返回true
     */
   public boolean deleteMembArchInfo(MembArchInfo info){
	   Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.delete(info);
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
    * 通过健康档案ID查询电子健康档案详情
    * @param id
    * @return 健康档案对象
    */
   public MembArchInfo findDetailById(int id){
	   Session session=HibernateSessionFactory.getSession();
	   MembArchInfo info=(MembArchInfo) session.get(MembArchInfo.class, id);
	   session.close();
	   return info;
   }
   
   /**
    * 通过会员ID查询电子健康档案
    * @param membId
    * @return 健康档案列表
    */
	public List<MembArchInfo> findDetailByMembId(String membId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MembArchInfo.class);
		criteria.add(Restrictions.eq("membRegi.membId", membId));
		List<MembArchInfo> infoList=criteria.list();
	    session.close();
		return infoList;
	}
	
	/**
	 * 通过会员ID和家属姓名查询电子健康档案
	 * @param membId
	 * @param name
	 * @return 健康档案列表
	 */
	public List<MembArchInfo> findDetail(String membId, String name){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MembArchInfo.class);
		criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", membId),Restrictions.eq("name",name)));
		List<MembArchInfo> infoList=criteria.list();
	    session.close();
		return infoList;
	}
	

}
