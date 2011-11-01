package belajar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HaloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		String content = "<html><head><title>Halo Servlet</title></head><body>Halo Servlet</body></html>";
		resp.getWriter().print(content);
		resp.getWriter().flush();
		resp.getWriter().close();
	}
	
}
