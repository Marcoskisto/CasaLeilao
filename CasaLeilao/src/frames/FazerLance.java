package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import classesBasicas.Item;
import classesBasicas.Lance;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseMotionAdapter;

public class FazerLance extends JInternalFrame {
	private JTable table;
	private JTextField fieldValor;

	static private String[][] dadosDaTabela= {};
	static DefaultTableModel tabelaItens;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FazerLance frame = new FazerLance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void carregarDadosItens() {
		tabelaItens = new DefaultTableModel(
				dadosDaTabela, new String[] {
						"ID Item", "Ano", "Lance Mínimo", "Descricao"
				}) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		
		String[] linha;
		for(Item item: TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao).getItens()) {
			linha = new String[5];
			linha[0] = Integer.toString(item.getIdItem());
			linha[1] = item.getAno();
			linha[2] = Double.toString(item.getLanceMinimo());
			linha[3] = item.getDescricao();
			
			tabelaItens.addRow(linha);
			
		}
	}
	
	/**
	 * Create the frame.
	 */
	public FazerLance() {
		setTitle("FAZER LANCE");
		setBounds(100, 100, 702, 504);
		getContentPane().setLayout(null);

		JTextArea textPaneItem = new JTextArea();
		textPaneItem.setEditable(false);
		textPaneItem.setBounds(184, 265, 346, 88);
		getContentPane().add(textPaneItem);
		textPaneItem.setText("teste de campo");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				try {
				
					if(TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao).getItens().size()>0) {
						//lista de itens
						Item item=TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao).getItemPorId(Integer.parseInt((String) tabelaItens.getValueAt(table.getSelectedRow(), 0)));
						textPaneItem.setText("Id Item:"+item.getIdItem()+"\n Ano do bem: "+item.getAno()+"\n Descrição: "+item.getDescricao()+"\n Lance mínimo: "+item.getLanceMinimo());
					}
				}catch(Exception e) {
					
				}
			}
		});

		scrollPane.setBounds(84, 77, 560, 177);
		getContentPane().add(scrollPane);
		
		carregarDadosItens();
		
		table = new JTable(tabelaItens);
		scrollPane.setViewportView(table);

		
		JLabel lblSelecioneUmLeilo = new JLabel("SELECIONE UM ITEM E DIGITE O VALOR DO LANCE:");
		lblSelecioneUmLeilo.setBounds(221, 40, 324, 14);
		getContentPane().add(lblSelecioneUmLeilo);
		
		JButton btnNewButton = new JButton("Registrar Lance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idItem = Integer.parseInt((String) tabelaItens.getValueAt(table.getSelectedRow(), 0));
				Lance novoLance = new Lance(idItem,TelaPrincipal.loginCpf, Double.parseDouble(fieldValor.getText()));
				
				//Cadastra novo lance na lista de lances do CasaLeilao
				//Cadastra o id do lance no respectivo item se o lance for o menor ja incluído
				TelaPrincipal.casa.addLance(novoLance, TelaPrincipal.idLeilao);
			}
		});
		btnNewButton.setBounds(285, 425, 147, 38);
		getContentPane().add(btnNewButton);
		
		
		JLabel lblDetalhesDoItem = new JLabel("Detalhes do ITEM: ");
		lblDetalhesDoItem.setBounds(52, 293, 122, 14);
		getContentPane().add(lblDetalhesDoItem);
		
		fieldValor = new JTextField();
		fieldValor.setBounds(294, 364, 122, 32);
		getContentPane().add(fieldValor);
		fieldValor.setColumns(10);
		
		JLabel lblValorDoLance = new JLabel("Valor do Lance: ");
		lblValorDoLance.setBounds(194, 373, 112, 14);
		getContentPane().add(lblValorDoLance);
		
		JButton button = new JButton("<< Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SelecionarLeilaoParaLance novaTela = new SelecionarLeilaoParaLance();
				TelaPrincipal.desktopPane.add(novaTela);
				novaTela.setVisible(true);
				
				//fechar tela atual
				try {
					setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBackground(Color.ORANGE);
		button.setBounds(10, 11, 89, 23);
		getContentPane().add(button);
		

	}
}
