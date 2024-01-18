package nil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user,pass,url;
		url="jdbc:mysql://localhost:3306/swap";	
		user="root";
		pass="Swapnil@123";

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name,contact,address;
		name=request.getParameter("name");
		contact=request.getParameter("contact");
		address=request.getParameter("Address");
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		
		String query="update student1 set contact_no=?,city=? where name=?";
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1, contact);
		st.setString(2, address);
		st.setString(3, name);
		st.execute();
		
		
		out.println("<font color='green'><h4>Record updated Successfully...</h5></font>");
		out.println("<a href='CRUD_APP.html'>Back</a>");
	
		}
		catch(Exception ex)
		{
			out.println("<font color='red'><h4>Record fail to update...</h5></font>");
			out.println("<a href='CRUD_APP.html'>Back</a>");

		}
	}

}
