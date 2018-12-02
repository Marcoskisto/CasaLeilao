package classesBasicas;

import java.util.LinkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 

public class Cliente  {
	private String nome;
	private String cpf;
	private String senha;
	
	
	public Cliente(String nome,String cpf,String senha) {
		this.nome=nome;
		this.cpf=cpf;
		this.senha=senha;

	}
	public void updateCliente(Cliente newCliente) {
		this.nome=newCliente.getNome();
		this.senha=newCliente.getSenha();
	}
	   
}
