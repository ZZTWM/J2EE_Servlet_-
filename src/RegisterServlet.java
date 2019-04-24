import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("pragma", "no-cache");
		
		//��ȡ���ĵĲ�������servlet���н���ͱ���
		request.setCharacterEncoding("UTF-8");
		
		/**
		 * �ڿ���̨����ʾ
		 */
		String name = request.getParameter("name");
		
		//��ȡ��ֵ����:request.getParameter
		System.out.println("��ȡ��ֵ����name��" + name);
		
		//��ȡ���ж�ֵ�Ĳ���:request.getParameterValues
		String[] hobits = request.getParameterValues("hobits");
		System.out.println("��ȡ���ж�ֵ�Ĳ���hobits:" + Arrays.asList(hobits));
		
		//�������еĲ���:request.getParameterMap()
		System.out.println("ͨ�� getParameterMap �������еĲ����� ");
		Map<String,String[]> parameters = request.getParameterMap();
		Set<String> paramNames = parameters.keySet();
		for (String param : paramNames) {
			String[] value = parameters.get(param);
			System.out.println(param + ":" + Arrays.asList(value));
		}
		
		//�������ĵ���Ӧ
		response.setContentType("text/html; charset=UTF-8");
		
		/**
		 * ����ҳ����ʾ
		 */
		//��ȡ��ֵ����:request.getParameter
		response.getWriter().println("name��" + name + "<br>");
		//��ȡ���ж�ֵ�Ĳ���:request.getParameterValues
		response.getWriter().println("��ȡ���ж�ֵ�Ĳ���:hobits:" + Arrays.asList(hobits) + "<br>");
		//�������еĲ���:request.getParameterMap()
		response.getWriter().println("ͨ�� getParameterMap �������еĲ����� ");
		for (String param : paramNames) {
			String[] value = parameters.get(param);
			response.getWriter().println(param + ":" + Arrays.asList(value));
		}
		
		
	}
	
}
