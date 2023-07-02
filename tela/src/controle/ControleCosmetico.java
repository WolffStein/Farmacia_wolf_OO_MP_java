package controle;
import modelo.*;
import java.util.ArrayList;

/**
 * Classe que ira fazer o controle de dados com a modelo.Cosmetico e a view.TelaDetalheProduto
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class ControleCosmetico {
	private ArrayList<Cosmetico> a = new ArrayList<Cosmetico>();
	private Cosmetico cosmetico = new Cosmetico();

	/**
	 * Construtor da classe ControleCosmetico
	 */
	//Construtor
	public ControleCosmetico() {
		
	}

	/**
	 * Cria dados aleatorios a serem adicionados na nossa JList
	 */
	public void fillWithSomeDataCos() {
//		int posicao = cosmetico.IndexOf(procurado);
		if(cosmetico.getNome() != null) {
			
		} else {
			for(int i=0;i<5;i++) {
				Cosmetico cosmeticoA = new Cosmetico("cosmetico: "+i,"fabricante: "+i,i,true,"local"+i,i);
				a.add(cosmeticoA);
				}
			}
	}
		
	/**
	 * Retorna um ArrayList com todos os dados do Cosmetico
	 * @return ArrayList ArrayList com Todos os atributos do objeto especifico da classe Cosmetico
	 */
	// função para pegar todos os dados do objeto cosmetico
	public ArrayList<Cosmetico> getAll() {
		
		return this.a;
		
	}
	/**
	 * Cria um novo elemento (Cosmetico) e adiciona ele no final da nossa lista (no caso sera uma JList)
	 * @param nome Nome do Cosmetico
	 * @param fabricante Fabricante do Cosmetico
	 * @param preco Preco do Cosmetico
	 * @param dermo Se é dermocosmetico ou não
	 * @param local Local de aplicação do Cosmetico
	 * @param grau Grau do Cosmetico
	 * @return boolean Cria o elemento no final da lista
	 */
	//  Create do CRUD
	public boolean setCosmetico(String nome, String fabricante, double preco, boolean dermo ,String local, int grau) {
		//* setCosmetico cria um novo elemento e adiciona no final da lista 
		Cosmetico novoCosmetico = new Cosmetico(nome,fabricante,preco,dermo,local,grau);
		a.add(novoCosmetico);
		
		return true;
	}
	
	/**
	 * Retorna o elemento que esta na posicao solicitada
	 * @param posicao Argumento da posicao em que se encontra nosso ArrayList
	 * @return ArrayList Retorna o elemento que esta na posicao solicitada
	 */
	// Read do CRUD
	public Cosmetico getCosmetico(int posicao) {
		//* getCosmetico recebe uma posicao e retorna o cosmetico dessa posicao
		return a.get(posicao);
		}
	/**
	 * Atualiza os dados da ArrayList Cosmetico na posicao solicitada
	 * @param posicao Posicao que está nosso elemento na lista
	 * @param nome Nome do Cosmetico a ser adicionado
	 * @param fabricante Fabricante do Cosmetico a ser adicionado
	 * @param preco Preco do Cosmetico a ser adicionado
	 * @param dermo Se é dermocosmetico ou não
	 * @param local Local de aplicação do Cosmetico a ser adicionado
	 * @param grau Grau do Cosmetico a ser adicionado
	 * @return boolean Atualiza os dados da ArrayList Cosmetico na posicao solicitada
	 */
	// Update do CRUD
	public boolean editCosmetico(int posicao,String nome, String fabricante, double preco, boolean dermo ,String local, int grau) {
		//* EditCosmetico recebe uma posicao e atualiza os valores do cosmetico nessa posicao
		Cosmetico cosmetico =  a.get(posicao);
		cosmetico.setNome(nome);
		cosmetico.setFabricante(fabricante);
		cosmetico.setPreco(preco);
		cosmetico.setDermo(dermo);
		cosmetico.setLocal(local);
		cosmetico.setGrau(grau);
		a.set(posicao, cosmetico);
		
		return true;
		
	}
	/**
	 * Remove da ArrayList o elemento Cosmetico solicitado
	 * @param posicao Posicao em que está nosso elemento na lista
	 * @return boolean Remove o elemento (Cosmetico) que esta na posicao solicitada
	 */
	// Delete do CRUD
	public boolean removerCosmetico(int posicao) {
		 //* removerCosmetico recebe uma posicao e remove o elemento dessa posicao
		 a.remove(posicao);
		 
		 return true;
	}
	
}