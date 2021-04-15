package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.Ride;
import ola.com.booking.model.User;
import ola.com.booking.service.RideService;
import ola.com.booking.service.UserService;
import ola.com.booking.service.impl.RideServiceImpl;
import ola.com.booking.service.impl.UserServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	RideService rideService = new RideServiceImpl();

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
			Boolean isExist = userService.validateUser(req.getParameter("name"), req.getParameter("passowrd"));
			System.out.println("name" + req.getParameter("name"));
			String Uname = req.getParameter("name");
			List<User> userList = userService.getUserData(Uname);
			// instead of boolean get user object
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			if (isExist) {
				for (User user2 : userList) {
					int idd = user2.getuserId();
					req.setAttribute("USERID", idd + "");
				}
				RequestDispatcher rd = req.getRequestDispatcher("routes");

				rd.forward(req, resp);
			} else {
				out.println("<font color='red'><b>You have entered incorrect password</b></font>");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.html");
				rd.include(req, resp);
			}

		}
		if (req.getParameter("action").equals("Book")) {
			System.out.println("sudeshaa");
			Ride ride = new Ride();
			ride.setRouteId(req.getParameter("routeId"));
			ride.setUserId(req.getParameter("userid"));
			rideService.saveRide(ride);
			RequestDispatcher rd = req.getRequestDispatcher("rides");
			rd.forward(req, resp);

		}
	}
}
