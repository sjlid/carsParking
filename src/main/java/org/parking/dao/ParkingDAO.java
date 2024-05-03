package org.parking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.parking.models.Car;
import org.parking.models.Nameplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Transactional
    public void carDepart(Nameplate nameplate) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Car.class, nameplate));
    }

    @Transactional(readOnly = true)
    public List<Car> carsOnParking() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Car p", Car.class).getResultList();
    }
}
