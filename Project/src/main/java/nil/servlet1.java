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
import java.sql.Statement;

public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String user,pass,url;
		url="jdbc:mysql://localhost:3306/swap";	
		user="root";
		pass="Swapnil@123";
		String name,contact,address;
		name=request.getParameter("name");
		contact=request.getParameter("contact");
		address=request.getParameter("Address");
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			
			String query="insert into student1 values(?,?,?)";
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, contact);
			st.setString(3, address);
			st.execute();
			
			
			out.println("<front color='green'><h5>Record Inserted Succesfully..........</h5></font>");
			out.println("<a href='CRUD_APP.html'>Back</a>");
		}
		catch(Exception e) {
			out.println("<front color='green'><h5>Record Inserted Failed..........</h5></font>");
			out.println("<a href='CRUD_APP.html'>Back</a>");
		}

		
		
		
		
	}

}
