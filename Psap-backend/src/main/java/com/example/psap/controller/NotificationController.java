package com.example.psap.controller;

import com.example.psap.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.psap.entity.ParkingSlots;
import com.example.psap.entity.Users;
import com.example.psap.exception.NotificationException;
import com.example.psap.service.INotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	INotificationService notificationService;

	@Autowired
	UserServiceimpl userServiceimpl;
	
	@PostMapping("/registerEmail")
	public String sendRegisterEmail(@RequestBody Users user) throws NotificationException {
		notificationService.sendRegistrationEmail(user);
		return "Mail sent for registration";
	}
	
	@PostMapping("/parkingConfirm/{userid}")
	public String sendParkingConfirmEmail(@PathVariable int userid , @RequestBody ParkingSlots parkingSlots) throws NotificationException {
		Users users = userServiceimpl.showUser(userid);
		notificationService.sendParkingConfirmationEmail(users,parkingSlots);
		return "Mail sent for resetting password";
	}
	
	
	@PostMapping("/parkingCancel/{userid}")
	public String sendParkingCancelEmail(@PathVariable int userid ,@RequestBody ParkingSlots parkingSlots) throws NotificationException {
		Users users = userServiceimpl.showUser(userid);
		notificationService.sendParkingCancellationEmail(users,parkingSlots);
		return "Mail sent for resetting password";
	}
	
	@PostMapping("/forgotPassword")
	public String sendPasswordEmail(@RequestBody Users user) throws NotificationException {
		notificationService.sendForgotPasswordEmail(user);
		return "Mail sent for resetting password";
	}
	
	@PostMapping("/forgotLoginId/{emailId}")
	public String sendForgotLoginEmail(@PathVariable String emailId) throws NotificationException {
		notificationService.sendLoginIdEmail(emailId);
		return "Mail sent for retrieving login id";
	}

}
