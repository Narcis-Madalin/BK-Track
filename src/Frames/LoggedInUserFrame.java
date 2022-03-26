package Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;

/**
 * Clasa reprezinta ecranul principal de dupa logare/din interiorul contului bancar al unui utilizator
 */

public class LoggedInUserFrame implements ActionListener{
	
	ContBancar c;
	ConexiuneBazaDeDate conn;
	
	String idCont2;
	
	JFrame loggedinFrame = new JFrame();
	
	JButton logout = new JButton();
	JButton depunere = new JButton();
	JButton retragere = new JButton();
	JButton butonTransfer = new JButton();
	JButton butonConvertor = new JButton();
	JButton butonPlataFacturi = new JButton();
	JButton butonStergereCont = new JButton();
	JButton transformareValuta = new JButton();
	
	JMenuBar meniu;
	
	JMenu optiuni;
	
	JMenuItem depozitare;
	JMenuItem extragere;
	JMenuItem istoric;
	JMenuItem transfer;
	JMenuItem convertor;
	
	LoggedInUserFrame(ContBancar c){
		
		this.c = c;
		conn = new ConexiuneBazaDeDate();
		
		// FRAME
		
		loggedinFrame.setTitle("Bank App - Bun Venit " + c.getUtilizator().getNume() + " " + c.getUtilizator().getPrenume());
		loggedinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loggedinFrame.setSize(1000,1000);
		loggedinFrame.setLayout(new BorderLayout(20,20));
		
		
		// PANOURILE
		
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		loggedinFrame.add(panouTitlu,BorderLayout.NORTH);
						
						
		JPanel panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		//panouCampuri.setBackground(Color.magenta);
		panouCampuri.setLayout(new GridBagLayout());
		loggedinFrame.add(panouCampuri,BorderLayout.CENTER);
						
						
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		//panouBottom.setBackground(Color.red);
		//panouBottom.setLayout(new GridBagLayout());
		loggedinFrame.add(panouBottom,BorderLayout.SOUTH);
		
		
		// ETICHETA DE TITLU
		
		JLabel eticheta1 = new JLabel("Bun Venit, " + c.getUtilizator().getNume() + " " + c.getUtilizator().getPrenume() + "!");
		eticheta1.setFont(new Font("Arial", Font.PLAIN, 30));
		eticheta1.setOpaque(true);
		eticheta1.setVerticalAlignment(JLabel.CENTER);
		eticheta1.setHorizontalAlignment(JLabel.CENTER);
						
		panouTitlu.add(eticheta1);
		
		
		// ETICHETE De MIJLOC
		
		GridBagConstraints gc=new GridBagConstraints();
		
		JLabel etichetaSold = new JLabel("Soldul curent: " + c.getSold() + " " + c.getMoneda());
		etichetaSold.setFont(new Font("Arial", Font.PLAIN, 30));
		etichetaSold.setOpaque(true);
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weighty = 1;
		
		panouCampuri.add(etichetaSold, gc);
		
		// Butoane de mijloc
		
		// Buton depunere suma
		
		depunere.setPreferredSize(new Dimension(200,50));
		depunere.setText("depunere suma");
		depunere.setFocusable(false);
		depunere.setFont(new Font("Arial", Font.PLAIN, 20));
		depunere.addActionListener(this);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 1;
		
		panouCampuri.add(depunere, gc);
		
		// Buton Retragere suma
		
		retragere.setPreferredSize(new Dimension(200,50));
		retragere.setText("retragere suma");
		retragere.setFocusable(false);
		retragere.setFont(new Font("Arial", Font.PLAIN, 20));
		retragere.addActionListener(this);
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weighty = 1;
		
		panouCampuri.add(retragere, gc);
		
		// Buton Convertor valutar
		
		butonConvertor.setPreferredSize(new Dimension(200,50));
		butonConvertor.setText("Convertor valutar");
		butonConvertor.setFocusable(false);
		butonConvertor.setFont(new Font("Arial", Font.PLAIN, 20));
		butonConvertor.addActionListener(this);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weighty = 1;
		
		panouCampuri.add(butonConvertor, gc);
		
		// Buton transfer
		
		butonTransfer.setPreferredSize(new Dimension(200,50));
		butonTransfer.setText("Transfer");
		butonTransfer.setFocusable(false);
		butonTransfer.setFont(new Font("Arial", Font.PLAIN, 20));
		butonTransfer.addActionListener(this);
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weighty = 1;
		
		panouCampuri.add(butonTransfer, gc);
		
		// Buton plata facturi
		
		butonPlataFacturi.setPreferredSize(new Dimension(200,50));
		butonPlataFacturi.setText("Plata facturi");
		butonPlataFacturi.setFocusable(false);
		butonPlataFacturi.setFont(new Font("Arial", Font.PLAIN, 20));
		butonPlataFacturi.addActionListener(this);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weighty = 1;
		
		panouCampuri.add(butonPlataFacturi, gc);
		
		
		// Buton stergere cont
		
				butonStergereCont.setPreferredSize(new Dimension(200,50));
				butonStergereCont.setText("Stergere cont");
				butonStergereCont.setFocusable(false);
				butonStergereCont.setFont(new Font("Arial", Font.PLAIN, 20));
				butonStergereCont.addActionListener(this);
				gc.gridx = 2;
				gc.gridy = 3;
				gc.weighty = 1;
				
				panouCampuri.add(butonStergereCont, gc);
				
				// Buton transformare valuta
				
				transformareValuta.setPreferredSize(new Dimension(200,50));
				transformareValuta.setText("Transformare");
				transformareValuta.setFocusable(false);
				transformareValuta.setFont(new Font("Arial", Font.PLAIN, 20));
				transformareValuta.addActionListener(this);
				gc.gridx = 0;
				gc.gridy = 4;
				gc.weighty = 1;
				
				panouCampuri.add(transformareValuta, gc);
		
		// SETAREA BUTOANELOR
		
		logout.setPreferredSize(new Dimension(200,50));
		logout.setText("Logout");
		logout.setFocusable(false);
		logout.setFont(new Font("Arial", Font.PLAIN, 20));
		logout.addActionListener(this);
						
		panouBottom.add(logout);
		
		
		// MENU BAR
		
		meniu = new JMenuBar();
		
		optiuni = new JMenu("Optiuni");
		
		meniu.add(optiuni);
		
		depozitare = new JMenuItem("Depunere suma");
		depozitare.addActionListener(this);
		extragere = new JMenuItem("Extragere suma");
		extragere.addActionListener(this);
		transfer = new JMenuItem("Transfer suma");
		transfer.addActionListener(this);
		convertor = new JMenuItem("Convertor valutar");
		convertor.addActionListener(this);
		
		optiuni.add(depozitare);
		optiuni.add(extragere);
		optiuni.add(transfer);
		optiuni.add(convertor);
		
		loggedinFrame.setJMenuBar(meniu);
		
		
		loggedinFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == logout) {
			int val = JOptionPane.showConfirmDialog(loggedinFrame, "Sigur vrei sa iesi din cont?", "", JOptionPane.YES_NO_CANCEL_OPTION);
			if(val == 0) {
			loggedinFrame.dispose();
			LoginFrame loginFrame = new LoginFrame();
			}
		}
		
