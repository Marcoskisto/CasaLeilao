package classesBasicas;


import lombok.*;

@Getter @Setter 
public class Item {
	private int idItem; 
	private String descricao;
	private double lanceMinimo;
	private String ano;
	private int tipo;
	private int idMenorLance;
	
	public Item() {
		this.idItem=UnikeId.getIdKey();
		
	}
	public void updateItem(Item item) {
		this.setDescricao(item.getDescricao());
		this.setLanceMinimo(item.getLanceMinimo());
		this.setAno(item.getAno());
		this.setTipo(item.getTipo());
	}
	
	public void setSeMenorLance(int idLance) {
		if()
	}
	
}
