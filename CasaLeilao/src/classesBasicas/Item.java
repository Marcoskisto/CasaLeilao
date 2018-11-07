package classesBasicas;

import java.util.LinkedList;
import lombok.*;

@Getter @Setter
public abstract class Item {
	private int codigo; 
	private String descricao;
	private String lanceMinimo;
	private LinkedList<Lance> lances;
	private int ano;

}
