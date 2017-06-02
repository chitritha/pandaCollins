package model;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataBo
 */
@WebServlet("/DataBo")
public class DataBo extends HttpServlet {
	public int validateAndSave(Data data){
		if(data.getPassword().length() < 8) {
			return -1;
		}else if(!data.getEmail().contains("@")){
			if((!data.getEmail().contains(".in"))|| (!data.getEmail().contains(".com"))){
				return -2;
			}
		}else if(data.getPhone().length() < 8) {
			return -3;
		}
		DataDAO dd = new DataDAO();
		return dd.save(data);
	}
	private static final long serialVersionUID = 1L;
       
    /**s
     * @see HttpServlet#HttpServlet()
     */
    public DataBo() {
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
		doGet(request, response);
	}

}
