package br.com.modelo;

import java.util.Date;

public class Agenda {

	private Long id;
	private int curso;
	private int modulo;
	private String local;
	private Date data;
	private String Bairro;
	private String endereco;
	private String estado;
	private int realizado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRealizado() {
		return realizado;
	}
	public void setRealizado(int realizado) {
		this.realizado = realizado;
	}
	private int cidade;

	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getCidade() {
		return cidade;
	}
	public void setCidade(int cidade) {
		this.cidade = cidade;
	}
	public int getModulo() {
		return modulo;
	}
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
