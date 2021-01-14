package com.lhleonardo.apisales.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.OrderStatus;

@Entity
@Table(name = "ORDERSALES")
public class OrderSales implements Serializable {
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long orderSalesId;	
		
		private OrderStatus status;
		
		//@OneToMany(targetEntity=User.class, mappedBy="ORDERSALES",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
		//@JoinColumn(name="productId")
		//private Product[] products;
		
		@OneToMany(cascade = CascadeType.ALL)  
		@JoinColumn(name="orderSalesId")
		private List<Product> products;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name="consumerId")
		private Consumer consumer;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name="paymentId")
		private Payment payment;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name="deliveryId")
		private Delivery delivery;

		public OrderSales() {
			super();
		}

		public OrderSales(Long orderSalesId, OrderStatus status, List<Product> products, Consumer consumer,
				Payment payment, Delivery delivery) {
			super();
			this.orderSalesId = orderSalesId;
			this.status = status;
			this.products = products;
			this.consumer = consumer;
			this.payment = payment;
			this.delivery = delivery;
		}

		public Long getOrderSalesId() {
			return orderSalesId;
		}

		public void setOrderSalesId(Long orderId) {
			this.orderSalesId = orderId;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public Consumer getConsumer() {
			return consumer;
		}

		public void setConsumer(Consumer consumer) {
			this.consumer = consumer;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public Delivery getDelivery() {
			return delivery;
		}

		public void setDelivery(Delivery delivery) {
			this.delivery = delivery;
		}
}
