package br.com.ipb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ipb.dao.ObterDadosDosCombosDAO;

public class PreparaDadosDosCombosDoRolDeMembros implements Tarefa{
	private static final String PARCIAL = "parcial";
	private static final String COMPLETO = "completo";
	static ObterDadosDosCombosDAO obterDadosDosCombosDAO;
	
	public PreparaDadosDosCombosDoRolDeMembros() {
		if (obterDadosDosCombosDAO == null)
			obterDadosDosCombosDAO = new ObterDadosDosCombosDAO();
	}
 	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String tipoCarregamento = obterParametrosDaRequest(req);
		
		if (!tipoCarregamento.isEmpty() && PARCIAL.equalsIgnoreCase(tipoCarregamento)){
			setarListasBasicaDosCombosNaRequest(req);
		} else if (!tipoCarregamento.isEmpty() && COMPLETO.equalsIgnoreCase(tipoCarregamento)){
			setarListasCompletaDosCombosNaRequest(req);
		}
		return "admin/rolDeMembros.jsp";
	}
	
	public static void setarListasCompletaDosCombosNaRequest(HttpServletRequest req) {
		setarListasBasicaDosCombosNaRequest(req);
		req.setAttribute("listaAdmissoes", obterDadosDosCombosDAO.getListaAdmissoes());
		req.setAttribute("listaEliminacoes", obterDadosDosCombosDAO.getListaEliminacoes());
		req.setAttribute("listaProfissoes", obterDadosDosCombosDAO.getListaProfissoes());
		req.setAttribute("listaSociedades", obterDadosDosCombosDAO.getListaSociedades());
	}

	public static void setarListasBasicaDosCombosNaRequest(HttpServletRequest req) {
		req.setAttribute("listaUnidades", obterDadosDosCombosDAO.getListaUnidades());
		req.setAttribute("listaCondicoes", obterDadosDosCombosDAO.getListaCondicao());
	}
	
	@Override
	public String obterParametrosDaRequest(HttpServletRequest req) {
		return req.getParameter("tipoDeCarregamento");
	}

}
