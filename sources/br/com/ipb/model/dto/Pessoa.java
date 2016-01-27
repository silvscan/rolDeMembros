package br.com.ipb.model.dto;

import java.time.LocalDate;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	private String naturalidade;
	private String nacionalidade;
	private int sexo;
	private String tipoSanguino;
	private String estadoCivil;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getTipoSanguino() {
		return tipoSanguino;
	}
	public void setTipoSanguino(String tipoSanguino) {
		this.tipoSanguino = tipoSanguino;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}