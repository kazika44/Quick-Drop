package com.cba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver extends AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;
    private String licenceNo;
    private float rating;
    private String username;
    private String password;
    private String address;
    private Long mobileNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cabId")
    private Cab cab;
    @OneToMany(mappedBy = "driver")
    private List<TripBooking> tripbooking1;

    @Override
    public String toString() {
        return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + ", username="
                + username + ", password=" + password + ", address=" + address + ", mobileNumber=" + mobileNumber
                + ", email=" + email + ", cab=" + cab + ", tripbooking=" + tripbooking1 + "]";
    }


    @Override
    public void setCustomerId(int customerId) {
        // TODO Auto-generated method stub

    }


}
