package pachet1;

import java.io.Serializable;

/**
 * Clasa pentru stocarea informatiilor de baza ale unei persoane
 */

public class Persoana implements Serializable{
	
	int varsta;
	String nume, prenume, adresa, oras, tara, nrTel, email;
	
	public Persoana(int varsta, String nume, String prenume, String adresa, String oras, String tara,
			String nrTel, String email) {

		this.varsta = varsta;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.oras = oras;
		this.tara = tara;
		this.nrTel = nrTel;
		this.email = email;
	}
	
	
	public int getVarsta() {
		return varsta;
	}
	
	
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	
	
	public String getNume() {
		return nume;
	}
	
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	
	public String getPrenume() {
		return prenume;
	}
	
	
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	
	public String getAdresa() {
		return adresa;
	}
	
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
	public String getOras() {
		return oras;
	}
	
	
	public void setOras(String oras) {
		this.oras = oras;
	}
	
	
	public String getTara() {
		return tara;
	}
	
	
	public void setTara(String tara) {
		this.tara = tara;
	}
	
	
	public String getNrTel() {
		return nrTel;
	}
	
	
	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return  nume + "\n" + prenume + "\n" + varsta + "\n" +
				adresa + "\n" + oras + "\n" +  tara + "\n" +  nrTel + "\n" + email + "\n";
	}
	
	

}
