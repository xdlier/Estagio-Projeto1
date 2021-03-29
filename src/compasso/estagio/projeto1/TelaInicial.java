package compasso.estagio.projeto1;

import java.util.HashMap;
import java.util.Scanner;

public class TelaInicial {

	private HashMap<Integer, Funcionario> funcionarios = new HashMap<Integer, Funcionario>();
	Scanner read = new Scanner(System.in);

	public void telaInicial() {

		System.out.println("Que atividade gostaria de realizar:\nA) Cadastrar funcionario\n"
				+ "B) Registrar ponto\nC) Consultar ponto de funcionario");
		String escolha = read.next();

		if (escolha.equalsIgnoreCase("a")) {
			funcionarios = Cadastrador.cadastrarFuncionario();
			telaInicial();
		} else if (escolha.equalsIgnoreCase("b")) {
			BatedorDePonto.baterPontoFuncionario(funcionarios);
			telaInicial();
		} else if (escolha.equalsIgnoreCase("c")) {
			Consultador.consultaPontosFuncionario(funcionarios);
			telaInicial();
		} else {
			System.out.println("Op��o incorreta, tente novamente");
			telaInicial();
		}
	}
}
