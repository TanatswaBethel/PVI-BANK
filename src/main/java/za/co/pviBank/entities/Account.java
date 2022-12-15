package za.co.pviBank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "card_number")
	private Long cardNumber;

	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "account_balance")
	private Double accountBalance;
	
	
	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account() {
		super();
	}

	public Account(Integer id, Long accountNumber, String accountType, Long cardNumber, Double amount, Double accountBalance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.accountBalance = accountBalance;
	}

	public Account(String accountType, Double accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	
	
}
