package controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class DataController
 */
@WebServlet("/DataController")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataController() {
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
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String x = request.getParameter("userName");
		String y = request.getParameter("password");
		String e = request.getParameter("email");
		String p = request.getParameter("phone");
		Data obj = new Data();
		obj.setUserName(x);
		obj.setPassword(y);
		obj.setEmail(e);
		obj.setPhone(p);
		DataBo db = new DataBo();
		int b = db.validateAndSave(obj);
		if(b == 1)
			request.getRequestDispatcher("Success.jsp").forward(request, response);
		else if(b == 0)
			request.getRequestDispatcher("Failure.jsp").forward(request, response);
		else if(b == -1)
			out.println("Password must be atleast 8 characters!!");
		else if(b == -2 || b == -3)
			out.println("Invalid Credentials!!");
	}

}
