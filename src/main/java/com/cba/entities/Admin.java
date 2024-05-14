package com.cba.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue
    private int adminId;
    private String username;
    private String password;
    private String address;
    private Long mobileNumber;
    private String email;

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", address="
                + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
    }


}
