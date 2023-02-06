package com.deloitte.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@Column(nullable = false)
	private Integer customerId;
	
	@Column(nullable = false)
	private double totalOrderAmount = 0.0;
	
	private String orderStatus;
	
	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate orderDate = LocalDate.now();
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate shippedDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate deliveredDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate returnDate;
}
