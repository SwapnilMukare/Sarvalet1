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

public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Cookie c[]=request.getCookies();
		if(c==null)
		{
			response.sendRedirect("login.html");
		}
		else {
			out.println("<h1>Email:"+c[0].getValue()+"</h1>");
			out.println("<h1>Password:"+c[1].getValue()+"</h1>");
			
			
		}
	}

}
