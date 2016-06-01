/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAOs;

import java.util.ArrayList;
import java.util.List;
import models.entities.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import static utils.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class EmployeeDAO {


    public static Employee read(String cpf) {
        Session session = getSessionFactory().openSession();
        Employee employee = new Employee();
        employee.setCpf(cpf);
        Query query = session.createQuery("from Employee where cpf = :cpf");
        query.setParameter("cpf", employee.getCpf());
        employee = (Employee) query.uniqueResult();
        session.close();
        return employee;
    }
    
    public static void update(Employee employee){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void create(Employee employee) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Employee> readAll(){
        Session session = getSessionFactory().openSession();
        List<Employee> list = session.createCriteria(Employee.class).list();
        session.close();
        return list;
    }
    
    public static List<Employee> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Employee where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<Employee> list = query.list();
        session.close();
        return list;
    }
    
    public static void delete(Employee employee){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }
}
