package nil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String user,pass;
		user=request.getParameter("user");
		pass=request.getParameter("pass");
		out.println("Username:"+user);
		out.println("Password:"+pass);
		
		Cookie c1=new Cookie("user",user);
		Cookie c2=new Cookie("pass",pass);
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.sendRedirect("Login1");
	}

}
