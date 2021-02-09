import java.util.Scanner;

public class Projeto1 {
	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		int n = 0;
		ListaFuncionario funcionario = new ListaFuncionario();

		do {
			System.out.println("Que atividade gostaria de realizar:\nA) Cadastrar funcionario\n"
					+ "B) Registrar ponto\nC) Consultar ponto de funcionario");
			String escolha = read.next();

			if (escolha.equalsIgnoreCase("a")) {
				System.out.println("Informe o nome, matricula e cargo:");
				funcionario.cadastrar(read.next(), read.next(), read.next());
			} else if (escolha.equalsIgnoreCase("b")) {
				if (funcionario.verificarLista()) {
					System.out.println("Não há funcionários cadastrados.");
				} else {
					System.out.println("Informe o número de matricula:");
					funcionario.baterPonto(read.next());
				}
			} else if (escolha.equalsIgnoreCase("c")) {
				if (funcionario.verificarLista()) {
					System.out.println("Não há funcionários cadastrados.");
				} else {
					System.out.println("Informe o número de matrícula:");
					funcionario.historicoPonto(read.next());
				}

			} else {
				System.out.println("Opção incorreta, tente novamente");
			}

			n++;
		} while (n < 10);
	}
}
