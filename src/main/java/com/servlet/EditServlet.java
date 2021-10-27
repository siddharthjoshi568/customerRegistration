package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(request.getParameter("partyId"));
		// System.out.println("EditServlet");

		PrintWriter out = response.getWriter();

		UserBean ub = new UserBean();

		ub = UserDao.getUserByPartyId(request.getParameter("partyId"));
		// System.out.println("In EditServlet " + ub);

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("user", ub);
		
		RequestDispatcher rd=request.getRequestDispatcher("edit.jsp"); //servlet2 is
		 //url-pattern of the edit.jsp
		  
		 rd.forward(request, response);
		 //method may be include or forward
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
