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
					System.out.println("N�o h� funcion�rios cadastrados.");
				} else {
					System.out.println("Informe o n�mero de matricula:");
					funcionario.baterPonto(read.next());
				}
			} else if (escolha.equalsIgnoreCase("c")) {
				if (funcionario.verificarLista()) {
					System.out.println("N�o h� funcion�rios cadastrados.");
				} else {
					System.out.println("Informe o n�mero de matr�cula:");
					funcionario.historicoPonto(read.next());
				}

			} else {
				System.out.println("Op��o incorreta, tente novamente");
			}

			n++;
		} while (n < 10);
	}
}
