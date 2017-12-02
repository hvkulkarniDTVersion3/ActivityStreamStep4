package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.UserCircle;

/*
* This class is implementing the UserCircleDAO interface. This class has to be annotated with 
* @Repository annotation.
* @Repository - is an annotation that marks the specific class as a Data Access Object, 
* thus clarifying it's role.
* @Transactional - The transactional annotation itself defines the scope of a single database 
* 					transaction. The database transaction happens inside the scope of a persistence 
* 					context.  
* */
@Repository("userCircleDAO")
@Transactional
public class UserCircleDAOImpl implements UserCircleDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserDAO userDAO;
	@Autowired
	CircleDAO circleDAO;

	/*
	 * Add a user to a circle
	 */
	public boolean addUser(String username, String circleName) {
		if (circleDAO.get(circleName) != null && userDAO.get(username) != null) {
			System.out.println("tested circlename and username");
			if (get(username, circleName) == null) {
				Session session = null;
				session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(new UserCircle(username, circleName));
				session.getTransaction().commit();
				session.close();
				return true;
			} else
				return false;
		} else
			return false;
	}

	/*
	 * Remove a user from a circle
	 */
	public boolean removeUser(String username, String circleName) {
		UserCircle userCircle = get(username, circleName);
		if (userCircle != null) {
			Session session = null;
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(userCircle);
			session.getTransaction().commit();
			session.close();
			return true;
		} else
			return false;
	}

	/*
	 * Retrieve unique UserCircle object which contains a specific username and
	 * circleName
	 */
	public UserCircle get(String username, String circleName) {
		Session session = null;
		session = sessionFactory.openSession();
		Query<UserCircle> query = session
				.createQuery("from UserCircle where userName = :username and circleName = :circleName");
		query.setString("username", username);
		query.setString("circleName", circleName);
		List userCircles = query.list();
		session.close();
		UserCircle userCircle = null;
		if (userCircles.size() > 0)
			userCircle = (UserCircle) userCircles.get(0);
		return userCircle;
	}

	/*
	 * Retrieve all subscribed circles by a user
	 */
	@SuppressWarnings("unchecked")
	public List<String> getMyCircles(String username) {
		Session session = null;
		session = sessionFactory.openSession();
		Query<Circle> query = session.createQuery("select circleName from UserCircle where userName = :username");
		query.setString("username", username);
		List userCircles = query.list();
		session.close();
		return userCircles;
	}
}