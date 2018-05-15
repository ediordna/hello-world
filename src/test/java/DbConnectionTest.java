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

	//Einzelne Methoden pro Testfall (insgesamt 7)
	//berechneGurtmass Methode wird geprüft
	@Test
	public void ZeroGurtmaßTest() { 
		paket.setLength(0);
		paket.setHeight(0);
		paket.setWidth(0);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 0 ergeben sollen",0,ergebnis);
	}
	
	@Test
	public void OneGurtmaßTest() { 
		paket.setLength(1);
		paket.setHeight(0);
		paket.setWidth(0);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 1 ergeben sollen",1,ergebnis);
	}
	
	@Test
	public void SmallGurtmaßTest() {
		paket.setLength(5);
		paket.setHeight(10);
		paket.setWidth(5);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 35 ergeben sollen",35,ergebnis);
	}
	
	@Test
	public void MediumGurtmaßTest() {
		paket.setLength(10);
		paket.setHeight(10);
		paket.setWidth(10);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 50 ergeben sollen",50,ergebnis);
	}
	
	@Test
	public void LargeGurtmaßTest() {
		paket.setLength(10);
		paket.setHeight(15);
		paket.setWidth(10);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 65 ergeben sollen",65,ergebnis);
	}
	
	@Test
	public void XLargeGurtmaßTest() {
		paket.setLength(20);
		paket.setHeight(10);
		paket.setWidth(20);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 80 ergeben sollen",80,ergebnis);
	}
	
	@Test
	public void XXLargeGurtmaßTest() {
		paket.setLength(20);
		paket.setHeight(40);
		paket.setWidth(100);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 300 ergeben sollen",300,ergebnis);
	}
	
	@Test
	public void TooLargeGurtmaßTest() {
		paket.setLength(1000);
		paket.setHeight(1000);
		paket.setWidth(1000);
		int ergebnis = dbConnection.berechneGurtmass(paket);
		assertEquals("Hätte 5000 ergeben sollen",5000,ergebnis);
	}
		
}
