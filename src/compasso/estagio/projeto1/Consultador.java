package compasso.estagio.projeto1;

import java.util.HashMap;
import java.util.Scanner;

public class Consultador {

	Scanner read = new Scanner(System.in);

	public void consultaPontosFuncionario(HashMap<Integer, Funcionario> funcionarios) {

		Funcionario funcionario = new Funcionario();
		if (funcionarios.isEmpty()) {
			System.out.println("N�o h� funcion�rios cadastrados.");
			return;
		}

		System.out.println("Informe o n�mero de matricula:");
		funcionario = funcionarios.get(read.nextInt());

		if (funcionario==null) {
			System.out.println("Matricula incorreta, tente novamente");
			consultaPontosFuncionario(funcionarios);
			return;
		}
		funcionario.consultaPontos();
	}

}
