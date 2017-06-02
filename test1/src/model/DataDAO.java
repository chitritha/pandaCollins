package model;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataDAO
 */
@WebServlet("/DataDAO")
public class DataDAO extends HttpServlet {
	int noOfRowsAffected;
	public int save(Data data){
		String userName = data.getUserName();
		String password = data.getPassword();
		String email = data.getEmail();
		String phone = data.getPhone();
		String sql = "insert into users(user_Name, password, email, phone_no) values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/footwear", "root","vasu1972");
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);	
			pstmt.setString(2, password);
			pstmt.setString(3, email);	
			pstmt.setString(4, phone);
			noOfRowsAffected = pstmt.executeUpdate();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(noOfRowsAffected > 0)
			return 1;
		return 0;
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataDAO() {
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
