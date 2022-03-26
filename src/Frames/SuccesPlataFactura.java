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
 * Clasa reprezinta o pagina intampinata atunci cand plata unei facturi a fost executata cu succes
 */

public class SuccesPlataFactura implements ActionListener{
	
	ContBancar c;
	
	JFrame succes = new JFrame();
	
	JButton inapoi = new JButton();
	
	JLabel etichetaCalcul;
	
	JPanel panouCampuri;
	
	SuccesPlataFactura(ContBancar c){
		
		this.c = c;
		
		// FRAME
		
		succes.setTitle("Bank App - Succes plata factura ");
		succes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		succes.setSize(700,700);
		succes.setLayout(new BorderLayout(20,20));
				
				
		// PANOURILE
				
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		succes.add(panouTitlu,BorderLayout.NORTH);
								
								
		panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		panouCampuri.setLayout(new GridBagLayout());
		succes.add(panouCampuri,BorderLayout.CENTER);
								
								
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		succes.add(panouBottom,BorderLayout.SOUTH);
				
				
		// ETICHETA DE TITLU
				
		JLabel eticheta1 = new JLabel("Succes la platirea facturii");
		eticheta1.setFont(new Font("Arial", Font.PLAIN, 30));
		eticheta1.setOpaque(true);
		eticheta1.setVerticalAlignment(JLabel.CENTER);
		eticheta1.setHorizontalAlignment(JLabel.CENTER);
								
		panouTitlu.add(eticheta1);
		
		
		// SETAREA BUTOANELOR
		
		inapoi.setPreferredSize(new Dimension(200,50));
		inapoi.setText("Inapoi la pagina principala");
		inapoi.setFocusable(false);
		inapoi.setFont(new Font("Arial", Font.PLAIN, 20));
		inapoi.addActionListener(this);
								
		panouBottom.add(inapoi);
		
		succes.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == inapoi) {
			succes.dispose();
			LoggedInUserFrame loggedIn = new LoggedInUserFrame(c);
		}

	}

}
