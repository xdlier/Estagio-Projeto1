import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ponto {

	private LocalDateTime agora;
	private String data, entradaHora, saidaHora;
	
	public Ponto () {
		agora = LocalDateTime.now();
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		data = formatterData.format(agora);
		entradaHora = "00:00:00";
		saidaHora = "00:00:00";
	}

	public void baterpontoEntrada() {
		agora = LocalDateTime.now();
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		entradaHora = formatterHora.format(agora);
	}

	public void baterpontoSaida() {
		agora = LocalDateTime.now();
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		saidaHora = formatterHora.format(agora);
	}

	public String data() {
		return data;
	}
	
	public String entrada() {
		return entradaHora;
	}
	
	public String saida() {
		return saidaHora;
	}

}