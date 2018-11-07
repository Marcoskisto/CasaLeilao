package classesBasicas;

import java.util.LinkedList;

import lombok.*;

@Getter @Setter @AllArgsConstructor

public class Leilao {
	private int idLeilao;
	private LinkedList<Item> itens;
	private String dataHoraInicio;
	private String dataHoraFim;
	private String bancoCnpj;
	private String status;
}
