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
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

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


	public void fecharJanela() {
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public GerenciarLeiloes() {
		setClosable(true);
		setTitle("Gerenciar Leil\u00F5es");
		setBounds(100, 100, 950, 479);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneLeiloes = new JScrollPane();
		scrollPaneLeiloes.setBounds(0, 70, 934, 238);
		getContentPane().add(scrollPaneLeiloes);
		
		carregarDadosLeilao();

		table = new JTable(tabelaLeiloes);
		scrollPaneLeiloes.setViewportView(table);
		
		
		JButton btnAlterar = new JButton("3\u00BA - Editar Leil\u00E3o / Status");
		btnAlterar.setToolTipText("Selecione um leil\u00E3o primeiro");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.idLeilao = Integer.parseInt((String) tabelaLeiloes.getValueAt(table.getSelectedRow(),0));
				AtualizarLeilao leilao = new AtualizarLeilao();
				TelaPrincipal.desktopPane.add(leilao);
				leilao.setVisible(true);
				
				//fecha janela atual
				fecharJanela();
				
			}
		});
		btnAlterar.setBounds(501, 360, 183, 37);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Leil\u00E3o");
		btnExcluir.setToolTipText("Selecione um leil\u00E3o primeiro");
		btnExcluir.setBackground(new Color(255, 140, 0));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TelaPrincipal.casa.getLeiloes().size()>0) {
					TelaPrincipal.casa.removeLeilao(Integer.parseInt((String) tabelaLeiloes.getValueAt(table.getSelectedRow(),0)));
					tabelaLeiloes.removeRow(table.getSelectedRow());
				}
			}
		});
		btnExcluir.setBounds(721, 360, 175, 37);
		getContentPane().add(btnExcluir);
		
		JButton btnGerenciarItens = new JButton("2\u00BA - Gerenciar ITENS\r\n do Leilao");
		btnGerenciarItens.setBackground(new Color(152, 251, 152));
		btnGerenciarItens.setToolTipText("Selecione um leil\u00E3o primeiro");
		btnGerenciarItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.idLeilao = Integer.parseInt((String) tabelaLeiloes.getValueAt(table.getSelectedRow(),0));
				GerenciarItens itensLeilao = new GerenciarItens();
				TelaPrincipal.desktopPane.add(itensLeilao);
				itensLeilao.setVisible(true);
				
				//fecha janela atual
				fecharJanela();
			}
		});
		btnGerenciarItens.setBounds(261, 360, 198, 37);
		getContentPane().add(btnGerenciarItens);
		
		
		JButton btnCadastrar = new JButton("1\u00BA - Cadastrar Leil\u00E3o");
		btnCadastrar.setBackground(new Color(144, 238, 144));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ABRE A JANELA DE CADASTRAR LEILÃO
				CadastrarLeilao novoLeilao = new CadastrarLeilao();
				TelaPrincipal.desktopPane.add(novoLeilao);
				novoLeilao.setVisible(true);
				
				//FECHA A JANELA A JANELA ATUAL AO ABRIR A DE CADASTRAR LEILAO 
				fecharJanela();

			}
		});
		btnCadastrar.setBounds(45, 360, 175, 37);
		getContentPane().add(btnCadastrar);
		
		JLabel lblLeilesCadastrados = new JLabel("LEIL\u00D5ES CADASTRADOS");
		lblLeilesCadastrados.setBounds(403, 0, 150, 19);
		getContentPane().add(lblLeilesCadastrados);
		
		JLabel lblPassoCadastrarO = new JLabel("1\u00BA Passo:  Cadastrar o leilao - 2\u00BA: selecionar o Leil\u00E3o e \"Gerenciar Itens\" - 3\u00BA: Alterar Status do Leilao - Ap\u00F3s isso o cliente pode efetuar os lances.");
		lblPassoCadastrarO.setBounds(10, 312, 772, 25);
		getContentPane().add(lblPassoCadastrarO);

	}
}
