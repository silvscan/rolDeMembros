package br.com.ipb.util;

public class ConstantesUteis {
	/*
	 * Nomes de atributos default para setar na request
	 */
	public static final String ATTR_AVISO = "mensagemDeAviso";
	public static final String ATTR_ERRO = "mensagemDeErro";
	public static final String ATTR_SUCESSO = "mensagemDeSucesso";
	
	/*
	 * Mensagens de erro default 
	 */
	public static final Object MSG_SUCESSO_CADASTRO_DEFAULT = "&nbsp;&nbsp;Cadastro realizado com sucesso!";
	public static final Object MSG_ERRO_DEFAULT = "&nbsp;&nbsp;Ocorreu um erro durante a realiza\u00e7\u00e3o da tarefa solicitada. "
												+ "Caso o problema persista, entre com contado com o administrador do sistema.";
	public static final Object MSG_SUCESSO_CONTINUAR_CADASTRO = "&nbsp;&nbsp;Continue o cadastro infomando os Dados Pessoais, Endereço, Dados Eclesiásticos e Situação,";
	
	/*
	 * ZoneId para Auxiliar na geração de datas com LocalDate
	 */
	public static final String ZONE_ID_SP = "America/Sao_Paulo";

}
