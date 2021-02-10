import java.util.Scanner;

public class TelaInicial {
	
	private ListaFuncionario funcionario = new ListaFuncionario();
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
			System.out.println("Op��o incorreta, tente novamente");
			telaInicial();
		}
	}
	
	public void cadastrarFuncionario() {
		String nome, matricula, cargo;
		System.out.println("Informe o nome:");
		nome = read.next();
		System.out.println("Informe a matr�cula:");
		matricula = read.next();
		System.out.println("Informe o cargo:");
		cargo = read.next();
		funcionario.cadastrar(nome, matricula, cargo);
		
		telaInicial();
	}
	
	public void baterPontoFuncionario() {
		if (funcionario.verificarLista()) {
			System.out.println("N�o h� funcion�rios cadastrados.");
		} else {
			System.out.println("Informe o n�mero de matricula:");
			funcionario.baterPonto(read.next());
		}
		
		telaInicial();
	}
	
	public void consultaPontosFuncionario() {
		if (funcionario.verificarLista()) {
			System.out.println("N�o h� funcion�rios cadastrados.");
		} else {
			System.out.println("Informe o n�mero de matr�cula:");
			funcionario.historicoPonto(read.next());
		}
		telaInicial();
	}
}
