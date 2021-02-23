import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionalidades {

	private List<Funcionario> funcionarios = new ArrayList<>();
	Scanner read = new Scanner(System.in);

	public void telaInicial() {

		System.out.println("Que atividade gostaria de realizar:\nA) Cadastrar funcionario\n"
				+ "B) Registrar ponto\nC) Consultar ponto de funcionario");
		String escolha = read.next();

		if (escolha.equalsIgnoreCase("a")) {
			cadastrarFuncionario();
		} else if (escolha.equalsIgnoreCase("b")) {
			baterPontoFuncionario();
		} else if (escolha.equalsIgnoreCase("c")) {
			consultaPontosFuncionario();
		} else {
			System.out.println("Opção incorreta, tente novamente");
			telaInicial();
		}
	}

	public void cadastrarFuncionario() {
		String nome, matricula, cargo;
		System.out.println("Informe o nome:");
		nome = read.next();
		System.out.println("Informe a matrícula:");
		matricula = read.next();
		System.out.println("Informe o cargo:");
		cargo = read.next();
		funcionarios.add(new Funcionario(nome, matricula, cargo));

		telaInicial();
	}

	public void baterPontoFuncionario() {
		
		if (funcionarios.isEmpty()) {
			System.out.println("Não há funcionários cadastrados.");
			telaInicial();
		}
		
		System.out.println("Informe o número de matricula:");
		
		int i = indexFuncionario(read.next());
		if (i < 0) {
			System.out.println("Matricula incorreta, tente novamente");
			baterPontoFuncionario();
		}
		funcionarios.get(i).batendoPonto();
		telaInicial();

	}

	public void consultaPontosFuncionario() {
		if (funcionarios.isEmpty()) {
			System.out.println("Não há funcionários cadastrados.");
			telaInicial();
		}
		System.out.println("Informe o número de matrícula:");
		
		int i = indexFuncionario(read.next());
		if (i < 0) {
			System.out.println("Matricula incorreta, tente novamente");
			consultaPontosFuncionario();
		}
		funcionarios.get(i).consultaPontos();
		telaInicial();

	}

	public int indexFuncionario(String matricula) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (funcionarios.get(i).getMatricula().equals(matricula))
				return i;
		}
		return -1;
	}

}
