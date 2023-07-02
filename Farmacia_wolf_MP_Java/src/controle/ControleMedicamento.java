package controle;

import modelo.*;
import java.util.ArrayList;
/**
 * Classe que ira fazer o controle de dados com a modelo.Produto e a view.TelaDetalheProduto
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class ControleMedicamento {

		private ArrayList<Medicamento> m = new ArrayList<Medicamento>(); 
		private Medicamento medicamento = new Medicamento();

		/**
		 * Construtor do ControleMedicamento
		 */
		//Construtor ControleMedicamento
		public ControleMedicamento() {
			
		}
		
		
		/**
		 * Cria dados aleatorios a serem adicionados na nossa JList
		 */
		public void fillWithSomeDataMed() {
			if(medicamento.getNome() != null) {
					
			} else {
				for(int i=0;i<5;i++) {
					Medicamento medicamentoA = new Medicamento("medicamento: "+i,"fabricante: "+i,i,"forma"+i,"Tarja"+i,true);
					m.add(medicamentoA);
					}
				}
		}
			
		
		/**
		 * Retorna um ArrayList com todos os dados do Medicamento
		 * @return ArrayList ArrayList com Todos os atributos do objeto especifico da classe Medicamento
		 */
		//função para pegar todos os dados do objeto Medicamento
		public ArrayList<Medicamento> getAll(){
			return this.m;
			
		}
		/**
		 * Cria um novo elemento (Medicamento) e adiciona ele no final da nossa lista (no caso sera uma JList)
		 * @param nome Nome do medicamento
		 * @param fabricante Fabricante do medicamento
		 * @param preco Preço do medicamento
		 * @param forma Forma do medicamento
		 * @param tarjado Tarja do medicamento
		 * @param generico Se é generico ou não
		 * @return boolean Cria o elemento no final da lista
		 */
		// Create do CRUD Medicamento
		public boolean setMedicamento(String nome, String fabricante, double preco, String forma, String tarjado, boolean generico) {
			Medicamento novoMedicamento = new Medicamento(nome,fabricante,preco,forma,tarjado,generico);
			m.add(novoMedicamento);
			
			return true;
			
		}
		
		/**
		 * Retorna o elemento que esta na posicao solicitada
		 * @param posicao Argumento da posicao em que se encontra nosso ArrayList
		 * @return ArrayList Retorna o elemento que esta na posicao solicitada
		 */
		// Read do CRUD Medicamento
		public Medicamento getMedicamento(int posicao){
			
			return m.get(posicao);
			
		}
		/**
		 * Atualiza os dados da ArrayList Medicamento na posicao solicitada
		 * @param nome Nome do medicamento
		 * @param fabricante Fabricante do medicamento
		 * @param preco Preço do medicamento
		 * @param forma Forma do medicamento
		 * @param tarjado Tarja do medicamento
		 * @param generico Se é generico ou não
		 * @return boolean Atualiza os dados da ArrayList Medicamento na posicao solicitada
		 */
		// Update do CRUD Medicamento
		public boolean  editMedicamento (int posicao, String nome, String fabricante, double preco, String forma, String tarjado, boolean generico) {
			
			Medicamento medicamento = m.get(posicao);
			medicamento.setNome(nome);
			medicamento.setFabricante(fabricante);
			medicamento.setPreco(preco);
			medicamento.setForma(forma);
			medicamento.setTarja(tarjado);
			medicamento.setGen(generico);
			
			return true;
		}
		
		/**
		 * Remove da ArrayList o elemento Medicamento solicitado
		 * @param posicao Posicao em que está nosso elemento na lista
		 * @return boolean  Remove o elemento (Medicamento) que esta na posicao solicitada
		 */
		// Delete do CRUD Medicamento
		public boolean removerMedicamento(int posicao){
			
			m.remove(posicao);
			
			return true;
		}

	
	}