package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BaseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在这里解决乱码问题（未获取数据之前）
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		System.out.println(method);
		
		try {
			Method method2 = this.getClass().getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			
			//把方法权限设大
			method2.setAccessible(true);
			method2.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
