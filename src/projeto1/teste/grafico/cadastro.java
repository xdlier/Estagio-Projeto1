package projeto1.teste.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class cadastro implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame janela = new JFrame("Tela de Cadastro");

		JTextField nome = new JTextField(60);
		JTextField matricula = new JTextField(11);
		JTextField cargo = new JTextField(20);
		JButton cadastrar = new JButton(" Cadastrar ");
		JButton telaInicial = new JButton(" Menu Inicial ");
		JLabel resultado = new JLabel("     ");
		
		cadastrar.addActionListener(null);
		telaInicial.addActionListener(new TesteInterfaceGrafica());
		
		JPanel painel = new JPanel();
		painel.add(new JLabel("Informe o nome:"));
		painel.add(nome);
		painel.add(new JLabel("Informe a matrícula:"));
		painel.add(matricula);
		painel.add(new JLabel("Informe o cargo:"));
		painel.add(cargo);
		painel.add(cadastrar);
		painel.add(telaInicial);
		painel.add(resultado);
		
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
	}

}
