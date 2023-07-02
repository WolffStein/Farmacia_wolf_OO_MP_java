package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * Gera a Tela inicial e possui o Método Main() para iniciar o projeto.
 * @author Wolfgang Friedrich Stein
 * @since 2023
 * @version 1.0
 */
public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame ("Farmacia");
	private static JLabel titulo = new JLabel ("Menu Principal");
	private static JButton cosmetico = new JButton ("Cosmetico");
	private static JButton medicamento = new JButton ("Medicamento");
	private ControleCosmetico controleCosmetico = new ControleCosmetico();
	private ControleMedicamento controleMedicamento = new ControleMedicamento();
	
	/**
	 * Seta os limites e adiciona os botões da TelaMenu
	 */
	public TelaMenu() {
		titulo.setFont(new Font("Arial",Font.BOLD,20)); 
		titulo.setBounds(120,10,150,30);
		cosmetico.setBounds(120,60,150,30);
		
		medicamento.setBounds(120,120,150,30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(cosmetico);
		janela.add(medicamento);
		
		janela.setSize(400,250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
	}
	
	/**
	 * Metodo Main
	 * @param args pega os argumentos da TelaMenu para inicializar
	 */
	//main do programa
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		cosmetico.addActionListener(menu);
		medicamento.addActionListener(menu);
	}

	/**
	 * Verifica qual dos botões (Cosmetico || Medicamento) foi clicado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cosmetico)
			new TelaProduto(controleCosmetico, controleMedicamento).mostrarDados(1);
			controleCosmetico.fillWithSomeDataCos();
		if(src == medicamento)
			new TelaProduto(controleCosmetico, controleMedicamento).mostrarDados(2);
			controleMedicamento.fillWithSomeDataMed();
	}
		
}
	


