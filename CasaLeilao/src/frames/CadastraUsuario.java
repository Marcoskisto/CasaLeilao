package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import classesBasicas.CasaLeilao;
import classesBasicas.Cliente;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Point;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastraUsuario extends JInternalFrame {
	private JTextField nomeUsuario;
	private JTextField cpfUsuario;
	private JTextField senhaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraUsuario frame = new CadastraUsuario();
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
	public CadastraUsuario() {
		setLocation(new Point(100, 200));
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(true);
		setTitle("Cadastrar Usu\u00E1rio");
		setBounds(100, 100, 282, 335);
		getContentPane().setLayout(null);
		
		nomeUsuario = new JTextField();
		nomeUsuario.setBounds(42, 70, 192, 30);
		getContentPane().add(nomeUsuario);
		nomeUsuario.setColumns(10);
		
		cpfUsuario = new JTextField();
		cpfUsuario.setColumns(10);
		cpfUsuario.setBounds(42, 137, 192, 30);
		getContentPane().add(cpfUsuario);
		
		senhaUsuario = new JTextField();
		senhaUsuario.setColumns(10);
		senhaUsuario.setBounds(42, 203, 192, 30);
		getContentPane().add(senhaUsuario);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(42, 49, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(42, 118, 46, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(42, 183, 46, 14);
		getContentPane().add(lblSenha);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente usuario = new Cliente(nomeUsuario.getText(),cpfUsuario.getText(),senhaUsuario.getText());
				TelaPrincipal.casa.addCliente(usuario);
				
				
				
			}
		});
		btnContinuar.setBounds(99, 252, 89, 23);
		getContentPane().add(btnContinuar);
		
		JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroDeUsurio.setBounds(73, 11, 133, 14);
		getContentPane().add(lblCadastroDeUsurio);

	}
}
