package modelo;

/**
 * Classe medicamento determina dados de um medicamento e herda da classe Produto.
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class Medicamento extends Produto {
	private String forma;
	private String tarjado;
	private boolean generico;
	
	private Medicamento[] medicamento = new Medicamento[50];

	
	/**
	 * Construtor Medicamento pega os atributos do metodo pai (Produto)
	 */
	public Medicamento(){
		super();	
	}
	
	/**
	 * Sobrecarga doConstrutor do Medicamento que sobrescreve o método super de produto.
	 * @param nome Nome do medicamento
	 * @param fabricante Fabricante do medicamento
	 * @param preco Preço do medicamento
	 * @param forma Forma do medicamento
	 * @param tarjado Tarja do medicamento
	 * @param generico Se é generico ou não
	 */
	//construtor Sobrescrita
	public Medicamento(String nome, String fabricante, double preco, String forma, String tarjado, boolean generico/*String generico*/  ) {		
		//esse super pega atributos da classe produto
		super(nome,fabricante,preco);
		this.forma = forma;
		this.tarjado = tarjado;
		this.generico = generico;
		
	}
	
	
	/**
	 * Metodo toString que servira para printar os dados de nome e fabricante na nossa TelaDetalheProduto
	 */
	public String toString() {
		return nome + " " + fabricante ;
	
	}
	/**
	 * Retorna a Forma do medicamento
	 * @return String Forma do medicamento
	 */
	public String getForma() {
		return forma;
	}
	/**
	 * Seta a forma do medicamento
	 * @param forma a ser setada
	 */
	public void setForma(String forma) {
		this.forma = forma;
	}	
	/**
	 * Retorna a tarja do medicamento
	 * @return String Tarja do medicamento
	 */
	public String getTarja() {
		return tarjado;
	}
	/**
	 * Seta a tarja do medicamento
	 * @param tarjado Tarja a ser setada
	 */
	public void setTarja(String tarjado) {
		this.tarjado = tarjado;
	}	
	/**
	 * Retorna se o medicamento é generico
	 * @return String se é Genérico ou não
	 */
	public boolean getGen() {
		return true;
	}
	/**
	 * Seta o se o medicamento é generico
	 * @param generico Generico a ser setado
	 */
	public void setGen(boolean generico) {
		this.generico = generico;
	}	
}
