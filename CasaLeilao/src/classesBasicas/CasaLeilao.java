package classesBasicas;

import java.util.LinkedList;
import lombok.*;

@Getter
@Setter
public class CasaLeilao {
	private LinkedList<Leilao> leiloes;
	private LinkedList<Cliente> clientes;
	private LinkedList<Banco> bancos;
	
	public Leilao getLeilaoPorId(int idLeilao) {
		Leilao leilao=this.getLeiloes().stream()
				.filter(l-> l.getIdLeilao()==idLeilao)
				.findAny().orElse(null);
		return leilao;
	}
	public void addLeilao(Leilao leilao){
		leiloes.add(leilao);
	}
	public void removeLeilao(int idLeilao) {
		leiloes.remove(this.getLeilaoPorId(idLeilao));
	}
	public void update(int idLeilao, Leilao leilao) {
		
	}

}
