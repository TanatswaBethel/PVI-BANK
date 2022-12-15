package za.co.pviBank.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.Table;


@Entity
@Table(name = "Customers")
public class Customer extends Person {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;
	
	
	@JoinColumn(name = "account", unique = true)
	private Account account;

	@Column(name = "occupation")
	private String occupation;

	
	
	public Customer() {
	
		super();
	}
	
	
	public Customer(String firstName, String surname, String gender, String dateOfBirth, String idNumber,
			String maritalStatus, String residentialAddress, String emailAddress, Integer phoneNumber, String occupation) {
		super(firstName, surname, gender, dateOfBirth, idNumber, maritalStatus, residentialAddress, emailAddress,
				phoneNumber);
		this.occupation = occupation;
	
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	@Override
	public String toString() {
		return "Customer [account=" + account + ", occupation=" + occupation +" "+super.toString()+"]";
	}

	

	


}
