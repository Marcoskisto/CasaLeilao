package classesBasicas;


import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public abstract class Item {
	private int idItem; 
	private String descricao;
	private double lanceMinimo;
	private int ano;
	private String tipo;
	
	public Item(String descricao, double lanceMinimo, int ano) {
		this.idItem=UnikeId.getIdKey();
		this.descricao=descricao;
		this.lanceMinimo=lanceMinimo;
		this.ano=ano;
		this.tipo=null;
	}
	public void updateItem(Item item) {
		this.setDescricao(item.getDescricao());
		this.setLanceMinimo(item.getLanceMinimo());
		this.setAno(item.getAno());
		this.setTipo(item.getTipo());
	}
}
