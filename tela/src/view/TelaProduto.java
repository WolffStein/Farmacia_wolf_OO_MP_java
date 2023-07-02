package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;
import java.util.ArrayList;


/**
 * Cria as telas dos Produtos (Cosmetico || Medicamento) 
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class TelaProduto implements ActionListener, ListSelectionListener {		
		private JFrame janela;
		private JLabel titulo;
		private JButton cadastroCosmetico;
		private JButton refreshCosmetico;
		private JButton cadastroMedicamento;
		private JButton refreshMedicamento;
		private JList listaCosmeticoCadastrados;
		private JList listaMedicamentoCadastrados;
		private String[] listaNomes = new String[50];
		private ArrayList listaCosmeticos;
		private ControleCosmetico controleCosmetico;
		private ControleMedicamento controleMedicamento;
		private ArrayList listaMedicamentos;
		private JScrollPane scrollPane = new JScrollPane();
		private JPanel panel = new JPanel(new BorderLayout());

		/**
		 * @param controleCosmetico ControleCosmetico como o tipo de parametro 
		 * @see ControleCosmetico
		 * @param controleMedicamento ControleMedicamento como o tipo de parametro
		 * @see ControleMedicamento
		 */
		public TelaProduto(ControleCosmetico controleCosmetico, ControleMedicamento controleMedicamento) {
            this.controleCosmetico = controleCosmetico;
            this.controleMedicamento  = controleMedicamento;
        }
		
		/**
		 * Cria dois cases, no case 1 será mostrado a Lista de Cosmetico cadastrados (JList) e no case 2 uma Lista de Medicamento cadastrados (JList)
		 * @param op
		 */
		public void mostrarDados(int op){
	
		
		switch (op) {
		case 1:// Mostrar dados de Cosmeticos cadastrados (JList)
			listaCosmeticos = controleCosmetico.getAll();
			listaCosmeticoCadastrados = new JList(listaCosmeticos.toArray());		    
			janela = new JFrame("Cosmetico");
			titulo = new JLabel("Cosmeticos Cadastrados");
			cadastroCosmetico = new JButton("Cadastrar");
			refreshCosmetico = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaCosmeticoCadastrados.setBounds(20, 50, 300, 600);
			scrollPane.setViewportView(listaCosmeticoCadastrados);
			listaCosmeticoCadastrados.setLayoutOrientation(JList.VERTICAL);
			listaCosmeticoCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCosmeticoCadastrados.setVisibleRowCount(10);

			cadastroCosmetico.setBounds(70, 700, 100, 30);
			refreshCosmetico.setBounds(200, 700, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaCosmeticoCadastrados);
			janela.add(cadastroCosmetico);
			janela.add(refreshCosmetico);

			janela.setSize(400, 800);
			janela.setVisible(true);

			cadastroCosmetico.addActionListener(this);
			refreshCosmetico.addActionListener(this);
			listaCosmeticoCadastrados.addListSelectionListener(this);

			break;

		case 2:// Mostrar dados de Medicamentos cadastrados (JList)
			listaMedicamentos = controleMedicamento.getAll();
			listaMedicamentoCadastrados = new JList(listaMedicamentos.toArray());
			janela = new JFrame("Medicamentos");
			titulo = new JLabel("Medicamentos Cadastrados");
			cadastroMedicamento = new JButton("Cadastrar");
			refreshMedicamento = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 500, 30);
			listaMedicamentoCadastrados.setBounds(20, 50, 300, 600);
			listaMedicamentoCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMedicamentoCadastrados.setVisibleRowCount(10);


			cadastroMedicamento.setBounds(70, 700, 100, 30);
			refreshMedicamento.setBounds(200, 700, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaMedicamentoCadastrados);
			janela.add(cadastroMedicamento);
			janela.add(refreshMedicamento);

			janela.setSize(400, 800);
			janela.setVisible(true);

			cadastroMedicamento.addActionListener(this);
			refreshMedicamento.addActionListener(this);
			listaMedicamentoCadastrados.addListSelectionListener(this);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opcao nao encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}

		/**
		 * Verifica a opcao selecionada pelo usuario, e abre a Lista dos Cosmeticos || Medicamentos.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			Object src = e.getSource();

			if(e.getValueIsAdjusting() && src == listaCosmeticoCadastrados) {
				new TelaDetalheProduto().inserirEditarCosmetico(3, controleCosmetico, this, 
						listaCosmeticoCadastrados.getSelectedIndex());
			}

			if(e.getValueIsAdjusting() && src == listaMedicamentoCadastrados) {
				new TelaDetalheProduto().inserirEditarMedicamento(3, controleMedicamento, this, 
						listaMedicamentoCadastrados.getSelectedIndex());
			}
		}	

		/**
		 * Verifica a opção seleciona e Cria ou Edita o Produto sleecionado.
		 */
		@Override
		//Captura eventos relacionados aos botoes da interface
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			//Cadastro de novo Cosmetico (op =1 do TelaDetalheProduto)
			if(src == cadastroCosmetico)
				new TelaDetalheProduto().inserirEditarCosmetico(1, controleCosmetico, this, 0);

			//Cadastro de novo Medicamento  (op =1 do TelaDetalheProduto)
			if(src == cadastroMedicamento)
				new TelaDetalheProduto().inserirEditarMedicamento(1, controleMedicamento, this, 0);

			// Atualiza a lista de elementos de Cosmeticos mostrada no JList
			if (src == refreshCosmetico) {
				ArrayList listaCosmeticosAtualizada  = controleCosmetico.getAll();
				listaCosmeticoCadastrados.setListData(listaCosmeticosAtualizada.toArray(new Object[0]));
				listaCosmeticoCadastrados.updateUI();
			}

			// Atualiza a lista de elementos de Medicamentos mostrada no JList
			if(src == refreshMedicamento) {
				ArrayList listaMedicamentosAtualizada  = controleMedicamento.getAll();
			 	listaMedicamentoCadastrados.setListData(listaMedicamentosAtualizada.toArray(new Object[0]));
				listaMedicamentoCadastrados.updateUI();
			}

		}

		
			
}

