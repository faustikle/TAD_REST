package br.tad.modelo;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Produto implements Serializable	{
	
	@Id @GeneratedValue
	private Long id;	
	private String nome;
	private String descricao;
	private Double preco;
	@Column(name="XPdasdasdasd")
	private String outroNome;
	
	@Column(name="XXX")
	private String outraColuna;
	
	/**
	 * @return the outraColuna
	 */
	public String getOutraColuna() {
		return outraColuna;
	}
	/**
	 * @param outraColuna the outraColuna to set
	 */
	public void setOutraColuna(String outraColuna) {
		this.outraColuna = outraColuna;
	}
	public String getOutroNome() {
		return outroNome;
	}
	public void setOutroNome(String outroNome) {
		this.outroNome = outroNome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	
}
