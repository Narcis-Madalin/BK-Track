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
 * Clasa reprezinta o pagina intampinata atunci cand plata unei facturi a esuat
 */

public class EroarePlataFactura implements ActionListener{
	
	ContBancar c;

	JFrame eroare = new JFrame();
	
	JButton inapoi = new JButton();
	
	JLabel etichetaCalcul;
	
	JPanel panouCampuri;
	
	EroarePlataFactura(ContBancar c){
		
		this.c = c;
		
		// FRAME
		
		eroare.setTitle("Bank App - Eroare plata factura ");
		eroare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eroare.setSize(700,700);
		eroare.setLayout(new BorderLayout(20,20));
				
				
		// PANOURILE
				
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		eroare.add(panouTitlu,BorderLayout.NORTH);
								
								
		panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		panouCampuri.setLayout(new GridBagLayout());
		eroare.add(panouCampuri,BorderLayout.CENTER);
								
								
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		eroare.add(panouBottom,BorderLayout.SOUTH);
				
				
		// ETICHETA DE TITLU
				
		JLabel eticheta1 = new JLabel("Eroare la platirea facturii");
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
		
		
		// ETICHETE De MIJLOC
		
		
		GridBagConstraints gc=new GridBagConstraints();
		
		
		// DIN
				
		JLabel etichetaMonedaDin = new JLabel("Fie codul de verificare a fost introdus gresit, fie soldul este insuficient pentru plata facturii:"); // creates a label and sets text for it
		etichetaMonedaDin.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaMonedaDin.setOpaque(true);
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaMonedaDin, gc);
		
		eroare.setVisible(true); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == inapoi) {
			eroare.dispose();
			LoggedInUserFrame loggedIn = new LoggedInUserFrame(c);
		}

	}

}
