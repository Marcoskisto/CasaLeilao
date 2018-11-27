package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classesBasicas.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MeuPerfil extends JInternalFrame {
	private JTextField textCpf;
	private JTextField textNome;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeuPerfil frame = new MeuPerfil();
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
	public MeuPerfil() {
		setClosable(true);
		setTitle("Meu Perfil");
		setBounds(100, 100, 313, 315);
		getContentPane().setLayout(null);
		
		textCpf = new JTextField();
		textCpf.setEditable(false);
		textCpf.setBounds(78, 52, 150, 30);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(78, 114, 150, 30);
		getContentPane().add(textNome);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(78, 180, 150, 30);
		getContentPane().add(textSenha);
		
		//CARREGA DADOS DO USUÁRIO NA TELA MeuPerfil
		Cliente usuario= TelaPrincipal.casa.getClientePorCpf(TelaPrincipal.loginCpf);
		textCpf.setText(usuario.getCpf());
		textNome.setText(usuario.getNome()); 
		textSenha.setText(usuario.getSenha());
		
		JButton btnSalvar = new JButton("Salvar");
		
		//ATUALIZA DADOS DO CLIENTE(NOME, CPF E SENHA)
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario.setCpf(textCpf.getText());
				usuario.setNome(textNome.getText());
				usuario.setSenha(textSenha.getText());
			}
			
		});
		btnSalvar.setBounds(104, 239, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(78, 37, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(78, 100, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(78, 166, 46, 14);
		getContentPane().add(lblSenha);
		
		JLabel lblAlterarUsurio = new JLabel("Perfil do Usu\u00E1rio");
		lblAlterarUsurio.setBounds(104, 12, 89, 14);
		getContentPane().add(lblAlterarUsurio);

	}

}
