package Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;
import pachet1.Mail;

/**
 * Clasa reprezinta o factura de curent/apa/caldura care poate fi platita de utilizatorul unui cont bancar
 */

public class FacturaCurentFrame implements ActionListener{
	
	ContBancar c;
	ConexiuneBazaDeDate conn;
	
	String tipFactura;
	
	double random , random2;
	
	double subtotal, subtotalConvertit, procentTva, tva , total, totalConvertit, tvaConvertit;
	
	JFrame facturaCurent = new JFrame();
	
	JButton inapoi = new JButton();
	JButton plateste = new JButton();
	
	JLabel etichetaNume, etichetaPrenume, etichetaAdresa, etichetaOras, etichetaTara, etchetaNrTel, etichetaEmail;
	
	JPanel panouCampuri;
	
	FacturaCurentFrame(ContBancar c, String tipFactura){
		
		this.c = c;
		conn = new ConexiuneBazaDeDate();
		this.tipFactura = tipFactura;
		random = ThreadLocalRandom.current().nextDouble(100, 350);
		random2 = ThreadLocalRandom.current().nextDouble(1, 9);
		subtotal = random;
		subtotalConvertit = conn.calculareSumaInNouaMoneda("Leu", c.getMoneda(), subtotal);
		procentTva = random2;
		tva = procentTva * subtotal / 100;
		total = tva + subtotal;
		totalConvertit = conn.calculareSumaInNouaMoneda("Leu", c.getMoneda(), total);
		tvaConvertit = conn.calculareSumaInNouaMoneda("Leu", c.getMoneda(), tva);
		
		// FRAME
		
		facturaCurent.setTitle("Bank App - Factura " + tipFactura);
		facturaCurent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		facturaCurent.setSize(700,700);
		facturaCurent.setLayout(new BorderLayout(20,20));
				
				
		// PANOURILE
				
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		facturaCurent.add(panouTitlu,BorderLayout.NORTH);
								
								
		panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		panouCampuri.setLayout(new GridBagLayout());
		facturaCurent.add(panouCampuri,BorderLayout.CENTER);
								
								
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		facturaCurent.add(panouBottom,BorderLayout.SOUTH);
				
				
		// ETICHETA DE TITLU
				
		JLabel eticheta1 = new JLabel("Factura " + tipFactura);
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
		
		
		plateste.setPreferredSize(new Dimension(200,50));
		plateste.setText("Efectueaza plata");
		plateste.setFocusable(false);
		plateste.setFont(new Font("Arial", Font.PLAIN, 20));
		plateste.addActionListener(this);
								
		panouBottom.add(plateste);
		
		
		// ETICHETE De MIJLOC
		
		
		GridBagConstraints gc=new GridBagConstraints();
				
		
				
		JLabel etichetaFacturat = new JLabel("Facturat catre: ");
		etichetaFacturat.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaFacturat.setOpaque(true);
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaFacturat, gc);
		
		
		// eticheta nume
		
		
		
		JLabel etichetaNume = new JLabel("Nume: " + c.getUtilizator().getNume());
		etichetaNume.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaNume.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 0;
		panouCampuri.add(etichetaNume, gc);
		
		
		// eticheta prenume
		
		
		
				JLabel etichetaPrenume = new JLabel("Prenume: " + c.getUtilizator().getPrenume());
				etichetaPrenume.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaPrenume.setOpaque(true);
				gc.gridx = 0;
				gc.gridy = 2;
				gc.weighty = 0;
				panouCampuri.add(etichetaPrenume, gc);
		
		
				// eticheta adresa
				
				
				
				JLabel etichetaAdresa = new JLabel("Adresa: " + c.getUtilizator().getAdresa());
				etichetaAdresa.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaAdresa.setOpaque(true);
				gc.gridx = 0;
				gc.gridy = 3;
				gc.weighty = 0;
				panouCampuri.add(etichetaAdresa, gc);
				
					// eticheta oras
				
				
				
				JLabel etichetaOras = new JLabel("Oras: " + c.getUtilizator().getOras());
				etichetaOras.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaOras.setOpaque(true);
				gc.gridx = 0;
				gc.gridy = 4;
				gc.weighty = 0;
				panouCampuri.add(etichetaOras, gc);
				
				// eticheta tara
				
				
				
