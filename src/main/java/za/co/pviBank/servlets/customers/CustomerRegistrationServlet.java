package za.co.pviBank.servlets.customers;

import java.io.IOException;
import java.util.SplittableRandom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.pviBank.entities.Account;
import za.co.pviBank.entities.Customer;


@WebServlet("/customer-reg-page.jsp")
public class CustomerRegistrationServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String surname = req.getParameter("surname");
		String gender = req.getParameter("gender");
		String dateOfBirth = req.getParameter("dateOfBirth");
		String idNumber = req.getParameter("idNumber");
		String maritalStatus = req.getParameter("maritalStatus");
		String residentialAddress = req.getParameter("residentialAddress");
		String emailAddress = req.getParameter("emailAddress");
		Integer phoneNumber = Integer.valueOf(req.getParameter("phoneNumber"));
		String occupation = req.getParameter("occupation");
		System.out.println("=================================================");
	
		String accountType = req.getParameter("accountType");
		Double accountBalance = Double.valueOf(req.getParameter("accountBalance"));
		
		
		
		
		Account account = new Account(accountType,accountBalance);
		
		Customer customer = new Customer (firstName, surname, gender, dateOfBirth, idNumber,
				maritalStatus, residentialAddress, emailAddress, phoneNumber, occupation);

		
		Long accountNumber = randomNumbers();
		account.setAccountNumber(accountNumber);
		
		Long cardNumber = randomNumbers2();
		account.setCardNumber(cardNumber);
		
		customer.setAccount(account);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(account); // when saving or updating in the database;
		
		em.persist(customer);
		
		em.getTransaction().commit();

		req.getRequestDispatcher("customer-display.jsp").forward(req, resp);
	}
	
	
	static Long randomNumbers() {

		StringBuilder builder = new StringBuilder();

		SplittableRandom random = new SplittableRandom();

		builder.append(006);
		for (int a = 0; a < 10; a++)
			builder.append(random.nextInt(1, 6));

		return Long.valueOf(builder.toString());
	}
		

	static Long randomNumbers2() {

		StringBuilder builder = new StringBuilder();

		SplittableRandom random = new SplittableRandom();

		builder.append(45);
		for (int a = 0; a < 17; a++)
			builder.append(random.nextInt(1, 9));

		return Long.valueOf(builder.toString());
	}
	
}
