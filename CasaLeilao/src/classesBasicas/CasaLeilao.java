package classesBasicas;

import java.util.LinkedList;
import lombok.*;

@Getter
@Setter
public class CasaLeilao {
	private LinkedList<Leilao> leiloes;
	private LinkedList<Cliente> clientes;
	private LinkedList<Banco> bancos;
	
	public CasaLeilao() {
		this.leiloes = new LinkedList<Leilao>();
		this.clientes = new LinkedList<Cliente>();
		this.bancos = new LinkedList<Banco>();
	}


	//metodos da lista de leiloes
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
		leiloes.remove(leiloes.indexOf(this.getLeilaoPorId(idLeilao)));
	}
	
	//metodos da lista de clientes
	public Cliente getClientePorCpf(String cpf) {
		Cliente cliente = this.getClientes().stream()
				.filter(c->c.getCpf().equals(cpf))
				.findAny().orElse(null);
		return cliente;
	}
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	public void removeCliente(String cpf) {
		clientes.remove(clientes.indexOf(this.getClientePorCpf(cpf)));
	}
	
	//metodos da lista de bancos
	public Banco getBancoPorCnpj(String cnpj) {
		Banco banco=this.getBancos().stream()
				.filter(b -> b.getCnpj().equals(cnpj))
				.findAny().orElse(null);
		return banco;
	}
	public void addBanco(Banco banco) {
		bancos.add(banco);
	}
	public void removeBanco(String cnpj) {
		bancos.remove(bancos.indexOf(this.getBancoPorCnpj(cnpj)));
	}
	
	public LinkedList<Lance> buscaLancesdoItem(int idItem) {
		LinkedList<Lance> lances = new LinkedList<Lance>();
		for(Cliente c: this.getClientes()) {
			for(Lance l: c.getLances()) {
				if(l.getIdItem()==idItem)
				lances.add(l);
			}
		}
	return lances;
	}


	public boolean login(String cpf, String senha) {	
		for(Cliente c: this.clientes) {
			if(c.getCpf().equals(cpf) && c.getSenha().equals(senha)) 
			return true;
		}
		return false;
	}



}
