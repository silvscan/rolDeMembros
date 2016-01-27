package br.com.ipb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ipb.controller.Login;
import br.com.ipb.model.dto.Usuario;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) resp;  
        
        String loginURL = request.getContextPath() + "/login.jsp"; 
        String tarefa = request.getParameter("tarefa") != null ? request.getParameter("tarefa") : "";
        
        
        if ( request.getRequestURI().equals(loginURL) || 
        	 session.getAttribute("usuario") != null || 
        	 new Login().getClass().getSimpleName().equalsIgnoreCase(tarefa)
        ) { 
        	chain.doFilter(request, response); 
        } else { 
        	request.setAttribute("msg", "Você não está logado no sistema!");
        	response.sendRedirect(loginURL); 
        } 
	}

	public void init(FilterConfig arg0) throws ServletException {}

}
