package br.com.ipb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ipb.model.dto.Usuario;

public class Login implements Tarefa{
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Usuario user = obterParametrosDaRequest(req);
		session.setAttribute("usuario", user); 
		return "admin/index.jsp";
	}

	@Override
	public Usuario obterParametrosDaRequest(HttpServletRequest req) {
		String user = req.getParameter("user");
		String senha = req.getParameter("senha");
		return new Usuario(user, senha);
	};
	
}
