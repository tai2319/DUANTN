package com.ps20652.DATN.service.impl;

import com.ps20652.DATN.DAO.AccountDAO;
import com.ps20652.DATN.entity.Account;
import com.ps20652.DATN.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
	@Autowired
	private JavaMailSender javaMailSender;

    @Override
    @Transactional
    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<Account> getAccountById(int userId) {
        return accountDAO.findById(userId);
    }

    @Override
    @Transactional
    public void saveAccount(Account account) {
        accountDAO.save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(int userId) {
        accountDAO.deleteById(userId);
    }

    @Override
    @Transactional
    public Account findByUsername(String username) {
        return (Account) accountDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public List<Account> findByRole(String role) {
        return accountDAO.findByRole(role);
    }
    @Override
    public boolean changePassword(int userId, String newPassword) {
        Optional<Account> optionalAccount = accountDAO.findById(userId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setPassword(newPassword);
            accountDAO.save(account);
            return true;
        }
        return false;
    }

    @Override
    public Account updateAccountInfo(int userId, Account updatedAccount) {
        Optional<Account> optionalAccount = accountDAO.findById(userId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setAddress(updatedAccount.getAddress());
            account.setFullName(updatedAccount.getFullName());
            account.setEmail(updatedAccount.getEmail());
            // Các thông tin cá nhân khác cũng có thể được cập nhật tại đây
            accountDAO.save(account);
            return account;
        }
        return null;
    }

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}
	@Override
	public Account create(Account account) {

		return accountDAO.save(account);
	}

	@Override
	public Account findbyId(Integer id) {
		
		return accountDAO.findById(id).get();
	}

	@Override
	public void delete(Account account) {
		accountDAO.delete(account);
		
	}

	@Override
	public List<Account> findByUsernamee(String username) {
		return accountDAO.findByUsername(username);
	}

	@Override
	public Account update(Account account) {
	
		return accountDAO.save(account);
	}

	@Override
	public void sendOTP(String userEmail) {
	    Account account = accountDAO.findByEmail(userEmail);
	    if (account == null) {
	        // Xá»­ lÃ½ trÆ°á»�ng há»£p ngÆ°á»�i dÃ¹ng khÃ´ng tá»“n táº¡i
	        // ThÃ´ng bÃ¡o lá»—i hoáº·c thá»±c hiá»‡n xá»­ lÃ½ tÃ¹y thuá»™c vÃ o yÃªu cáº§u cá»§a báº¡n
	        return;
	    }

	    // Táº¡o mÃ£ OTP
	    String otp = generateOTP();

	    // LÆ°u mÃ£ OTP vÃ  thá»�i gian táº¡o vÃ o cÆ¡ sá»Ÿ dá»¯ liá»‡u
	    account.setOtp(otp);
	    account.setOtpCreatedAt(LocalDateTime.now()); // LÆ°u thá»�i gian táº¡o mÃ£ OTP
	    accountDAO.save(account);

	    // Gá»­i email chá»©a mÃ£ OTP
	    sendOTPtoMail(userEmail, otp);
	}
	 private void sendOTPtoMail(String userEmail, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(userEmail);
	        message.setSubject("DATN MÃ£ OTP");
	        message.setText("MÃ£ OTP cá»§a báº¡n lÃ : " + otp);

	        javaMailSender.send(message);
	    }

	 public String generateOTP() {
		    // Táº¡o UUID ngáº«u nhiÃªn
		    UUID uuid = UUID.randomUUID();
		    
		    // Láº¥y giÃ¡ trá»‹ tháº­p phÃ¢n cá»§a UUID (loáº¡i bá»� dáº¥u gáº¡ch ná»‘i vÃ  kÃ½ tá»±)
		    String uuidStr = uuid.toString().replaceAll("-", "").replaceAll("[a-zA-Z]", "");
		    
		    // Láº¥y 6 kÃ½ tá»± Ä‘áº§u tiÃªn cá»§a UUID
		    String otp = uuidStr.substring(0, 6);
		    
		    return otp;
		}

	@Override
	public Account findByEmail(String email) {
		return accountDAO.findByEmail(email);
	}
	@Override
	public boolean verifyOTP(String email, String otp) {
	    Account account = accountDAO.findByEmail(email);
	    
	    if (account != null) {
	        LocalDateTime otpCreatedAt = account.getOtpCreatedAt();
	        LocalDateTime currentTime = LocalDateTime.now();
	        Duration duration = Duration.between(otpCreatedAt, currentTime);
	        
	        // Kiá»ƒm tra xem Ä‘Ã£ qua 1 phÃºt chÆ°a
	        if (duration.getSeconds() <= 60) {
	            String storedOTP = account.getOtp();
	            
	            // So sÃ¡nh mÃ£ OTP ngÆ°á»�i dÃ¹ng nháº­p vá»›i mÃ£ OTP Ä‘Ã£ lÆ°u
	            if (otp.equals(storedOTP)) {
	                return true; // MÃ£ OTP há»£p lá»‡
	            }
	        }
	    }

	    return false; // MÃ£ OTP khÃ´ng há»£p lá»‡ hoáº·c háº¿t háº¡n
	}
	public String getUserOTPFromDatabase(String email) {
	    // Sá»­ dá»¥ng Spring Data JPA Ä‘á»ƒ láº¥y thÃ´ng tin ngÆ°á»�i dÃ¹ng tá»« cÆ¡ sá»Ÿ dá»¯ liá»‡u
	    Account account =accountDAO.findByEmail(email);
	    if (account != null) {
	        return account.getOtp(); // Láº¥y mÃ£ OTP tá»« Ä‘á»‘i tÆ°á»£ng User
	    } else {
	        return null; // Hoáº·c null náº¿u khÃ´ng tÃ¬m tháº¥y ngÆ°á»�i dÃ¹ng
	    }
	}
	@Override
	public boolean resetPassword(String email, String newPassword) {
	    // Thá»±c hiá»‡n viá»‡c Ä‘áº·t láº¡i máº­t kháº©u cho ngÆ°á»�i dÃ¹ng vá»›i máº­t kháº©u má»›i
	    // VÃ­ dá»¥: LÆ°u máº­t kháº©u má»›i vÃ o cÆ¡ sá»Ÿ dá»¯ liá»‡u
	    boolean passwordResetSuccessful = saveNewPassword(email, newPassword);
	    
	    return passwordResetSuccessful;
	}
	
	public boolean saveNewPassword(String email, String newPassword) {
	    Account account = accountDAO.findByEmail(email);
	    
	    if (account != null) {
	        // MÃ£ hÃ³a máº­t kháº©u má»›i (Ä‘áº£m báº£o mÃ£ hÃ³a máº­t kháº©u trÆ°á»›c khi lÆ°u vÃ o cÆ¡ sá»Ÿ dá»¯ liá»‡u)
	        String pass = newPassword;
	        
	        // Cáº­p nháº­t máº­t kháº©u má»›i cho ngÆ°á»�i dÃ¹ng
	        account.setPassword(pass);
	        
	        // LÆ°u cáº­p nháº­t vÃ o cÆ¡ sá»Ÿ dá»¯ liá»‡u
	        accountDAO.save(account);
	        
	        return true;
	    }
	    
	    return false; // Tráº£ vá»� false náº¿u khÃ´ng tÃ¬m tháº¥y ngÆ°á»�i dÃ¹ng
	}
	@Override
	public Account findbyIdAcc(Account account) {
		return accountDAO.findById(account.getUserId()).get();
	}

	@Override
	public Account  getAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return (Account) accountDAO.findByUsername(username);
	}
	   @Override
	    public Account findUserByUsername(String username) {
	        // Delegate the call to the AccountRepository to find the user by username.
	        return (Account) accountDAO.findByUsername(username);
	    }

}
