package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserLoginBean;
import com.dao.LoginDao;
import com.dao.UserLoginId_Search;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		HttpSession httpSession = request.getSession();
		UserLoginBean ulb = new UserLoginBean();
		
		//Fetching values from login form
		String userLoginId = request.getParameter("userLoginId");
		String password = request.getParameter("password");
		
		ulb.setUserLoginId(userLoginId);
		ulb.setPassword(password);
		
		//Search user in Userlogin table
		if(UserLoginId_Search.findUser(userLoginId) == false)
		{
			httpSession.setAttribute("message", "User Id does'nt exist! Please try again!");
			System.out.println("Testing in login.java");
			response.sendRedirect("login.jsp");
			return;
		}
		
		if(LoginDao.userLogin(ulb))
		{
			httpSession.setAttribute("current-user", ulb);
			response.sendRedirect("home.jsp");
			return;
		}
		else
		{
			httpSession.setAttribute("message", "Invalid Credentials! Please try again!");
			response.sendRedirect("login.jsp");
			return;
		}
		
		//doGet(request, response);
	}

}
