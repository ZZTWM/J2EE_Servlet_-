import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	//实例化
	public LoginServlet(){
		System.out.println("LoginServlet：构造方法被调用");
	}
	
	//初始化
	public void init(ServletConfig config){
		System.out.println("init(ServletConfig)：初始化");
	} 
	
	//销毁
	public void destory(){
		System.out.println("destory()：销毁"); 
	}
	
	protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("pragma", "no-cache");
		
		//获取中文的参数：在servlet进行解码和编码
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//request的常见方法
        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());
		
		String html = null;
		if("admin".equals(name) && "12345".equals(password)){
			html = "<div style='color:green'>登录成功</div>";
			//服务端跳转：转发
			request.getRequestDispatcher("success.html").forward(request, response);
		}
		else{
			html = "<div style='color:red'>登录失败</div>";
			//客户端跳转：重定向
			response.sendRedirect("fail.html");
			
			//response.setStatus(301);
			//response.setHeader("Location", "fail.html");
		}
		
		//返回中文的响应
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println(html);
		
		//在控制台打印
		System.out.println("name：" + name);
		System.out.println("password：" + password);
		
		//在网页上显示
		response.getWriter().println("name：" + name);
		response.getWriter().println("password：" + password);
		
	}
}
