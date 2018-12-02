package frames;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Color;

public class Relogio extends JInternalFrame {

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

	/**
	 * Create the frame.
	 */
	public Relogio() {
		setLocation(new Point(1000, 700));
		setTitle("REL\u00D3GIO DO SISTEMA");
		setBounds(100, 100, 227, 137);
		getContentPane().setLayout(null);
		
		Date date = new Date();
		SpinnerDateModel sm = 
			new SpinnerDateModel(date, null, null, Calendar.DATE);
		
		JSpinner spinnerData = new JSpinner(sm);
		JSpinner.DateEditor de_spinnerData = new JSpinner.DateEditor(spinnerData, "dd/MM/yyyy - HH:mm");
		spinnerData.setEditor(de_spinnerData);
		
		spinnerData.setBounds(38, 28, 146, 33);
		getContentPane().add(spinnerData);
		
		JButton btnAtualizarData = new JButton("Atualizar data do sistema");
		btnAtualizarData.setBackground(Color.ORANGE);
		btnAtualizarData.setForeground(Color.BLACK);
		btnAtualizarData.setBounds(14, 73, 187, 23);
		getContentPane().add(btnAtualizarData);
		
		JLabel lblDataSimulada = new JLabel("DATA SIMULADA");
		lblDataSimulada.setBounds(61, 3, 129, 14);
		getContentPane().add(lblDataSimulada);
		
	}
}
