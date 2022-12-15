package za.co.pviBank.servlets.employees;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.pviBank.entities.Employee;


@WebServlet("/dereg-employee-page.jsp")
public class EmployeeDeregisterServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String stringStaffNumber = req.getParameter("staffNumber");
		String staffNumber;

		if (stringStaffNumber == null || stringStaffNumber == "" || stringStaffNumber == "0") {
			try {
				throw new InvalidValueException();
			} catch (InvalidValueException e) {

				req.setAttribute("MESSAGE", e.getMessage());
				req.getRequestDispatcher("employee-deregister.jsp").forward(req, resp);
			}
		}

		else {
			staffNumber = String.valueOf(stringStaffNumber);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
//JEE
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

//			String query = "Delete from Employee where staffNumber='" + staffNumber+"'";
			String query = "UPDATE  Employee SET activated=false where staffNumber='" + staffNumber+"'";

			int result = em.createQuery(query).executeUpdate();

			System.out.println(result);
			em.getTransaction().commit();

			if (result == 0) {
				req.setAttribute("MESSAGE", "The staff number you provided does not exit.");
				req.getRequestDispatcher("employee-deregister.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("employee-display.jsp").forward(req, resp);
			}
		}

	}

}
