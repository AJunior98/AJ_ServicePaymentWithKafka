package com.ajunior.paymentservice.entities;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable{
	
	private Long id;
	private Long idUser;
	private Long idProduct;
	private String cardNumber;
	
	public Payment() {
	}

	public Payment(Long id, Long idUser, Long idProduct, String cardNumber) {
		this.id = id;
		this.idUser = idUser;
		this.idProduct = idProduct;
		this.cardNumber = cardNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
}
