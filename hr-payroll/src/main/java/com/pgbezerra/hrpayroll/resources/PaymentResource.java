package com.pgbezerra.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgbezerra.hrpayroll.entities.Payment;
import com.pgbezerra.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable(value = "workerId") Long workerId,
			@PathVariable(value = "days") Integer days) {
		Payment obj = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(obj);
	}

}
