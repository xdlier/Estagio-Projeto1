package projeto1.teste.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesteInterfaceGrafica implements ActionListener {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Tela Inicial");

		JButton cadastro = new JButton(" Cadastrar Funcionário ");
		JButton baterPonto = new JButton(" Bater Ponto ");
		JButton consulta = new JButton(" Consulta Histórico ");

		cadastro.addActionListener(new cadastro());
		baterPonto.addActionListener(new baterPonto());
		consulta.addActionListener(new consulta());
		
		JPanel painel = new JPanel();
		painel.add(new JLabel(" O que gostaria de fazer? "));
		painel.add(cadastro);
		painel.add(baterPonto);
		painel.add(consulta);

		
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main(null);
	}

}
