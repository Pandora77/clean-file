package com.pr.domain;

import java.math.BigDecimal;import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pr.entity.ClientEntity;
import com.pr.entity.PaymentEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientOrderDTO {

	@JsonIgnore
	private Long id;
	
	private String clientOrderId;
	private LocalDate orderDate;	
	private BigDecimal price;
	private ClientEntity client;
	private PaymentEntity payment;
}
