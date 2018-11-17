package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin extends JInternalFrame {
	private JTextField textCpf;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setClosable(true);
		setTitle("LOGIN");
		setBounds(100, 100, 342, 315);
		getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Fazer login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.logon=TelaPrincipal.casa.login(textCpf.getText(),textSenha.getText());
				if(TelaPrincipal.logon) TelaPrincipal.loginCpf=textCpf.getText();
				System.out.println("STATUS DO LOGIN:"+TelaPrincipal.logon);
			}
		});
		btnLogin.setBounds(120, 197, 98, 23);
		getContentPane().add(btnLogin);
		
		JButton btnNovoCadastro = new JButton("Cadastrar Usu\u00E1rio");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastraUsuario novoCadastro= new CadastraUsuario();
				TelaPrincipal.desktopPane.add(novoCadastro);
				novoCadastro.setVisible(true);
			}
		});
		btnNovoCadastro.setBounds(103, 231, 135, 23);
		getContentPane().add(btnNovoCadastro);
		
		textCpf = new JTextField();
		textCpf.setBounds(93, 65, 145, 30);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(93, 145, 145, 30);
		getContentPane().add(textSenha);
		textSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(93, 48, 32, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setBounds(93, 127, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblDigiteSuasCredenciais = new JLabel("Digite suas credenciais");
		lblDigiteSuasCredenciais.setBounds(103, 25, 145, 14);
		getContentPane().add(lblDigiteSuasCredenciais);

	}
}
