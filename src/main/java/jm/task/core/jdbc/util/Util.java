package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static SessionFactory sessionFactory;


    static {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdownHibernate() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("Сессия Hibernate закрыта.");
        }
    }


}
