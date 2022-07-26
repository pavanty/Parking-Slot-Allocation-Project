package com.example.psap.service;

import com.example.psap.entity.ParkingSlots;
import com.example.psap.entity.Users;
import com.example.psap.exception.NotificationException;

public interface INotificationService {
	
	public void sendRegistrationEmail(Users user) throws NotificationException;
	public void sendParkingConfirmationEmail(Users user, ParkingSlots slot) throws NotificationException;
	public void sendParkingCancellationEmail(Users user, ParkingSlots slot) throws NotificationException;
	public void sendForgotPasswordEmail(Users user) throws NotificationException;
	public void sendLoginIdEmail(String email) throws NotificationException;
	
}
