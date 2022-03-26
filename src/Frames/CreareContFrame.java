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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import pachet1.ConexiuneBazaDeDate;
import pachet1.Utilizator;

/**
 *  Clasa pentru crearea ecranului de Creare Cont in care se introduc datele pentru crearea si stocarea utilizatorului in baza de date
 */

public class CreareContFrame implements ActionListener{
	
	String valNume, valPrenume, valUsername, valParola, valAdresa, valOras, valTara, valNrTel, valEmail, valVarsta;
	
	JFrame creareContFrame = new JFrame();
	
	JButton inregistrare = new JButton();
	JButton inapoi = new JButton();
	
	JTextField nume = new JTextField();
	JTextField prenume = new JTextField();
	JTextField username = new JTextField();
	JPasswordField parola = new JPasswordField();
	JTextField adresa = new JTextField();
	JTextField oras = new JTextField();
	JTextField tara = new JTextField();
	JTextField nrTel = new JTextField();
	JTextField email = new JTextField();
	JTextField varsta = new JTextField();
	
	
	public CreareContFrame(){
		//FRAME-UL
		
		creareContFrame.setTitle("Bank App - Creare Cont");
		creareContFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creareContFrame.setSize(700,700);
		creareContFrame.setLayout(new BorderLayout(20,20));
		
		// PANOURILE
		
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		creareContFrame.add(panouTitlu,BorderLayout.NORTH);
		
		
		JPanel panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		panouCampuri.setLayout(new GridBagLayout());
		creareContFrame.add(panouCampuri,BorderLayout.CENTER);
		
		
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		creareContFrame.add(panouBottom,BorderLayout.SOUTH);
		
		// ETICHETA DE TITLU
		
		JLabel eticheta1 = new JLabel("Introducere Detalii");
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
		
		inregistrare.setPreferredSize(new Dimension(200,50));
		inregistrare.setText("Inregistrare");
		inregistrare.setFocusable(false);
		inregistrare.setFont(new Font("Arial", Font.PLAIN, 20));
		inregistrare.addActionListener(this);
		
		panouBottom.add(inregistrare);
		
		// CASUTELE DE TEXT
		
		// NUMELE
		
		GridBagConstraints gc=new GridBagConstraints();
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 0;
		
		nume.setPreferredSize(new Dimension(170,40));
		nume.setFont(new Font("Arial", Font.PLAIN, 17));
		panouCampuri.add(nume, gc);
		
		JLabel etichetaNume = new JLabel("Nume");
		etichetaNume.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaNume.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaNume, gc);
		
		// PRENUMELE
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weighty = 0;
		
		prenume.setPreferredSize(new Dimension(170,40));
		prenume.setFont(new Font("Arial", Font.PLAIN, 17));
		panouCampuri.add(prenume, gc);
		
		JLabel etichetaPrenume = new JLabel("Prenume");
		etichetaPrenume.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaPrenume.setOpaque(true);
		gc.gridx = 2;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaPrenume, gc);
		
		
		// USERNAME
		
		username.setPreferredSize(new Dimension(170,40));
		username.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weighty = 0;
		panouCampuri.add(username, gc);
		
		JLabel etichetaUsername = new JLabel("Username");
		etichetaUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaUsername.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weighty = 0;
		panouCampuri.add(etichetaUsername, gc);
		
		// PAROLA
		
		parola.setPreferredSize(new Dimension(170,40));
		parola.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weighty = 0;
		panouCampuri.add(parola, gc);
		
		JLabel etichetaParola = new JLabel("Parola");
		etichetaParola.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaParola.setOpaque(true);
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weighty = 0;
		panouCampuri.add(etichetaParola, gc);
		
		// DATA NASTERII
		
		varsta.setPreferredSize(new Dimension(170,40));
		varsta.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weighty = 0;
		panouCampuri.add(varsta, gc);
		
		JLabel etichetaDataNasterii = new JLabel("Varsta");
		etichetaDataNasterii.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaDataNasterii.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weighty = 0;
		panouCampuri.add(etichetaDataNasterii, gc);
		
		
		// Adresa
		
		adresa.setPreferredSize(new Dimension(170,40));
		adresa.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 2;
		gc.gridy = 5;
		gc.weighty = 0;
		panouCampuri.add(adresa, gc);
		
		JLabel etichetaAdresa = new JLabel("Adresa"); // creates a label and sets text for it
		etichetaAdresa.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaAdresa.setOpaque(true);
		gc.gridx = 2;
		gc.gridy = 4;
		gc.weighty = 0;
		panouCampuri.add(etichetaAdresa, gc);
		
		// Oras
		
		oras.setPreferredSize(new Dimension(170,40));
		oras.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 0;
		gc.gridy = 7;
		gc.weighty = 0;
		panouCampuri.add(oras, gc);
		
		JLabel etichetaOras = new JLabel("Oras"); // creates a label and sets text for it
		etichetaOras.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaOras.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weighty = 0;
		panouCampuri.add(etichetaOras, gc);
		
		// Tara
		
		tara.setPreferredSize(new Dimension(170,40));
		tara.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 2;
		gc.gridy = 7;
		gc.weighty = 0;
		panouCampuri.add(tara, gc);
		
		JLabel etichetaTara = new JLabel("Tara");
		etichetaTara.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaTara.setOpaque(true);
		gc.gridx = 2;
		gc.gridy = 6;
		gc.weighty = 0;
		panouCampuri.add(etichetaTara, gc);
		
		// Nr. Telefon
		
		nrTel.setPreferredSize(new Dimension(170,40));
		nrTel.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 0;
		gc.gridy = 9;
		gc.weighty = 0;
		panouCampuri.add(nrTel, gc);
		
		JLabel etichetaNrTel = new JLabel("Nr. de telefon");
		etichetaNrTel.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaNrTel.setOpaque(true);
		gc.gridx = 0;
		gc.gridy = 8;
		gc.weighty = 0;
		panouCampuri.add(etichetaNrTel, gc);
		
		// Email
		
		email.setPreferredSize(new Dimension(170,40));
		email.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 2;
		gc.gridy = 9;
		gc.weighty = 0;
		panouCampuri.add(email, gc);
		
		JLabel etichetaEmail = new JLabel("Email");
		etichetaEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaEmail.setOpaque(true);
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx = 2;
		gc.gridy = 8;
		gc.weighty = 0;
		panouCampuri.add(etichetaEmail, gc);
		
		
		creareContFrame.setVisible(true);
	}
	
	/**
	 * Metoda care reprezinta actiunile diferitelor butoane din frame
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == inapoi) {
			creareContFrame.dispose();
			MainMenuFrame meniuPrincipal = new MainMenuFrame();
		}
		
		if(e.getSource() == inregistrare) {
			valNume = nume.getText();
			valPrenume = prenume.getText();
			valUsername = username.getText();
			//String valParol = new String (parola.getPassword());
			valParola = parola.getText();
			valVarsta = varsta.getText();
			valAdresa = adresa.getText();
			valOras = oras.getText();
			valTara = tara.getText();
			valNrTel = nrTel.getText();
			valEmail = email.getText();
			
			Utilizator u = new Utilizator(Integer.parseInt(valVarsta), valNume, valPrenume, valAdresa, valOras, valTara, valNrTel, valEmail, valUsername, valParola);
			
			ConexiuneBazaDeDate c = new ConexiuneBazaDeDate();
			c.creareCont(u);
	
			creareContFrame.dispose();
			MainMenuFrame meniuPrincipal = new MainMenuFrame();
		}
		
	}

}
