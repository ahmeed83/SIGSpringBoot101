package com.dronebuzzers.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dronebuzzers.rest.order.Order;
import com.dronebuzzers.rest.order.OrderSummary;
import com.dronebuzzers.rest.part.MockedPartsDAO;
import com.dronebuzzers.rest.part.PartsDAO;

@CrossOrigin
@RestController
@RequestMapping("/dronebuzzers/order")
public class OrderController {

	private PartsDAO partsDAO;

	public OrderController(PartsDAO partsDAO) {
		this.partsDAO = partsDAO;
	}

	// Submit a parts order
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<OrderSummary> update(@RequestBody Order order) {

		OrderSummary orderSummary = new OrderSummary(order, partsDAO);

		return new ResponseEntity<OrderSummary>(orderSummary, HttpStatus.OK);

	}

}