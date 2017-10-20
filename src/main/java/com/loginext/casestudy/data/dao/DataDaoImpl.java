package com.loginext.casestudy.data.dao;

import com.loginext.casestudy.data.entity.CabAssignment;
import com.loginext.casestudy.data.entity.CabOrder;
import com.loginext.casestudy.data.entity.Driver;
import com.loginext.casestudy.request_response.ShowAllDriversResponse;
import com.sun.org.apache.bcel.internal.generic.CASTORE;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataDaoImpl implements DataDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Driver> getAvailableDrivers() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Driver.class);
        criteria.add(Restrictions.eq("status","AVAILABLE"));
        List drivers = criteria.list();
        return (List<Driver>)drivers;
    }

    @Override
    public List<Driver> getAllDrivers() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Driver.class);
        List drivers = criteria.list();
        return (List<Driver>)drivers;
    }

    @Override
    public void saveCabOrder(CabOrder cabOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(cabOrder);
    }

    @Override
    public void saveCabAssignment(CabAssignment cabAssignment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(cabAssignment);
    }

    @Override
    public void updateDriverStatus(Driver driverAssigned) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(driverAssigned);
    }
}
