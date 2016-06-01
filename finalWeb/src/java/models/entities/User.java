/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import models.DAOs.UserDAO;

/**
 *
 * @author Alisson
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int id;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name="name")
    private String nome;
    
    @Column(name = "LOGIN", unique = true)
    private String login;

    public User() {
    }

    public void add() {
        if (!(UserDAO.read(this.getLogin()) == null)) {
            UserDAO.update(this);
        } else {
            UserDAO.create(this);
        }
    }

    public void update() {
        UserDAO.update(this);
    }

    public void delete() {
        UserDAO.delete(this);
    }

    public static List<User> getAll(String type, String param) {
        return UserDAO.readAll(type, param);
    }

    public static List<User> getAll() {
        return UserDAO.readAll();
    }

    public User auth() {
        User user = UserDAO.read(this.getLogin());
        if ( user!=null && user.getPassword().equals(this.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
    
    public User getUser(){
       User user = UserDAO.read(this.getLogin());
        if ( user!=null) {
            return user;
        } else {
            return null;
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
