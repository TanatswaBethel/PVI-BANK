package za.co.pviBank.servlets.customers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
import za.co.pviBank.entities.Transactions;
import za.co.pviBank.servlets.employees.InvalidValueException;


@WebServlet("/customer-trans.jsp")
public class CustomerTransactionSevlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long accountNumber = Long.valueOf(req.getParameter("accountNumber"));
//		selecting from Transaction where account number = accountNumber
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	if (accountNumber != 0) {
	
	String query = "Select t from Transactions t" ;

	List<Transactions> transactions = em.createQuery(query).getResultList();
	
	System.out.println("Transactions: "+ transactions);
	

	
	transactions =	transactions.stream().filter(t -> t.getAccountNumber().longValue() == accountNumber).collect(Collectors.toList());
			
			
	
	req.setAttribute("TRANSACTIONS", transactions);
	}
	req.getRequestDispatcher("transactions.jsp").forward(req, resp);

}

	

//	@Override
//	protected void doPdoPostost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//	
//	Long longAccountNumber = Long.valueOf(req.getParameter("accountNumber"));
//	Long accountNumber;
//
//	if (longAccountNumber == null || longAccountNumber == 0) {
//		try {
//			throw new InvalidValueException();
//		} catch (InvalidValueException e) {
//
//			req.setAttribute("MESSAGE", e.getMessage());
//			req.getRequestDispatcher("customer-transactions.jsp").forward(req, resp);
//		}
//	}
//
//	else {
//		accountNumber = Long.valueOf(longAccountNumber);
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
//
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		String query = "Select t from Transactions t where accountNumber=" + accountNumber ;
//		int result = em.createQuery(query).executeUpdate();
//
//		System.out.println(result);
//		em.getTransaction().commit();
//
//		if (result == 0) {
//			req.setAttribute("MESSAGE", "The account number you provided does not exit");
//			req.getRequestDispatcher("customer-transactions.jsp").forward(req, resp);
//		} else {
//			req.getRequestDispatcher("customer-transactions.jsp").forward(req, resp);
//	}
//	}
//
//	
//	}	
//	
//	

}
