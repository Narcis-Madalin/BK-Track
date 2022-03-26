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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;
import pachet1.Utilizator;

/**
 * Clasa reprezinta meniul de logare al utilizatorului in contul bancar al aplicatiei
 */

public class LoginFrame implements ActionListener{
	
	String valUsername , valParola ;
	
	JFrame loginFrame = new JFrame();
	
	JButton logare = new JButton();
	JButton inapoi = new JButton();
	
	JTextField username = new JTextField();
	JPasswordField parola = new JPasswordField();
	
	LoginFrame(){
		
		// FRAME
		
		loginFrame.setTitle("Bank App - Logare");
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(700,700);
		loginFrame.setLayout(new BorderLayout(20,20));
		
		// PANOURILE
		
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		loginFrame.add(panouTitlu,BorderLayout.NORTH);
				
				
		JPanel panouCampuri = new JPanel();
		panouCampuri.setPreferredSize(new Dimension(100,100));
		panouCampuri.setLayout(new GridBagLayout());
		loginFrame.add(panouCampuri,BorderLayout.CENTER);
				
				
		JPanel panouBottom = new JPanel();
		panouBottom.setPreferredSize(new Dimension(100,100));
		loginFrame.add(panouBottom,BorderLayout.SOUTH);
		
		
		// ETICHETA DE TITLU
		
		JLabel eticheta1 = new JLabel("Login");
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
				
		logare.setPreferredSize(new Dimension(200,50));
		logare.setText("Login");
		logare.setFocusable(false);
		logare.setFont(new Font("Arial", Font.PLAIN, 20));
		logare.addActionListener(this);
				
		panouBottom.add(logare);
		
		// CASUTELE DE TEXT
		
		// USERNAME
		
		GridBagConstraints gc=new GridBagConstraints();
		
		username.setPreferredSize(new Dimension(170,40));
		username.setFont(new Font("Arial", Font.PLAIN, 17));
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weighty = 0;
		panouCampuri.add(username, gc);
				
		JLabel etichetaUsername = new JLabel("Username");
		etichetaUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaUsername.setOpaque(true);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weighty = 0;
		panouCampuri.add(etichetaUsername, gc);
				
		// PAROLA
				
		parola.setPreferredSize(new Dimension(170,40));
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weighty = 0;
		panouCampuri.add(parola, gc);
				
		JLabel etichetaParola = new JLabel("Parola");
		etichetaParola.setFont(new Font("Arial", Font.PLAIN, 20));
		etichetaParola.setOpaque(true);
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weighty = 0;
		panouCampuri.add(etichetaParola, gc);
		
		
		loginFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == inapoi) {
			loginFrame.dispose();
			MainMenuFrame mainMenuFrame = new MainMenuFrame();
		}
		
		if(e.getSource() == logare) {
			valUsername = username.getText();
			valParola = parola.getText();
			ConexiuneBazaDeDate c = new ConexiuneBazaDeDate();
			String id = c.cautareUtilizator2(valUsername, valParola);
			if(id.equals("")) {
				JOptionPane.showMessageDialog(loginFrame, "Utilizatorul introdus nu a fost gasit!", "Atentie!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Utilizator u = c.returnareUtilizator(id);
				ContBancar cont = c.returnareContBancar(u, id);
				loginFrame.dispose();
				LoggedInUserFrame loggedInUser = new LoggedInUserFrame(cont);
			}
		}
		
	}

}
