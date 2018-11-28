package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.plaf.DesktopPaneUI;

import classesBasicas.Endereco;
import classesBasicas.Leilao;

import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CadastrarLeilao extends JInternalFrame {
	private JTextField fieldRua;
	private JTextField fieldNumero;
	private JTextField fieldCidade;
	private JFormattedTextField fieldData;
	private JTextField fieldEstado;

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
		setBounds(100, 100, 450, 340);
		getContentPane().setLayout(null);
		
		fieldData = new JFormattedTextField();
		fieldData.setToolTipText("");
		fieldData.setBounds(35, 89, 85, 20);
		getContentPane().add(fieldData);
		
		JFormattedTextField fieldHora = new JFormattedTextField();
		fieldHora.setToolTipText("##:##");
		fieldHora.setBounds(35, 148, 85, 20);
		getContentPane().add(fieldHora);
		
		fieldRua = new JTextField();
		fieldRua.setBounds(185, 89, 140, 20);
		getContentPane().add(fieldRua);
		fieldRua.setColumns(10);
		
		fieldNumero = new JTextField();
		fieldNumero.setBounds(344, 89, 49, 20);
		getContentPane().add(fieldNumero);
		fieldNumero.setColumns(10);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(185, 148, 140, 20);
		getContentPane().add(fieldCidade);
		fieldCidade.setColumns(10);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setBounds(35, 73, 46, 14);
		getContentPane().add(lblData);
		
		JLabel lblHora = new JLabel("HORA");
		lblHora.setBounds(34, 133, 46, 14);
		getContentPane().add(lblHora);
		
		JLabel lblRua = new JLabel("RUA:");
		lblRua.setBounds(185, 73, 46, 14);
		getContentPane().add(lblRua);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(347, 73, 46, 14);
		getContentPane().add(lblN);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(185, 133, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(344, 133, 46, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblAgendamentoDeLeilao = new JLabel("Agendamento de Leilao");
		lblAgendamentoDeLeilao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgendamentoDeLeilao.setBounds(131, 18, 194, 20);
		getContentPane().add(lblAgendamentoDeLeilao);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Leilao novoLeilao = new Leilao();
				
				try {
					
					novoLeilao.setDataHora(fieldData.getText(), fieldHora.getText());
					novoLeilao.setEndereco(new Endereco(fieldRua.getText(), fieldNumero.getText(), fieldCidade.getText(), fieldEstado.getText()));
					TelaPrincipal.casa.addLeilao(novoLeilao);
					System.out.println(TelaPrincipal.casa.getLeilaoPorId(1000001).getIdLeilao());
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnContinuar.setBounds(185, 265, 89, 23);
		getContentPane().add(btnContinuar);
		
		JComboBox comboBoxBanco = new JComboBox();
		comboBoxBanco.setBounds(48, 210, 205, 20);
		getContentPane().add(comboBoxBanco);
		
		JLabel lblBanco = new JLabel("BANCO");
		lblBanco.setBounds(131, 185, 46, 14);
		getContentPane().add(lblBanco);
		
		JButton btnCadastrarBanco = new JButton("Cadastrar Banco");
		btnCadastrarBanco.setBounds(263, 209, 123, 23);
		getContentPane().add(btnCadastrarBanco);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(235, 49, 76, 14);
		getContentPane().add(lblEndereo);
		
		fieldEstado = new JTextField();
		fieldEstado.setBounds(344, 148, 49, 20);
		getContentPane().add(fieldEstado);
		fieldEstado.setColumns(10);

	}
}
