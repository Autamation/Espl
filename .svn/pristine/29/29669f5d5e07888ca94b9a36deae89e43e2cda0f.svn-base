package com.prakat.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.prakat.dao.PaymentProcessDAO;
import com.prakat.model.PaymentVo;

@Repository
public class PaymentProcessDAOIml implements  PaymentProcessDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean savePaymentDetails(PaymentVo paymentVo) {
		
		Logger log = Logger.getLogger(PaymentProcessDAOIml.class.getName());
		// TODO Auto-generated method stub
		//boolean paymentVo=false;
		
		log.info("Executing PaymentProcessDAOIml.savePaymentDetails()...");
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()). buildServiceRegistry();
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = null;
		Transaction txn = null;
		boolean flag = false;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.save(paymentVo);
			txn.commit();
		    
			//em.persist(userDetailsVO);
			flag = true;
			log.info("Saved savePaymentDetails successfully.");
		}
		catch(Exception e) {
			log.error(" Unable to savePaymentDetails successfully.");
			e.printStackTrace();
		}
		finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }
		    session.flush();  
		    session.close();   
		}
		return flag;

		
	}

}
