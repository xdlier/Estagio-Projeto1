package compasso.estagio.projeto1;

import java.util.HashMap;
import java.util.Scanner;

public class BatedorDePonto {

	static Scanner read = new Scanner(System.in);

	public static void baterPontoFuncionario(HashMap<Integer, Funcionario> funcionarios) {

		Funcionario funcionario = new Funcionario();
		if (funcionarios.isEmpty()) {
			System.out.println("Não há funcionários cadastrados.");
			return;
		}

		System.out.println("Informe o número de matricula:");
		funcionario = funcionarios.get(read.nextInt());
		
		if (funcionario==null) {
			System.out.println("Matricula incorreta, tente novamente");
			baterPontoFuncionario(funcionarios);
			return;
		}
		funcionario.batendoPonto();
	}

}
