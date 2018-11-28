package classesBasicas;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Imovel extends Item{
	private double area;
	private Endereco endereco;
	private int nAndares;
}
