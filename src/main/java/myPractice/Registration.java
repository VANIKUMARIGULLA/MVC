package myPractice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		
		System.out.println("Data of Controller : " + username +" "+ firstname +" "+ lastname +" "+ email +" "+ password +" "+ confirmpassword);
		
		Student s = new Student();
		s.setUsername(username);
		s.setFirstname(firstname);
		s.setLastname(lastname);
		s.setEmail(email);
		s.setPassword(password);
		s.setConfirmpassword(confirmpassword);
		
		StudentDAO sd = new StudentDAO();
		String status = sd.create(s);
		
		if(status.equals("SUCCESS")) {
			RequestDispatcher rd = request.getRequestDispatcher("/success.html");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}

}
