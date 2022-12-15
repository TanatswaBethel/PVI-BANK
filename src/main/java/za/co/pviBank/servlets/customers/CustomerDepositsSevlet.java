package za.co.pviBank.servlets.customers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

@WebServlet("/customer-depo-page.jsp")
public class CustomerDepositsSevlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long accountNumber = Long.valueOf(req.getParameter("accountNumber"));
		Double amount = Double.valueOf(req.getParameter("amount"));
		String reference = req.getParameter("reference");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Account> accounts = (List<Account>) em.createQuery("Select a from Account a").getResultList();

		if (amount != 0.0 && accountNumber != 0) {

			Double depositAmount = amount;
			Optional<Account> foundAccount = accounts.stream()
					.filter(a -> a.getAccountNumber().longValue() == accountNumber).findFirst();

			if (foundAccount != null) {
				try {
					Account account = foundAccount.get();
					Double balance = account.getAccountBalance();

					balance = balance + depositAmount;
					account.setAccountBalance(balance);

					em.merge(account);
				

					Transactions transactions = new Transactions( accountNumber,  account.getCardNumber(),
									depositAmount,  account.getAccountBalance(),
									 "DEPOSIT", LocalDateTime.now());
					transactions.setId(07363535335);
					em.merge(transactions);

					em.getTransaction().commit();
					req.getRequestDispatcher("customer-display.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					em.getTransaction().rollback();
					e.printStackTrace();
				}
			} else {
				req.setAttribute("Message", "Invalid Account Number");
				req.getRequestDispatcher("customer-deposits.jsp").forward(req, resp);
			}

		}

	}

}