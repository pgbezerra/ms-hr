package com.pgbezerra.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.pgbezerra.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob Brown", 250.0, days);
	}
	
}
