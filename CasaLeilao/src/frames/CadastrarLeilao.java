package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

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
		
		JFormattedTextField fieldData = new JFormattedTextField();
		fieldData.setBounds(35, 70, 85, 20);
		getContentPane().add(fieldData);
		
		JFormattedTextField fieldHora = new JFormattedTextField();
		fieldHora.setBounds(35, 130, 85, 20);
		getContentPane().add(fieldHora);
		
		fieldRua = new JTextField();
		fieldRua.setBounds(185, 70, 140, 20);
		getContentPane().add(fieldRua);
		fieldRua.setColumns(10);
		
		fieldNumero = new JTextField();
		fieldNumero.setBounds(344, 70, 49, 20);
		getContentPane().add(fieldNumero);
		fieldNumero.setColumns(10);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(185, 130, 140, 20);
		getContentPane().add(fieldCidade);
		fieldCidade.setColumns(10);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"", "SP", "RJ", "MG", "GO", "AL", "AC", "MA", "MS", "MT", "RS", "SC", "TO", "SE", "PA", "PR", "PE", "AM", "AP", "ES", "RR", "RO"}));
		comboBoxEstado.setBounds(344, 130, 49, 20);
		getContentPane().add(comboBoxEstado);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setBounds(34, 48, 46, 14);
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
		
		JLabel lblAgendamentoDeLeilao = new JLabel("Agendamento de Leilao");
		lblAgendamentoDeLeilao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgendamentoDeLeilao.setBounds(111, 11, 194, 20);
		getContentPane().add(lblAgendamentoDeLeilao);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Leilao novoLeilao = new Leilao();
				System.out.println("teste1");
				System.out.println("teste2");
				try {
					novoLeilao.setDataHora(fieldData.getText(), fieldHora.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnContinuar.setBounds(156, 236, 89, 23);
		getContentPane().add(btnContinuar);

	}
}
