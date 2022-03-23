package conexionpostgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	final private String url = "jdbc:postgresql://ec2-3-208-121-149.compute-1.amazonaws.com:5432/d1tnit3tds2m1j";
	final private String user = "azlqopjoohuzmf";
	final private String password = "6ccbc5de0675ce4f7e7a83acb8fe2fbac912417e1b9a6ea8761e4ece516e2590";

	private Connection conn = null;

	public Connection obtenerConexion() {

		try {
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexion exitosa");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.conn;
	}
	
	public void cerrarConexion() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
