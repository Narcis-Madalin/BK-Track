package Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;

/**
 * Clasa reprezinta un calculator de conversie valutara
 */

public class ConvertorValutarFrame implements ActionListener{
	
	ContBancar c;
	ConexiuneBazaDeDate conn;
	
	String moneda1, moneda2;
	
	double valSuma2 = 0.0;
	
	JFrame convertor = new JFrame();
	
	JButton inapoi = new JButton();
	JButton calcul = new JButton();
	
	String[] monede = {"Leu", "Euro", "Dolarul american", "Lira Sterina", "Francul Elvetian"};//, "Dolarul australian", "Dolarul Canadian", "Coroana Ceha", "Coroana Daneza", "Coroana Suedeza", "Rubla Ruseasca", "Dinarul Sarbesc", "Zlotul Polonez", "Lira Turceasca", "Forinti"};
	
	JComboBox monedaDin = new JComboBox(monede);
	JComboBox monedaIn = new JComboBox(monede);
	
	JTextField suma = new JTextField();
	
	JLabel etichetaCalcul;
	
	JPanel panouCampuri;
	
	ConvertorValutarFrame(ContBancar c){
		
		this.c = c;
		conn = new ConexiuneBazaDeDate();
		
		// FRAME
		
		convertor.setTitle("Bank App - Convertor Valutar ");
		convertor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		convertor.setSize(700,700);
		convertor.setLayout(new BorderLayout(20,20));
				
				
		// PANOURILE
				
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		convertor.add(panouTitlu,BorderLayout.NORTH);
								
								
		panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		panouCampuri.setLayout(new GridBagLayout());
		convertor.add(panouCampuri,BorderLayout.CENTER);
								
								
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		convertor.add(panouBottom,BorderLayout.SOUTH);
				
				
		// ETICHETA DE TITLU
				
		JLabel eticheta1 = new JLabel("Convertor Valutar");
		eticheta1.setFont(new Font("Arial", Font.PLAIN, 30));
		eticheta1.setOpaque(true);
		eticheta1.setVerticalAlignment(JLabel.CENTER);
		eticheta1.setHorizontalAlignment(JLabel.CENTER);
								
		panouTitlu.add(eticheta1);
		
		
		// SETAREA BUTOANELOR
		
		inapoi.setPreferredSize(new Dimension(200,50));
		inapoi.setText("Inapoi");
		inapoi.setFocusable(false);
		inapoi.setFont(new Font("Arial", Font.PLAIN, 20));
		inapoi.addActionListener(this);
								
		panouBottom.add(inapoi);
		
		
		calcul.setPreferredSize(new Dimension(200,50));
		calcul.setText("Calculeaza");
		calcul.setFocusable(false);
		calcul.setFont(new Font("Arial", Font.PLAIN, 20));
		calcul.addActionListener(this);
								
		panouBottom.add(calcul);
		
		
		// ETICHETE De MIJLOC
		
		
		GridBagConstraints gc=new GridBagConstraints();
		
		
		// DIN
		
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 0;
				
		monedaDin.setPreferredSize(new Dimension(170,40));
		monedaDin.setFont(new Font("Arial", Font.PLAIN, 17));
		panouCampuri.add(monedaDin, gc);
				
		JLabel etichetaMonedaDin = new JLabel("Din:");
		etichetaMonedaDin.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaMonedaDin.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaMonedaDin, gc);
		
		
		// SUMA
		
		suma.setPreferredSize(new Dimension(170,40));
		suma.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weighty = 0;
		panouCampuri.add(suma, gc);
		
		JLabel etichetaSuma = new JLabel("Suma:");
		etichetaSuma.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaSuma.setOpaque(true);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaSuma, gc);
		
		
		// Moneda IN
		
		monedaIn.setPreferredSize(new Dimension(170,40));
		monedaIn.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weighty = 0;
		panouCampuri.add(monedaIn, gc);
				
		JLabel etichetaMonedaIn = new JLabel("In:");
		etichetaMonedaIn.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaMonedaIn.setOpaque(true);
		gc.gridx = 2;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaMonedaIn, gc);
		
		
		etichetaCalcul = new JLabel("Valoarea este: " + valSuma2);
		etichetaCalcul.setFont(new Font("Arial", Font.PLAIN, 30));
		etichetaCalcul.setOpaque(true);
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weighty = 1;
		panouCampuri.add(etichetaCalcul, gc);
		
		
		convertor.setVisible(true); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == inapoi) {
			convertor.dispose();
			LoggedInUserFrame loggedIn = new LoggedInUserFrame(c);
		}
		
		if(e.getSource() == calcul) {
			String valSuma = suma.getText();
			if(valSuma.isEmpty() == false) {
				String validare = "[0-9]+[.]?[0-9]*";
				
				if(valSuma.matches(validare) == false) {
					JOptionPane.showMessageDialog(convertor, "Suma introdusa nu este valida!", "Atentie!", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					
					
					
					moneda1 = (String) monedaDin.getSelectedItem();
					moneda2 = (String) monedaIn.getSelectedItem();
					
					valSuma2 = Double.parseDouble(valSuma);
					
					valSuma2 = conn.calculareSumaInNouaMoneda(moneda1, moneda2, valSuma2);
					
					valMoneda();

				}
			}
		}
		
	}
	
	public void valMoneda() {
		etichetaCalcul.setText("Valoarea este: " + valSuma2);
	}

}
