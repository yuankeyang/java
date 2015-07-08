package com.netmed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netmed.hibernate.HibernateSessionFactory;
import com.netmed.pojo.MemberArticle;

/**
 * 会员文章--就医经验
 * @author Administrator
 * 05-14
 */
public class MemberArticleDAO {
	
	/**
     * 会员新写的一篇文章,就医经验
     * @param article
     * @return 新建成功返回文章id
     */
	public int NewArticle(MemberArticle article){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(article);
		tran.commit();		
		session.close();
		return article.getId();
	}
	
	/**
     * 会员删除一篇文章
     * @param article
     * @return 刪除成功返回true
     */
	public boolean DeleteArticle(MemberArticle article){
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
	public MemberArticle SelectArticle(int id){
		Session session=HibernateSessionFactory.getSession();
		MemberArticle article=(MemberArticle) session.get(MemberArticle.class, id);
		session.close();
		return article;
	}
	
	/**
     * 会员 更新一篇文章
     * @param article
     * @return 更新成功返回true
     */
	public boolean UpdateArticle(MemberArticle article){
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
     * 通过会员Id查找文章列表
     * 按时间排序，越近越靠前
     * @param membId
     * @return 文章列表
     */
	public List<MemberArticle> FindArticleByMembId(String membId){
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(MemberArticle.class);
		criteria.add(Restrictions.eq("membRegi.membId", membId));
		criteria.addOrder(Order.desc("time"));
		List<MemberArticle> articleList=criteria.list();
		session.close();
		return articleList;
	}
	

}
