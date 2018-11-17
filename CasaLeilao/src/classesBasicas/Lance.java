package classesBasicas;

import lombok.*;

@Getter @Setter
public class Lance {
	private int idLance;
	private int idItem;
	private double valorLance;
	
	public Lance(int idItem, double valorLance) {
		this.idLance=UnikeId.getIdKey();
		this.idItem=idItem;
		this.valorLance=valorLance;
	}
	
}
