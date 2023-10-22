package com.ps20652.DATN.service;

import com.ps20652.DATN.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
	// Khai báo phương thức lấy tài khoản theo tên người dùng
	 Account findUserByUsername(String username);
    Account getAccountByUsername(String username);
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(int userId);
    void saveAccount(Account account);
    void deleteAccount(int userId);
    Account findByUsername(String username);
    List<Account> findByRole(String role);
    // Thêm phương thức để đổi mật khẩu
    boolean changePassword(int userId, String newPassword);
    
    // Thêm phương thức để sửa thông tin cá nhân
    Account updateAccountInfo(int userId, Account updatedAccount);
	public void sendOTP(String userEmail);
	
	Account findByEmail(String email);
	
	
	public boolean verifyOTP(String email, String otp);
	
	public boolean resetPassword(String email, String newPassword);
	public List<Account> findAll();

	public Account create(Account acc);
	
	public Account findbyId(Integer id);
	
	public Account findbyIdAcc(Account account);
	
	public void delete(Account account);
	
	Account update(Account account);

	List<Account> findByUsernamee(String username);
	
}