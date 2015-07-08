package com.netmed.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.Collection;

/**
 * @author Administrator
 *   收藏表DAO
 *   05-12
 */
public class CollectionDAO {
	
	/**
	 * 新建一条收藏记录,成功则返回非0整数
	 * @param collection
	 * @return 整型
	 */
	public int SaveCollection(Collection collection){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(collection);
		tran.commit();
		session.close();
		return collection.getId();
	}
	
	/**
	 * 通过专家ID和用户ID找到收藏记录,删除收藏
	 * @param expertId
	 * @param userId
	 * @return 收藏记录的条数
	 */
	public int CancelCollection(String expertId,String userId){
		
		/**通过专家ID和用户ID找到收藏记录**/
		List<Collection> result=FindCollectId(expertId,userId);
		
		Session session=HibernateSessionFactory.getSession();		
		Transaction tran=session.beginTransaction();
	    for(int i=0;i<result.size();i++){
	    	session.delete(result.get(i));
	    }
	    tran.commit();  /**将所有收藏删除后再提交事务**/
		session.close();
		return result.size();
	}
	
	/**
	 * 通过专家ID和用户ID找到收藏记录
	 * @param expertId
	 * @param userId
	 * @return 收藏列表
	 */
	public List<Collection> FindCollectId(String expertId,String userId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Collection.class);
		criteria.add(Restrictions.and(Restrictions.eq("membRegi.membId", userId),Restrictions.eq("expeRegi.expeId", expertId)));
		List<Collection> result=criteria.list();
		session.close();
		return result;
	}
	
	/**
	 * 通过专家id查询其收藏专家
	 * @param memb_id
	 * @return 收藏列表
	 */
	public List<Collection> getCollections(String memb_id){
		Session session=HibernateSessionFactory.getSession();
        Criteria criteria=session.createCriteria(Collection.class);
        criteria.add(Restrictions.eq("membRegi.membId", memb_id));
        List<Collection> collect=criteria.list();
		session.close();
 		return collect;
	}
	

}
