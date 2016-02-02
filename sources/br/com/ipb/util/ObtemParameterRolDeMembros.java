package br.com.ipb.util;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;

import br.com.ipb.model.dto.Membro;

public class ObtemParameterRolDeMembros {
	RequestUteis requestUteis;
	
	public ObtemParameterRolDeMembros() {
		requestUteis = new RequestUteis();
	}
	
	public Membro obterParametrosDaRequest(HttpServletRequest req) {
		Membro membro = new Membro();
		
		//Dados Cadastrais
		membro.setId(requestUteis.validarSeParamentroExisteNaRequest(req,"codigo")? requestUteis.getParameterInt(req, "codigo") : 0);
		membro.setNome(req.getParameter("nome"));
		membro.getCondicao().setCodigo(requestUteis.validarSeParamentroExisteNaRequest(req, "condicao") ? requestUteis.getParameterInt(req, "condicao") : 0);
		membro.getUnidadeFrequentada().setCodigo(requestUteis.validarSeParamentroExisteNaRequest(req, "unidade") ? requestUteis.getParameterInt(req, "unidade") : 0);
		membro.setDataDeCadastramento(requestUteis.validarSeParamentroExisteNaRequest(req, "dataDeCadastramento") ?  
				requestUteis.getParameterDate(req, "dataDeCadastramento") : LocalDate.now(ZoneId.of(ConstantesUteis.ZONE_ID_SP)));
		membro.setDataDeAtualizacao(requestUteis.validarSeParamentroExisteNaRequest(req, "dataDeAtualizacao") ?  
				requestUteis.getParameterDate(req, "dataDeAtualizacao") : LocalDate.now(ZoneId.of(ConstantesUteis.ZONE_ID_SP)));
		
		//Dados Pessoais
		membro.setDataNascimento(requestUteis.validarSeParamentroExisteNaRequest(req, "dataDeNascimento")? requestUteis.getParameterDate(req, "dataDeNascimento") : null);
		membro.setNaturalidade(requestUteis.validarSeParamentroExisteNaRequest(req, "naturalidade") ? requestUteis.getParameterString(req, "naturalidade") : "");
		membro.setNacionalidade(requestUteis.validarSeParamentroExisteNaRequest(req, "nacionalidade") ? requestUteis.getParameterString(req, "nacionalidade") : "");
		membro.setSexo(requestUteis.validarSeParamentroExisteNaRequest(req, "sexo") ? requestUteis.getParameterInt(req, "sexo") : null);
		membro.setTipoSanguino(requestUteis.validarSeParamentroExisteNaRequest(req, "tipoSanguineo")? requestUteis.getParameterString(req, "tipoSanguineo") : "");
		membro.setGrauDeEscolaridade(requestUteis.validarSeParamentroExisteNaRequest(req, "escolaridade") ? requestUteis.getParameterString(req, "escolaridade") : "");
		membro.setNomeDoPai(requestUteis.validarSeParamentroExisteNaRequest(req, "pai") ? requestUteis.getParameterString(req, "pai") : "");
		membro.setNomeDaMae(requestUteis.validarSeParamentroExisteNaRequest(req, "mae") ? requestUteis.getParameterString(req, "mae") : "");
		membro.setEstadoCivil(requestUteis.validarSeParamentroExisteNaRequest(req, "estadoCivil") ? requestUteis.getParameterString(req, "estadoCivil") : "");
		membro.setDataCasamento(requestUteis.validarSeParamentroExisteNaRequest(req, "dataDeCasamento") ? requestUteis.getParameterDate(req, "dataDeCasamento") : null);
		membro.setConjugue(requestUteis.validarSeParamentroExisteNaRequest(req, "conjugue") ? requestUteis.getParameterString(req, "conjugue") : "");
		
		return membro;
	}
}
