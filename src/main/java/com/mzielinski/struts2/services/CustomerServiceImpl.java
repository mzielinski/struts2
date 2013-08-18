package com.mzielinski.struts2.services;

import com.mzielinski.struts2.model.Customer;
import com.mzielinski.struts2.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * @author mzielinski, Rule Financial
 */
public class CustomerServiceImpl extends HibernateUtil implements CustomerService {

    @Override
    public Customer add(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public Customer delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, id);
        if (null != customer) {
            session.delete(customer);
        }
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public Customer show(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, id);
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public List<Customer> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Customer> customers = null;
        try {
            customers = (List<Customer>) session.createQuery("from Customer").list();
        } catch (HibernateException e) {
            System.err.println(e);
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return customers;
    }

}
