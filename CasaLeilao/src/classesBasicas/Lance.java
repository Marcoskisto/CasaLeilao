package classesBasicas;

import lombok.*;

@Getter @Setter
public class Lance {
	private int idLance;
	private int idItem;
	private String cpfCliente;
	private double valorLance;
	
	public Lance(int idItem, String cpfCliente, double valorLance) {
		this.idLance=UnikeId.getIdKey();
		this.idItem=idItem;
		this.cpfCliente=cpfCliente;
		this.valorLance=valorLance;
	}
	

	
}
