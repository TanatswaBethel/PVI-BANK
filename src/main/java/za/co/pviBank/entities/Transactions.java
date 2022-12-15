package za.co.pviBank.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;

	@Column(name = "account_number")
	private Long accountNumber;

	@Column(name = "card_number")
	private Long cardNumber;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "account_balance")
	private Double accountBalance;

	@Column(name = "reference")
	private String reference;

	@Column(name = "transaction_date")
	private LocalDateTime transactionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Transactions() {
		super();
	}

	public Transactions(Integer id, Long accountNumber, Long cardNumber, Double amount,
			Double accountBalance, String reference, LocalDateTime transactionDate) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;

		this.amount = amount;
		this.accountBalance = accountBalance;
		this.reference = reference;
		this.transactionDate = transactionDate;
	}

	/**
	 * @param accountNumber
	 * @param cardNumber
	 * @param description
	 * @param amount
	 * @param accountBalance
	 * @param reference
	 * @param transactionDate
	 */
	public Transactions(Long accountNumber, Long cardNumber, Double amount, Double accountBalance,
			String reference, LocalDateTime transactionDate) {
		super();
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;

		this.amount = amount;
		this.accountBalance = accountBalance;
		this.reference = reference;
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", accountNumber=" + accountNumber + ", cardNumber=" + cardNumber
				 + ", amount=" + amount + ", accountBalance=" + accountBalance
				+ ", reference=" + reference + ", transactionDate=" + transactionDate + "]";
	}

}
