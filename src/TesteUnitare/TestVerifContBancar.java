package TesteUnitare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;
import pachet1.Utilizator;

/**
 * Clasa care testeaza returnarea datelor contului unui utilizator din baza de date, dupa datele de utilizator si id-ul acestuia
 */

public class TestVerifContBancar {
	
	@Test
	public void test() {
		ConexiuneBazaDeDate conn = new ConexiuneBazaDeDate();
		Utilizator u = new Utilizator(31, "George", "Alin", "Bulevardul Eroilor", "Bucuresti", "Romania", "0781546845", "Alin07@gmail.com", "Alin07", "1234");
		ContBancar c = new ContBancar(2500, "Euro", u);
		Utilizator u3 = new Utilizator(25, "Popescu", "Bogdan", "Strada Independentei", "Bucuresti", "Romania", "0319647915", "BogdanPop@gmail.ro", "BogdanPop", "9876");
		ContBancar c3 = new ContBancar(2962, "Lira Sterlina", u3);
		assertEquals(null, conn.returnareContBancar(u, conn.cautareUtilizator(u.getNumeUtilizator())));
		assertEquals(c3, conn.returnareContBancar(u3, conn.cautareUtilizator(u3.getNumeUtilizator())));
		//assertEquals(false, Main.cautareContBancar("Alin", "1234", c));
	}

}
