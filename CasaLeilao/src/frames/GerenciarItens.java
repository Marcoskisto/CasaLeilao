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
import javax.swing.JTable;
import javax.swing.JButton;

public class GerenciarItens extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	private JTextField textField_11;

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
		setTitle("Gerenciar Itens");
		setBounds(100, 100, 1073, 527);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(46, 69, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 140, 378, 37);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 69, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AUTOM\u00D3VEL", "IM\u00D3VEL"}));
		comboBox.setBounds(279, 69, 128, 20);
		getContentPane().add(comboBox);
		
		JLabel lblAnoDoBem = new JLabel("ANO do Bem");
		lblAnoDoBem.setBounds(45, 54, 87, 14);
		getContentPane().add(lblAnoDoBem);
		
		JLabel lblLanceMnimo = new JLabel("LANCE M\u00CDNIMO");
		lblLanceMnimo.setBounds(161, 54, 86, 14);
		getContentPane().add(lblLanceMnimo);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(279, 54, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblDescrioDoBem = new JLabel("Descri\u00E7\u00E3o do bem");
		lblDescrioDoBem.setBounds(46, 125, 111, 14);
		getContentPane().add(lblDescrioDoBem);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(46, 215, 164, 213);
		getContentPane().add(layeredPane);
		
		JLabel lblVeculo = new JLabel("VE\u00CDCULO");
		lblVeculo.setBounds(52, 11, 67, 14);
		layeredPane.add(lblVeculo);
		
		JLabel lblCor = new JLabel("COR");
		lblCor.setBounds(10, 41, 46, 14);
		layeredPane.add(lblCor);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 57, 128, 20);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setBounds(10, 104, 60, 14);
		layeredPane.add(lblModelo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 118, 128, 20);
		layeredPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPlaca = new JLabel("PLACA");
		lblPlaca.setBounds(10, 149, 46, 14);
		layeredPane.add(lblPlaca);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 170, 128, 20);
		layeredPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(229, 215, 195, 213);
		getContentPane().add(layeredPane_1);
		
		JLabel lblImvel = new JLabel("IM\u00D3VEL");
		lblImvel.setBounds(66, 0, 67, 14);
		layeredPane_1.add(lblImvel);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 55, 76, 20);
		layeredPane_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblrea = new JLabel("\u00C1REA");
		lblrea.setBounds(10, 41, 46, 14);
		layeredPane_1.add(lblrea);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 102, 46, 14);
		layeredPane_1.add(lblRua);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 116, 117, 20);
		layeredPane_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(10, 170, 117, 20);
		layeredPane_1.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 155, 46, 14);
		layeredPane_1.add(lblCidade);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(72, 86, 86, 14);
		layeredPane_1.add(lblEndereo);
		
		JLabel lblN = new JLabel("n\u00BA");
		lblN.setBounds(138, 102, 46, 14);
		layeredPane_1.add(lblN);
		
		textField_9 = new JTextField();
		textField_9.setBounds(137, 116, 43, 20);
		layeredPane_1.add(textField_9);
		textField_9.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(137, 170, 43, 20);
		layeredPane_1.add(comboBox_1);
		
		JLabel lblPavimentosandares = new JLabel("Andares");
		lblPavimentosandares.setBounds(117, 41, 67, 14);
		layeredPane_1.add(lblPavimentosandares);
		
		textField_8 = new JTextField();
		textField_8.setBounds(117, 55, 67, 20);
		layeredPane_1.add(textField_8);
		textField_8.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(460, 111, 17, 317);
		getContentPane().add(separator);
		
		table = new JTable();
		table.setBounds(487, 98, 547, 253);
		getContentPane().add(table);
		
		JButton btnSalvarincluir = new JButton("INCLUIR");
		btnSalvarincluir.setBounds(173, 450, 140, 23);
		getContentPane().add(btnSalvarincluir);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(667, 450, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(792, 450, 89, 23);
		getContentPane().add(btnExcluir);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(578, 391, 378, 37);
		getContentPane().add(textField_11);

	}
}
