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

@WebServlet ("/employee-upd.jsp")
public class EmployeeUpdateServlet extends HttpServlet {
	
	@Override
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
		String staffNumber = req.getParameter("staffNumber");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
	
	//	Employee employee = em.find(Employee.class, staffNumber); uses the primary key.
		
	String query = "Select e from Employee e where staffNumber='"+staffNumber+"'";
		
	Employee     employee = (Employee) em.createQuery(query).getSingleResult();
	       
		if(employee != null) {
		
			employee.setFirstName(firstName);
			employee.setSurname(surname);
			employee.setGender(gender);
			employee.setDateOfBirth(dateOfBirth);
			employee.setIdNumber(idNumber);
			employee.setPosition(position);
			employee.setMaritalStatus(maritalStatus);
			employee.setResidentialAddress(residentialAddress);
			employee.setEmailAddress(emailAddress);
			employee.setPhoneNumber(phoneNumber);
			employee.setUserName(userName);
			employee.setPassword(password);
			
			
		em.merge(employee); //when saving or updating in the database;
		
		em.getTransaction().commit();
		
		}
		
		else {
			req.setAttribute("MESSAGE", "NO EMPLOYEE WITH STAFF NUMBER: " + staffNumber + "WAS FOUND");
			req.getRequestDispatcher("employee-display.jsp").forward(req, resp);
		}
		
		System.out.println("employee:" + employee);
		
	}
	
	

}
