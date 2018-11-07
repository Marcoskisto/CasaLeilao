package classesBasicas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor

public class Cliente {
	private String nome;
	private String cpf;
	private String senha;

}
