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

import za.co.pviBank.entities.Customer;
import za.co.pviBank.entities.Account;

@WebServlet("/customer-upd-page.jsp")
public class CustomerUpdateServlet extends HttpServlet {
	
	
	@Override
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
		Integer accountNumber = Integer.valueOf(req.getParameter("accountNumber"));
 
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		
//		Customer customer = em.find(Customer.class, customer.getAccount().getAccountNumber());
		
		Customer customer = em.find(Customer.class, accountNumber);
		
		if(customer != null) {
		
			customer.setFirstName(firstName);
			customer.setSurname(surname);
			customer.setGender(gender);
			customer.setDateOfBirth(dateOfBirth);
			customer.setIdNumber(idNumber);
			customer.setOccupation(occupation);
			customer.setMaritalStatus(maritalStatus);
			customer.setResidentialAddress(residentialAddress);
			customer.setEmailAddress(emailAddress);
			customer.setPhoneNumber(phoneNumber);
		
			

		em.merge(customer); //when saving or updating in the database;
		
		em.getTransaction().commit();
		req.getRequestDispatcher("customer-display.jsp").forward(req, resp);

		}
		
		else {
			req.setAttribute("MESSAGE", "NO CUSTOMER WITH ACCOUNT NUMBER: " + accountNumber + " WAS FOUND");
			req.getRequestDispatcher("customer-update.jsp").forward(req, resp);
		}
		
		System.out.println("customers:" + customer);
		
	
	
	}

	
}
