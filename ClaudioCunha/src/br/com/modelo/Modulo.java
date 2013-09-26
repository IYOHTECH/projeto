package br.com.modelo;

public class Modulo {

	private String nome;
	private String descricao;
	private Long id;
	private Double valor;
	private Long curso;
	
	public Long getCurso() {
		return curso;
	}
	public void setCurso(Long curso) {
		this.curso = curso;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
