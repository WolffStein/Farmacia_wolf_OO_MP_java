package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;


/**
 * Classe que ira mostrar os detalhes dos produtos, aqui sera realizado o CRUD do projeto
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class TelaDetalheProduto implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelForma = new JLabel("Forma: ");
	private JTextField valorForma;
	private JLabel labelDermo = new JLabel("Dermocosmetico: ");
	private JTextField valorDermo;
	private JLabel labelFabricante = new JLabel("Fabricante: ");
	private JTextField valorFabricante;
	private JLabel labelPreco = new JLabel("Preco: ");
	private JTextField valorPreco;
	private JLabel labelLocal = new JLabel("Local Aplicacao: ");
	private JTextField valorLocal;
	private JLabel labelGrau = new JLabel("Grau do cosmetico: ");
	private JTextField valorGrau;
	private JTextField valorTarja;
	private JLabel labelTarja = new JLabel("Tarja: ");
	private JTextField valorGenerico;
	private JLabel labelGenerico = new JLabel("Generico: ");
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private int posicao;
	private int opcao;
	private String s;
	private ControleCosmetico controleCosmetico;
	private ControleMedicamento controleMedicamento;


/**
 * InserirEditar irá servir para Cadastrar e editar os dados do Cosmetico, a TelaProduto ira solicitar qual sera a função necessária e esta função irá exercer ou não seu papel.
 * @param op Registra a opcao selecionada pelo usuario.
 * @param c ControleCosmetico declarado dessa forma para ser usado mais tarde.
 * @param p TelaProduto onde será utilizado.
 * @param pos posicao do objeto.
 */
public void inserirEditarCosmetico(int op, ControleCosmetico c,
		TelaProduto p, int pos) {

	controleCosmetico = c;
	opcao = op;
	posicao = pos;

	if (op == 1) s = "Cadastro de Cosmetico";
	if (op == 3) s = "Detalhe de Cosmetico";

	janela = new JFrame(s);

		if (op == 3) {//Preenche dados com dados do Cosmecitco clicado
			valorNome = new JTextField(c.getCosmetico(pos).getNome(),200);
			valorFabricante = new JTextField(c.getCosmetico(pos).getFabricante(),200);
			valorPreco= new JTextField(String.valueOf(c.getCosmetico(pos).getPreco()),200);
			valorDermo = new JTextField(String.valueOf(c.getCosmetico(pos).getDermo()), 200);
			valorLocal = new JTextField(c.getCosmetico(pos).getLocal(),200);
			valorGrau = new JTextField(String.valueOf(c.getCosmetico(pos).getGrau()),200);

		} else { //N�o preenche com dados
			valorNome = 	  new JTextField(200);
			valorFabricante = new JTextField(200);
			valorPreco = 	  new JTextField(200);
			valorDermo = 	  new JTextField(200);
			valorLocal = 	  new JTextField(200);
			valorGrau =  	  new JTextField(200);
			botaoSalvar.setBounds(245, 200, 115, 30);
		}
			
		//Dimensao Dados Produto
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelFabricante.setBounds(30, 50, 150, 25);
		valorFabricante.setBounds(180, 50, 180, 25);
		
		//Dimensao Dados Cosmetico
		labelPreco.setBounds(30, 80, 150, 25);
		valorPreco.setBounds(180, 80, 180, 25);
		labelDermo.setBounds(30, 110, 150, 25);
		valorDermo.setBounds(180, 110, 180, 25);
		labelLocal.setBounds(30, 140, 180, 25);
		valorLocal.setBounds(180, 140, 180, 25);
		labelGrau.setBounds(30,170,180,25);
		valorGrau.setBounds(180,170,180,25);

		//Dimensao botoes salvar e excluir
		botaoSalvar.setBounds(120, 200, 115, 30);
		botaoExcluir.setBounds(245, 200, 115, 30);
		
		//adiciona as janelas reladionadas a produto	
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelFabricante);
		this.janela.add(valorFabricante);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		
		//Adiciona os campos relacionados a Cosmetico
		this.janela.add(labelDermo);
		this.janela.add(valorDermo);
		this.janela.add(labelLocal);
		this.janela.add(valorLocal);
		this.janela.add(labelGrau);
		this.janela.add(valorGrau);
		
		//Adiciona botoes de excluir e salvar
		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);

		//Layout da janela
		this.janela.setLayout(null);
		
		//Setando as dimensões da janela
		this.janela.setSize(800, 500);
		this.janela.setVisible(true);

		// Verifica se o botão salvar ou excluir foi clicado
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	
		}

