package compasso.estagio.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastrador {

	private List<Funcionario> funcionarios = new ArrayList<>();
	Scanner read = new Scanner(System.in);

	public List<Funcionario> cadastrarFuncionario() {
		String nome, matricula, cargo;
		System.out.println("Informe o nome:");
		nome = read.next();
		System.out.println("Informe a matrícula:");
		matricula = read.next();
		System.out.println("Informe o cargo:");
		cargo = read.next();
		funcionarios.add(new Funcionario(nome, matricula, cargo));

		return funcionarios;
	}

}
