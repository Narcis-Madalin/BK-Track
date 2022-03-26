package Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pachet1.ContBancar;

/**
 * Clasa reprezinta un meniu de selectie pentru ce tip de factura se doreste a fi achitata
 */

public class FacturiFrame implements ActionListener{
	
	ContBancar c;
	
	JFrame facturi = new JFrame();
	
	
	JButton inapoi = new JButton();
	JButton facturaCurent = new JButton();
	JButton facturaCaldura = new JButton();
	JButton facturaApa = new JButton();
	
	JLabel etichetaTitlu;
	
	JPanel panouCampuri;
	
	FacturiFrame(ContBancar c){
		
		this.c = c;
		
		// FRAME
		
		facturi.setTitle("Bank App - Meniu Facturi ");
		facturi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		facturi.setSize(700,700);
		facturi.setLayout(new BorderLayout(20,20));
		
		// PANOURILE
		
				JPanel panouTitlu = new JPanel();
				panouTitlu.setPreferredSize(new Dimension(100,100));
				panouTitlu.setLayout(new BorderLayout());
				facturi.add(panouTitlu,BorderLayout.NORTH);
										
										
				panouCampuri = new JPanel();
				panouCampuri.setPreferredSize(new Dimension(100,100));
				panouCampuri.setLayout(new GridBagLayout());
				facturi.add(panouCampuri,BorderLayout.CENTER);
										
										
				JPanel panouBottom = new JPanel();
				panouBottom.setPreferredSize(new Dimension(100,100));
				facturi.add(panouBottom,BorderLayout.SOUTH);
				
				// ETICHETA DE TITLU
				
				JLabel eticheta1 = new JLabel("Selecteaza una din facturile de mai jos");
				eticheta1.setFont(new Font("Arial", Font.PLAIN, 20));
				eticheta1.setOpaque(true);
				eticheta1.setVerticalAlignment(JLabel.CENTER);
				eticheta1.setHorizontalAlignment(JLabel.CENTER);
										
				panouTitlu.add(eticheta1);
				
				// Butoane de mijloc
				
				GridBagConstraints gc=new GridBagConstraints();
				
				// Buton factura curent
				
				facturaCurent.setPreferredSize(new Dimension(200,50));
				facturaCurent.setText("Factura Curent");
				facturaCurent.setFocusable(false);
				facturaCurent.setFont(new Font("Arial", Font.PLAIN, 20));
				facturaCurent.addActionListener(this);
				gc.fill=GridBagConstraints.HORIZONTAL;
				gc.gridx = 1;
				gc.gridy = 0;
				gc.weighty = 1;
				
				panouCampuri.add(facturaCurent, gc);
				
				// Buton factura caldura
				
				facturaCaldura.setPreferredSize(new Dimension(200,50));
				facturaCaldura.setText("Factura Caldura");
				facturaCaldura.setFocusable(false);
				facturaCaldura.setFont(new Font("Arial", Font.PLAIN, 20));
				facturaCaldura.addActionListener(this);
				gc.fill=GridBagConstraints.HORIZONTAL;
				gc.gridx = 1;
				gc.gridy = 1;
				gc.weighty = 1;
				
				panouCampuri.add(facturaCaldura, gc);
				
				// Buton factura apa
				
				facturaApa.setPreferredSize(new Dimension(200,50));
				facturaApa.setText("Factura Apa");
				facturaApa.setFocusable(false);
				facturaApa.setFont(new Font("Arial", Font.PLAIN, 20));
				facturaApa.addActionListener(this);
				gc.fill=GridBagConstraints.HORIZONTAL;
				gc.gridx = 1;
				gc.gridy = 2;
				gc.weighty = 1;
				
				panouCampuri.add(facturaApa, gc);
				
				// Buton inapoi
				
				inapoi.setPreferredSize(new Dimension(200,50));
				inapoi.setText("Inapoi");
				inapoi.setFocusable(false);
				inapoi.setFont(new Font("Arial", Font.PLAIN, 20));
				inapoi.addActionListener(this);
										
				panouBottom.add(inapoi);
				
				
				
				facturi.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inapoi) {
			facturi.dispose();
			LoggedInUserFrame loggedIn = new LoggedInUserFrame(c);
		}
		
		if(e.getSource() == facturaCurent) {
			facturi.dispose();
			FacturaCurentFrame curent = new FacturaCurentFrame(c, "curent ");
		}
		
		if(e.getSource() == facturaCaldura) {
			facturi.dispose();
			FacturaCurentFrame caldura = new FacturaCurentFrame(c, "caldura ");
		}
		
		if(e.getSource() == facturaApa) {
			facturi.dispose();
			FacturaCurentFrame apa = new FacturaCurentFrame(c, "apa");
		}
		
	}

}
