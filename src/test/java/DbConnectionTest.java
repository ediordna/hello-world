import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Diese Klasse ist für units-test von nur einer Klasse verantwortlich
public class DbConnectionTest {
	private DbConnection dbConnection;
	private Paket paket;
	
	@Before
	public void setUp() throws Exception {
		dbConnection = new DbConnection();
		paket = new Paket();
	}


	@Test
	public void ZeroGurtmaßTest() { //Einzelne Methoden pro Testfall (insgesamt 7)
		paket.setLength(0);
		paket.setHeight(0);
		paket.setWidth(0);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 0 ergeben sollen",0,ergebnis);
	}
	
	@Test
	public void OneGurtmaßTest() { //Einzelne Methoden pro Testfall (insgesamt 7)
		fail("Noch nicht implementiert");
	}
}
