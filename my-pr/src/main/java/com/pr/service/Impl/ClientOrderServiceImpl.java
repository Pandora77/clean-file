package com.pr.service.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.domain.ClientOrderDTO;
import com.pr.entity.ClientOrderEntity;
import com.pr.repository.ClientOrderRepository;
import com.pr.service.ClientOrderService;
import com.pr.service.utils.ObjectMapperUtils;
import com.pr.service.utils.StringUtils;


@Service
public class ClientOrderServiceImpl implements ClientOrderService {

	@Autowired
	private ClientOrderRepository orderRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createOrder(ClientOrderDTO userOrderDTO) {
		userOrderDTO.setClientOrderId(stringUtils.generate(30));
		orderRepository.save(objectMapperUtils.map(clientOrderDTO, ClientOrderEntity.class));
		
	}

	@Override
	public List<ClientOrderDTO> getOrdersByDate(LocalDate date) {
		return objectMapperUtils.mapAll(orderRepository.findAllByOrderDate(date), ClientOrderDTO.class);
	}

	@Override
	public List<ClientOrderDTO> getAll() {
		return objectMapperUtils.mapAll(orderRepository.findAll(), ClientOrderDTO.class);
	}

}
