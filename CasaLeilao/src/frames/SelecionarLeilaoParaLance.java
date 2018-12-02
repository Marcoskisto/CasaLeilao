package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classesBasicas.Leilao;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class SelecionarLeilaoParaLance extends JInternalFrame {
	private JTable table;
	static private String[][] dadosDaTabela= {};
	
	static DefaultTableModel tabelaLeiloes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionarLeilaoParaLance frame = new SelecionarLeilaoParaLance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//gerar tabela
	public static void carregarDadosLeilao() {
		tabelaLeiloes = new DefaultTableModel(
				dadosDaTabela, new String[] {
						"ID Leil\u00E3o", "Data", "Banco", "Qtd de itens", "Status"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		
		String[] linha;
		for(Leilao leilao: TelaPrincipal.casa.getLeiloes()) {
			linha = new String[5];
			linha[0] = Integer.toString(leilao.getIdLeilao());
			linha[1] = leilao.getDataHoraInicio().toLocaleString();
			linha[2] = leilao.getBancoCnpj();
			linha[3] = Integer.toString(leilao.getItens().size());
			linha[4] = leilao.getStatus().toString();

			tabelaLeiloes.addRow(linha);
			
		}
	}

	/**
	 * Create the frame.
	 */
	public SelecionarLeilaoParaLance() {
		setTitle("Fazer Lances - Selecionar Leil\u00E3o");
		setClosable(true);
		setBounds(100, 100, 710, 387);
		getContentPane().setLayout(null);
		
		//tabela
		JScrollPane scrollPaneLeiloes = new JScrollPane();
		scrollPaneLeiloes.setBounds(10, 59, 673, 238);
		getContentPane().add(scrollPaneLeiloes);
		carregarDadosLeilao();
		table = new JTable(tabelaLeiloes);
		scrollPaneLeiloes.setViewportView(table);
		
		JLabel lblSelecioneUmLeilo = new JLabel("Selecione um Leil\u00E3o para o Lance: ");
		lblSelecioneUmLeilo.setBounds(241, 34, 229, 14);
		getContentPane().add(lblSelecioneUmLeilo);
		
		JButton btnAvanar = new JButton("Avan\u00E7ar >>");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(TelaPrincipal.casa.getLeiloes().size()>0) {
					TelaPrincipal.idLeilao = Integer.parseInt((String) tabelaLeiloes.getValueAt(table.getSelectedRow(),0));
				}
				FazerLance novoLance = new FazerLance();
				TelaPrincipal.desktopPane.add(novoLance);
				novoLance.setVisible(true);
				
				// fechar janela atual
				try {
					setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAvanar.setBackground(new Color(152, 251, 152));
		btnAvanar.setBounds(298, 310, 116, 36);
		getContentPane().add(btnAvanar);
		
		JLabel lblNestaTelaS = new JLabel("OBS.: Nesta tela s\u00F3 aparecem Leil\u00F5es com Status \"EM_ANDAMENTO\"");
		lblNestaTelaS.setBounds(167, 256, 368, 24);
		getContentPane().add(lblNestaTelaS);

	}
}
