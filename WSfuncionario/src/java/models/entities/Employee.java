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
import javax.xml.bind.annotation.XmlRootElement;
import models.DAOs.EmployeeDAO;

/**
 *
 * @author Alisson
 */
@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee {

    @Id
    @GeneratedValue
    private int id;


    public Employee() {
    }

    public void add() {
        if (!(EmployeeDAO.read(this.getCpf()) == null)) {
            EmployeeDAO.update(this);
        } else {
            EmployeeDAO.create(this);
        }
    }
    
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    private String celular;
    private Integer companyId;

    public void update() {
        EmployeeDAO.update(this);
    }

    public void delete() {
        EmployeeDAO.delete(this);
    }

    public static List<Employee> getAll(String type, String param) {
        return EmployeeDAO.readAll(type, param);
    }

    public static List<Employee> getAll() {
        return EmployeeDAO.readAll();
    }
    
    public Employee getEmployee(){
       Employee employee = EmployeeDAO.read(this.getCpf());
        if ( employee!=null) {
            return employee;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    
}
