package com.iisi.copilet.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository; // Import the necessary package

import org.springframework.stereotype.Repository;

import com.iisi.copilet.demo.entity.Account;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByName(String name);
}
