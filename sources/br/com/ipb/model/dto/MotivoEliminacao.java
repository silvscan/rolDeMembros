package br.com.ipb.model.dto;

public class MotivoEliminacao {
	private int codigo;
	private String motivo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTexto() {
		return motivo;
	}
	public void setTexto(String texto) {
		this.motivo = texto;
	}
	
	
}
