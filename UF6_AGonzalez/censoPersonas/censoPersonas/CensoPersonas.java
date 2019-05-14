package censoPersonas;

import java.sql.*;

public class CensoPersonas extends Persona implements Conexion{
	
	Connection con;
	Statement st;
	
	public static void main(String[] args) {
		cargarDriver();
		conectarBBDD();
		Persona p;
		p=new Persona("46738476","manolo",new Date (2001,5,5),"calle aragon 9","699563526");
	}
	public static void cargarDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver cargado correctamente");
		}
		catch(ClassNotFoundException e){
			System.out.println("Error de driver");
			e.printStackTrace();
		}
	}
	public static void conectarBBDD() {
		try {
			Connection con = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conexion creada correctamente");
		}
		catch(SQLException s) {
			System.out.println("Error SQL: ");
			s.printStackTrace();
		}
	}
}
