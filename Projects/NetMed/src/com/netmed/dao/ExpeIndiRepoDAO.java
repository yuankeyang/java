package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpeIndiRepo;

/**
 * 专家个人知识库DAO，对个人方剂库的增删改查
 * @author Administrator
 */
public class ExpeIndiRepoDAO {
	
	/**
	 * 专家新写的一篇处方，增加到工具箱
	 * @param repository
	 * @return 成功则返回一个非0整数
	 */
	public int NewRepository( ExpeIndiRepo repository){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(repository);
		tran.commit();		
		session.close();
		return repository.getRepoId();
	}
	
	/**
	 * 专家删除一篇处方
	 * @param repository
	 * @return 删除成功则返回true
	 */
	public boolean DeleteRepository(ExpeIndiRepo repository){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.delete(repository);
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
	 * 专家通过知识库ID查询一篇处方
	 * @param id
	 * @return 个人知识库对象
	 */
	public ExpeIndiRepo SelectRepository(int id){
		Session session=HibernateSessionFactory.getSession();
		ExpeIndiRepo repository=(ExpeIndiRepo) session.get(ExpeIndiRepo.class, id);
		session.close();
		return repository;
	}
	
	/**
	 * 专家 更新一篇处方
	 * @param repository
	 * @return 更新成功则返回true
	 */
	public boolean UpdateRepository(ExpeIndiRepo repository){
		Session session=HibernateSessionFactory.getSession();
		try{
			Transaction tran=session.beginTransaction();
			session.update(repository);
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
	 * 通过专家Id查找知识库
	 * @param expeId
	 * @return 知识库列表
	 */
	public List<ExpeIndiRepo> FindRepositoryByExpeId(String expeId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(ExpeIndiRepo.class);
		criteria.add(Restrictions.eq("expeRegi.expeId", expeId));
		criteria.addOrder(Order.desc("consTime"));    /**根据时间先后顺序排序,最新的最前**/
		List<ExpeIndiRepo> repositoryList=criteria.list();
		session.close();
		return  repositoryList;
	}

}
