package com.javatpoint.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.javatpoint.bean.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDaoTestCase {

	@Test
	void getRecordByIdTest() {
		
		User actual = UserDao.getRecordById(42);
		User expected = new User();
		assertNotNull(actual);
		assertEquals(expected.getClass(), actual.getClass());
		//equals(expected.getClass());
		actual.getClass().equals(expected.getClass());
		//fail("Not yet implemented");
	}
	
	@Test
	void getAllRecordsTest()
	{
		List<User> actual = UserDao.getAllRecords();
		//List<User> expected = new ArrayList<User>();
		String username = "Person2";
		
		actual.stream().anyMatch(user -> username.equals(user.getName()));
		
		User user42 = actual.stream()
			    .filter(user -> username.equals(user.getName()))
			    .findFirst()
			    .orElse(null);
			System.out.println("User: " + user42);
		
		assertTrue(actual.stream().anyMatch(user -> username.equals(user.getName())));
			
		//Boolean UserExists = actual.stream().anyMatch(user -> id.equals(user.getId()));
		//actual.contains(UserDao.getRecordById(1));
		//assertTrue(actual.contains(UserDao.getRecordById(42)));
		//actual.stream().anyMatch(o -> o.equals(UserDao.getRecordById(1)));
		//actual.stream().anyMatch(o -> o.equals(UserDao.getRecordById(1)));
				
	}
	
	
	@Test
	void deleteTest() {
		User user= new User();
		user.setId(10);
			
		int actual = UserDao.delete(user);
		int expected = 0;
		
		assertNotEquals(expected, actual);
		
		//fail("Not yet implemented");
	}
	

	@Test
	void updateTest() {
		
		User user= new User();
		user.setId(2);
		user.setName("Updated From Test Case");
		user.setPassword("UpdateTestCase");
		user.setEmail("updatetestcase@test.com");	
		
		int actual = UserDao.update(user);
		int expected = 0;
		
		assertNotEquals(expected, actual);
		
		//fail("Not yet implemented");
	}
	

	@Test
	void saveTest() {
		
		User user= new User();
		user.setName("New Test Case User");
		user.setEmail("testuser2@test.com");
		user.setPassword("NewTestUser");
			
		int actual = UserDao.save(user);
		int expected = 0;
		
		assertNotEquals(expected, actual);
		
		//fail("Not yet implemented");
	}

}
