
package com.jvwl.daoimpl.hibernate;

import org.hibernate.Session;

import com.jvwl.model.Admin;
import com.jvwl.util.HibernateUtil;
import com.jvwl.dao.AdminDao;

public class AdminDaoImpl implements AdminDao {

	public boolean login(Admin admin) {
    	Session session=null;
    	boolean login = false;
    	try {
			session = HibernateUtil.getSession();
    		session.beginTransaction();
    		Object object = session.createQuery("from Admin where username='"+admin.getUsername()+"' and password='"+admin.getPassword()+"'")
    								.uniqueResult();
			if(object!=null){
				login = true;
			}
			session.getTransaction().commit();
			return login;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return login;
		}
    }

    public boolean updatePassword(Admin admin) {
        return true;
    }

}
