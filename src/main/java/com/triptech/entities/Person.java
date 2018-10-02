package com.triptech.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.time.LocalDate;

//pojo-bol entity az annotaciok altal
@Entity
@Inheritance
public class Person {
    @Id
    @GeneratedValue
    private Long id; //lehet null
    private String lastName;
    private String firstName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private String idNumber;
    private String idType;
    private String addressCountry;
    private String addressCity;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressFree() {
        return addressFree;
    }

    public void setAddressFree(String addressFree) {
        this.addressFree = addressFree;
    }

    private String addressFree;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}
