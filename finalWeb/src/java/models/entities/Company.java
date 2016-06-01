/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import models.DAOs.CompanyDAO;

/**
 *
 *
 * @author Alisson
 */
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    private int id;
    private String name;      
    private String cnpj;
    private String razaoSocial;
    private String endereco;
    private String email;
    private List<Integer> employees;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Integer> employees) {
        this.employees = employees;
    }
    
    public Company() {
    }

    public void add() {
        CompanyDAO.create(this);
    }

    public void update() {
        CompanyDAO.update(this);
    }

    public void delete() {
        CompanyDAO.delete(this);
    }

    public static List<Company> getAll(String type, String param) {
        return CompanyDAO.readAll(type, param);
    }

    public static List<Company> getAll() {
        return CompanyDAO.readAll();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}