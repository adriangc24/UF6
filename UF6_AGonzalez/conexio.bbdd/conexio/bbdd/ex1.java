package conexio.bbdd;


import java.sql.*;

import javax.swing.plaf.synth.SynthScrollBarUI;


public class ex1 {
	public static void main(String[] args) {
		
		String usuario = "usuario";
		String password = "P@ssw0rd";
		String url = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String consulta = "select * from actor;";
		String update;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //conexion con el driver
			System.out.println("Driver carregat correctament");
			Connection con = DriverManager.getConnection(url, usuario, password); //conexion con la bbdd
			Statement st = con.createStatement(); //creacion del statement
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("Conectado correctamente");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			ResultSetMetaData rsmd = rs.getMetaData(); // para sacar informacion de las columnas
			
			/*
			System.out.println(rsmd.getColumnName(1)+"||"+rsmd.getColumnName(2)+"--------------------||"+rsmd.getColumnName(3)+"-----------------||"+rsmd.getColumnName(4));
			while(rs.next()) {
				System.out.println("|"+rs.getInt(1)+"------||"+rs.getString(2)+"||--------------||"+rs.getString(3)+"||-----------------------------||"+rs.getTime(4)+"|");
			}
			*/
			
			PreparedStatement ps;
			
			/*
			consulta = "select * from actor where actor_id = ?";
			ps=con.prepareStatement(consulta);
			ps.setInt(1, 100);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getTime(4));
			}
			*/
			
			update="update country set country=? where country_id=?";
			ps=con.prepareStatement(update);
			ps.setString(1, "Hospitalet");
			ps.setInt(2, 109);
			ps.executeUpdate();
			
			//int filasActualizadas=stm.executeUpdate(update);
			//System.out.println("Actualizadas "+filasActualizadas);
			
		}
		catch(ClassNotFoundException e){
			System.out.println("No se encontro el driver");
		} 
		catch (SQLException s) {
			System.out.println("Excepcio SQL");
			s.printStackTrace();
		}
	}
	
}
