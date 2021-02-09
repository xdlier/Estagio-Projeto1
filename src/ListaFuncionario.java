import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListaFuncionario {

	private Listnode head;
	private Listnode tail;
	private int size = 0;

	private class Listnode {

		private Funcionario funcionario = new Funcionario();
		private Listnode next;

		private Listnode(String nome, String matricula, String cargo, Listnode next) {
			funcionario.cadastro(nome, matricula, cargo);
			this.next = next;
		}
	}

	private class Funcionario {
		private String nome;
		private String matricula;
		private String cargo;
		private ListaPonto ponto = new ListaPonto();

		public class ListaPonto {

			private Listnode head;
			private Listnode tail;
			private Listnode previous;
			private int size = 0, contador = 0;

			private class Listnode {

				private Ponto ponto = new Ponto();
				private Listnode next, previous;
				private int contador = 0;

				private Listnode(Listnode next, Listnode previous, int contador) {
					if (this.contador == contador)
						ponto.baterpontoEntrada();
					else
						ponto.baterpontoSaida();
					this.next = next;
					this.previous = previous;
				}

				private Listnode(int contador) {
					this.contador = contador;
				}

				private Listnode() {
					next = previous = null;
				}
			}

			private class Ponto {

				private LocalDateTime entrada, saida, agora;
				private String data, entradaHora, saidaHora;
				private int contador = 0;

				private void baterpontoEntrada() {
					entrada = LocalDateTime.now();
					DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					data = formatterData.format(entrada);
					DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
					entradaHora = formatterHora.format(entrada);
				}

				private void baterpontoSaida() {
					saida = LocalDateTime.now();
					DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					data = formatterData.format(saida);
					DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
					saidaHora = formatterHora.format(saida);
					contador = 1;
				}

				private void imprimirPonto() {
					if (contador == 1)
						System.out.println("Saída:" + saidaHora);
					else
						System.out.println("Entrada:" + entradaHora+ "\n" + data);
				}

				private String verificarData() {
					agora = LocalDateTime.now();
					DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					data = formatterData.format(agora);
					return data;
				}

				private String data() {
					return data;
				}

			}

			private ListaPonto() {
				head = tail = previous = null;
			}

			private void baterPonto() {
				if (contador == 2) {
					Listnode verificarPonto = new Listnode(contador);
					if (tail.ponto.data().equals(verificarPonto.ponto.verificarData())) {
						System.out.println("Os pontos deste funcionário já foram marcados!");
						return;
					} else
						contador = 0;
				}
				Listnode novoPonto = new Listnode(null, previous, contador);
				System.out.println("Ponto cadastrado com sucesso!");
				if (size == 0) {
					head = novoPonto;
				} else {
					tail.next = novoPonto;
				}
				tail = novoPonto;
				previous = tail;
				size++;
				contador++;
			}

			private void historicoPonto() {
				Listnode varre = new Listnode();
				if (size != 0) {
					varre = tail;
					for (int i = 0; i < 7; i++) {
						if (varre.previous == null) {
							varre.ponto.imprimirPonto();
							System.out.println("Sem mais pontos.");
							break;
						}
						varre.ponto.imprimirPonto();
						varre = varre.previous;
					}
				}
			}

			private int contador() {
				return contador;
			}

		}

		private Funcionario() {
			nome = "NULL";
			matricula = "0";
			cargo = "NULL";

		}

		private void cadastro(String nome, String matricula, String cargo) {
			if (nome != null && matricula != null && cargo != null) {
				this.nome = nome;
				this.cargo = cargo;
				this.matricula = matricula;
				System.out.println("Conta cadastrada com sucesso!");
			} else
				System.out.println("Erro, por favor, tente novamente");
		}

		private String nome() {
			return nome;
		}

	}

	public ListaFuncionario() {
		head = tail = null;
	}

	public void cadastrar(String nome, String matricula, String cargo) {
		if (verificarMatricula(matricula)) {
			Listnode novoFuncionario = new Listnode(nome, matricula, cargo, null);
			if (size == 0) {
				head = novoFuncionario;
			} else {
				tail.next = novoFuncionario;
			}
			tail = novoFuncionario;
			size++;
		} else
			System.out.println("Matrícula já cadastrada, por favor, tente novamente");
	}

	public boolean verificarMatricula(String matricula) {
		if (head != null) {
			Listnode varre = head;
			while (varre != null) {
				if (varre.funcionario.matricula.equals(matricula))
					return false;
				varre = varre.next;
			}
			return true;
		} else
			return true;
	}

	public void baterPonto(String matricula) {
		if (head != null) {
			if (verificarMatricula(matricula))
				System.out.println("Funcionário não encontrado!");
			else {
				Listnode varre = head;
				while (varre != null) {
					if (varre.funcionario.matricula.equals(matricula)) {
						varre.funcionario.ponto.baterPonto();
						break;
					}
					varre = varre.next;
				}
			}
		} else
			System.out.println("Nenhum funcionario cadastrado!");
	}

	public void historicoPonto(String matricula) {
		if (head != null) {
			if (verificarMatricula(matricula))
				System.out.println("Funcionário não encontrado");
			else {
				Listnode varre = head;
				while (varre != null) {
					if (varre.funcionario.matricula.equals(matricula)) {
						System.out.println("Nome:" + varre.funcionario.nome());
						varre.funcionario.ponto.historicoPonto();
						break;
					}
					varre = varre.next;
				}
			}
		} else
			System.out.println("Nenhum funcionario cadastrado!");
	}

	public boolean verificarLista() {
		if (head == null) {
			return true;
		}
		return false;
	}

}
