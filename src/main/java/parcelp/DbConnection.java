package parcelp;
import java.sql.*;

public class DbConnection {
	public Paket calculateSize(Paket pak) {
		int GurtmassEingabe = berechneGurtmass(pak);
		String SQL_Query = "SELECT Paketgroesse from Groessen where Min_Gurtmass <=" + GurtmassEingabe
				+ " AND Max_Gurtmass >" + GurtmassEingabe;

		try {
			String url = "jdbc:mysql://mysql_parcelsize/Datenbank_APS";
			Connection conn = DriverManager.getConnection(url, "www-data", "SWA2018mysql");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SQL_Query);
			if (rs.next()) {
				String Paketgroesse = rs.getString("Paketgroesse");
				System.out.println(Paketgroesse + "\n");
				pak.setSize(Paketgroesse);
			} else
				pak.setSize("unknown");
			rs.close(); // andere Reihenfolge
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return pak;
	}

	public int berechneGurtmass(Paket pack) {
		int Gurtmass = pack.getLength() + 2 * pack.getWidth() + 2 * pack.getHeight();
		
		return Gurtmass;
	}

}