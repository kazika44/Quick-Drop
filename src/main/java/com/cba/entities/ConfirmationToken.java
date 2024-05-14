package com.cba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Token")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tokenId;
    @Column(name = "confirmation_Token", updatable = false, nullable = false)
    private String confirmationToken;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public ConfirmationToken(Customer customer) {
        this.customer=customer;
    }
}
