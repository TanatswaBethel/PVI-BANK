package za.co.pviBank.servlets.customers;

import java.io.IOException;

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
import za.co.pviBank.servlets.employees.InvalidValueException;

@WebServlet("/customer-dereg-page.jsp")
public class CustomerDeregistrationServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long longAccountNumber = Long.valueOf(req.getParameter("accountNumber"));
		Long accountNumber;

		if (longAccountNumber == null || longAccountNumber == 0) {
			try {
				throw new InvalidValueException();
			} catch (InvalidValueException e) {

				req.setAttribute("MESSAGE", e.getMessage());
				req.getRequestDispatcher("customer-deregistration.jsp").forward(req, resp);
			}
		}

		else {
			accountNumber = Long.valueOf(longAccountNumber);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			String query = "Delete from Account where accountNumber=" + accountNumber;
			int result = em.createQuery(query).executeUpdate();

			System.out.println(result);
			em.getTransaction().commit();

			if (result == 0) {
				req.setAttribute("MESSAGE", "The account number you provided does not exit");
				req.getRequestDispatcher("customer-deregistration.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("customer-display.jsp").forward(req, resp);
			}
		}

	}


}
