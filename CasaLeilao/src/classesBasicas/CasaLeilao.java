package classesBasicas;

import java.util.LinkedList;

import lombok.*;

@Getter
@Setter
public class CasaLeilao {
	private String nome;
	private LinkedList<Leilao> leiloes;
	private LinkedList<Cliente> clientes;
	private LinkedList<Banco> bancos;
	
}
