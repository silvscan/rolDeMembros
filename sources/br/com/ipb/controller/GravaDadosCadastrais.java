package br.com.ipb.controller;

import java.time.LocalDate;
import java.time.ZoneId;

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
		new PreparaDadosDosCombosDoRolDeMembros().setarListasBasicaDosCombosNaRequest(req);
		cadastrarNovoMembro(req);
		return "admin/rolDeMembros.jsp";
	}
	
	private void cadastrarNovoMembro(HttpServletRequest req){
		Membro membro = obterParametrosDaRequest(req);
		try {
			dao.salvar(membro);
			req.setAttribute("liberarDemaisCadastros", true);
			req.setAttribute("ultimaAcao", this.getClass().getSimpleName());
			new PreparaDadosDosCombosDoRolDeMembros().setarListasCompletaDosCombosNaRequest(req);
			req.setAttribute(ConstantesUteis.ATTR_SUCESSO, ConstantesUteis.MSG_SUCESSO_CADASTRO_DEFAULT);
			req.setAttribute(ConstantesUteis.ATTR_AVISO, ConstantesUteis.MSG_SUCESSO_CONTINUAR_CADASTRO);
		} catch (IllegalArgumentException e) {
			req.setAttribute(ConstantesUteis.ATTR_ERRO, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			req.setAttribute(ConstantesUteis.ATTR_ERRO, ConstantesUteis.MSG_ERRO_DEFAULT);
			e.printStackTrace();
		}
		
		req.setAttribute("membro", membro);
	}

	public Membro obterParametrosDaRequest(HttpServletRequest req) {
		Membro membro = new Membro();
		membro.setId(req.getParameter("codigo") != null && !"".equals(req.getParameter("codigo"))? Integer.valueOf(req.getParameter("codigo")) : 0);
		membro.setNome(req.getParameter("nome"));
		membro.getCondicao().setCodigo(req.getParameter("condicao")  != null && !"".equals(req.getParameter("condicao")) ? Integer.valueOf(req.getParameter("condicao")) : 0);
		membro.getUnidadeFrequentada().setCodigo(req.getParameter("unidade")  != null && !"".equals(req.getParameter("unidade")) ? Integer.valueOf(req.getParameter("unidade")) : 0);
		membro.setDataDeCadastramento(LocalDate.now(ZoneId.of(ConstantesUteis.ZONE_ID_SP)));
		membro.setDataDeAtualizacao(LocalDate.now(ZoneId.of(ConstantesUteis.ZONE_ID_SP)));
		return membro;
	}
}
