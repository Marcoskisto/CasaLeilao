package classesBasicas;

import java.util.LinkedList;

public class Main {
	public static void main(String [] args) {
	System.out.println("teste");		
	CasaLeilao casa = new CasaLeilao();
	casa.setLeiloes(new LinkedList<Leilao>());
	Leilao leilao1=new Leilao(321, new LinkedList<Item>(), "11h", "22222", "Fechado");
	Leilao leilao2=new Leilao(123, new LinkedList<Item>(), "10h", "1100000031", "Aberto");
	casa.addLeilao(leilao2);
	Leilao leilao = casa.getLeilaoPorId(123);
	System.out.println(leilao.getIdLeilao());
	casa.getLeilaoPorId(123).updateLeilao(leilao1);
	System.out.println(casa.getLeilaoPorId(321).getBancoCnpj());
	}
	
}