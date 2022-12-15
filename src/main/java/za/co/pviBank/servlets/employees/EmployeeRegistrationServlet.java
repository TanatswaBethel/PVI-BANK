package za.co.pviBank.servlets.employees;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.SplittableRandom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.pviBank.entities.Employee;

@WebServlet("/employee-reg.jsp")
public class EmployeeRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String surname = req.getParameter("surname");
		String gender = req.getParameter("gender");
		String dateOfBirth = req.getParameter("dateOfBirth");
		String idNumber = req.getParameter("idNumber");
		String position = req.getParameter("position");
		String maritalStatus = req.getParameter("maritalStatus");
		String residentialAddress = req.getParameter("residentialAddress");
		String emailAddress = req.getParameter("emailAddress");
		Integer phoneNumber = Integer.valueOf(req.getParameter("phoneNumber"));
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		Employee employee = new Employee(firstName, surname, gender, dateOfBirth, idNumber, position,
				maritalStatus, residentialAddress, emailAddress, phoneNumber, userName, password);

	
		String staffNumber = randomNumbers();
		
		employee.setActivated(true);
		employee.setStaffNumber(staffNumber);

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(employee); // when saving or updating in the database;

		em.getTransaction().commit();

		req.getRequestDispatcher("employee-display.jsp").forward(req, resp);
	}
	
	
	static String randomNumbers() {

		StringBuilder builder = new StringBuilder();

		SplittableRandom random = new SplittableRandom();

		builder.append("PVI");
		for (int a = 0; a < 5; a++)
			builder.append(random.nextInt(1, 6));

		return builder.toString();
	}
	
	

}