				JLabel etichetaTara = new JLabel("Tara: " + c.getUtilizator().getTara());
				etichetaTara.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaTara.setOpaque(true);
				gc.gridx = 0;
				gc.gridy = 5;
				gc.weighty = 0;
				panouCampuri.add(etichetaTara, gc);
				
				
				// eticheta nrTel
				
				
				JLabel etichetanrTel = new JLabel("Telefon: " + c.getUtilizator().getNrTel());
				etichetanrTel.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetanrTel.setOpaque(true);
				gc.gridx = 0;
				gc.gridy = 6;
				gc.weighty = 0;
				panouCampuri.add(etichetanrTel, gc);
				
				// eticheta email
				
				
				JLabel etichetaEmail = new JLabel("Email: " + c.getUtilizator().getEmail());
				etichetaEmail.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaEmail.setOpaque(true);
				gc.gridx = 0;
				gc.gridy = 7;
				gc.weighty = 0;
				panouCampuri.add(etichetaEmail, gc);
				
				// eticheta subtotal
				
				JLabel etichetaSubtotal = new JLabel("Subtotal: " + subtotalConvertit);
				etichetaSubtotal.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaSubtotal.setOpaque(true);
				gc.gridx = 2;
				gc.gridy = 8;
				gc.weighty = 0;
				panouCampuri.add(etichetaSubtotal, gc);
				
				// eticheta procent tva
				
				JLabel etichetaProcentTva = new JLabel("% TVA: " + procentTva);
				etichetaProcentTva.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaProcentTva.setOpaque(true);
				gc.gridx = 2;
				gc.gridy = 9;
				gc.weighty = 0;
				panouCampuri.add(etichetaProcentTva, gc);
				
				// eticheta val tva
				
				JLabel etichetaValTva = new JLabel("Val TVA: " + tvaConvertit);
				etichetaValTva.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaValTva.setOpaque(true);
				gc.gridx = 2;
				gc.gridy = 10;
				gc.weighty = 0;
				panouCampuri.add(etichetaValTva, gc);
				
				// eticheta val total
				
				JLabel etichetaValTotal = new JLabel("TOTAL: " + totalConvertit);
				etichetaValTotal.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaValTotal.setOpaque(true);
				gc.gridx = 2;
				gc.gridy = 11;
				gc.weighty = 0;
				panouCampuri.add(etichetaValTotal, gc);
				
				// eticheta despartitoare
				
				JLabel etichetaDespartitoare = new JLabel(" ");
				etichetaDespartitoare.setFont(new Font("Arial", Font.PLAIN, 20));
				etichetaDespartitoare.setOpaque(true);
				gc.fill=GridBagConstraints.HORIZONTAL;
				gc.gridx = 1;
				gc.gridy = 6;
				gc.weighty = 0;
				panouCampuri.add(etichetaDespartitoare, gc);
		
		
		facturaCurent.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == inapoi) {
			facturaCurent.dispose();
			LoggedInUserFrame loggedIn = new LoggedInUserFrame(c);
		}
		
		if(e.getSource() == plateste) {
			int val = JOptionPane.showConfirmDialog(facturaCurent, "Doresti sa platesti factura?", "", JOptionPane.YES_NO_CANCEL_OPTION);
			if(val == 0) {
				String cod = getRandom();
				Mail mail = new Mail();
				mail.setupServerProperties();
				String email = "testbancar@gmail.com";
				try {
					mail.draftEmail(email, Integer.parseInt(cod));
				} catch (NumberFormatException | MessagingException | IOException e1) {
					e1.printStackTrace();
				}
				try {
					mail.sendEmail();
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				String suma = JOptionPane.showInputDialog("Introdu codul de verificare trimis pe email");
				if(suma != null) {
				if(suma.equals(cod) == true) {
					String suma2 = "" + totalConvertit;
					
					conn.extragereSuma(suma2, c, facturaCurent);
					SuccesPlataFactura succes = new SuccesPlataFactura(c);
					facturaCurent.dispose();
				}
				else {
					facturaCurent.dispose();
					EroarePlataFactura eroare = new EroarePlataFactura(c);
				}
				}
			}
			else {
				facturaCurent.dispose();
				EroarePlataFactura eroare = new EroarePlataFactura(c);
			}
		}
		
		
		
	}
	
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

}
