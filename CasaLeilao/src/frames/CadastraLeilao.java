package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class CadastraLeilao extends JFrame {

	private JPanel contentPane;
	private JTextField leilaoEndRua;
	private JTextField leilaoEndNumero;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraLeilao frame = new CadastraLeilao();
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
	public CadastraLeilao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnContinuar = new JButton("continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnContinuar.setBounds(168, 208, 89, 23);
		contentPane.add(btnContinuar);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setBounds(63, 44, 46, 14);
		contentPane.add(lblData);
		
		leilaoEndRua = new JTextField();
		leilaoEndRua.setBounds(63, 104, 146, 20);
		contentPane.add(leilaoEndRua);
		leilaoEndRua.setColumns(10);
		
		leilaoEndNumero = new JTextField();
		leilaoEndNumero.setBounds(234, 104, 46, 20);
		contentPane.add(leilaoEndNumero);
		leilaoEndNumero.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(63, 157, 146, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel leilaoRua = new JLabel("RUA");
		leilaoRua.setBounds(63, 90, 46, 14);
		contentPane.add(leilaoRua);
		
		JLabel Numero = new JLabel("N\u00BA");
		Numero.setBounds(234, 90, 46, 14);
		contentPane.add(Numero);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(63, 142, 46, 14);
		contentPane.add(lblCidade);
		
		JComboBox leilaoEndEstado = new JComboBox();
		leilaoEndEstado.setModel(new DefaultComboBoxModel(new String[] {"SP", "RJ", "MG", "ES", "PR", "RS", "SC", "GO", "MT", "MS", "TO", "MA", "PA", "RN", "RO", "RR", "AL", "PB", "SE", "BA", "CE", "AM", "AC"}));
		leilaoEndEstado.setBounds(234, 157, 46, 20);
		contentPane.add(leilaoEndEstado);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(234, 142, 60, 14);
		contentPane.add(lblEstado);
		
		JLabel lblCadastrarLeilao = new JLabel("CADASTRAR LEILAO");
		lblCadastrarLeilao.setBounds(152, 11, 130, 14);
		contentPane.add(lblCadastrarLeilao);
		
		JFormattedTextField leilaoData = new JFormattedTextField();
		leilaoData.setBounds(97, 41, 89, 20);
		contentPane.add(leilaoData);
	}
}
