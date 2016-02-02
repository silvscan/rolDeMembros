package br.com.ipb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ipb.dao.DadosPessoaisDAO;
import br.com.ipb.dao.DefaultDAO;
import br.com.ipb.dao.RolDeMembrosDAO;
import br.com.ipb.model.dto.Membro;
import br.com.ipb.util.ConstantesUteis;
import br.com.ipb.util.ObtemParameterRolDeMembros;

public class GravaDadosPessoais implements Tarefa{
	private DefaultDAO<Membro> dao;
	private RolDeMembrosDAO rolDeMembrosDAO;
	
	public GravaDadosPessoais() {
		dao = new DadosPessoaisDAO();
		rolDeMembrosDAO = new RolDeMembrosDAO();
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		new PreparaDadosDosCombosDoRolDeMembros().setarListasBasicaDosCombosNaRequest(req);
		cadastrarDadosPessoais(req);
		return "admin/rolDeMembros.jsp";
	}

	
	private void cadastrarDadosPessoais(HttpServletRequest req){
		Membro membro = obterParametrosDaRequest(req);
		List<Membro> listaMembros = new ArrayList<Membro>();
		try {
			dao.salvar(membro);
			req.setAttribute("liberarDemaisCadastros", true);
			req.setAttribute("ultimaAcao", this.getClass().getSimpleName());
			new PreparaDadosDosCombosDoRolDeMembros().setarListasCompletaDosCombosNaRequest(req);
			
			req.setAttribute(ConstantesUteis.ATTR_SUCESSO, ConstantesUteis.MSG_SUCESSO_CADASTRO_DEFAULT);
		} catch (IllegalArgumentException e) {
			req.setAttribute(ConstantesUteis.ATTR_ERRO, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			req.setAttribute(ConstantesUteis.ATTR_ERRO, ConstantesUteis.MSG_ERRO_DEFAULT);
			e.printStackTrace();
		}
		try{
			listaMembros = rolDeMembrosDAO.consultar(membro);
			req.setAttribute("membro", listaMembros.get(0));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Membro obterParametrosDaRequest(HttpServletRequest req) {
		return new ObtemParameterRolDeMembros().obterParametrosDaRequest(req);
	}

}
