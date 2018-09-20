package com.pr.service;

import java.time.LocalDate;
import java.util.List;

import com.pr.domain.ClientOrderDTO;


public interface ClientOrderService {

	void createOrder(ClientOrderDTO userOrderDTO);
	
	List<ClientOrderDTO> getOrdersByDate(LocalDate date);
	
	List<ClientOrderDTO> getAll();
}
