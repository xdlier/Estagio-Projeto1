package compasso.estagio.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consultador {

	private List<Funcionario> funcionarios = new ArrayList<>();
	Scanner read = new Scanner(System.in);

	public void consultaPontosFuncionario(List<Funcionario> funcionarios) {

		this.funcionarios = funcionarios;
		if (funcionarios.isEmpty()) {
			System.out.println("Não há funcionários cadastrados.");
			return;
		}
		System.out.println("Informe o número de matrícula:");

		int i = indexFuncionario(read.next());
		if (i < 0) {
			System.out.println("Matricula incorreta, tente novamente");
			consultaPontosFuncionario(funcionarios);
			return;
		}
		funcionarios.get(i).consultaPontos();
	}

	public int indexFuncionario(String matricula) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (funcionarios.get(i).getMatricula().equals(matricula))
				return i;
		}
		return -1;
	}

}
