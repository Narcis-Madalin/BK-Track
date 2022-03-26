package pachet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clasa pentru stabilirea conexiunii la baza de date si pentru diferite metode ce necesita accesul la baza de date
 */

public class ConexiuneBazaDeDate {
	
	static String uname = "root", pass = "parola", url = "jdbc:mysql://localhost:3306/banca1";
	
	public ConexiuneBazaDeDate() {
		String uname = "root";
		String pass = "parola";
		String url = "jdbc:mysql://localhost:3306/banca1";
	}
	
	/**
	 * Metoda creareCont este folosita pentru crearea unui cont in ecranul "Creare Cont" al aplicatiei
	 * @param u un obiect de tip Utilizator, pentru preluara informatiilor utilizatorului pentru introducerea lor in baza de date
	 */
	
	public void creareCont(Utilizator u) {
		String query = "Select ID_Utilizator from banca1.Utilizator where NrTel = '" + u.getNrTel() +"'";
		String query1 = "insert into banca1.Utilizator(Nume, Prenume, Varsta, Adresa, Oras, Tara, NrTel, Email, NumeUtilizator, Parola) values ('" + u.getNume() +"', '" + u.getPrenume() +"', '" + u.getVarsta() +"', '" + u.getAdresa() + "', '" + u.getOras() + "', '" + u.getTara() + "', '" + u.getNrTel() + "', '" + u.getEmail() + "', '" + u.getNumeUtilizator() + "', '" + u.getParola() + "');";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			statement.executeUpdate(query1);
			ResultSet rezultat = statement.executeQuery(query);
			rezultat.next();
			String id = rezultat.getString(1);
			int valID = Integer.parseInt(id);
	
			String query2 = "insert into banca1.cont_bancar(ID_Utilizator, Sold, Moneda) values (" + valID + ", 3000.0, 'Leu');";
			statement.executeUpdate(query2);
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda cautareUtilizator este folosita pentru cautarea unui utilizaor in baza de date dupa nume
	 * @param u reprezinta numele de utilizator
	 * @return returneaza id-ul utilizatorului din baza de date
	 */
	
	public String cautareUtilizator (String u) {
		
		String id = "";
		String query1 = "Select ID_Utilizator from banca1.utilizator where NumeUtilizator = '" + u +"' ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			ResultSet rezultat = statement.executeQuery(query1);
			rezultat.next();
			id = rezultat.getString(1);
				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	/**
	 * Metoda cautareUtilizator2 este folosita pentru cautarea unui utilizaor in baza de date dupa nume si parola
	 * @param u reprezinta numele de utilizator, iar p reprezinta parola utilizatorului, acestea fiind preluate din casutele text din LoginFrame
	 * @return returneaza id-ul utilizatorului din baza de date
	 */
	
	public String cautareUtilizator2 (String u, String p) {
		
		String id = "";
		String query1 = "Select ID_Utilizator from banca1.utilizator where NumeUtilizator = '" + u +"' and Parola =  '" + p + "' ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			ResultSet rezultat = statement.executeQuery(query1);
			rezultat.next();
			id = rezultat.getString(1);
				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	/**
	 * Metoda returnareUtilizator este folosita pentru cautarea unui utilizaor in baza de date dupa id-ul sau
	 * @param id reprezinta id-ul utilizatorului
	 * @return returneaza obiectul de tip Utilizator
	 */
	
	public Utilizator returnareUtilizator (String id) {
		
		String nume = "", prenume ="", varsta="", adresa="", oras="", tara="", nrTel="", email="", numeUtilizator="", parola="";
		String query1 = "Select Nume, Prenume, Varsta, Adresa, Oras, Tara, NrTel, Email, NumeUtilizator, Parola from banca1.utilizator where ID_Utilizator = " + id + " ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			ResultSet rezultat = statement.executeQuery(query1);
			
			rezultat.next();
			
			nume = rezultat.getString(1);
			prenume = rezultat.getString(2);
			varsta = rezultat.getString(3);
			adresa = rezultat.getString(4);
			oras = rezultat.getString(5);
			tara = rezultat.getString(6);
			nrTel = rezultat.getString(7);
			email = rezultat.getString(8);
			numeUtilizator = rezultat.getString(9);
			parola = rezultat.getString(10);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		Utilizator u = new Utilizator(Integer.parseInt(varsta), nume, prenume, adresa, oras, tara, nrTel, email, numeUtilizator, parola);
		return u;
	}
	
	/**
	 * Metoda returnareContBancar este folosita pentru cautarea contului bancar in baza de date dupa id-ul utilizatorului si construirea obiectului ContBancar
	 * @param id reprezinta id-ul utilizatorului si u reprezinta obiectul de tip Utilizator
	 * @return returneaza obiectul de tip ContBancar
	 */
	
	public ContBancar returnareContBancar (Utilizator u, String id) {
		
		String sold ="", moneda ="";
		String query2 = "select Sold, Moneda from banca1.cont_bancar where ID_Utilizator = " + id + " ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			ResultSet rezultat = statement.executeQuery(query2);
			
			rezultat.next();
			
			sold = rezultat.getString(1);
			moneda = rezultat.getString(2);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		ContBancar c = new ContBancar(Double.parseDouble(sold), moneda, u);
		return c;
	}
	
	/**
	 * Metoda depozitareSuma este folosita pentru depozitarea unei sume in contul bancar
	 * @param s reprezinta sold-ul adaugat si c reprezinta contul catre care se face adaugarea soldului
	 */
	
	public void depozitareSuma(String s, ContBancar c) {
		
		String query = "update banca1.cont_bancar set Sold = Sold + " + s + " where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			statement.executeUpdate(query);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		c.setSold(c.getSold() + Double.parseDouble(s));
	}
	
	/**
	 * Metoda extragereSuma este folosita pentru extragerea unei sume din contul bancar
	 * @param s reprezinta sold-ul adaugat si c reprezinta contul catre care se face adaugarea soldului si j este frame-ul pentru care apare mesajul de avertizare in cazul in care nu se poate realiza operatia
	 */
	
	public void extragereSuma(String s, ContBancar c, JFrame j) {
		double total = c.getSold();
		double suma = Double.parseDouble(s);
		if(total >= suma) {
	
			String query = "update banca1.cont_bancar set Sold = Sold - " + s + " where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				Connection conexiune = DriverManager.getConnection(url, uname, pass);
				Statement statement = conexiune.createStatement();
				statement.executeUpdate(query);
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			c.setSold(c.getSold() - Double.parseDouble(s));
		}
		
		else {
			JOptionPane.showMessageDialog(j, "Suma introdusa depaseste valoarea soldului!", "Atentie!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Metoda transferSuma este folosita pentru transferarea unei sume dintr-un cont bancar catre alt cont
	 * @param s reprezinta sold-ul transferat si c reprezinta contul de la care care se face transferul soldului si j este frame-ul pentru care apare mesajul de avertizare in cazul in care nu se poate realiza operatia
	 */
	
	public void transferSuma(String s, ContBancar c, JFrame j) {
		double total = c.getSold();
		double suma = Double.parseDouble(s);
		if(total > suma) {
			String username = JOptionPane.showInputDialog("Introdu numele de utilizator al creditorului!");
			if(username != null) {
				
				if(username.isEmpty() == false) {
					String id = cautareUtilizator(username);
					if(id.equals("")) {
						JOptionPane.showMessageDialog(j, "Utilizatorul introdus nu a fost gasit!", "Atentie!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						double sumaConvertita = calculareSumaInNouaMoneda(c.getMoneda(),returnareContBancar(returnareUtilizator(id), id).getMoneda() , suma);
						
						String query1 = "update banca1.cont_bancar set Sold = Sold - " + s + " where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
						String query2 = "update banca1.cont_bancar set Sold = Sold + " + sumaConvertita + " where ID_Utilizator = " + id + " ;";
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch(ClassNotFoundException e) {
							e.printStackTrace();
						}
						
						try {
							Connection conexiune = DriverManager.getConnection(url, uname, pass);
							Statement statement = conexiune.createStatement();
							statement.executeUpdate(query1);
							statement.executeUpdate(query2);
							
						} 
						catch (SQLException e) {
							e.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(j, "Suma introdusa a fost transferata!", "Succes!", JOptionPane.INFORMATION_MESSAGE);
						c.setSold(c.getSold() - Double.parseDouble(s));
					}
					
				}
			
				else  {
					JOptionPane.showMessageDialog(j, "Numele introdus nu este valid!", "Atentie!", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
		
		else {
			JOptionPane.showMessageDialog(j, "Suma introdusa depaseste valoarea soldului!", "Atentie!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Metoda stergereCont este folosita pentru stergerea definitiva a unui cont bancar
	 * @param c reprezinta contul pentru care se face stergerea si j este frame-ul pentru care apare mesajul de avertizare in cazul in care nu se poate realiza operatia
	 */
	
	public void stergereCont(ContBancar c, JFrame j) {
		
		String query1 = "delete from banca1.cont_bancar where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
		String query2 = "delete from banca1.utilizator where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			statement.executeUpdate(query1);
			statement.executeUpdate(query2);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(j, "Contul a fost sters!", "Succes!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Metoda convertireSuma este folosita pentru operatia de conversie valuatara a monedei contului bancar
	 * @param s reprezinta noua valoare a soldului dupa conversie, moneda2 este noua moneda in care a fost convertit soldul contului si c reprezinta contul in care se modifica valuta
	 */
	
	public void convertireSuma(String s, String moneda2, ContBancar c) {
		String uname = "root";
		String pass = "parola";
		String url = "jdbc:mysql://localhost:3306/banca";
		String query = "update banca1.cont_bancar set Sold = " + s + " where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
		String query2 = "update banca1.cont_bancar set Moneda = '" + moneda2 + "' where ID_Utilizator = " + cautareUtilizator(c.getUtilizator().getNumeUtilizator()) + " ;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conexiune = DriverManager.getConnection(url, uname, pass);
			Statement statement = conexiune.createStatement();
			statement.executeUpdate(query);
			statement.executeUpdate(query2);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		c.setMoneda(moneda2);
		c.setSold(Double.parseDouble(s));
	}
	
	/**
	 * Metoda calculareSumaInNouaMoneda este folosita pentru operatia de calculare a conversiei valutare
	 * @param monedaVeche reprezinta vechea valuta a contului, monedaNoua este noua moneda in care se converteste soldul si suma reprezinta valoarea care urmeaza a fi convertita
	 * @return returneaza o valoare de tip double, care reprezinta suma dupa conversie
	 */
	
	public double calculareSumaInNouaMoneda(String monedaVeche, String monedaNoua, double suma) {
		if(monedaVeche.equals("Leu") && monedaNoua.equals("Euro")) {
			suma = suma * 0.2021;
		}
		
		else if(monedaVeche.equals("Leu") && monedaNoua.equals("Dolarul american")) {
			suma = suma * 0.2285;
		}
		
		else if(monedaVeche.equals("Leu") && monedaNoua.equals("Lira Sterina")) {
			suma = suma * 0.1721;
		}
		
		else if(monedaVeche.equals("Leu") && monedaNoua.equals("Francul Elvetian")) {
			suma = suma * 0.2102;
		}
		
		else if(monedaVeche.equals("Euro") && monedaNoua.equals("Leu")) {
			suma = suma * 4.9487;
		}
		
		else if(monedaVeche.equals("Euro") && monedaNoua.equals("Dolarul american")) {
			suma = suma * 1.1307;
		}
		
		else if(monedaVeche.equals("Euro") && monedaNoua.equals("Lira Sterina")) {
			suma = suma * 0.8514;
		}
		
		else if(monedaVeche.equals("Euro") && monedaNoua.equals("Francul Elvetian")) {
			suma = suma * 1.0318;
		}
		
		else if(monedaVeche.equals("Dolarul american") && monedaNoua.equals("Leu")) {
			suma = suma * 4.3767;
		}
		
		else if(monedaVeche.equals("Dolarul american") && monedaNoua.equals("Euro")) {
			suma = suma * 0.8844;
		}
		
		else if(monedaVeche.equals("Dolarul american") && monedaNoua.equals("Lira Sterina")) {
			suma = suma * 0.7530;
		}
		
		else if(monedaVeche.equals("Dolarul american") && monedaNoua.equals("Francul Elvetian")) {
			suma = suma * 0.9196;
		}
		
		else if(monedaVeche.equals("Lira Sterina") && monedaNoua.equals("Leu")) {
			suma = suma * 5.8121;
		}
		
		else if(monedaVeche.equals("Lira Sterina") && monedaNoua.equals("Euro")) {
			suma = suma * 1.1745;
		}
		
		else if(monedaVeche.equals("Lira Sterina") && monedaNoua.equals("Dolarul american")) {
			suma = suma * 1.3280;
		}
		
		else if(monedaVeche.equals("Lira Sterina") && monedaNoua.equals("Francul Elvetian")) {
			suma = suma * 1.2212;
		}
		
		else if(monedaVeche.equals("Francul Elvetian") && monedaNoua.equals("Leu")) {
			suma = suma * 4.7595;
		}
		
		else if(monedaVeche.equals("Francul Elvetian") && monedaNoua.equals("Euro")) {
			suma = suma * 0.9618;
		}
		
		else if(monedaVeche.equals("Francul Elvetian") && monedaNoua.equals("Dolarul american")) {
			suma = suma * 1.0875;
		}
		
		else if(monedaVeche.equals("Francul Elvetian") && monedaNoua.equals("Lira Sterina")) {
			suma = suma * 0.8189;
		}
		
		return suma;
	}

}
