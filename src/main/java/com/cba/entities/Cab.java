package com.cba.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cab")
public class Cab extends AuditModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1736893392612608637L;
    @Id
    @GeneratedValue
    private int cabId;
    private String carType;
    private float perKmRate;

    @OneToOne(mappedBy = "cab")
    private Driver driver;


    @Override
    public String toString() {
        return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
    }

}
