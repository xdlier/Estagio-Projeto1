package compasso.estagio.projeto1;

import java.util.HashMap;
import java.util.Scanner;

public class Cadastrador {

	private HashMap<Integer, Funcionario> funcionarios = new HashMap<Integer, Funcionario>();
	Scanner read = new Scanner(System.in);

	public HashMap<Integer, Funcionario> cadastrarFuncionario() {
		String nome, matriculaString, cargo;
		Integer matricula;

		try {
			System.out.println("Informe o nome:");
			nome = read.nextLine();
			System.out.println("Informe a matrícula:");
			matricula = Integer.parseInt(read.nextLine());
			matriculaString = matricula.toString();
			System.out.println("Informe o cargo:");
			cargo = read.nextLine();
			funcionarios.put(matricula, new Funcionario(nome, matriculaString, cargo));
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar funcionário, tente novamente!");
			cadastrarFuncionario();
		}

		return funcionarios;
	}

}
