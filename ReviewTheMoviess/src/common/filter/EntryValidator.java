package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EntryValidator implements Filter
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException
   {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		HttpSession session=request.getSession(false);
		int count=1;
		
//		boolean loggedIn=false;
		
		
		if(session!=null&&session.getAttribute("user")!=null)
		{
//			loggedIn=true;
			System.out.println("from session set");
			response.sendRedirect("home");
		}
		else
		{
//			response.sendRedirect("pages/index.jsp");
			chain.doFilter(req, res);
		}
		
		System.out.println("from filter count"+count);
		count++;
		
//		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
