package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import classesBasicas.*;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import java.awt.Color;

public class GerenciarItens extends JInternalFrame {
	private JTextField fieldAno;
	private JTextField fieldDescricao;
	private JTextField fieldLance;
	private JTextField fieldVeiculoCor;
	private JTextField fieldVeiculoModelo;
	private JTextField fieldVeiculoPlaca;
	private JTextField fieldImovelArea;
	private JTextField fieldImovelRua;
	private JTextField fieldImoveilAndares;
	private JTextField fieldImovelNumero;
	private JTextField fieldImovelCidade;
	private JTextField fieldImovelEstado;
	private JTable table;
	
	static private String[][] dadosDaTabela= {};
	static DefaultTableModel tabelaItens;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarItens frame = new GerenciarItens();
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
	public GerenciarItens() {
		setTitle("Gerenciar Itens");
		setBounds(100, 100, 1073, 566);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(487, 133, 560, 317);
		getContentPane().add(scrollPane);
		
		carregarDadosItens();
		
		table = new JTable(tabelaItens);
		scrollPane.setViewportView(table);
		
		fieldAno = new JTextField();
		fieldAno.setBounds(45, 73, 86, 20);
		getContentPane().add(fieldAno);
		fieldAno.setColumns(10);
		
		fieldDescricao = new JTextField();
		fieldDescricao.setBounds(45, 126, 378, 37);
		getContentPane().add(fieldDescricao);
		fieldDescricao.setColumns(10);
		
		fieldLance = new JTextField();
		fieldLance.setBounds(161, 73, 86, 20);
		getContentPane().add(fieldLance);
		fieldLance.setColumns(10);
		
		JLabel lblAnoDoBem = new JLabel("ANO do Bem");
		lblAnoDoBem.setBounds(45, 60, 87, 14);
		getContentPane().add(lblAnoDoBem);
		
		JLabel lblLanceMnimo = new JLabel("LANCE M\u00CDNIMO");
		lblLanceMnimo.setBounds(161, 60, 86, 14);
		getContentPane().add(lblLanceMnimo);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(209, 190, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblDescrioDoBem = new JLabel("Descri\u00E7\u00E3o do bem");
		lblDescrioDoBem.setBounds(45, 110, 111, 14);
		getContentPane().add(lblDescrioDoBem);
		
		JLayeredPane paneVeiculo = new JLayeredPane();
		paneVeiculo.setBounds(46, 237, 164, 213);
		getContentPane().add(paneVeiculo);
		
		JLabel lblCor = new JLabel("COR");
		lblCor.setBounds(10, 41, 46, 14);
		paneVeiculo.add(lblCor);
		
		fieldVeiculoCor = new JTextField();
		fieldVeiculoCor.setBounds(10, 57, 128, 20);
		paneVeiculo.add(fieldVeiculoCor);
		fieldVeiculoCor.setColumns(10);
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setBounds(10, 104, 60, 14);
		paneVeiculo.add(lblModelo);
		
		fieldVeiculoModelo = new JTextField();
		fieldVeiculoModelo.setBounds(10, 118, 128, 20);
		paneVeiculo.add(fieldVeiculoModelo);
		fieldVeiculoModelo.setColumns(10);
		
		JLabel lblPlaca = new JLabel("PLACA");
		lblPlaca.setBounds(10, 149, 46, 14);
		paneVeiculo.add(lblPlaca);
		
		fieldVeiculoPlaca = new JTextField();
		fieldVeiculoPlaca.setBounds(10, 170, 128, 20);
		paneVeiculo.add(fieldVeiculoPlaca);
		fieldVeiculoPlaca.setColumns(10);
		
		JLayeredPane paneImovel = new JLayeredPane();
		paneImovel.setBounds(229, 237, 195, 213);
		getContentPane().add(paneImovel);
		
		fieldImovelArea = new JTextField();
		fieldImovelArea.setEnabled(false);
		fieldImovelArea.setBounds(10, 55, 76, 20);
		paneImovel.add(fieldImovelArea);
		fieldImovelArea.setColumns(10);
		
		JLabel lblrea = new JLabel("\u00C1REA");
		lblrea.setBounds(10, 41, 46, 14);
		paneImovel.add(lblrea);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 102, 46, 14);
		paneImovel.add(lblRua);
		
		fieldImovelRua = new JTextField();
		fieldImovelRua.setEnabled(false);
		fieldImovelRua.setBounds(10, 116, 117, 20);
		paneImovel.add(fieldImovelRua);
		fieldImovelRua.setColumns(10);
		
		fieldImovelCidade = new JTextField();
		fieldImovelCidade.setEnabled(false);
		fieldImovelCidade.setBounds(10, 170, 117, 20);
		paneImovel.add(fieldImovelCidade);
		fieldImovelCidade.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 155, 46, 14);
		paneImovel.add(lblCidade);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(72, 86, 86, 14);
		paneImovel.add(lblEndereo);
		
		JLabel lblN = new JLabel("n\u00BA");
		lblN.setBounds(138, 102, 46, 14);
		paneImovel.add(lblN);
		
		fieldImovelNumero = new JTextField();
		fieldImovelNumero.setEnabled(false);
		fieldImovelNumero.setBounds(137, 116, 43, 20);
		paneImovel.add(fieldImovelNumero);
		fieldImovelNumero.setColumns(10);
		
		JLabel lblPavimentosandares = new JLabel("Andares");
		lblPavimentosandares.setBounds(117, 41, 67, 14);
		paneImovel.add(lblPavimentosandares);
		
