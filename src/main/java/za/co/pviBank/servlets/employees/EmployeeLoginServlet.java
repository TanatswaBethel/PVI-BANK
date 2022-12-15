package za.co.pviBank.servlets.employees;

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

import za.co.pviBank.entities.Employee;


@WebServlet("/login.jsp")
public class EmployeeLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			String userName = req.getParameter("userName");
			String password = req.getParameter("password");
			
			if(userName != null && password != null) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				
				Employee employee = new Employee ();
				
				List<Employee> employees = em.createQuery("Select e from Employee e").getResultList();
				
				boolean result = employee.login(userName, password, employees);
				
				if(result) {
					req.getRequestDispatcher("menu.jsp").forward(req, resp);
				}else {
					
					req.setAttribute("MESSAGE", "INVALID LOGIN DETAILS.");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	
	
	
	
	
	
	
}
