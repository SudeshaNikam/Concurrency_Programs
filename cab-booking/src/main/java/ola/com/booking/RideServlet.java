package ola.com.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

@WebServlet("/rides")
public class RideServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RideService rideservice = new RideServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// u have userId
		req.setAttribute("rideList", rideservice.getRides()); // all rout info + userId
		req.setAttribute("message", "<font color='green'><b>Save Ride Details Successfully</b></font>");
		System.out.println("ridelist" + rideservice.getRides().toString());
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/rideview.jsp");
		rd.forward(req, resp);
	}

}
