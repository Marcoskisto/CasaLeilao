package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.plaf.DesktopPaneUI;

import classesBasicas.*;

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
import javax.swing.JScrollPane;

public class AtualizarLeilao extends JInternalFrame {
	private JTextField fieldRua;
	private JTextField fieldNumero;
	private JTextField fieldCidade;
	private JFormattedTextField fieldData;
	private JTextField fieldBanco;
	private JTextField fieldIdLeilao;
	private JTextField fieldEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarLeilao frame = new AtualizarLeilao();
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
	public AtualizarLeilao() {
		setClosable(true);
		setTitle("Atualizar Leil\u00E3o");
		setBounds(100, 100, 430, 420);
		getContentPane().setLayout(null);
		
		fieldData = new JFormattedTextField();
		fieldData.setToolTipText("");
		fieldData.setBounds(35, 141, 85, 20);
		getContentPane().add(fieldData);
		
		JFormattedTextField fieldHora = new JFormattedTextField();
		fieldHora.setToolTipText("##:##");
		fieldHora.setBounds(35, 211, 85, 20);
		getContentPane().add(fieldHora);
		
		fieldRua = new JTextField();
		fieldRua.setBounds(185, 141, 140, 20);
		getContentPane().add(fieldRua);
		fieldRua.setColumns(10);
		
		fieldNumero = new JTextField();
		fieldNumero.setBounds(335, 141, 49, 20);
		getContentPane().add(fieldNumero);
		fieldNumero.setColumns(10);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(185, 211, 140, 20);
		getContentPane().add(fieldCidade);
		fieldCidade.setColumns(10);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setBounds(35, 125, 46, 14);
		getContentPane().add(lblData);
		
		JLabel lblHora = new JLabel("HORA");
		lblHora.setBounds(35, 197, 46, 14);
		getContentPane().add(lblHora);
		
		JLabel lblRua = new JLabel("RUA:");
		lblRua.setBounds(185, 125, 46, 14);
		getContentPane().add(lblRua);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(335, 125, 46, 14);
		getContentPane().add(lblN);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(185, 197, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(335, 197, 60, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblAgendamentoDeLeilao = new JLabel("ATUALIZAR LEIL\u00C3O");
		lblAgendamentoDeLeilao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgendamentoDeLeilao.setBounds(185, 11, 194, 20);
		getContentPane().add(lblAgendamentoDeLeilao);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(StatusLeilao.values()));
		comboBox.setEditable(true);
		comboBox.setBounds(197, 282, 122, 20);
		getContentPane().add(comboBox);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//atualizar leilão cadastrado
					// - busca o leilão pelo id
					Leilao leilaoAtualizado = TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao);
					// - atualiza a data e endereço do leilão
					Endereco novoEndereco = new Endereco(fieldRua.getText(), fieldNumero.getText(), fieldCidade.getText(), fieldEstado.getText());
					leilaoAtualizado.setDataHora(fieldData.getText(), fieldHora.getText());
					leilaoAtualizado.setEndereco(novoEndereco);
					leilaoAtualizado.setStatus((StatusLeilao) comboBox.getSelectedItem());
					
					//abrir Tela gerenciarLeilao
					TelaPrincipal.abrirTelaGerenciarLeiloes();
					
					//fecha janela atual
					try {
						setClosed(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnSalvar.setBounds(154, 356, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblBanco = new JLabel("BANCO");
		lblBanco.setBounds(35, 266, 46, 14);
		getContentPane().add(lblBanco);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(235, 94, 76, 14);
		getContentPane().add(lblEndereo);
		
		fieldBanco = new JTextField();
		fieldBanco.setEditable(false);
		fieldBanco.setBounds(34, 282, 122, 20);
		getContentPane().add(fieldBanco);
		fieldBanco.setColumns(10);
		
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(197, 266, 46, 14);
		getContentPane().add(lblStatus);
		
		fieldIdLeilao = new JTextField();
		fieldIdLeilao.setEditable(false);
		fieldIdLeilao.setBounds(35, 91, 86, 20);
		getContentPane().add(fieldIdLeilao);
		fieldIdLeilao.setColumns(10);
		
		JLabel lblIdLeilo = new JLabel("ID LEIL\u00C3O");
		lblIdLeilo.setBounds(35, 74, 85, 14);
		getContentPane().add(lblIdLeilo);
		
		//carrega dados do leilão na tela de alterar leiloes
		Leilao leilaoAtual= TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao);
		fieldIdLeilao.setText(Integer.toString(leilaoAtual.getIdLeilao()));
		fieldBanco.setText(leilaoAtual.getBancoCnpj());
		fieldCidade.setText(leilaoAtual.getEndereco().getCidade());
		fieldNumero.setText(leilaoAtual.getEndereco().getNumero());
		fieldRua.setText(leilaoAtual.getEndereco().getRua());
		fieldData.setText(leilaoAtual.getDataFormatada());
		fieldHora.setText(leilaoAtual.getHoraFormatada());
		
		fieldEstado = new JTextField();
		fieldEstado.setBounds(335, 211, 53, 20);
		getContentPane().add(fieldEstado);
		fieldEstado.setColumns(10);
		
	}
}
