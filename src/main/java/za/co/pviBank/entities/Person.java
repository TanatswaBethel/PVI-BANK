package za.co.pviBank.entities;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "surname")
	private String surname;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "id_number")
	private String idNumber;


	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "residential_address")
	private String residentialAddress;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "phone_number")
	private Integer phoneNumber;


	@Column(name = "activated")
	private Boolean activated;

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	
	public Person() {
		super();
	}

	public Person( String firstName, String surname, String gender, String dateOfBirth,
			String idNumber, String maritalStatus, String residentialAddress, String emailAddress,
			Integer phoneNumber) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.idNumber = idNumber;
		this.maritalStatus = maritalStatus;
		this.residentialAddress = residentialAddress;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		
	}

	@Override
	public String toString() {
		return "Person [ firstName=" + firstName + ", surname=" + surname + ", age=" +  ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", idNumber=" + idNumber 
				+ ", maritalStatus=" + maritalStatus + ", residentialAddress=" + residentialAddress + ", emailAddress="
				+ emailAddress + ", phoneNumber=" + phoneNumber + ", userName=" + "]";
	}

	
	
}
