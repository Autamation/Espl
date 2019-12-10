package com.prakat.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prakat.controller.EQualityLabsController;
import com.prakat.dao.TenonApiDao;
import com.prakat.model.EQualityLabsVo;
import com.prakat.model.TenonApiVo;
import com.prakat.model.TenonByWCAG;
import com.prakat.model.UserDetailsVo;

@Repository
@Transactional
public class TenonApiDaoImpl implements TenonApiDao {
	@PersistenceContext
	private EntityManager manager;
	@Autowired EQualityLabsDAOImpl dao;

	static Logger logger = Logger.getLogger(TenonApiDaoImpl.class.getName());

	public List<EQualityLabsVo> getDetailsOfAllUrlByUrl() {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from EQualityLabsVo");

		java.util.List list = query.list();
		logger.debug(list);
		t.commit();
		session.close();
		return list;
	}

	public void saveDetailsOfAllUrl(EQualityLabsVo equalityLab) {
		/*
		 * Configuration configuration = new Configuration();
		 * configuration.configure(); ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder().applySettings(
		 * configuration.getProperties()). buildServiceRegistry();
		 * SessionFactory sessionFactory =
		 * configuration.buildSessionFactory(serviceRegistry);
		 */
		Session session = null;

		Transaction txn = null;
		try {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			txn = session.beginTransaction();
			session.save(equalityLab);
			txn.commit();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}

	}

	
	
	public void saveDetailsOfAllUrls(List<TenonByWCAG> tenonByWCAGs) {
		/*
		 * Configuration configuration = new Configuration();
		 * configuration.configure(); ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder().applySettings(
		 * configuration.getProperties()). buildServiceRegistry();
		 * SessionFactory sessionFactory =
		 * configuration.buildSessionFactory(serviceRegistry);
		 */
		Session session = null;

		Transaction txn = null;
		try {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			txn = session.beginTransaction();
			session.save(tenonByWCAGs);
			txn.commit();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}

	}

	public void saveDetailsOfAllUrl(TenonByWCAG tenonbyWcag) {
		/*
		 * Configuration configuration = new Configuration();
		 * configuration.configure(); ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder().applySettings(
		 * configuration.getProperties()). buildServiceRegistry();
		 * SessionFactory sessionFactory =
		 * configuration.buildSessionFactory(serviceRegistry);
		 */
		Session session = null;

		Transaction txn = null;
		try {
			System.out.println("witiout is comming");
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			//tenonbyWcag.setUserId(userId);
			int userId=tenonbyWcag.getUserId();
			tenonbyWcag.setUserId(userId);
			session.saveOrUpdate(tenonbyWcag);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}

	}


	public void updateDB(List<TenonByWCAG> tenonApiObj, int userId) {
		{
				/*
				 * Configuration configuration = new Configuration();
				 * configuration.configure(); ServiceRegistry serviceRegistry = new
				 * ServiceRegistryBuilder().applySettings(
				 * configuration.getProperties()). buildServiceRegistry();
				 * SessionFactory sessionFactory =
				 * configuration.buildSessionFactory(serviceRegistry);
				 */
				Session session = null;

				Transaction txn = null;
				try {
					SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
					session = sessionFactory.openSession();
					txn = session.beginTransaction();
					for(TenonByWCAG tenonObj : tenonApiObj) {
						tenonObj.setUserId(userId);
					    session.merge(tenonObj);
					}
					//tenonbyWcag.setUserId(userId);
					//int userId=tenonbyWcag.getUserId();
					//session.saveOrUpdate(tenonbyWcag);
					txn.commit();
				} catch (Exception e) {
					//e.printStackTrace();
					//logger.info(e.getMessage());
				} finally {
					if (!txn.wasCommitted()) {
						txn.rollback();
					}

					session.flush();
					session.close();
				}

			}


	}

	public void saveResultsetObj(TenonApiVo res) {
		Session session = null;

		Transaction txn = null;
		try {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.merge(res);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}
		
	}
}
