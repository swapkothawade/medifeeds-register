package com.medifeeds.register.repo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.medifeeds.register.domain.Login;
import com.medifeeds.register.domain.User;
import com.medifeeds.register.exceptions.MedifeedsException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepo;
	
	@Before
	public void setup(){
		User user = new User(1l,"Swapnil","kothawade","swapnil.kothawade@gmail.com","Swara_2013","HSC");
		userRepo.save(user);
		
	}
	@Test
	public void findAll(){
		List<User> users = userRepo.findAll();
		assertEquals(1, users.size());
	}
	@Test(expected=MedifeedsException.class)
	public void testEmailValidation (){
		User user = new User(2l,"Swapnil","kothawade","swapnil.kothawade@gmail.com","Swara_2013","HSC");
		userRepo.save(user);
		
	}
	@Test
	public void testLoginSucess(){
		Login login = new Login("swapnil.kothawade@gmail.com","Swara_2013");
		User user = userRepo.findByUseremail(login.getUseremail());
		assertEquals("Login Successfull",login.getPassword(),user.getPassword());
	}
	@Test
	public void testLoginFailureWrongPassword(){
		Login login = new Login("swapnil.kothawade@gmail.com","Swara_201311");
		User user = userRepo.findByUseremail(login.getUseremail());
		assertEquals("Login Failure, Incorrect Password",login.getPassword(),user.getPassword());
	}
	@Test
	public void testUserNotFound(){
		Login login = new Login("swapnil.kothawade1@gmail.com","Swara_2013");
		User user = userRepo.findByUseremail(login.getUseremail());
		assertEquals("User Not Found",user,null);
	}
	@After
	public void testDeleteAll (){
		userRepo.deleteAll();
		
	}
	
}
