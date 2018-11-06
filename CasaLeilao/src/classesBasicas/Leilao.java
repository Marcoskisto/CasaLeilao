package classesBasicas;

import java.util.LinkedList;

import lombok.*;

@Getter
@Setter
public class Leilao {
	private LinkedList<Item> itens;
	private String dataHoraInicio;
	private String dataHoraFim;
	private String bancoCnpj;
	private String status;
}
