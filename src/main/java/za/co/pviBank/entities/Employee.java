package za.co.pviBank.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;

	@Column(name = "position")
	private String position;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "passowrd")
	private String password;

	@Column(name = "staff_number", unique = true)
	private String staffNumber;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", position=" + position + ", userName=" + userName + ", password=" + password
				+ ", staffNumber=" + staffNumber +" "+super.toString()+ "]";
	}

	public Employee() {
		super();
	}

	public Employee(String firstName, String surname, String gender, String dateOfBirth, String idNumber,
			String position, String maritalStatus, String residentialAddress, String emailAddress, int phoneNumber,
			String userName, String password) {
		super(firstName, surname, gender, dateOfBirth, idNumber, maritalStatus, residentialAddress, emailAddress,
				phoneNumber);
		this.position = position;
		this.userName = userName;
		this.password = password;
	}

	public boolean login(String userName, String password, List<Employee> employees) {

		if (employees != null) {
			for (int index = 0; index < employees.size(); index++) {
				if (employees.get(index).getUserName().equals(userName)
						& employees.get(index).getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

}
