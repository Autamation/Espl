package com.prakat.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prakat.dao.EQualityLabsDAO;
import com.prakat.model.EQualityLabsVo;
import com.prakat.model.UserDetailsVo;
import com.prakat.util.AES256EncryptionDecryption;

@SessionAttributes({ "userId", "email", "userName", "user", "loggedInUserType" })

@Repository
public class EQualityLabsDAOImpl implements EQualityLabsDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	static Logger log = Logger.getLogger(EQualityLabsDAOImpl.class.getName());

	@Override
	public int getRegisteredUserId(UserDetailsVo userDetailsVO) {
		

		log.info("Executing EQualityLabsDAOImpl.getRegisteredUserId()...");
		int userId=0;;
		try {
			Query hql = em.createQuery("from UserDetailsVo where email = '"+userDetailsVO.getEmail()+"'");
			List <UserDetailsVo> resultSetList = hql.getResultList();
			if(resultSetList.size() > 0) {
			
			for(UserDetailsVo obj : resultSetList) {
				userId = obj.getUserId();
			}
			}
			
			else {
				log.error("Unable to fetch user id.");
			}
		}
		catch(Exception e) {
			log.error("Unable to fetch user id.");
			e.printStackTrace();
		}
		return userId;

	}

	
	public int getUserIdFromRegisteredEmail(String email) {
		

		log.info("Executing EQualityLabsDAOImpl.getRegisteredUserId()...");
		int userId = 0;
		try {
			Query hql = em.createQuery("from UserDetailsVo where email = '"+email+"'");
			List <UserDetailsVo> resultSetList = hql.getResultList();
			if(resultSetList.size() > 0) {
			
			for(UserDetailsVo obj : resultSetList) {
				userId = obj.getUserId();
			}
			}
			
			else {
				log.error("Unable to fetch user id.");
			}
		}
		catch(Exception e) {
			log.error("Unable to fetch user id.");
			e.printStackTrace();
		}
		return userId;

	}
	
	@Override
	public boolean saveRegisteredUserDetails(UserDetailsVo userDetailsVO) {
		
		log.info("Executing EQualityLabsDAOImpl.saveRegisteredUserDetails()...");
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
			session.save(userDetailsVO);
			txn.commit();
		    
			//em.persist(userDetailsVO);
			flag = true;
			log.info("Registered user details successfully.");
		}
		catch(Exception e) {
			log.error("Unable to register user details.");
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

	@Override
	public UserDetailsVo checkLoggedInUserId(UserDetailsVo userDetailsVO) {
		
		log.info("Executing EQualityLabsDAOImpl.checkLoggedInUserId()...");
		String userId = "";
		try {
			String pwd = userDetailsVO.getPassword().trim();
			if(pwd != null && pwd.length() > 0) {
				Query hql = em.createQuery("from UserDetailsVo where email = '"+userDetailsVO.getEmail()+"'");
				List resultSetList = hql.getResultList();
				for(Object obj : resultSetList) {
					userDetailsVO = (UserDetailsVo) obj;
				}
				if(resultSetList.size() > 0 && AES256EncryptionDecryption.decrypt(userDetailsVO.getPassword().trim()).equals(pwd)) {
					userId = userDetailsVO.getUserId().toString();
					String firstName = userDetailsVO.getFirstName();
					String lastName = userDetailsVO.getLastName();
					userDetailsVO.setFirstName(firstName);
					userDetailsVO.setLastName(lastName);
					log.info("Fetched user id successfully.");
				}
				else {
					log.debug("Unable to fetch user id as password is incorrect.");
					userDetailsVO.setUserId(null);
				}
			}
			else {
				log.debug("Unable to fetch user id as password is empty.");
			}
		}
		catch(Exception e) {
			log.error("Unable to fetch user id.");
			e.printStackTrace();
		}
		return userDetailsVO;

	}
	
	@Override
	public boolean savepersonalInfoDetails(UserDetailsVo userDetailsVO) {

		
		log.info("Executing EQualityLabsDAOImpl.savepersonalInfoDetails()...");
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
			session.merge(userDetailsVO);
			txn.commit();
		    
			//em.persist(userDetailsVO);
			flag = true;
			log.info("Saved personal Info details successfully.");
		}
		catch(Exception e) {
			log.error(" Unable to Save personal Info details successfully.");
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

	@Override
	public UserDetailsVo fetchRegisteredUserDetails(String email) {

		log.info("Executing EQualityLabsDAOImpl.fetchRegisteredUserDetails()...");
		UserDetailsVo userDetailsVO = null;
		
		int userId = getUserIdFromRegisteredEmail(email) ;
		/*try {
			//Query q = session.createQuery("select new User (u.id, u.name, u.object) from User u").list();
			Query q = session.createQuery("select new User UserDetailsVo(u.email,u.id ) from  UserDetailsVo u").list();

			//Query hql = em.createQuery("from UserDetailsVo where email = "+email);
			List resultSetList = hql.getResultList();
			if(resultSetList.size() > 0) {
				userDetailsVO = (UserDetailsVo) resultSetList.get(0);
				log.info("Fetched user details successfully.");
			}
			else {
				log.debug("Unable to fetch user details.");
			}
		}
		catch(Exception e) {
			log.error("Unable to fetch user details.");
			e.printStackTrace();
		}
		return userDetailsVO;
		*/
		
		
		
		
		
		
		log.info("Executing EQualityLabsDAOImpl.upateUserDetails()...");
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
			userDetailsVO = (UserDetailsVo)session.get(UserDetailsVo.class, userId);
			txn.commit();
			
			//em.merge(userDetailsVO);
			flag = true;
			log.info("fetched registered user details successfully.");
		}
		catch(Exception e) {
			log.error("Unable to registered user  details.");
			e.printStackTrace();
		}
		return userDetailsVO;

	}


	@Override
	public boolean upateUserDetails(UserDetailsVo userDetailsVO) {
		
		log.info("Executing EQualityLabsDAOImpl.upateUserDetails()...");
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
			session.merge(userDetailsVO);
			txn.commit();
			
			//em.merge(userDetailsVO);
			flag = true;
			log.info("Updated user details successfully.");
		}
		catch(Exception e) {
			log.error("Unable to update user details.");
			e.printStackTrace();
		}
		return flag;

	}

	
	@Override
	public boolean userMasterRegistrationUpdatePassword(UserDetailsVo UserDetailsVO) throws Exception {

		log.info("Executing EQualityLabsDAOImpl.saveRegisteredUserDetails()...");
		Configuration configuration = new Configuration();
		configuration.configure();
		boolean passwordUpdated = false;

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()). buildServiceRegistry();
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = null;
		Transaction txn = null;
		boolean flag = false;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.update(UserDetailsVO);
			txn.commit();
		    
			//em.persist(userDetailsVO);
			/*flag = true;
			boolean*/ 
			passwordUpdated = true;

			log.info("Registered user details successfully.");
		}
		catch(Exception e) {
			log.error("Unable to register user details.");
			e.printStackTrace();
		}
		finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }
		    session.flush();  
		    session.close();   
		}
		return passwordUpdated;
		
		
		
		
		
		
		/*log.info("Processing UserDetailsVo.UserMasterRegistrationUpdatePassword()...");
		boolean passwordUpdated = false;

		try {
			Query query = em.createQuery("UPDATE UserDetailsVo SET  password = :newPassword  WHERE  email = :email");
			query.setParameter("email", UserDetailsVO.getEmail());
			query.setParameter("newPassword", UserDetailsVO.getPassword());
			int numberOfRecordsUpdated = query.executeUpdate();
			if (numberOfRecordsUpdated > 0) {
				passwordUpdated = true;
			}

			log.info("Updated user password successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to update user password.");
			throw e;
		}
		return passwordUpdated;
	
*/
	}
	
	@Override
	public boolean userMasterChanagePassword(UserDetailsVo UserDetailsVO) throws Exception {

		log.info("Executing EQualityLabsDAOImpl.saveRegisteredUserDetails()...");
		Configuration configuration = new Configuration();
		configuration.configure();
		boolean passwordUpdated = false;

		/*ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()). buildServiceRegistry();*/
		//SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = null;
		Transaction txn = null;
		boolean flag = false;
		
		try {
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		//	session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.merge(UserDetailsVO);
			txn.commit();
		    
			//em.persist(userDetailsVO);
			/*flag = true;
			boolean*/ 
			passwordUpdated = true;

			log.info("Registered user details successfully.");
		}
		catch(Exception e) {
			log.error("Unable to register user details.");
			e.printStackTrace();
		}
		finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }
		    session.flush();  
		    session.close();  
		}
		return passwordUpdated;
		
		
		
		
		
		
		/*log.info("Processing UserDetailsVo.UserMasterRegistrationUpdatePassword()...");
		boolean passwordUpdated = false;

		try {
			Query query = em.createQuery("UPDATE UserDetailsVo SET  password = :newPassword  WHERE  email = :email");
			query.setParameter("email", UserDetailsVO.getEmail());
			query.setParameter("newPassword", UserDetailsVO.getPassword());
			int numberOfRecordsUpdated = query.executeUpdate();
			if (numberOfRecordsUpdated > 0) {
				passwordUpdated = true;
			}

			log.info("Updated user password successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to update user password.");
			throw e;
		}
		return passwordUpdated;
	
*/
	}
	
	@Override
	public void save(List<EQualityLabsVo> equalityLabs) {
		
	}


	@Override
	public boolean userExists(String email) throws Exception {
		// TODO Auto-generated method stub
		log.info("Executing EQualityLabsDAOImpld().UserExists"); 
		boolean userExists = false;
		try {
				Query hql = em.createQuery("from UserDetailsVo where email = '"+email+"'");
				List <UserDetailsVo> resultSetList = hql.getResultList();
				if(resultSetList.size() > 0) {
			
							return true;
			    }
			
			}
		
		finally {
			
					}
		return userExists;

				}
		}
