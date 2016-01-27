package br.com.ipb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	public String executa(HttpServletRequest req, HttpServletResponse resp);
	public Object obterParametrosDaRequest(HttpServletRequest req);
}
