package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class CadastrarLeilao extends JInternalFrame {
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldCidade;
	private JTextField textFieldCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLeilao frame = new CadastrarLeilao();
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
	public CadastrarLeilao() {
		setClosable(true);
		setTitle("Cadastrar Leil\u00E3o");
		setBounds(100, 100, 450, 310);
		getContentPane().setLayout(null);
		
		JFormattedTextField frmtdtxtfldData = new JFormattedTextField();
		frmtdtxtfldData.setBounds(35, 81, 85, 20);
		getContentPane().add(frmtdtxtfldData);
		
		JFormattedTextField frmtdtxtfldHora = new JFormattedTextField();
		frmtdtxtfldHora.setBounds(35, 130, 85, 20);
		getContentPane().add(frmtdtxtfldHora);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(185, 70, 140, 20);
		getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(344, 70, 49, 20);
		getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(185, 130, 140, 20);
		getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"", "SP", "RJ", "MG", "GO", "AL", "AC", "MA", "MS", "MT", "RS", "SC", "TO", "SE", "PA", "PR", "PE", "AM", "AP", "ES", "RR", "RO"}));
		comboBoxEstado.setBounds(344, 130, 49, 20);
		getContentPane().add(comboBoxEstado);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(185, 186, 86, 20);
		getContentPane().add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setBounds(34, 59, 46, 14);
		getContentPane().add(lblData);
		
		JLabel lblHora = new JLabel("HORA");
		lblHora.setBounds(34, 112, 46, 14);
		getContentPane().add(lblHora);
		
		JLabel lblRua = new JLabel("RUA:");
		lblRua.setBounds(185, 48, 46, 14);
		getContentPane().add(lblRua);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(344, 48, 46, 14);
		getContentPane().add(lblN);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(185, 112, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(344, 112, 46, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(185, 171, 46, 14);
		getContentPane().add(lblCep);
		
		JLabel lblAgendamentoDeLeilao = new JLabel("Agendamento de Leilao");
		lblAgendamentoDeLeilao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgendamentoDeLeilao.setBounds(111, 11, 194, 20);
		getContentPane().add(lblAgendamentoDeLeilao);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(156, 236, 89, 23);
		getContentPane().add(btnContinuar);

	}
}
