package com.airline.airline.airlinereseservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "passenger_id")
    private Long id;
    private String firstName;
    private String lastName;
    private Date bod;
    private String contactNumber;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private List<Booking> booking;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, Date bod, String contactNumber, String email, String username, String password, List<Booking> booking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bod = bod;
        this.contactNumber = contactNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.booking = booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bod=" + bod +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