		if(e.getSource() == depozitare || e.getSource() == depunere) {
			String suma = JOptionPane.showInputDialog("Ce suma doresti sa depui? ");
			int verif = 0;
			if(suma != null) {
				String validare = "[0-9]+[.]?[0-9]*";
				if(suma.matches(validare) == false)
					verif = 1;
				
				if(verif == 0 && suma.isEmpty() == false) {
					conn.depozitareSuma(suma, c);
					loggedinFrame.dispose();
					LoggedInUserFrame loggedInFrame = new LoggedInUserFrame(c);
				}
			
				else  {
					JOptionPane.showMessageDialog(loggedinFrame, "Suma introdusa nu este valida!", "Atentie!", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
		
		if(e.getSource() == extragere || e.getSource() == retragere) {
			String suma = JOptionPane.showInputDialog("Ce suma doresti sa extragi? ");
			int verif = 0;
			if(suma != null) {
				String validare = "[0-9]+[.]?[0-9]*";
				if(suma.matches(validare) == false)
					verif = 1;
				
				if(verif == 0 && suma.isEmpty() == false) {
					conn.extragereSuma(suma, c, loggedinFrame);
					loggedinFrame.dispose();
					LoggedInUserFrame loggedInFrame = new LoggedInUserFrame(c);
				}
			
				else  {
					JOptionPane.showMessageDialog(loggedinFrame, "Suma introdusa nu este valida!", "Atentie!", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
		
		if(e.getSource() == transfer || e.getSource() == butonTransfer) {
			String suma = JOptionPane.showInputDialog("Ce suma doresti sa transferi? ");
			int verif = 0;
			if(suma != null) {
				String validare = "[0-9]+[.]?[0-9]*";
				if(suma.matches(validare) == false)
					verif = 1;
				
				if(verif == 0 && suma.isEmpty() == false) {
					conn.transferSuma(suma, c, loggedinFrame);
					loggedinFrame.dispose();
					LoggedInUserFrame loggedInFrame = new LoggedInUserFrame(c);
				}
			
				else  {
					JOptionPane.showMessageDialog(loggedinFrame, "Suma introdusa nu este valida!", "Atentie!", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
		
		if(e.getSource() == convertor || e.getSource() == butonConvertor) {
			loggedinFrame.dispose();
			ConvertorValutarFrame convertorValutar = new ConvertorValutarFrame(c);
		}
		
		if(e.getSource() == butonPlataFacturi) {
			loggedinFrame.dispose();
			FacturiFrame facturi = new FacturiFrame(c);
		}
		
		if(e.getSource() == butonStergereCont) {
			int val = JOptionPane.showConfirmDialog(loggedinFrame, "Sigur vrei sa iesi din cont?", "", JOptionPane.YES_NO_CANCEL_OPTION);
			if(val == 0) {
			conn.stergereCont(c, loggedinFrame);
			loggedinFrame.dispose();
			LoginFrame loginFrame = new LoginFrame();
			}
		}
		
		if(e.getSource() == transformareValuta) {
			loggedinFrame.dispose();
			SchimbareValutaFrame clasa2 = new SchimbareValutaFrame(c);
		}
		
	}
}
