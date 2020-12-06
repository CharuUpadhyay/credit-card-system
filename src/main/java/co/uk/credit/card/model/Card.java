package co.uk.credit.card.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String number;
	private BigDecimal balance;
	private BigDecimal creditLimit;
	

	public Card() {
		super();
	}

	public Card(Long id, String name, String number, BigDecimal balance, BigDecimal creditLimit) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.balance = balance;
		this.creditLimit = creditLimit;
	}

	public Card(String name, String number, BigDecimal balance, BigDecimal creditLimit) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
		this.creditLimit = creditLimit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Card [id=%s, name=%s, number=%s]", id, name, number);
	}

}
