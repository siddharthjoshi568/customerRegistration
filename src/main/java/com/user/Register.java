package com.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String address = request.getParameter("address"); 
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		//String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		String phone = request.getParameter("phone");
		String userLoginId = request.getParameter("userLoginId");
		String password = request.getParameter("password");
		
		System.out.print(firstName +"\n"+lastName+"\n"+address+"\n"+city+"\n"+state+"\n"+zip+"\n"+phone+"\n"+userLoginId+"\n"+password);
		
		doGet(request, response);
	}

}
