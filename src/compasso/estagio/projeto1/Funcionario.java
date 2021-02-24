package compasso.estagio.projeto1;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private String nome;
	private String matricula;
	private String cargo;
	private List<Ponto> pontos = new ArrayList<>();

	public Funcionario(String nome, String matricula, String cargo) {
		try {
			this.nome = nome;
			this.cargo = cargo;
			this.matricula = matricula;
			System.out.println("Conta cadastrada com sucesso!");
		} catch (NullPointerException e) {
			System.out.println("Erro, por favor, tente novamente");
		}

	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return nome + "\n" + matricula + "\n" + cargo;
	}

	public void batendoPonto() {

		Ponto ponto = new Ponto();
		if (pontos.isEmpty()) {
			ponto.baterpontoEntrada();
			pontos.add(ponto);
			System.out.println(
					"Entrada realizada às: " + pontos.get(0).entrada() + " " + pontos.get(pontos.size() - 1).data());
		} else if (ponto.data().equals(pontos.get(pontos.size() - 1).data())
				&& pontos.get(pontos.size() - 1).saida().equals("00:00:00")) {
			pontos.get(pontos.size() - 1).baterpontoSaida();
			System.out.println("Saída realizada às: " + pontos.get(pontos.size() - 1).saida() + " "
					+ pontos.get(pontos.size() - 1).data());
		} else if (ponto.data().equals(pontos.get(pontos.size() - 1).data())) {
			System.out.println("Pontos do dia já cadastrados");
		} else {
			ponto.baterpontoEntrada();
			pontos.add(ponto);
			System.out.println("Entrada realizada às: " + pontos.get(pontos.size() - 1).entrada() + " "
					+ pontos.get(pontos.size() - 1).data());
		}
	}

	public void consultaPontos() {
		for (int i = pontos.size() - 1; i > pontos.size() - 8; i--) {
			if(i<0) {
				System.out.println("Sem mais pontos!");
				return;
			}
			System.out.println("Data: " + pontos.get(i).data() + "\nEntrada: " + pontos.get(i).entrada() + "\nSaída: "
					+ pontos.get(i).saida());
		}
	}

}
