package br.com.ipb.model.dto;

import java.time.LocalDate;

public class Membro extends Pessoa{
	
	public Membro() {
		condicao = new Condicao();
		endereco = new Endereco();
		profissao = new Profissao();
		unidadeFrequentada = new Unidade();
	}
	private int id;
	private Endereco endereco;
	private Unidade unidadeFrequentada;
	private Profissao profissao;
	private Condicao condicao;
	private String grauDeEscolaridade;
	private String localDeTrabalho;
	private String telefoneComercial;
	private String celular;
	private String email;
	private String conjugue;
	private LocalDate dataCasamento;
	private String nomeDoPai;
	private String nomeDaMae;
	private LocalDate dataDeInclusao;
	private int admitidoPor;
	private String livroE;
	private String paginaE;
	private String igrejaDeOrigem;
	private LocalDate dataDeSaida;
	private int eleminadoPor;
	private String livros;
	private String paginas;
	private String igrejaDeDestino;
	private String pastorBatizado;
	private String igrejaBatizado;
	private LocalDate dataBatismo;
	private String pastorProfissao;
	private String igrejaProfissao;
	private LocalDate dataProfissao;
	private String livroP;
	private String paginaP;
	private int sociedade;
	private LocalDate dataDeCadastramento;
	private LocalDate dataDeAtualizacao;
	private String talentos;
	private int correspondencia;
	private String ataAdmissao;
	private String ataEliminacao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Unidade getUnidade() {
		return unidadeFrequentada;
	}
	public void setUnidade(Unidade unidade) {
		this.unidadeFrequentada = unidade;
	}
	public Profissao getProfissao() {
		return profissao;
	}
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	public Condicao getCondicao() {
		return condicao;
	}
	public void setCondicao(Condicao condicao) {
		this.condicao = condicao;
	}
	public String getGrauDeEscolaridade() {
		return grauDeEscolaridade;
	}
	public void setGrauDeEscolaridade(String grauDeEscolaridade) {
		this.grauDeEscolaridade = grauDeEscolaridade;
	}
	public String getLocalDeTrabalho() {
		return localDeTrabalho;
	}
	public void setLocalDeTrabalho(String localDeTrabalho) {
		this.localDeTrabalho = localDeTrabalho;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConjugue() {
		return conjugue;
	}
	public void setConjugue(String conjugue) {
		this.conjugue = conjugue;
	}
	public LocalDate getDataCasamento() {
		return dataCasamento;
	}
	public void setDataCasamento(LocalDate dataCasamento) {
		this.dataCasamento = dataCasamento;
	}
	public String getNomeDoPai() {
		return nomeDoPai;
	}
	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}
	public String getNomeDaMae() {
		return nomeDaMae;
	}
	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}
	public LocalDate getDataDeInclusao() {
		return dataDeInclusao;
	}
	public void setDataDeInclusao(LocalDate dataDeInclusao) {
		this.dataDeInclusao = dataDeInclusao;
	}
	public int getAdmitidoPor() {
		return admitidoPor;
	}
	public void setAdmitidoPor(int admitidoPor) {
		this.admitidoPor = admitidoPor;
	}
	public String getLivroE() {
		return livroE;
	}
	public void setLivroE(String livroE) {
		this.livroE = livroE;
	}
	public String getPaginaE() {
		return paginaE;
	}
	public void setPaginaE(String paginaE) {
		this.paginaE = paginaE;
	}
	public String getIgrejaDeOrigem() {
		return igrejaDeOrigem;
	}
	public void setIgrejaDeOrigem(String igrejaDeOrigem) {
		this.igrejaDeOrigem = igrejaDeOrigem;
	}
	public LocalDate getDataDeSaida() {
		return dataDeSaida;
	}
	public void setDataDeSaida(LocalDate dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}
	public int getEleminadoPor() {
		return eleminadoPor;
	}
	public void setEleminadoPor(int eleminadoPor) {
		this.eleminadoPor = eleminadoPor;
	}
	public String getLivros() {
		return livros;
	}
	public void setLivros(String livros) {
		this.livros = livros;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	public String getIgrejaDeDestino() {
		return igrejaDeDestino;
	}
	public void setIgrejaDeDestino(String igrejaDeDestino) {
		this.igrejaDeDestino = igrejaDeDestino;
	}
	public String getPastorBatizado() {
		return pastorBatizado;
	}
	public void setPastorBatizado(String pastorBatizado) {
		this.pastorBatizado = pastorBatizado;
	}
	public String getIgrejaBatizado() {
		return igrejaBatizado;
	}
	public void setIgrejaBatizado(String igrejaBatizado) {
		this.igrejaBatizado = igrejaBatizado;
	}
	public LocalDate getDataBatismo() {
		return dataBatismo;
	}
	public void setDataBatismo(LocalDate dataBatismo) {
		this.dataBatismo = dataBatismo;
	}
	public String getPastorProfissao() {
		return pastorProfissao;
	}
	public void setPastorProfissao(String pastorProfissao) {
		this.pastorProfissao = pastorProfissao;
	}
	public String getIgrejaProfissao() {
		return igrejaProfissao;
	}
	public void setIgrejaProfissao(String igrejaProfissao) {
		this.igrejaProfissao = igrejaProfissao;
	}
	public LocalDate getDataProfissao() {
		return dataProfissao;
	}
	public void setDataProfissao(LocalDate dataProfissao) {
		this.dataProfissao = dataProfissao;
	}
	public String getLivroP() {
		return livroP;
	}
	public void setLivroP(String livroP) {
		this.livroP = livroP;
	}
	public String getPaginaP() {
		return paginaP;
	}
	public void setPaginaP(String paginaP) {
		this.paginaP = paginaP;
	}
	public int getSociedade() {
		return sociedade;
	}
	public void setSociedade(int sociedade) {
		this.sociedade = sociedade;
	}
	public LocalDate getDataDeCadastramento() {
		return dataDeCadastramento;
	}
	public void setDataDeCadastramento(LocalDate dataDeCadastramento) {
		this.dataDeCadastramento = dataDeCadastramento;
	}
	public LocalDate getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}
	public void setDataDeAtualizacao(LocalDate dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}
	public String getTalentos() {
		return talentos;
	}
	public void setTalentos(String talentos) {
		this.talentos = talentos;
	}
	public int getCorrespondencia() {
		return correspondencia;
	}
	public void setCorrespondencia(int correspondencia) {
		this.correspondencia = correspondencia;
	}
	public String getAtaAdmissao() {
		return ataAdmissao;
	}
	public void setAtaAdmissao(String ataAdmissao) {
		this.ataAdmissao = ataAdmissao;
	}
	public String getAtaEliminacao() {
		return ataEliminacao;
	}
	public void setAtaEliminacao(String ataEliminacao) {
		this.ataEliminacao = ataEliminacao;
	}
}
