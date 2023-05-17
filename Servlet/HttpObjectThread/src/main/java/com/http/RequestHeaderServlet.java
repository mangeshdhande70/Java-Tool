package com.http;



import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/demo")
public class RequestHeaderServlet extends HttpServlet {
	
	
	
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
	
		LocalDateTime dateTime = LocalDateTime.now();
		int hour = dateTime.getHour();
		String msg = "";
		
		if (hour<12) {
			msg +="Good Morning"; 
		}else if (hour<16) {
			msg+="Good Afternoon";
		}else if (hour<20) {
			msg+="Good Evening";
		}else {
			msg+="Good Night";
		}
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<h1 style='color:red; text-aligh:center;'> Welcome to Servlet Coding </h1> ");
		out.println("<h1 style='color:red; text-aligh:center;'>DATE :: "+dateTime+"</h1> ");
		out.println("<h1 style='color:red; text-aligh:center;'>Greeting from the servlet :: "+msg+" </h1> ");
		
		
		out.println("<br/>Servlet Request Object is :: "+request.hashCode());
		out.println("<br/>Servlet Response Object is :: "+response.hashCode());
		out.println("<br/>Servlet Current Object is :: "+this.hashCode());
		out.println("<br/>Servlet Requst-Thread Object is :: "+Thread.currentThread().hashCode());
		out.println("</body>");
		
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		}
		
}

