package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.ExpertArticle;

/**
 * 专家文章DAO,对文章的增删改查
 * @author Administrator
 *  05-15
 */
public class ExpertArticleDAO {


	    /**
	     * 专家新写的一篇文章
	     * @param article
	     * @return 新建成功返回文章id
	     */
		public int NewArticle(ExpertArticle article){
			Session session=HibernateSessionFactory.getSession();
			Transaction tran=session.beginTransaction();
			session.save(article);
			tran.commit();		
			session.close();
			return article.getId();
		}
		
		 /**
	     * 专家删除一篇文章
	     * @param article
	     * @return 刪除成功返回true
	     */
		public boolean DeleteArticle(ExpertArticle article){
			Session session=HibernateSessionFactory.getSession();
			try{
				Transaction tran=session.beginTransaction();
				session.delete(article);
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
	     * 通过文章ID查询一篇文章
	     * @param id
	     * @return 文章对象
	     */
		public ExpertArticle SelectArticle(int id){
			Session session=HibernateSessionFactory.getSession();
			ExpertArticle article=(ExpertArticle) session.get(ExpertArticle.class, id);
			session.close();
			return article;
		}
		
		/**
	     * 专家 更新一篇文章
	     * @param article
	     * @return 更新成功返回true
	     */
		public boolean UpdateArticle(ExpertArticle article){
			Session session=HibernateSessionFactory.getSession();
			try{
				Transaction tran=session.beginTransaction();
				session.update(article);
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
	     * 通过专家Id查找文章列表
	     * @param expeId
	     * @return 文章列表
	     */
		public List<ExpertArticle> FindArticleByExpeId(String expeId){
			Session session=HibernateSessionFactory.getSession();
			Criteria criteria=session.createCriteria(ExpertArticle.class);
			criteria.add(Restrictions.eq("expeRegi.expeId", expeId));
			criteria.addOrder(Order.desc("time"));    /**按创作时间排序**/
			List<ExpertArticle> articleList=criteria.list();
			session.close();
			return  articleList;
		}
		


}
