import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

		public void baterpontoEntrada() {
			entrada = LocalDateTime.now();
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			data = formatterData.format(entrada);
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			entradaHora = formatterHora.format(entrada);
		}

		public void baterpontoSaida() {
			saida = LocalDateTime.now();
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			data = formatterData.format(saida);
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			saidaHora = formatterHora.format(saida);
			contador=1;
		}

		public void imprimirPonto() {
			if(contador==1)
				System.out.println(data + "\n" + saidaHora);
			else
				System.out.println(data + "\n" + entradaHora);
		}

		public String verificarData() {
			agora = LocalDateTime.now();
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			data = formatterData.format(agora);
			return data;
		}

		public String data() {
			return data;
		}

	}

	public ListaPonto() {
		head = tail = previous = null;
	}

	public void baterPonto() {
		if (contador == 2) {
			Listnode verificarPonto = new Listnode(contador);
			if (tail.ponto.data().equals(verificarPonto.ponto.verificarData())) {
				System.out.println("Os pontos deste funcionário já foram marcados!");
				return;
			}
			else
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

	public void historicoPonto() {
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

	public int contador() {
		return contador;
	}

}
