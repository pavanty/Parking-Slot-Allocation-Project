package com.example.psap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.example.psap.dao.UserRepository;
import com.example.psap.entity.ParkingSlots;
import com.example.psap.entity.Users;
import com.example.psap.exception.NotificationException;

@Service
public class NotificationSeriviceImpl implements INotificationService{

	@Autowired
	 private JavaMailSenderImpl mailSender;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void sendRegistrationEmail(Users user) throws NotificationException {
		// TODO Auto-generated method stub
		SimpleMailMessage mes=new SimpleMailMessage();
		mes.setFrom("applicationspringboot@gmail.com");
		mes.setTo(user.getEmail());
		mes.setText("Dear User,\n\nPlease use below link to register.\n\nlocalhost:8080/user/register \n\nThanks & Regards");
		mes.setSubject("Registration Mail From Parking Slot Allocation");
		
		mailSender.send(mes);
		
	}

	@Override
	public void sendParkingConfirmationEmail(Users user, ParkingSlots slot) throws NotificationException {
		// TODO Auto-generated method stub
		SimpleMailMessage mes=new SimpleMailMessage();
		mes.setFrom("applicationspringboot@gmail.com");
		mes.setTo(user.getEmail());
		mes.setText("Dear User,\n\nYour parking slot is confirmed. Please refer the parking slot below.\nParking slot Id:"+slot.getParkingSlotId()+"\n\nThanks & Regards");
		mes.setSubject("Parking Slot Confirmation Mail From Parking Slot Allocation");
		
		mailSender.send(mes);
	}

	@Override
	public void sendParkingCancellationEmail(Users user, ParkingSlots slot) throws NotificationException {
		// TODO Auto-generated method stub
		SimpleMailMessage mes=new SimpleMailMessage();
		mes.setFrom("applicationspringboot@gmail.com");
		mes.setTo(user.getEmail());
		mes.setText("Dear User,\n\nYour parking slot is canceled. Please refer the parking slot below.\nParking slot Id:"+slot.getParkingSlotId()+"\n\nThanks & Regards");
		mes.setSubject("Parking Slot Cancelation Mail From Parking Slot Allocation");
		
		mailSender.send(mes);
		
	}

	@Override
	public void sendForgotPasswordEmail(Users user) throws NotificationException {
		// TODO Auto-generated method stub
		SimpleMailMessage mes=new SimpleMailMessage();
		mes.setFrom("applicationspringboot@gmail.com");
		mes.setTo(user.getEmail());
		mes.setText("Dear User,\n\nPlease use below link to reset ur password.\n\nlocalhost:8080/user/update"+user.getUser_id()+"\n\nThanks & Regards");
		mes.setSubject("Password Reset Mail From Parking Slot Allocation");
		
		mailSender.send(mes);
		
	}

	@Override
	public void sendLoginIdEmail(String email) throws NotificationException {
		// TODO Auto-generated method stub
		Users ur=userRepository.findByemail(email);
		SimpleMailMessage mes=new SimpleMailMessage();
		mes.setFrom("applicationspringboot@gmail.com");
		mes.setTo(email);
		mes.setText("Dear User,\n\nThe username for your account is : "+ur.getUsername()+"\npassword : "+ur.getPassword()+"\n\nThanks & Regards");
		mes.setSubject("LoginId Mail From Parking Slot Allocation");
		
		mailSender.send(mes);
	}

}
