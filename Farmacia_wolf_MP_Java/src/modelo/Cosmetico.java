package modelo;

/**
 * Classe Cosmetico determina dados de um cosmético e herda da classe Produto.
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class Cosmetico extends Produto {
	private boolean dermo;
	private String local;
	private int grau;
	
	private Cosmetico[] cosmetico = new Cosmetico[50];
	
	
	/**
	 * Construtor de Cosmetico pega os atributos do metodo pai (Produto)
	 */
	public Cosmetico() {
		super();
	}
	
	
	
	//construtor
	/**
	 * Sobrecarga do construtor do Cosmetico que sobrescreve o método super de produto.
	 * @param nome Nome do Cosmetico
	 * @param fabricante Fabricante do Cosmetico
	 * @param preco Preco do Cosmetico
	 * @param dermo Se é dermocosmetico ou não
	 * @param local Local de aplicação do Cosmetico
	 * @param grau Grau do Cosmetico
	 */
	public Cosmetico(String nome, String fabricante, double preco, boolean dermo ,String local, int grau ) {
		//esse super pega atributos da classe produto
		super(nome,fabricante,preco);
		this.dermo = dermo;
		this.local = local;
		this.grau = grau;
	}
	
	

	
	/**
	 * Metodo toString que servira para printar os dados de nome e fabricante na nossa TelaDetalheProduto
	 */
	public String toString() {
		return nome + " " + fabricante;
	
	}
	
	/**
	 * Retorna um booleano, se for true é por que o cosmetico é do tipo dermocosmético. E false para se não for do tipo dermocosmético
	 * @return boolean se é dermocosmetico ou não
	 */
	public boolean getDermo() {
		return dermo;
	}
	
	/**
	 * Seta o valor de dermocosmetico
	 * @param dermo seta se é dermocosmético ou não
	 */
	public void setDermo(boolean dermo) {
		this.dermo = dermo;
	}
	/**
	 * Retorna o local de aplicação do cosmetico
	 * @return String Local de aplicação
	 */
	public String getLocal() {
		return local;
	}
	/**
	 * Seta o local de aplicação do cosmético
	 * @param local Local de aplicação a ser setado
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * Retorna o grau do cosmético
	 * @return int O grau do cosmético
	 */
	public int getGrau() {
		return grau;
	}
	/**
	 * Seta o grau do cosmético
	 * @param grau Grau a ser setado
	 */
	public void setGrau(int grau) {
		this.grau = grau;
	}
}
