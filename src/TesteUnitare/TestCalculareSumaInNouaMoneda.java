package TesteUnitare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;
import pachet1.Utilizator;

/**
 * Clasa care testeaza calculul conversiei valutei pe care il realizeaza un convertor valutar
 */

public class TestCalculareSumaInNouaMoneda {
	@Test
	public void test() {
		ConexiuneBazaDeDate conn = new ConexiuneBazaDeDate();
		Utilizator u = new Utilizator(31, "George", "Alin", "Bulevardul Eroilor", "Bucuresti", "Romania", "0781546845", "Alin07@gmail.com", "Alin07", "1234");
		ContBancar c = new ContBancar(2500, "Euro", u);
		assertEquals(12371.75, conn.calculareSumaInNouaMoneda(c.getMoneda(), "Leu", c.getSold()));
		assertEquals(2826.75, conn.calculareSumaInNouaMoneda(c.getMoneda(), "Dolarul american", c.getSold()));
		assertEquals(2128.5, conn.calculareSumaInNouaMoneda(c.getMoneda(), "Lira Sterina", c.getSold()));
		assertEquals(2579.5, conn.calculareSumaInNouaMoneda(c.getMoneda(), "Francul Elvetian", c.getSold()));
	}

}
