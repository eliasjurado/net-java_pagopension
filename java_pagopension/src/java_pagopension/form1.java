package java_pagopension;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class form1 {

	private JFrame frmColegio;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 window = new form1();
					window.frmColegio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public form1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmColegio = new JFrame();
		frmColegio.setResizable(false);
		frmColegio.setIconImage(Toolkit.getDefaultToolkit().getImage(form1.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmColegio.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				txtTotal.setText("250.00");
			}
		});
		frmColegio.setTitle("IE San Particio");
		frmColegio.setBounds(100, 100, 272, 152);
		frmColegio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmColegio.getContentPane().setLayout(null);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setBounds(159, 80, 91, 19);
		txtTotal.setEditable(false);
		frmColegio.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JSpinner spiHijos = new JSpinner();
		spiHijos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				double pension = 250.00;
				int hijos = Integer.parseInt(spiHijos.getValue().toString());
				if(hijos==1) {
					txtTotal.setText("250.00");
				}
				else if(hijos==2) {
					txtTotal.setText("400.00");
				}
				else {
					double totpen = pension*hijos*0.7;
					DecimalFormat df = new DecimalFormat("0.00");
					txtTotal.setText(String.valueOf(df.format(totpen)));
				}
				
			}
		});
		spiHijos.setBounds(159, 48, 91, 20);
		spiHijos.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		frmColegio.getContentPane().add(spiHijos);
		
		JLabel lblNroHijos = new JLabel("Nro. Hijos");
		lblNroHijos.setBounds(12, 50, 122, 15);
		frmColegio.getContentPane().add(lblNroHijos);
		
		JLabel lblTotalPensin = new JLabel("Total Pensión S/.");
		lblTotalPensin.setBounds(12, 82, 122, 15);
		frmColegio.getContentPane().add(lblTotalPensin);
		
		JLabel lblPensinS = new JLabel("Pensión S/.250.00");
		lblPensinS.setBounds(12, 12, 238, 15);
		frmColegio.getContentPane().add(lblPensinS);
	}
}
