package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.User;
import ola.com.booking.service.UserService;
import ola.com.booking.service.impl.UserServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("action").equals("register")) {
			User user = new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setPhoneNo(req.getParameter("phoneNo"));

			userService.saveUser(user);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
		}

		if (req.getParameter("action").equals("login")) {
			User user = userService.validateUser(req.getParameter("name"), req.getParameter("password"));
			// instead of boolean get user object
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();

			if (user != null) {// user obj null or not
				RequestDispatcher rd = req.getRequestDispatcher("routes");
				int id = user.getuserId();
				req.setAttribute("USER_ID", id + "");
				// send userId also
				rd.forward(req, resp);
			} else {
				out.println("<font color='red'><b>You have entered incorrect password</b></font>");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.html");
				rd.include(req, resp);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("Log").equals("Login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.include(req, resp);
		}
	}

	
}
