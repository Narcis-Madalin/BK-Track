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

/**
 * Clasa care reprezinta meniul principal al aplicatiei
 */

public class MainMenuFrame implements ActionListener{
	
	JFrame mainMenuFrame = new JFrame();
	JButton butonCreareCont = new JButton();
	JButton butonLogare = new JButton();
	JButton butonIesire = new JButton();
	
	public MainMenuFrame(){
		
		mainMenuFrame.setTitle("Bank App - Meniu Principal");
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainMenuFrame.setSize(700,700); 
		mainMenuFrame.setLayout(new BorderLayout(50,50));
		
		JPanel panouTitlu = new JPanel();
		panouTitlu.setPreferredSize(new Dimension(100,100));
		panouTitlu.setLayout(new BorderLayout());
		mainMenuFrame.add(panouTitlu,BorderLayout.NORTH);
		
		JPanel panouButoane = new JPanel();
		panouButoane.setPreferredSize(new Dimension(100,100));
		panouButoane.setLayout(new GridBagLayout());
		mainMenuFrame.add(panouButoane,BorderLayout.CENTER);
		
		
				JLabel eticheta1 = new JLabel("Meniu Principal");
				
				panouTitlu.add(eticheta1);
				
				eticheta1.setFont(new Font("Arial", Font.PLAIN, 50)); 
				
				eticheta1.setOpaque(true);
				
				
				eticheta1.setVerticalAlignment(JLabel.BOTTOM);
				eticheta1.setHorizontalAlignment(JLabel.CENTER);
				
			
				butonCreareCont.setPreferredSize(new Dimension(200,50));
				butonCreareCont.setText("Creare cont");
				butonCreareCont.setFocusable(false);
				butonCreareCont.setFont(new Font("Arial", Font.PLAIN, 20));
				butonCreareCont.addActionListener(this);

				GridBagConstraints gc=new GridBagConstraints();

				gc.fill=GridBagConstraints.HORIZONTAL;

				gc.gridx = 1;
				gc.gridy = 0;
				gc.weighty = 1;
				
				panouButoane.add(butonCreareCont,gc);
				

				butonLogare.setPreferredSize(new Dimension(200,50));
				butonLogare.setText("Logare");
				butonLogare.setFocusable(false);
				butonLogare.setFont(new Font("Arial", Font.PLAIN, 20));
				butonLogare.addActionListener(this);
				gc.fill=GridBagConstraints.HORIZONTAL;
				gc.gridx = 1;
				gc.gridy = 1;
				gc.weighty = 0.1;
				panouButoane.add(butonLogare,gc);
				
				
				butonIesire.setPreferredSize(new Dimension(200,50));
				butonIesire.setText("Iesire");
				butonIesire.setFocusable(false);
				butonIesire.setFont(new Font("Arial", Font.PLAIN, 20));
				butonIesire.addActionListener(this);
				gc.fill=GridBagConstraints.HORIZONTAL;
				gc.gridx = 1;
				gc.gridy = 2;
				gc.weighty = 1;
				panouButoane.add(butonIesire,gc);
				
				
				mainMenuFrame.setVisible(true); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == butonCreareCont) {
			mainMenuFrame.dispose();
			CreareContFrame creareCont = new CreareContFrame();
		}
		
		if (e.getSource() == butonLogare) {
			mainMenuFrame.dispose();
			LoginFrame loginFrame = new LoginFrame();
		}
		
		if(e.getSource() == butonIesire) {
			System.exit(0);
		}
		
	}

}
