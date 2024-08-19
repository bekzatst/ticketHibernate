package org.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
