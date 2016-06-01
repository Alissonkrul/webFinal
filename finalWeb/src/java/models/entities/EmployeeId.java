/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Alisson
 */
@Entity
public class EmployeeId {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer EmlpoyeeId;
}