/**
 * InserirEditarMedicamento irá servir para Cadastrar e editar os dados do Medicamento, a TelaProduto ira solicitar qual sera a função necessária e esta função irá exercer ou não seu papel.
 * @param op Registra a opcao selecionada pelo usuario.
 * @param m ControleMedicamento declarado dessa forma para ser usado mais tarde.
 * @param p TelaProduto onde será utilizado.
 * @param pos TelaProduto onde será utilizado.
 */
public void inserirEditarMedicamento(int op, ControleMedicamento m,
		TelaProduto p, int pos) {

	controleMedicamento = m;
	opcao = op;
	posicao = pos;

	if (op == 1) s = "Cadastro de Medicamento";
	if (op == 3) s = "Detalhe de Medicamento";

	janela = new JFrame(s);

	    if (op == 3 ) { //Preenche dados com dados do Medicamento clicado 
	
			//Pegando valores dos elementos do medicamento
			valorNome = new JTextField(m.getMedicamento(pos).getNome(),200);
			valorFabricante = new JTextField(m.getMedicamento(pos).getFabricante(),200);
			valorPreco= new JTextField(String.valueOf(m.getMedicamento(pos).getPreco()));
			valorForma = new JTextField(m.getMedicamento(pos).getForma(), 200);
			valorTarja = new JTextField(m.getMedicamento(pos).getTarja(),200);
			valorGenerico = new JTextField(String.valueOf(m.getMedicamento(pos).getGen()), 200);

		} else { //Nao preenche com dados
            valorNome =       new JTextField(200);
            valorFabricante =       new JTextField(200);
            valorPreco =       new JTextField(200);
            valorForma =       new JTextField(200);
            valorTarja =       new JTextField(200);
            valorGenerico =       new JTextField(200);
            botaoSalvar.setBounds(245, 200, 115, 30);
        }
			  
		//Dimensao dos dados Produto geral 
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelFabricante.setBounds(30, 50, 150, 25);
		valorFabricante.setBounds(180, 50, 180, 25);
		labelPreco.setBounds(30, 80, 150, 25);
		valorPreco.setBounds(180, 80, 180, 25);
		
		//Dimensao dados Medicamento
		labelForma.setBounds(30, 110, 150, 25);
		valorForma.setBounds(180, 110, 180, 25);
		labelTarja.setBounds(30, 140, 180, 25);
		valorTarja.setBounds(180, 140, 180, 25);
		labelGenerico.setBounds(30,170,180,25);
		valorGenerico.setBounds(180,170,180,25);
		
		//Dimensao dos botoes salvar e excluir
		botaoSalvar.setBounds(120, 200, 115, 30);
		botaoExcluir.setBounds(245, 200, 115, 30);
		
		//adiciona as janelas de salvar e excluir
		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);

		//Adiciona as janelas de atributos tipo Produto
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelFabricante);
		this.janela.add(valorFabricante);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		
		//Adiciona as janelas de atributos tipo Medicamento
		this.janela.add(labelForma);
		this.janela.add(valorForma);
		this.janela.add(labelTarja);
		this.janela.add(valorTarja);
		this.janela.add(labelGenerico);
		this.janela.add(valorGenerico);
		this.janela.add(botaoSalvar);

		//Seta o layout
		this.janela.setLayout(null);
		
		// Tamanho da janela detalhe Medicamento
		this.janela.setSize(800, 500);
		this.janela.setVisible(true);

		//Adiciona os "escutadores" de acao do usuario
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}
	

/**
 * Aqui será verificado se a opção escolhida para salvar foi de Cadastro ou de Atualização (opcao 3 e 1 respectivamente) tanto do Cosmetico como do Medicamento.
 */
