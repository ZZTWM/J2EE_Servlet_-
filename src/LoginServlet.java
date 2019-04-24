import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	//ʵ����
	public LoginServlet(){
		System.out.println("LoginServlet�����췽��������");
	}
	
	//��ʼ��
	public void init(ServletConfig config){
		System.out.println("init(ServletConfig)����ʼ��");
	} 
	
	//����
	public void destory(){
		System.out.println("destory()������"); 
	}
	
	protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("pragma", "no-cache");
		
		//��ȡ���ĵĲ�������servlet���н���ͱ���
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//request�ĳ�������
        System.out.println("�������������ʱ������URL������Э�� ������ �˿�(�����): " + request.getRequestURL());
        System.out.println("����������������Դ�����֣�ȥ����Э���������: " + request.getRequestURI());
        System.out.println("�������еĲ�������: " + request.getQueryString());
        System.out.println("����������ڵĿͻ�����IP��ַ: " + request.getRemoteAddr());
        System.out.println("����������ڵĿͻ�����������: " + request.getRemoteHost());
        System.out.println("����������ڵĿͻ���ʹ�õ�����˿�: " + request.getRemotePort());
        System.out.println("��������IP��ַ: " + request.getLocalAddr());
        System.out.println("��������������: " + request.getLocalName());
        System.out.println("�õ��ͻ�������ʽ: " + request.getMethod());
		
		String html = null;
		if("admin".equals(name) && "12345".equals(password)){
			html = "<div style='color:green'>��¼�ɹ�</div>";
			//�������ת��ת��
			request.getRequestDispatcher("success.html").forward(request, response);
		}
		else{
			html = "<div style='color:red'>��¼ʧ��</div>";
			//�ͻ�����ת���ض���
			response.sendRedirect("fail.html");
			
			//response.setStatus(301);
			//response.setHeader("Location", "fail.html");
		}
		
		//�������ĵ���Ӧ
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println(html);
		
		//�ڿ���̨��ӡ
		System.out.println("name��" + name);
		System.out.println("password��" + password);
		
		//����ҳ����ʾ
		response.getWriter().println("name��" + name);
		response.getWriter().println("password��" + password);
		
	}
}
