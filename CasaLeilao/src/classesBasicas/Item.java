package classesBasicas;


import lombok.*;

@Getter @Setter 
public class Item {
	private int idItem; 
	private String descricao;
	private double lanceMinimo;
	private String ano;
	private int tipo;
	private Lance MenorLance;
	
	public Item() {
		this.idItem=UnikeId.getIdKey();
		MenorLance=new Lance(0,"", 999999999);
	}
	public void updateItem(Item item) {
		this.setDescricao(item.getDescricao());
		this.setLanceMinimo(item.getLanceMinimo());
		this.setAno(item.getAno());
		this.setTipo(item.getTipo());
	}
	
	public void setSeMenorLance(Lance novoLance) {
		if(novoLance.getValorLance() < MenorLance.getValorLance()) {
			this.MenorLance.setCpfCliente(novoLance.getCpfCliente());
			this.MenorLance.setIdItem(novoLance.getIdItem());
			this.MenorLance.setIdLance(novoLance.getIdLance());
			this.MenorLance.setValorLance(novoLance.getValorLance());
		}
	}
	
}
