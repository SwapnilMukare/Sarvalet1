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


public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url,user,pass;
		url="jdbc:mysql://localhost:3306/swap";
		user="root";
		pass="Swapnil@123";
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name;
		name=request.getParameter("name");
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		
		String query="delete from student1 where name=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, name);
		
		st.execute();
		
		
		out.println("<font color='green'><h4>Record deleted Successfully...</h5></font>");
		out.println("<a href='CRUD_APP.html'>Back</a>");
	
		}
		catch(Exception ex)
		{
			out.println("<font color='red'><h4>Record fail to delete...</h5></font>");
			out.println("<a href='CRUD_APP.html'>Back</a>");

		}
	}

}
