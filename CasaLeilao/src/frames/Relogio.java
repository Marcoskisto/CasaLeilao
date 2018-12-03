package frames;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import classesBasicas.Leilao;
import classesBasicas.StatusLeilao;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Relogio extends JInternalFrame {
	static Date dataHoraSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relogio frame = new Relogio();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Date setDataHoraFinal(String dataHora) throws ParseException{
		SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyyhh:mm");
		Date dataHoraSystem = mascara.parse(dataHora);
		return dataHoraSystem;
		}
	
	public String getHoraFormatada() {
		SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyyhh:mm");
		return mascara.format(dataHoraSystem);
	}
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}
	/**
	 * Create the frame.
	 */
	public Relogio() {
		
		setLocation(new Point(1000, 700));
		setTitle("REL\u00D3GIO DO SISTEMA");
		setBounds(100, 100, 294, 181);
		getContentPane().setLayout(null);
		
		Date date = new Date();
		SpinnerDateModel sm = 
			new SpinnerDateModel(date, null, null, Calendar.DATE);
		
		JSpinner spinnerData = new JSpinner(sm);
		spinnerData.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		JSpinner.DateEditor de_spinnerData = new JSpinner.DateEditor(spinnerData, "dd/MM/yyyyHH:mm");
		spinnerData.setEditor(de_spinnerData);
		dataHoraSystem = (Date) spinnerData.getValue();
		
		
		
		spinnerData.setBounds(71, 29, 146, 33);
		getContentPane().add(spinnerData);
		
		JButton btnAtualizarData = new JButton("Atualizar data do sistema");
		btnAtualizarData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataHoraSystem = (Date) spinnerData.getValue();
				for(Leilao l: TelaPrincipal.casa.getLeiloes()) {
					if(l.getDataHoraInicio().before(dataHoraSystem) 
						&& l.getDataHoraFim().after(dataHoraSystem)) {
						System.out.println("teste");
						l.setStatus(StatusLeilao.EM_ANDAMENTO);
					}else if(l.getDataHoraInicio().after(dataHoraSystem)) {
						l.setStatus(StatusLeilao.PENDENTE);
					}else if(l.getDataHoraFim().before(dataHoraSystem)) {
						l.setStatus(StatusLeilao.FINALIZADO);
					}
				} 
				
			}
		});
		btnAtualizarData.setBackground(Color.ORANGE);
		btnAtualizarData.setForeground(Color.BLACK);
		btnAtualizarData.setBounds(43, 74, 187, 23);
		getContentPane().add(btnAtualizarData);
		
		JLabel lblDataSimulada = new JLabel("DATA SIMULADA");
		lblDataSimulada.setBounds(102, 4, 129, 14);
		getContentPane().add(lblDataSimulada);
		
		JLabel lblApsAtualizarFeche = new JLabel("Ap\u00F3s atualizar, feche as janelas e reabra-as");
		lblApsAtualizarFeche.setBounds(10, 108, 268, 14);
		getContentPane().add(lblApsAtualizarFeche);
		
	}
}
