package com.example.psap.service;

import com.example.psap.dao.PaymentDao;
import com.example.psap.entity.Payment;
import com.example.psap.service.IPaymentService;
import com.example.psap.service.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentDao paymentDao;

    @Test
    void readPaymentById() {
        Payment payment = new Payment();
        payment.setPaymentId(1L);
        String type = "CREDIT_CARD";
        payment.setType(type);

        payment.setPaymentDateTime("28-05-2021");


        String status = "Confirmed";
        payment.setStatus(status);
        double amountPaid = 50;
        payment.setAmountPaid(amountPaid);

        when(paymentDao.findById(1L)).thenReturn(Optional.of(payment));

        Payment newpayment = paymentService.readPaymentById(1L);
        assertThat(newpayment.getAmountPaid()).isEqualTo(amountPaid);
        assertThat(newpayment.getStatus()).isEqualTo(status);
    }

    @Test
    void parkingBookingPayment() {
        Payment payment = new Payment();
        payment.setPaymentId(1L);
        String type = "CREDIT_CARD";
        payment.setType(type);

        payment.setPaymentDateTime("28-05-2021");


        String status = "Confirmed";
        payment.setStatus(status);
        double amountPaid = 50;
        payment.setAmountPaid(amountPaid);
        when(paymentDao.save(payment)).thenReturn(payment);

        Payment newpayment = paymentService.parkingBookingPayment(payment);
        assertThat(newpayment.getAmountPaid()).isEqualTo(amountPaid);
        assertThat(newpayment.getStatus()).isEqualTo(status);
    }
}