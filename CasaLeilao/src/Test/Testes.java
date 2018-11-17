package Test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import classesBasicas.*;

public class Testes {
	CasaLeilao casa = new CasaLeilao();
	@Test
	public void testesCasaLeilao() {
		System.out.println("teste");		
		
		Leilao leilao1=new Leilao("11h", "111", "Fechado");
		Leilao leilao2=new Leilao("10h", "222", "Aberto");
		Leilao leilao3=new Leilao("33h", "333", "andamento");
		
		
		//testa lista de leiloes
		casa.addLeilao(leilao1);
		assertEquals(casa.getLeiloes().size(),1);
		assertEquals(casa.getLeilaoPorId(1000001).getBancoCnpj(),"111");
		Leilao leilao = casa.getLeilaoPorId(1000001);
		System.out.println(leilao.getIdLeilao());
		
		//testa updateLeilao
		casa.getLeilaoPorId(1000001).updateLeilao(leilao2);
		System.out.println(casa.getLeilaoPorId(1000002).getBancoCnpj());
		assertEquals(casa.getLeilaoPorId(1000002).getBancoCnpj(),"222");
		
		//testa removeLeilao
		casa.addLeilao(leilao3);
		assertEquals(casa.getLeiloes().size(),2);
		casa.removeLeilao(1000003);
		assertEquals(casa.getLeiloes().size(),1);
		
		// testa lista de clientes
		Cliente cliente1 = new Cliente("marcos", "1111", "1010");
		Cliente cliente2 = new Cliente("josé", "2222", "2020");
		Cliente cliente3 = new Cliente("maria", "3333", "3030");
		
		casa.addCliente(cliente1);
		assertEquals(casa.getClientes().size(),1);
		assertEquals(casa.getClientePorCpf("1111").getCpf(),"1111");
		
		//testa incluir lance
		//testa update lance
		//testa remove lance
	}
	
		
	
	
	
}
