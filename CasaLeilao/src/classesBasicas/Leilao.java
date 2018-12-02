package classesBasicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import lombok.*;
import sun.security.x509.UniqueIdentity;

@Getter @Setter 

public class Leilao {
	private int idLeilao;
	private LinkedList<Item> itens;
	private Date dataHoraInicio;
	private String bancoCnpj;
	private StatusLeilao status;
	// (1) ABERTO - (2) EM ANDAMENTO - (3) FINALIZADO
	private Endereco endereco;
	
	public Leilao() {
		this.idLeilao=UnikeId.getIdKey();
		this.itens=new LinkedList<Item>();
		this.dataHoraInicio=new Date();
		this.bancoCnpj="pendente";
		this.status= StatusLeilao.PENDENTE;
		this.endereco=null;
	}
	
	public void updateLeilao(Leilao newLeilao) {
		this.setIdLeilao(newLeilao.getIdLeilao());
		this.setDataHoraInicio(newLeilao.getDataHoraInicio());
		this.setBancoCnpj(newLeilao.getBancoCnpj());
		this.setStatus(newLeilao.getStatus());
	}
	public void setDataHora(String data, String hora) throws ParseException{
		String novaData = data+hora;
		SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyyhh:mm");
		this.dataHoraInicio = mascara.parse(novaData);
		}
	public String getDataFormatada() {
		SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
		return mascara.format(this.dataHoraInicio);

	}
	public String getHoraFormatada() {
		SimpleDateFormat mascara= new SimpleDateFormat("hh:mm");
		return mascara.format(this.dataHoraInicio);
	}
	public Item getItemPorId(int id){
		for(Item item: this.itens) {
			if (item.getIdItem()==id) return item;
		}
		return null;
	}
	public void removeItemPorId(int id) {
		this.itens.remove(this.getItemPorId(id));
	}

}
