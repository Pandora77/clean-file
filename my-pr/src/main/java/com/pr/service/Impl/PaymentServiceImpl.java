package com.pr.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.domain.PaymentDTO;
import com.pr.entity.PaymentEntity;
import com.pr.repository.PaymentRepository;
import com.pr.service.PaymentService;
import com.pr.service.utils.ObjectMapperUtils;
import com.pr.service.utils.StringUtils;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void addPayment(PaymentDTO paymentDTO) {
		paymentDTO.setPaymentId(stringUtils.generate(50));
		paymentDTO.setStatus(PAYMENT_AWAITING);
		paymentRepository.save(objectMapperUtils.map(paymentDTO, PaymentEntity.class));
	}

	@Override
	public void updatePayment(PaymentDTO paymentDTO) {
		paymentDTO.setStatus(PAYMENT_COMPLETED);
		paymentRepository.save(objectMapperUtils.map(paymentDTO, PaymentEntity.class));
		
	}

	@Override
	public List<PaymentDTO> getAll() {
		return objectMapperUtils.mapAll(paymentRepository.findAll(), PaymentDTO.class);
	}

}
