package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CadastrarBanco extends JInternalFrame {
	private JTextField textFieldNomeBanco;
	private JTextField textFieldCnpjBanco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarBanco frame = new CadastrarBanco();
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
	public CadastrarBanco() {
		setClosable(true);
		setTitle("Cadastrar Banco");
		setBounds(100, 100, 256, 300);
		getContentPane().setLayout(null);
		
		textFieldNomeBanco = new JTextField();
		textFieldNomeBanco.setBounds(53, 95, 143, 20);
		getContentPane().add(textFieldNomeBanco);
		textFieldNomeBanco.setColumns(10);
		
		textFieldCnpjBanco = new JTextField();
		textFieldCnpjBanco.setBounds(53, 153, 143, 20);
		getContentPane().add(textFieldCnpjBanco);
		textFieldCnpjBanco.setColumns(10);
		
		JLabel lblNomeDoBanco = new JLabel("Nome do Banco");
		lblNomeDoBanco.setBounds(53, 77, 98, 14);
		getContentPane().add(lblNomeDoBanco);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(53, 137, 46, 14);
		getContentPane().add(lblCnpj);
		
		JButton btnCadastrarBanco = new JButton("Cadastrar");
		btnCadastrarBanco.setBounds(81, 206, 89, 23);
		getContentPane().add(btnCadastrarBanco);
		
		JLabel lblDadosDoBanco = new JLabel("Dados do Banco");
		lblDadosDoBanco.setBounds(70, 38, 115, 14);
		getContentPane().add(lblDadosDoBanco);

	}

}
