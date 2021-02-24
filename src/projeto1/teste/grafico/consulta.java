package projeto1.teste.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class consulta implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame janela = new JFrame("Tela de Consulta");
		
		JTextField matricula = new JTextField(11);
		JButton consultando = new JButton(" Consultar ");
		JButton telaInicial = new JButton(" Menu Inicial ");

		consultando.addActionListener(null);
		telaInicial.addActionListener(new TesteInterfaceGrafica());
		
		JPanel painel = new JPanel();
		painel.add(new JLabel(" Informe a matrícula: "));
		painel.add(matricula);
		painel.add(consultando);
		painel.add(telaInicial);

		
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
	}

}
