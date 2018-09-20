package com.pr.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pr.domain.ClientDTO;
import com.pr.repository.ClientOrderRepository;
import com.pr.service.ClientService;
import com.pr.service.utils.ObjectMapperUtils;
import com.pr.service.utils.StringUtils;

public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientOrderRepository customerRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;

	@Override
	public void createClint(ClientDTO client) {
		client.setClientId(stringUtils.generate());
		customerRepository.save(objectMapperUtils.map(client, ClientDTO.class));
	}

	@Override
	public void updateClint(ClientDTO clientDTO) {
		customerRepository.save(objectMapperUtils.map(client, ClientDTO.class));
	}
	

}
