package pachet1;

import java.io.Serializable;

/**
 * Clasa pentru stocarea informatiilor despre contul bancar al unui utilizator
 */

public class ContBancar implements Serializable{
	
	double sold;
	String moneda;
	Utilizator utilizator;
	
	
	public ContBancar(Utilizator utilizator) {
		
		this.sold = 3000;
		this.moneda = "Leu";
		this.utilizator = utilizator;
	}
	
	public ContBancar(double sold, String moneda, Utilizator utilizator) {
		
		this.sold = sold;
		this.moneda = moneda;
		this.utilizator = utilizator;
	}


	public double getSold() {
		return sold;
	}


	public void setSold(double sold) {
		this.sold = sold;
	}


	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public Utilizator getUtilizator() {
		return utilizator;
	}


	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}


	@Override
	public String toString() {
		return utilizator + "\n" + sold + "\n" + moneda + "\n";
	}

}
