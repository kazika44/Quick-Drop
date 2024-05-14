package com.cba.repository;

import com.cba.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConfirmationTokenRepository extends JpaRepository<ConfirmationToken,String> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
