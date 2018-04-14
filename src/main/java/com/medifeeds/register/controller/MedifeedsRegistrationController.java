package com.medifeeds.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medifeeds.register.domain.Login;
import com.medifeeds.register.domain.User;
import com.medifeeds.register.exceptions.MedifeedsException;
import com.medifeeds.register.repo.UserRepository;

@RestController
@RequestMapping("/medifeeds")
public class MedifeedsRegistrationController {
	
	@Autowired
	UserRepository userRepo;
	@RequestMapping(value="/sign-up",method=RequestMethod.POST)
	public boolean register(@RequestBody User user){
		User existingUser = userRepo.findByUseremail(user.getUseremail());
		if(existingUser !=null){
			throw new MedifeedsException(user.getUseremail() +" is Already Registered, Please use different email id");
		}
		userRepo.save(user);
		
		return true;
	}
	
	@GetMapping("/hello")
	public String sayHello(){
		return "Hello Medifeeds User";
	}
	
	@GetMapping("/users")
	public List<User> users(){
		return userRepo.findAll();
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Login user){
		boolean isUserValid = false;
		User tempUser = userRepo.findByUseremail(user.getUseremail());
		if(user.getPassword().equals(tempUser.getPassword()))
			return true;
		return isUserValid;
	}
	@PostMapping("/resetpassword")
	public boolean resetpassword(@RequestBody Login user){
		User tempUser = userRepo.findByUseremail(user.getUseremail());
		tempUser.setPassword(user.getPassword());
		userRepo.save(tempUser);
		return true;
		
	}
	
	
}
