package sn.zone01dakar.securite.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class PrivateFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
public PrivateFilter() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// On recupere le nom de la session
		String username = (String)session.getAttribute("username");
		// On recupere le chemain demande par l'utilisateur
		String chemin = req.getServletPath();
		// On recupere la methode HTTP utilise (GET ou POST)
		String method = req.getMethod();
		if (username != null || chemin.equals("/") || chemin.equals("/login") || chemin.equals("/signup") || chemin.equals("/logout") || chemin.equals("/index.jsp") || chemin.equals("/login") && method.equalsIgnoreCase("POST") || chemin.equals("/signup") || chemin.equals("/logout") || chemin.equals("/index.jsp") || chemin.equals("/signup") && method.equalsIgnoreCase("POST") || chemin.startsWith("/public/")) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect(req.getContextPath());
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
