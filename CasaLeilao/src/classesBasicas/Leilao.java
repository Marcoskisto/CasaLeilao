package classesBasicas;

import java.util.LinkedList;

import lombok.*;
import sun.security.x509.UniqueIdentity;

@Getter @Setter 

public class Leilao {
	private int idLeilao;
	private LinkedList<Item> itens;
	private String dataHoraInicio;
	private String bancoCnpj;
	private String status;
	
	public Leilao(String dataHoraInicio, String bancoCnpj, String status) {
		this.idLeilao=UnikeId.getIdKey();
		this.itens=new LinkedList<Item>();
		this.dataHoraInicio=dataHoraInicio;
		this.bancoCnpj=bancoCnpj;
		this.status=status;
	}
	
	public void updateLeilao(Leilao newLeilao) {
		this.setIdLeilao(newLeilao.getIdLeilao());
		this.setDataHoraInicio(newLeilao.getDataHoraInicio());
		this.setBancoCnpj(newLeilao.getBancoCnpj());
		this.setStatus(newLeilao.getStatus());
	}

}
