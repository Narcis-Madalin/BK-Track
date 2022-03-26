package TesteUnitare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pachet1.ConexiuneBazaDeDate;
import pachet1.ContBancar;
import pachet1.Utilizator;

/**
 * Clasa care testeaza cautarea id-ului unui utilizator in baza de date, dupa numele sau de utilizator 
 */

public class TestReturnareUtilizCautat {
	
	@Test
	public void test() {
		ConexiuneBazaDeDate conn = new ConexiuneBazaDeDate();
		Utilizator u = new Utilizator(31, "George", "Alin", "Bulevardul Eroilor", "Bucuresti", "Romania", "0781546845", "Alin07@gmail.com", "Alin07", "1234");
		ContBancar c = new ContBancar(2500, "Euro", u);
		Utilizator u2 = new Utilizator(27, "Ionut", "Andrei", "Strada Universitatii", "Arad", "Romania", "0797489614", "IonutCelDur@yahoo.ro", "IonutCelDur", "nustiuceparolasapun");
		ContBancar c2 = new ContBancar(1300, "Lira Sterlina", u2);
		//Utilizator u3 = new Utilizator(25, "Popescu", "Bogdan", "Strada Independentei", "Bucuresti", "Romania", "0319647915", "BogdanPop@gmail.ro", "BogdanPop", "9876");
		//ContBancar c3 = new ContBancar(2962, "Lira Sterlina", u3);
		List<ContBancar> lista = new ArrayList<>();
		lista.add(c);
		lista.add(c2);
		assertEquals("", conn.cautareUtilizator("Alin07"));
		assertEquals("5", conn.cautareUtilizator("BogdanPop"));
	}

}
