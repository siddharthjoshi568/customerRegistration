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
import com.dao.UserLoginId_Search;
import com.service.MailUtil;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		try {
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
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
			
			if (userLoginId.isEmpty()) {
				out.println("User Login Id is required!");
				return;
			}
			
			if(UserLoginId_Search.findUser(userLoginId) == true)
			{
				httpSession.setAttribute("message", "User Login Id already exists! Please try again!");
				System.out.println("Testing");
				response.sendRedirect("register.jsp");
				return;
			}
			
			out.print("Successfully Registered!!");
			ub = new UserBean(firstName, lastName, address, city, zip, state, country, phone);	
			ulb = new UserLoginBean(userLoginId, password);
			System.out.println(ub);

			// Store to database using RegisterDao
			System.out.print(RegisterDao.userRegistration(ub, ulb));
			
			httpSession.setAttribute("message", "Registration Successful!!");
			
			//adding user to session
			httpSession.setAttribute("current-user", ulb);
			
			//list of all users
			List<UserBean> list = new ArrayList();
			list = AllUsers.allUsersList();
			
			httpSession.setAttribute("listOfUsers", list);
			
			//MailUtil.sendMail("siddharthjoshi568@gmail.com");
			response.sendRedirect("home.jsp");
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			httpSession.setAttribute("message", "Something went wrong! Please try again!");
			response.sendRedirect("register.jsp");
			return;
		}

		//doGet(request, response);
	}

}
