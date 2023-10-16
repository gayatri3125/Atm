package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.BankUser;

public interface userRepo extends JpaRepository<BankUser, Integer> {
	BankUser findByEmail(String email);
	BankUser findByNameAndPincode(String name, int pincode);
	BankUser findByName(String name);
	
	

}
