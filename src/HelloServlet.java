import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public void init(ServletConfig config){
		System.out.println("init of Hello Servlet");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
		Enumeration<String> headerNames = request.getHeaderNames();
		//获取头信息:在控制台上显示
		while(headerNames.hasMoreElements()){
			String header = headerNames.nextElement();
			String value = request.getHeader(header);
			System.out.printf("%s\t%s%n",header,value);
		}
		
		try {
			
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("pragma", "no-cache");
			
			response.setContentType("text/html;charset=UTF-8");
			//response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("<h2>第一次使用Servlet</h2>");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
