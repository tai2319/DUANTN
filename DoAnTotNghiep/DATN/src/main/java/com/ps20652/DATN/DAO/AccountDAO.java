package com.ps20652.DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ps20652.DATN.entity.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
  List  <Account> findByUsername(String username);
    List<Account> findByRole(String role);
    Account findByEmail(String email);
    Account getAccountByUsername(String username);

        Account findByUsernameAndPassword(String username, String password);
    
}
