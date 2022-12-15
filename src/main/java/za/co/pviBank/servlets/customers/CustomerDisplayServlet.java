package za.co.pviBank.servlets.customers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.pviBank.entities.Customer;
import za.co.pviBank.entities.Employee;

@WebServlet("/customer-dis-page.jsp")
public class CustomerDisplayServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		String query = "Select c from Customer c";
		
		List<Customer> customers = em.createQuery(query).getResultList();
		
		System.out.println("Customers: "+ customers);
		
		
		
		req.setAttribute("CUSTOMERS", customers);
	//	req.setAttribute("MESSAGE", "Customer Details!");
		req.getRequestDispatcher("customer-display.jsp").forward(req, resp);

	}
	

}
