package classesBasicas;

import java.util.LinkedList;

import lombok.*;

@Getter
@Setter
public class CasaLeilao {
	private LinkedList<Leilao> leiloes;
	private LinkedList<Cliente> clientes;
	private LinkedList<Banco> bancos;
	
	public void addLeilao(Leilao leilao){
		leiloes.add(leilao);
	}
	//parei aqui
	public void removerLeilao(int idLeilaoRecebido){
		leiloes.removeIf(l -> leiloes : );
	}
}
