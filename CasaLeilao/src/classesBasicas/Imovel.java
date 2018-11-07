package classesBasicas;

import lombok.*;

@Getter @Setter
public class Imovel extends Item{
	private double area;
	private String endereco;
	private int nAndares;
}
