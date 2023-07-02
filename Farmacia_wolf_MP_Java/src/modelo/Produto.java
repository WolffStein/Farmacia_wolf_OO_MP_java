package modelo;

//Classe "pai" abstrata das classes Cosmetico e java
/**
 * Classe Abstrata Produto
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public abstract class Produto {
	protected String nome;
	protected String fabricante;
	protected double preco;

	/**
	 * Construtor do Produto
	 */
	public Produto() {
		super();
	}
	/**
	 * Possui como entradas os seguintes parametros
	 * @param nome Nome do produto
	 * @param fabricante Fabricante do produto
	 * @param preco Preco do produto
	 */
	public Produto(String nome, String fabricante, double preco) {
		this.nome = nome;
		this.fabricante = fabricante;
		this.preco = preco;
	}
	/**
	 * Retorna o nome do Produto
	 * @return String Nome do produto
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Seta o nome do Produto
	 * @param nome nome a ser setado
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna o Preco do produto
	 * @return double Preço do produto
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * Seta o preco do produto
	 * @param preco preço a ser setado
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * Retorna o fabricante do produto
	 * @return String Fabricante do produto
	 */
	public String getFabricante() {
		return fabricante;
	}
	/**
	 * Seta o fabricante do produto
	 * @param fabricante fabricante a ser setado
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
}

