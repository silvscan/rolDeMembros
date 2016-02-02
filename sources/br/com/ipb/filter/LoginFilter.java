package br.com.ipb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ipb.util.ConstantesUteis;

@WebFilter(urlPatterns={"/admin/*", "/Controller/*"}) 
public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) resp;  
        
        String loginURL = request.getContextPath() + "/login.jsp"; 
        String servletURL = request.getContextPath() + "/Controller";
        String tarefa = request.getParameter("tarefa") != null ? request.getParameter("tarefa") : "";
        
        System.out.println(request.getRequestURI());
        if ( (request.getRequestURI().equals(loginURL) || session.getAttribute("usuario") != null || (request.getRequestURI().equals(servletURL) && tarefa.equals("Login")))
        	 
        ) { 
        	chain.doFilter(request, response); 
        } else { 
        	request.setAttribute(ConstantesUteis.ATTR_ERRO, "Você não está logado no sistema!");
        	RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
        } 
	}

	public void init(FilterConfig arg0) throws ServletException {}

}
