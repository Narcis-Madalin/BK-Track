package pachet1;

import java.io.Serializable;

/**
 * Clasa pentru stocarea informatiilor unui utilizator inscris in baza de date
 */

public class Utilizator extends Persoana implements Serializable{
	
	String numeUtilizator, parola;

	public Utilizator(int varsta, String nume, String prenume, String adresa, String oras, String tara,
			String nrTel, String email, String numeUtilizator, String parola) {
		super(varsta, nume, prenume, adresa, oras, tara, nrTel, email);
		this.numeUtilizator = numeUtilizator;
		this.parola = parola;
	}

	public String getNumeUtilizator() {
		return numeUtilizator;
	}

	public void setNumeUtilizator(String numeUtilizator) {
		this.numeUtilizator = numeUtilizator;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	@Override
	public String toString() {
		return super.toString() + numeUtilizator + "\n" + parola + "\n";
	}
	
	

}
