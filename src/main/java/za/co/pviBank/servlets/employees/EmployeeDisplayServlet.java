package za.co.pviBank.servlets.employees;

import java.io.IOException;
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

import za.co.pviBank.entities.Employee;


@WebServlet("/employee-display-page.jsp")
public class EmployeeDisplayServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		String query = "Select e from Employee e";
		
		List<Employee> employees = em.createQuery(query).getResultList();
		
		System.out.println("Employees: "+ employees);
		employees = employees.stream().filter(e -> e.getActivated()).collect(Collectors.toList());

		
		
		req.setAttribute("EMPLOYEES", employees);
		req.setAttribute("MESSAGE", "Employee Details!");
		req.getRequestDispatcher("employee-display.jsp").forward(req, resp);

	}
	
	

}
