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
import java.sql.ResultSet;
import java.sql.Statement;


public class servalet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String user,pass,url;
		url="jdbc:mysql://localhost:3306/swap";	
		user="root";
		pass="Swapnil@123";

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			String query="select* from student1";
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			out.println("<table border='2' cellspacing='0'><tr><th>Name</th><th>Contact</th><th>City</th></tr>");
			while(rs.next())
			{
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
				
				out.println("</table>");
				out.println("<a href='CRUD_APP.html'>Back</a>");
			}
			
			
		}
		catch (Exception ex)
		{
			out.println("<font color='red'><h4>Record fail to delete...</h5></font>");
			out.println("<a href='CRUD_APP.html'>Back</a>");

		}
	}

}