		fieldImoveilAndares = new JTextField();
		fieldImoveilAndares.setEnabled(false);
		fieldImoveilAndares.setBounds(117, 55, 67, 20);
		paneImovel.add(fieldImoveilAndares);
		fieldImoveilAndares.setColumns(10);
		
		fieldImovelEstado = new JTextField();
		fieldImovelEstado.setEnabled(false);
		fieldImovelEstado.setBounds(135, 170, 50, 20);
		paneImovel.add(fieldImovelEstado);
		fieldImovelEstado.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(138, 155, 46, 14);
		paneImovel.add(lblEstado);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(460, 133, 17, 317);
		getContentPane().add(separator);
		
		JButton btnExcluir = new JButton("EXCLUIR ITEM");
		btnExcluir.addActionListener(new ActionListener() {
			//excluir item da lista de itens
			public void actionPerformed(ActionEvent e) {
				Leilao leilao = TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao);
				if(leilao.getItens().size()>0) {
					//remove da lista de itens
					leilao.removeItemPorId(Integer.parseInt((String) tabelaItens.getValueAt(table.getSelectedRow(), 0)));
				
					//remove da tabela de itens exibida na janela
					tabelaItens.removeRow(table.getSelectedRow());
				}
			}
		});
		btnExcluir.setBounds(720, 472, 140, 37);
		getContentPane().add(btnExcluir);
		
		JRadioButton rdbtnVeculo = new JRadioButton("Ve\u00EDculo");
		rdbtnVeculo.setSelected(true);
		rdbtnVeculo.setBounds(109, 207, 69, 23);
		getContentPane().add(rdbtnVeculo);
		rdbtnVeculo.setActionCommand("veiculo");
		
		JRadioButton rdbtnImvel = new JRadioButton("Im\u00F3vel");
		rdbtnImvel.setBounds(288, 207, 66, 23);
		getContentPane().add(rdbtnImvel);
		rdbtnImvel.setActionCommand("imovel");
		rdbtnImvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldVeiculoCor.setEnabled(false);
				fieldVeiculoModelo.setEnabled(false);
				fieldVeiculoPlaca.setEnabled(false);
				
				fieldImoveilAndares.setEnabled(true);
				fieldImovelArea.setEnabled(true);
				fieldImovelCidade.setEnabled(true);
				fieldImovelEstado.setEnabled(true);
				fieldImovelNumero.setEnabled(true);
				fieldImovelRua.setEnabled(true);

				
			}
		});
		rdbtnVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fieldVeiculoCor.setEnabled(true);
				fieldVeiculoModelo.setEnabled(true);
				fieldVeiculoPlaca.setEnabled(true);
				
				fieldImoveilAndares.setEnabled(false);
				fieldImovelArea.setEnabled(false);
				fieldImovelCidade.setEnabled(false);
				fieldImovelEstado.setEnabled(false);
				fieldImovelNumero.setEnabled(false);
				fieldImovelRua.setEnabled(false);			
			}
			
		});
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnImvel);
		bg.add(rdbtnVeculo);
		
		
		
		JButton btnIncluirItem = new JButton("INCLUIR");
		btnIncluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				// instancia e add novo item na lista de itens do leilao de acordo com o tipo
				if(rdbtnVeculo.isSelected()) {
					System.out.println("teste");
					Veiculo novoVeiculo = new Veiculo();
					novoVeiculo.setCor(fieldVeiculoCor.getText());
					novoVeiculo.setModelo(fieldVeiculoModelo.getText());
					novoVeiculo.setPlaca(fieldVeiculoPlaca.getText());
					
					novoVeiculo.setAno(fieldAno.getText());
					novoVeiculo.setDescricao(fieldDescricao.getText());
					novoVeiculo.setLanceMinimo(Double.valueOf(fieldLance.getText()));
					
					//adiciona novo veiculo na lista de itens do leilao
					TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao).getItens().add(novoVeiculo);
					
					// adiciona nova linha na tabela exibida
					String[] row = {Integer.toString(novoVeiculo.getIdItem()),novoVeiculo.getAno(),Double.toString(novoVeiculo.getLanceMinimo()),novoVeiculo.getDescricao()};
					tabelaItens.addRow(row);
				}else {
					Imovel novoItem = new Imovel();
					novoItem.setArea(Double.valueOf(fieldImovelArea.getText()));
					novoItem.setEndereco(new Endereco(fieldImovelRua.getText(),fieldImovelNumero.getText(),fieldImovelCidade.getText(),fieldImovelEstado.getText()));
					
					novoItem.setAno(fieldAno.getText());
					novoItem.setDescricao(fieldDescricao.getText());
					novoItem.setLanceMinimo(Double.valueOf(fieldLance.getText()));

					//adiciona novo imóvel na lista de itens do leilao
					TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao).getItens().add(novoItem);
					//adiciona nova linha na tabela exibida
					String[] row = {Integer.toString(novoItem.getIdItem()),novoItem.getAno(),Double.toString(novoItem.getLanceMinimo()),novoItem.getDescricao()};
					tabelaItens.addRow(row);
				}
				
				
			}
		});
		btnIncluirItem.setBounds(173, 472, 140, 37);
		getContentPane().add(btnIncluirItem);
		
		JLabel lblGerenciarItens = new JLabel("GERENCIAR ITENS");
		lblGerenciarItens.setBounds(424, 11, 134, 14);
		getContentPane().add(lblGerenciarItens);
		
		JButton button = new JButton("<<  VOLTAR");
		button.setBackground(new Color(255, 165, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.abrirTelaGerenciarLeiloes();
				
				//FECHA A JANELA A JANELA ATUAL
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		button.setBounds(936, 11, 111, 23);
		getContentPane().add(button);
	}
}

