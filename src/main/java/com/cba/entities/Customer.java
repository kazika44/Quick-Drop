package com.cba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer extends AbstractUser {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int customerId;
    private String username;
    private String password;
    private String address;
    private Long mobileNumber;
    private String email;
    private boolean isEnabled;


    @OneToMany(mappedBy = "customer")
    private List<TripBooking> tripbooking;


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", isEnabled=" + isEnabled +
                ", tripbooking=" + tripbooking +
                '}';
    }
}
