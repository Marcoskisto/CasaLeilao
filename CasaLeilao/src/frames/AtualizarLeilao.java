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
		setBounds(100, 100, 430, 415);
		getContentPane().setLayout(null);
		
		fieldData = new JFormattedTextField();
		fieldData.setToolTipText("");
		fieldData.setBounds(81, 110, 85, 20);
		getContentPane().add(fieldData);
		
		JFormattedTextField fieldHora = new JFormattedTextField();
		fieldHora.setToolTipText("##:##");
		fieldHora.setBounds(81, 132, 85, 20);
		getContentPane().add(fieldHora);
		
		JFormattedTextField fieldDataFim = new JFormattedTextField();
		fieldDataFim.setToolTipText("");
		fieldDataFim.setBounds(249, 110, 85, 20);
		getContentPane().add(fieldDataFim);

		JFormattedTextField fieldHoraFim = new JFormattedTextField();
		fieldHoraFim.setToolTipText("##:##");
		fieldHoraFim.setBounds(249, 132, 85, 20);
		getContentPane().add(fieldHoraFim);
		
		
		fieldRua = new JTextField();
		fieldRua.setBounds(180, 233, 140, 20);
		getContentPane().add(fieldRua);
		fieldRua.setColumns(10);
		
		fieldNumero = new JTextField();
		fieldNumero.setBounds(330, 233, 53, 20);
		getContentPane().add(fieldNumero);
		fieldNumero.setColumns(10);
		
		fieldCidade = new JTextField();
		fieldCidade.setBounds(180, 293, 140, 20);
		getContentPane().add(fieldCidade);
		fieldCidade.setColumns(10);
		
		JLabel lblData = new JLabel("DATA In\u00EDcio");
		lblData.setBounds(10, 113, 71, 14);
		getContentPane().add(lblData);
		
		JLabel lblRua = new JLabel("RUA:");
		lblRua.setBounds(180, 220, 46, 14);
		getContentPane().add(lblRua);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(330, 220, 46, 14);
		getContentPane().add(lblN);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setBounds(185, 268, 46, 14);
		getContentPane().add(lblCidade);

		fieldEstado = new JTextField();
		fieldEstado.setBounds(335, 293, 53, 20);
		getContentPane().add(fieldEstado);
		fieldEstado.setColumns(10);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(335, 268, 60, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblAgendamentoDeLeilao = new JLabel("ATUALIZAR LEIL\u00C3O");
		lblAgendamentoDeLeilao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgendamentoDeLeilao.setBounds(131, 11, 194, 20);
		getContentPane().add(lblAgendamentoDeLeilao);
		
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
					leilaoAtualizado.setDataHoraFinal(fieldDataFim.getText(), fieldHoraFim.getText());
					leilaoAtualizado.setEndereco(novoEndereco);
					
					
					
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
		btnSalvar.setBounds(154, 353, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblBanco = new JLabel("BANCO");
		lblBanco.setBounds(10, 220, 46, 14);
		getContentPane().add(lblBanco);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(249, 190, 76, 14);
		getContentPane().add(lblEndereo);
		
		fieldBanco = new JTextField();
		fieldBanco.setEditable(false);
		fieldBanco.setBounds(10, 233, 122, 20);
		getContentPane().add(fieldBanco);
		fieldBanco.setColumns(10);
		
		fieldIdLeilao = new JTextField();
		fieldIdLeilao.setEditable(false);
		fieldIdLeilao.setBounds(81, 63, 86, 20);
		getContentPane().add(fieldIdLeilao);
		fieldIdLeilao.setColumns(10);
		
		JLabel lblIdLeilo = new JLabel("ID LEIL\u00C3O");
		lblIdLeilo.setBounds(10, 66, 85, 14);
		getContentPane().add(lblIdLeilo);
		
		//carrega dados do leilão na tela de alterar leiloes
		Leilao leilaoAtual= TelaPrincipal.casa.getLeilaoPorId(TelaPrincipal.idLeilao);
		fieldIdLeilao.setText(Integer.toString(leilaoAtual.getIdLeilao()));
		fieldBanco.setText(leilaoAtual.getBancoCnpj());
		fieldCidade.setText(leilaoAtual.getEndereco().getCidade());
		fieldEstado.setText(leilaoAtual.getEndereco().getEstado());
		fieldNumero.setText(leilaoAtual.getEndereco().getNumero());
		fieldRua.setText(leilaoAtual.getEndereco().getRua());
		fieldData.setText(leilaoAtual.getDataFormatada());
		fieldHora.setText(leilaoAtual.getHoraFormatada());
		fieldDataFim.setText(leilaoAtual.getDataFormatadaFinal());
		fieldHoraFim.setText(leilaoAtual.getHoraFormatada());
		
		
		JLabel lblDataFim = new JLabel("HORA Inicio");
		lblDataFim.setBounds(10, 135, 71, 14);
		getContentPane().add(lblDataFim);
		

		
		JLabel lblDataFim_1 = new JLabel("DATA Fim");
		lblDataFim_1.setBounds(197, 113, 71, 14);
		getContentPane().add(lblDataFim_1);
		
		JLabel lblHoraFim = new JLabel("HORA Fim");
		lblHoraFim.setBounds(197, 135, 71, 14);
		getContentPane().add(lblHoraFim);
		
	}
}
