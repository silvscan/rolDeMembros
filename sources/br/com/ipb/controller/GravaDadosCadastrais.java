package br.com.ipb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.ipb.dao.DadosCadastraisDAO;
import br.com.ipb.dao.DefaultDAO;
import br.com.ipb.model.dto.Membro;
import br.com.ipb.util.ConstantesUteis;

public class GravaDadosCadastrais implements Tarefa{
	
	private DefaultDAO<Membro> dao;
	
	public GravaDadosCadastrais() {
		dao = new DadosCadastraisDAO();
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		PreparaDadosDosCombosDoRolDeMembros.setarListasBasicaDosCombosNaRequest(req);
		cadastrarNovoMembro(req);
		
		return "admin/rolDeMembros.jsp";
	}

	
	private void cadastrarNovoMembro(HttpServletRequest req){
		Membro membro = obterParametrosDaRequest(req);
		try {
			dao.salvar(membro);
			req.setAttribute("liberarDemaisCadastros", true);
			PreparaDadosDosCombosDoRolDeMembros.setarListasCompletaDosCombosNaRequest(req);
		} catch (IllegalArgumentException e) {
			req.setAttribute(ConstantesUteis.MSG_AVISO, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			req.setAttribute(ConstantesUteis.MSG_AVISO, ConstantesUteis.MSG_ERRO_DEFAULT);
			e.printStackTrace();
		}
		
		manterCombosPreenchidos(membro, req);
	}

	private void manterCombosPreenchidos(Membro membro, HttpServletRequest req) {
		req.setAttribute("codigo", membro.getId() > 0 ? membro.getId() : null);
		req.setAttribute("nome", membro.getNome());
		req.setAttribute("condicao", membro.getCondicao());
		req.setAttribute("unidade", membro.getUnidade().getCodigo());
	}

	public Membro obterParametrosDaRequest(HttpServletRequest req) {
		Membro membro = new Membro();
		membro.setId(req.getParameter("codigo") != null && !"".equals(req.getParameter("codigo"))? Integer.valueOf(req.getParameter("codigo")) : 0);
		membro.setNome(req.getParameter("nome"));
		membro.getCondicao().setCodigo(req.getParameter("condicao")  != null && !"".equals(req.getParameter("condicao")) ? Integer.valueOf(req.getParameter("condicao")) : 0);
		membro.getUnidade().setCodigo(req.getParameter("unidade")  != null && !"".equals(req.getParameter("unidade")) ? Integer.valueOf(req.getParameter("unidade")) : 0);
		
		return membro;
	}
}
