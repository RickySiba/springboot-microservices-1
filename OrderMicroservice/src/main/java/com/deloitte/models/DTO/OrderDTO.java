package com.deloitte.models.DTO;

import java.time.LocalDate;

import com.deloitte.models.User;

import lombok.Data;

@Data
public class OrderDTO {
	
	private Integer orderId;
	
	private Integer customerId;
	
	private double totalOrderAmount = 0.0;
	
	private String orderStatus;
	
	private LocalDate orderDate = LocalDate.now();
	
	private LocalDate shippedDate;
	
	private LocalDate deliveredDate;
	
	private LocalDate returnDate;
	
	private User user;
}
