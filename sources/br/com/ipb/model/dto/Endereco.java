package br.com.ipb.model.dto;

public class Endereco {
	private int codEndereco;
	private String endereco;
	private String bairro;
	private String cidade;
	private String telefoneRes;
	public int getCodEndereco() {
		return codEndereco;
	}
	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefoneRes() {
		return telefoneRes;
	}
	public void setTelefoneRes(String telefoneRes) {
		this.telefoneRes = telefoneRes;
	}
}