public void actionPerformed(ActionEvent e) {
	Object src = e.getSource();
	// Salva os elementos da lista
	if(src == botaoSalvar) {
        try {
            boolean res;
            
            /* Como valorGenerico só existe para Medicamento, se o seu valor for nulo
             * entao é por que se trata de um Cosmetico.
             * 
             * a opcao (op) 3 é de dar update em um elemento da lista respectiva
             * 
             * A funcao editCosmetico ou Edit Medicamento nos 2 primeiros lacos
             *  serve para receber uma posicao e atualizar os valores dessa posicao (update)
             */
            if (opcao == 3 && valorGenerico == null){
                res = controleCosmetico.editCosmetico(
                    posicao,
                    valorNome.getText(),
                    valorFabricante.getText(),
                    Double.valueOf(valorPreco.getText()),
                    Boolean.valueOf(valorDermo.getText()),
                    valorLocal.getText(),
                    Integer.valueOf(valorGrau.getText()));
            }
            else if (opcao == 3 && valorGenerico != null) {
                res = controleMedicamento.editMedicamento(
                    posicao,
                    valorNome.getText(),
                    valorFabricante.getText(),
                    Double.valueOf(valorPreco.getText()),
                    valorForma.getText(),
                    valorTarja.getText(),
                    Boolean.valueOf(valorGenerico.getText()));
            }
            
            /* 
             * a opcao (op) 1 é de inserir um novo elemento na lista respectiva
             * 
             * A funcao setCosmetico ou setMedicamento nos 2 lacos seguintes
             *  serve para criar um novo elemento e adiciona-lo ao final da Lista
             */
            else if (opcao == 1 && valorGenerico == null){
                res = controleCosmetico.setCosmetico(
                    valorNome.getText(),
                    valorFabricante.getText(),
                    Double.valueOf(valorPreco.getText()),
                    Boolean.valueOf(valorDermo.getText()),
                    valorLocal.getText(),
                    Integer.valueOf(valorGrau.getText()));
            } else {
                res = controleMedicamento.setMedicamento(
                    valorNome.getText(),
                    valorFabricante.getText(),
                    Double.valueOf(valorPreco.getText()),
                    valorForma.getText(),
                    valorTarja.getText(),
                	Boolean.valueOf(valorGenerico.getText()));
            }
            
            // Mensagens de erro ou sucesso no cadastro
            if(res) {
                mensagemSucessoCadastro();
            }
            else mensagemErroCadastro();

            } catch (NullPointerException exc1) {
                mensagemErroCadastro();
                System.out.println(exc1);
            } catch (NumberFormatException exc2) {
                mensagemErroCadastro();
            }

      	}
	
		//Exclui o elemento da Lista
		if(src == botaoExcluir) {
	    	boolean res = false;
	        if (valorGenerico == null){
	            res = controleCosmetico.removerCosmetico(posicao);
	        } else {
	            res = controleMedicamento.removerMedicamento(posicao);
	        }
	
	        // mensagem de sucesso de exclusao
	        if(res) {
	            mensagemSucessoExclusao();
	       }
		} 
			
	}

/**
 * Aqui será printado a mensagem em caso de sucesso de exclusao
 */
public void mensagemSucessoExclusao() {
	JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
			JOptionPane.INFORMATION_MESSAGE);
	janela.dispose();
}
/**
 * Aqui será printado a mensagem em caso de sucesso de cadastro
 */
public void mensagemSucessoCadastro() {
	JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
			JOptionPane.INFORMATION_MESSAGE);
	janela.dispose();
}
/**
 * Aqui será printado a mensagem em caso de erro de cadastro
 */
public void mensagemErroCadastro() {
	JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
			+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
			+ "1. Nem todos os campos foram preenchidos \n"
			+ "2. Preco n�o cont�m apenas n�meros", null, 
			JOptionPane.ERROR_MESSAGE);
}
/**
 * Aqui será printado a mensagem em caso de erro de exclusao de cadastro
 */
public void mensagemErroExclusaoCosmetico() {
	JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
			+ "Verifique se o Produto est� cadastrado.\n"
			+ "Se sim, cancele o cadastro\n "
			+ " e tente novamente.", null, 
			JOptionPane.ERROR_MESSAGE);
}
/**
 * Aqui será printado a mensagem em caso de erro de exclusao
 */
public void mensagemErroExclusaoMedicamento() {
	JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n", null, 
			JOptionPane.ERROR_MESSAGE);
}

}
