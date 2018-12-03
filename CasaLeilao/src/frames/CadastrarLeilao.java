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
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 626, 374);
		getContentPane().setLayout(null);
		
		fieldData = new JFormattedTextField();
		fieldData.setToolTipText("");
		fieldData.setBounds(66, 115, 85, 20);
		getContentPane().add(fieldData);
		
		JFormattedTextField fieldHora = new JFormattedTextField();
		fieldHora.setToolTipText("##:##");
		fieldHora.setBounds(66, 175, 85, 20);
		getContentPane().add(fieldHora);
		
		JFormattedTextField fieldDataFim = new JFormattedTextField();
		fieldData.setToolTipText("");
		fieldDataFim.setBounds(213, 115, 85, 20);
		getContentPane().add(fieldDataFim);
		
		JFormattedTextField fieldHoraFim = new JFormattedTextField();
		fieldHoraFim.setToolTipText("##:##");
		fieldHoraFim.setBounds(213, 175, 85, 20);
		getContentPane().add(fieldHoraFim);
		
		fieldRua = new JTextField();
		fieldRua.setBounds(366, 116, 140, 20);
		getContentPane().add(fieldRua);
		fieldRua.setColumns(10);
		
		fieldNumero = new JTextField();
		fieldNumero.setBounds(525, 116, 49, 20);
		getContentPane().add(fieldNumero);
		fieldNumero.setColumns(10);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(366, 175, 140, 20);
		getContentPane().add(fieldCidade);
		fieldCidade.setColumns(10);
		
		JLabel lblData = new JLabel("DATA In\u00EDcio");
		lblData.setBounds(66, 94, 101, 14);
		getContentPane().add(lblData);
		
		JLabel lblHora = new JLabel("HORA Inicio");
		lblHora.setBounds(66, 160, 101, 14);
		getContentPane().add(lblHora);
		
		JLabel lblRua = new JLabel("RUA:");
		lblRua.setBounds(366, 100, 46, 14);
		getContentPane().add(lblRua);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(528, 100, 46, 14);
		getContentPane().add(lblN);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(366, 160, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(525, 160, 46, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblAgendamentoDeLeilao = new JLabel("Agendamento de Leilao");
		lblAgendamentoDeLeilao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgendamentoDeLeilao.setBounds(131, 18, 194, 20);
		getContentPane().add(lblAgendamentoDeLeilao);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//add novo leilão à lista de leilões
				Leilao novoLeilao = new Leilao();
				try {
					novoLeilao.setDataHora(fieldData.getText(), fieldHora.getText());
					novoLeilao.setDataHoraFinal(fieldDataFim.getText(), fieldHoraFim.getText());
					novoLeilao.setEndereco(new Endereco(fieldRua.getText(), fieldNumero.getText(), fieldCidade.getText(), fieldEstado.getText()));
					TelaPrincipal.casa.addLeilao(novoLeilao);
					TelaPrincipal.atualizaStatusLeilao();
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//fecha tela atual
				try {
					setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//volta para a tela gerenciarLeiloes
				TelaPrincipal.abrirTelaGerenciarLeiloes();
			}
		});
		btnContinuar.setBounds(277, 310, 89, 23);
		getContentPane().add(btnContinuar);
		
		JComboBox comboBoxBanco = new JComboBox();
		comboBoxBanco.setBounds(46, 255, 205, 20);
		getContentPane().add(comboBoxBanco);
		
		JLabel lblBanco = new JLabel("BANCO");
		lblBanco.setBounds(129, 230, 46, 14);
		getContentPane().add(lblBanco);
		
		JButton btnCadastrarBanco = new JButton("Cadastrar Banco");
		btnCadastrarBanco.setBounds(261, 254, 123, 23);
		getContentPane().add(btnCadastrarBanco);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(416, 76, 76, 14);
		getContentPane().add(lblEndereo);
		
		fieldEstado = new JTextField();
		fieldEstado.setBounds(525, 175, 49, 20);
		getContentPane().add(fieldEstado);
		fieldEstado.setColumns(10);
		
		JLabel lblDataFim = new JLabel("DATA Fim");
		lblDataFim.setBounds(213, 94, 101, 14);
		getContentPane().add(lblDataFim);
		
		JLabel lblHoraFim = new JLabel("HORA Fim");
		lblHoraFim.setBounds(213, 160, 101, 14);
		getContentPane().add(lblHoraFim);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(333, 92, 12, 115);
		getContentPane().add(separator);

	}
}
