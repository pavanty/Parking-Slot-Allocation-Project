package com.example.psap.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.psap.dao.UserRepository;
import com.example.psap.entity.Users;

class UserServiceTest {

	@InjectMocks
	UserServiceimpl userServiceimpl;
	
	@Mock
	UserRepository userRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddUser() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		when(userRepository.save(users)).thenReturn(users);
		Users ur=userServiceimpl.addUser(users);
		
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
		verify(userRepository,times(1)).save(users); 
	}

	@Test
	void testLogin() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findByUsernameAndPassword("Mahee","mahee")).thenReturn(optional);
		userServiceimpl.login("Mahee","mahee");
		
		Users ur=userRepository.findByUsernameAndPassword("Mahee","mahee").get();
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
		 
		
	}

	@Test
	void testUpdateUser() {
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findById(1)).thenReturn(optional);
		when(userRepository.save(users)).thenReturn(users);
		Users ur=userServiceimpl.updateUser(1, users);
		
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
	}

	@Test
	void testRemoveUser() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");

		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findById(1)).thenReturn(optional);
		userServiceimpl.removeUser(1);
		
		verify(userRepository,times(1)).deleteById(1);
	}

	@Test
	void testShowAllUsers() {
		
		Users users=new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Users users1=new Users();
		users1.setEmail("na@gmail.com");
		users1.setMobile("8886543210");
		users1.setPassword("kadi");
		users1.setUser_id(2);
		users1.setUsername("Sloin");
		
		List<Users> li=new ArrayList<Users>();
		li.add(users);
		li.add(users1);
		
		when(userRepository.findAll()).thenReturn(li);
		List<Users> l1=userServiceimpl.showAllUsers();
		assertEquals(2,l1.size());
		
	}

	@Test
	void testShowUser() {
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findById(1)).thenReturn(optional);
		Users ur=userServiceimpl.showUser(1);
		
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
	}


}
