package com.pr.service;

import java.util.List;

import com.pr.domain.PaymentDTO;

public interface PaymentService {

	void addPayment(PaymentDTO paymentDTO);
	
	void updatePayment(PaymentDTO paymentDTO);
	
	List<PaymentDTO> getAll();
}
