package com.cba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TripBooking")
public class TripBooking {

    @Id
    @GeneratedValue
    private int tripBookingId;

    private int customerId;

    private int driverId;

    private String fromLocation;

    private String toLocation;

    private LocalDateTime fromLocalDateTime;

    private LocalDateTime toLocalDateTime;
    private boolean status;

    private float distanceInKm;

    private float bill;


    @ManyToOne
    @JoinColumn(name = "Driver")
    private Driver driver;


    @ManyToOne
    @JoinColumn(name = "Customer")
    private Customer customer;

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TripBooking [tripBookingId=" + tripBookingId + ", customerId=" + customerId + ", driverId=" + driverId
                + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromLocalDateTime="
                + fromLocalDateTime + ", toLocalDateTime=" + toLocalDateTime + ", status=" + status + ", distanceInKm="
                + distanceInKm + ", bill=" + bill + "]";
    }

}
