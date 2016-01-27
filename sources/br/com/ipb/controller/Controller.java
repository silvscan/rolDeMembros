package br.com.ipb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Controller")
public class Controller extends HttpServlet {
	private static final String PathController = "br.com.ipb.controller.";
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		if (tarefa == null) {
			throw new IllegalArgumentException("Tarefa inexistente");
		}
		tarefa = PathController + tarefa;
		
		try{
			Class<?> tipo = Class.forName(tarefa);
			Tarefa instacia = (Tarefa) tipo.newInstance();
			String proximaAcao = instacia.executa(req,resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(proximaAcao);
			dispatcher.forward(req, resp);
		}catch(ClassNotFoundException | InstantiationException| IllegalAccessException e){
			throw new ServletException(e);
		}
	}
}
