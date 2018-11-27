package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import classesBasicas.Leilao;
import javafx.scene.chart.PieChart.Data;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciarLeiloes extends JInternalFrame {
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
					GerenciarLeiloes frame = new GerenciarLeiloes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
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
			linha[1] = leilao.getDataHoraInicio().toGMTString();
			linha[2] = leilao.getBancoCnpj();
			linha[3] = Integer.toString(leilao.getItens().size());
			linha[4] = Integer.toString(leilao.getStatus());

			tabelaLeiloes.addRow(linha);
			
		}
	}
	/**
	 * Create the frame.
	 */
	public GerenciarLeiloes() {
		setClosable(true);
		setTitle("Gerenciar Leil\u00F5es");
		setBounds(100, 100, 654, 360);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneLeiloes = new JScrollPane();
		scrollPaneLeiloes.setBounds(0, 30, 638, 238);
		getContentPane().add(scrollPaneLeiloes);
		
		carregarDadosLeilao();

		table = new JTable(tabelaLeiloes);
		scrollPaneLeiloes.setViewportView(table);
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.idLeilao = Integer.parseInt((String) tabelaLeiloes.getValueAt(table.getSelectedRow(),0));
				AtualizarLeilao leilao = new AtualizarLeilao();
				TelaPrincipal.desktopPane.add(leilao);
				leilao.setVisible(true);
				
			}
		});
		btnAlterar.setBounds(110, 287, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TelaPrincipal.casa.getLeiloes().size()>0) {
					TelaPrincipal.casa.removeLeilao(Integer.parseInt((String) tabelaLeiloes.getValueAt(table.getSelectedRow(),0)));
					tabelaLeiloes.removeRow(table.getSelectedRow());
				}
			}
		});
		btnExcluir.setBounds(271, 287, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnGerenciarItens = new JButton("Editar ITENS");
		btnGerenciarItens.setBounds(415, 287, 102, 23);
		getContentPane().add(btnGerenciarItens);

	}
}
