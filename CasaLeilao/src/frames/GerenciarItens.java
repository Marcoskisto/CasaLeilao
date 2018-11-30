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

import classesBasicas.*;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

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

	/**
	 * Create the frame.
	 */
	public GerenciarItens() {
		setClosable(true);
		setTitle("Gerenciar Itens");
		setBounds(100, 100, 1073, 527);
		getContentPane().setLayout(null);
		
		fieldAno = new JTextField();
		fieldAno.setBounds(46, 69, 86, 20);
		getContentPane().add(fieldAno);
		fieldAno.setColumns(10);
		
		fieldDescricao = new JTextField();
		fieldDescricao.setBounds(46, 140, 378, 37);
		getContentPane().add(fieldDescricao);
		fieldDescricao.setColumns(10);
		
		fieldLance = new JTextField();
		fieldLance.setBounds(161, 69, 86, 20);
		getContentPane().add(fieldLance);
		fieldLance.setColumns(10);
		
		JLabel lblAnoDoBem = new JLabel("ANO do Bem");
		lblAnoDoBem.setBounds(45, 54, 87, 14);
		getContentPane().add(lblAnoDoBem);
		
		JLabel lblLanceMnimo = new JLabel("LANCE M\u00CDNIMO");
		lblLanceMnimo.setBounds(161, 54, 86, 14);
		getContentPane().add(lblLanceMnimo);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(308, 54, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblDescrioDoBem = new JLabel("Descri\u00E7\u00E3o do bem");
		lblDescrioDoBem.setBounds(46, 125, 111, 14);
		getContentPane().add(lblDescrioDoBem);
		
		JLayeredPane paneVeiculo = new JLayeredPane();
		paneVeiculo.setBounds(46, 215, 164, 213);
		getContentPane().add(paneVeiculo);
		
		JLabel lblVeculo = new JLabel("VE\u00CDCULO");
		lblVeculo.setBounds(52, 11, 67, 14);
		paneVeiculo.add(lblVeculo);
		
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
		paneImovel.setBounds(229, 215, 195, 213);
		getContentPane().add(paneImovel);
		
		JLabel lblImvel = new JLabel("IM\u00D3VEL");
		lblImvel.setBounds(66, 0, 67, 14);
		paneImovel.add(lblImvel);
		
		fieldImovelArea = new JTextField();
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
		fieldImovelRua.setBounds(10, 116, 117, 20);
		paneImovel.add(fieldImovelRua);
		fieldImovelRua.setColumns(10);
		
		fieldImovelCidade = new JTextField();
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
		fieldImovelNumero.setBounds(137, 116, 43, 20);
		paneImovel.add(fieldImovelNumero);
		fieldImovelNumero.setColumns(10);
		
		JLabel lblPavimentosandares = new JLabel("Andares");
		lblPavimentosandares.setBounds(117, 41, 67, 14);
		paneImovel.add(lblPavimentosandares);
		
		fieldImoveilAndares = new JTextField();
		fieldImoveilAndares.setBounds(117, 55, 67, 20);
		paneImovel.add(fieldImoveilAndares);
		fieldImoveilAndares.setColumns(10);
		
		fieldImovelEstado = new JTextField();
		fieldImovelEstado.setBounds(135, 170, 50, 20);
		paneImovel.add(fieldImovelEstado);
		fieldImovelEstado.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(138, 155, 46, 14);
		paneImovel.add(lblEstado);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(460, 111, 17, 317);
		getContentPane().add(separator);
		
		JButton btnIncluirItem = new JButton("INCLUIR");
		btnIncluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*
				//CONTINUAR
				if(Integer.valueOf(comboBoxTipo.getSelectedIndex())==0) {
					Veiculo novoVeiculo = new Veiculo();
					novoVeiculo.setCor(fieldVeiculoCor.getText());
					novoVeiculo.setModelo(fieldVeiculoModelo.getText());
					novoVeiculo.setPlaca(fieldVeiculoPlaca.getText());
					
					novoVeiculo.setAno(fieldAno.getText());
					novoVeiculo.setDescricao(fieldDescricao.getText());
					novoVeiculo.setLanceMinimo(Double.valueOf(fieldLance.getText()));
					
				}else {
					Imovel novoImovel = new Imovel();
					novoImovel.setArea(Integer.valueOf(fieldImovelArea.getText()));
					novoImovel.setEndereco(new Endereco(fieldImovelRua.getText(),fieldImovelNumero.getText(),fieldImovelCidade.getText(),fieldImovelEstado.getText()));
					
					novoImovel.setAno(fieldAno.getText());
					novoImovel.setDescricao(fieldDescricao.getText());
					novoImovel.setLanceMinimo(Double.valueOf(fieldLance.getText()));
				}
				*/
				
			}
		});
		btnIncluirItem.setBounds(173, 450, 140, 23);
		getContentPane().add(btnIncluirItem);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(667, 450, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(792, 450, 89, 23);
		getContentPane().add(btnExcluir);
		
		JRadioButton rdbtnVeculo = new JRadioButton("Ve\u00EDculo");
		rdbtnVeculo.setBounds(266, 68, 69, 23);
		getContentPane().add(rdbtnVeculo);
		rdbtnVeculo.setActionCommand("veiculo");
		
		JRadioButton rdbtnImvel = new JRadioButton("Im\u00F3vel");
		rdbtnImvel.setBounds(337, 68, 66, 23);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 114, 485, 284);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}

