package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.entity.BankUser;
import com.web.entity.bankAccount;
import com.web.repo.bankAccountRepo;
import com.web.repo.userRepo;

@Controller
public class FrontController {
	@Autowired
	userRepo ur;
	@Autowired
	bankAccountRepo Br;
	public String LoggedUserName=null;
	@RequestMapping("/login")
	public String home() {
		return "home";
	}

	@RequestMapping("/Signup")
	public String Signup() {
		return "Signup";
	}

	@RequestMapping("/signupUser")
	public String signupUser(@ModelAttribute BankUser bu) {
	
		BankUser bankUser = ur.findByEmail(bu.getEmail());
		if (bankUser != null) {
			return "Error";
		} else {
			
			bankAccount ba= new bankAccount(0,0);
			Br.save(ba);
			bu.setBankaccount(ba);
			
			ur.save(bu);
			
			return "success";

		}

	}

	@RequestMapping("/loginUser")
	public String loginUser(@ModelAttribute BankUser bu) {
		
		BankUser bankUser = ur.findByNameAndPincode(bu.getName(), bu.getPincode());
		if (bankUser != null) {
			LoggedUserName=bu.getName();
			System.out.println(LoggedUserName);
			return "dashboard";
		} else {
			return "Notuser";

		}

	}
	
	@RequestMapping("/changePin")
	public String changePin()
	{
		
		return"changePin";
	}
	@RequestMapping("/saveNewPincode")
	@ResponseBody
	public String saveNewPincode(@RequestParam("newPincode" )int newPincode)
	{
		
		BankUser bankUser = ur.findByName(LoggedUserName);
		bankUser.setPincode(newPincode);
		ur.save(bankUser);
		return"Pincode changed Successfully";
	}
	
	
	@RequestMapping("/deposite")
	public String deposite()
	{
		
		return"deposite";
	}
	@RequestMapping("/addMoney")
	@ResponseBody
	public String addMoney(@RequestParam("amount") int addedValue)
	{
		
		  BankUser bankUser = ur.findByName(LoggedUserName);
		  bankAccount ba=bankUser.getBankaccount();
		  ba.setAccountBalance(ba.getAccountBalance()+addedValue);
		  ur.save(bankUser);
		  return"Money added successfully";
	}
	@RequestMapping("/withdraw")
	public String withdraw()
	{
		
		return"withdraw";
	}
	@RequestMapping("/withdrawMoney")
	@ResponseBody
	public String withdrawMoney(@RequestParam("amount") int addedValue)
	{
		
		  BankUser bankUser = ur.findByName(LoggedUserName);
		  bankAccount ba=bankUser.getBankaccount();
		  ba.setAccountBalance(ba.getAccountBalance()-addedValue);
		  ur.save(bankUser);

		  return"Money withdrawed successfully";
	}
	

	
	@RequestMapping("/Logout")
	@ResponseBody
	public String Logout()
	{
		LoggedUserName=null;
		System.out.println(LoggedUserName);
		return"logged out";
	}
	
	
	
	
	
}
