/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jkss.jpademo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Joakim
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_id;
    private String street;
    private int zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private Person person;

    public Address() {
    }

    public Address(String street, int zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
    
    public Long getId() {
        return a_id;
    }
    public void setId(Long id) {
        this.a_id = id;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
