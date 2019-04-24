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
		
		//获取中文的参数：在servlet进行解码和编码
		request.setCharacterEncoding("UTF-8");
		
		/**
		 * 在控制台上显示
		 */
		String name = request.getParameter("name");
		
		//获取单值参数:request.getParameter
		System.out.println("获取单值参数name：" + name);
		
		//获取具有多值的参数:request.getParameterValues
		String[] hobits = request.getParameterValues("hobits");
		System.out.println("获取具有多值的参数hobits:" + Arrays.asList(hobits));
		
		//遍历所有的参数:request.getParameterMap()
		System.out.println("通过 getParameterMap 遍历所有的参数： ");
		Map<String,String[]> parameters = request.getParameterMap();
		Set<String> paramNames = parameters.keySet();
		for (String param : paramNames) {
			String[] value = parameters.get(param);
			System.out.println(param + ":" + Arrays.asList(value));
		}
		
		//返回中文的响应
		response.setContentType("text/html; charset=UTF-8");
		
		/**
		 * 在网页上显示
		 */
		//获取单值参数:request.getParameter
		response.getWriter().println("name：" + name + "<br>");
		//获取具有多值的参数:request.getParameterValues
		response.getWriter().println("获取具有多值的参数:hobits:" + Arrays.asList(hobits) + "<br>");
		//遍历所有的参数:request.getParameterMap()
		response.getWriter().println("通过 getParameterMap 遍历所有的参数： ");
		for (String param : paramNames) {
			String[] value = parameters.get(param);
			response.getWriter().println(param + ":" + Arrays.asList(value));
		}
		
		
	}
	
}
