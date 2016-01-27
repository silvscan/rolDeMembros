package br.com.ipb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ipb.model.bo.BOConsultarInformacoesMembro;
import br.com.ipb.model.dto.Membro;

public class ConsultaInformacoesMembro implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		consultarMembros(req);
		PreparaDadosDosCombosDoRolDeMembros.setarListasBasicaDosCombosNaRequest(req);
		return "admin/rolDeMembros.jsp";
	}
	
	private void consultarMembros(HttpServletRequest req) {
		Membro membro = obterParametrosDaRequest(req);
		BOConsultarInformacoesMembro boConsultarInformacoesMembro = new BOConsultarInformacoesMembro();
		boConsultarInformacoesMembro.setMembro(membro);
 		List<Membro> listaMembros = boConsultarInformacoesMembro.consulta();
 		
		manterCombosPreenchidos(membro, req);
		req.setAttribute("listaMembros", listaMembros);
		req.setAttribute("ultimaAcao", this.getClass().getSimpleName());
		req.setAttribute("exibeResultadoConsulta", true);
	}
	
	public Membro obterParametrosDaRequest(HttpServletRequest req) {
		Membro membro = new Membro();
		membro.setId(req.getParameter("codigo") != null && !"".equals(req.getParameter("codigo"))? Integer.valueOf(req.getParameter("codigo")) : 0);
		membro.setNome(req.getParameter("nome"));
		membro.getCondicao().setCodigo(req.getParameter("condicao")  != null && !"".equals(req.getParameter("condicao")) ? Integer.valueOf(req.getParameter("condicao")) : 0);
		membro.getUnidade().setCodigo(req.getParameter("unidade")  != null && !"".equals(req.getParameter("unidade")) ? Integer.valueOf(req.getParameter("unidade")) : 0);
		
		return membro;
	}
	
	private void manterCombosPreenchidos(Membro membro, HttpServletRequest req) {
		req.setAttribute("codigo", membro.getId() > 0 ? membro.getId() : null);
		req.setAttribute("nome", membro.getNome());
		req.setAttribute("condicao", membro.getCondicao());
		req.setAttribute("unidade", membro.getUnidade().getCodigo());
	}
}
