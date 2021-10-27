package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.bean.UserLoginBean;
import com.dao.AllUsers;
import com.dao.RegisterDao;
import com.dao.UserDao;
import com.dao.UserLoginId_Search;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserBean ub = null;
		UserLoginBean ulb = null;
		HttpSession httpSession = request.getSession();
		
		//Fetching values from edit.jsp
		try {
			int partyId = Integer.parseInt(request.getParameter("partyId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String zip = request.getParameter("zip");
			String phone = request.getParameter("phone");
			String userLoginId = request.getParameter("userLoginId");
			String password = request.getParameter("password");

			// Validations
			if (firstName.isEmpty()) {
				out.println("First Name is required!");
				return;
			}
			
			if (lastName.isEmpty()) {
				out.println("Last Name is required!");
				return;
			}
			
			ub = new UserBean(partyId, firstName, lastName, address, city, zip, state, country, phone);	
			
			System.out.println(ub);
			
			UserDao.userUpdation(ub);

			// Store to database using RegisterDao
			//System.out.print(RegisterDao.userRegistration(ub, ulb));
			
			//httpSession.setAttribute("message", "Registration Successful!!");
			
			//adding user to session
			//httpSession.setAttribute("current-user", ulb);
			
			//list of all users
			List<UserBean> list = new ArrayList();
			list = AllUsers.allUsersList();
			
			httpSession.setAttribute("listOfUsers", list);
			
			response.sendRedirect("home.jsp");
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			httpSession.setAttribute("message", "Something went wrong! Please try again!");
			response.sendRedirect("edit.jsp");
			return;
		}

		
		//doGet(request, response);
	}

}
