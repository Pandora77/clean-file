package com.pr.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pr.domain.ClientOrderDTO;
import com.pr.service.ClientOrderService;

@RestController
@RequestMapping("orders")
public class OrderController {

	@Autowired
	ClientOrderService orderService;
	
	@PostMapping
	public ResponseEntity<Void> addOrder(@RequestBody ClientOrderDTO dto){
		orderService.createOrder(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientOrderDTO>> getOrders(){
		return new ResponseEntity<List<ClientOrderDTO>>(orderService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("date")
	public ResponseEntity<List<ClientOrderDTO>> getOrdersByDate(@PathVariable("orderDate") LocalDate date){
		return new ResponseEntity<List<ClientOrderDTO>>(orderService.getOrdersByDate(date), HttpStatus.OK);
	}
}

