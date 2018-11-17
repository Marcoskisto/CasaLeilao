package classesBasicas;

import java.util.LinkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor

public class Cliente {
	private String nome;
	private String cpf;
	private String senha;
	private LinkedList<Lance> lances;
	
	public Cliente(String nome,String cpf,String senha) {
		this.nome=nome;
		this.cpf=cpf;
		this.senha=senha;
		this.lances=new LinkedList<Lance>();
	}
	public void updateCliente(Cliente newCliente) {
		this.nome=newCliente.getNome();
		this.senha=newCliente.getSenha();
		this.lances=new LinkedList<Lance>();
	}
	   
}
