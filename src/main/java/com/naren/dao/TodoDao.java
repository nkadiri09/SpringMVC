package com.naren.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naren.model.Todo;

@Service
public class TodoDao implements Serializable {

	@Autowired
	private SessionFactory sessionFactory;

	Todo todo = new Todo();

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		try {
			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			todo.setId(1);
			todo.setUser(name);
			todo.setDesc(desc);
			todo.setTargetDate(targetDate);
			todo.setDone(isDone);
			session.save(todo);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public List<Todo> retrieveTodos(String user) {
		System.out.println(getSessionFactory().openSession());
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select * from Todo";
		Query query = (Query) session.createQuery(hql);
		List<Todo> todos = (List<Todo>) query.getResultList();

		return todos;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
