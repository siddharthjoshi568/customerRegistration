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
import com.dao.UserDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserLoginBean ulb = null;
		HttpSession httpSession = request.getSession();
		
		int partyId = Integer.parseInt(request.getParameter("partyId"));
		UserBean ub = new UserBean();
		ub.setPartyId(partyId);
		
		System.out.println(partyId);
		UserDao.deleteUser(ub);
		
		//list of all users
		List<UserBean> list = new ArrayList();
		list = AllUsers.allUsersList();
		
		httpSession.setAttribute("listOfUsers", list);
		
		response.sendRedirect("home.jsp");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Post");
		doGet(request, response);
	}

}
