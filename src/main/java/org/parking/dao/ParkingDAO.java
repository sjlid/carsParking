package org.parking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.parking.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class ParkingDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ParkingDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void carArrive(Car car) {

    }

    @Transactional
    public void carDepart(Car car) {

    }

    @Transactional(readOnly = true)
    public List<Car> carsOnParking() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Parking p", Car.class).getResultList();
    }
}
