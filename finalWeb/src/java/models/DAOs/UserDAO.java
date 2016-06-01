/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class UserDAO {


    public static User read(String login) {
        Session session = getSessionFactory().openSession();
        User user = new User();
        user.setLogin(login);
        Query query = session.createQuery("from User where login = :login");
        query.setParameter("login", user.getLogin());
        user = (User) query.uniqueResult();
        session.close();
        return user;
    }
    
    public static void update(User user){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void create(User user) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<User> readAll(){
        Session session = getSessionFactory().openSession();
        List<User> list = session.createCriteria(User.class).list();
        session.close();
        return list;
    }
    
    public static List<User> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from User where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<User> list = query.list();
        session.close();
        return list;
    }
    
    public static void delete(User user){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
