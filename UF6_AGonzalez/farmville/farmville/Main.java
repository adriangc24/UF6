package farmville;
import java.util.*;
import java.sql.*;
import java.util.*;

public class Main extends Granjero{
			static Scanner sc;
	public static void main(String[] args) {
		String usuario = "usuario";
		String password = "P@ssw0rd";
		String url = "jdbc:mysql://localhost:3306/farmville?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		ArrayList<Granjero> array = new ArrayList<Granjero>();
		sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregat correctament");
			
			Connection con = DriverManager.getConnection(url, usuario, password);
			Statement stm = con.createStatement();
			
			stm= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("Conectado correctamente");
			Statement st = con.createStatement();
			ResultSet rs = null;
			Granjero g;
			
			mostrarBases(rs,st);
			mostrarTablas(rs, st);
			ordenarDinero(rs, st, array);
			ordenarNombre(array);
			ordenarPuntos(array);
			añadirGranjero(rs,st);
			buscarGranjero(rs, st);
			aumentarNivel(rs, st);
			eliminarFila(rs, st);
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontro el driver");
		} catch (SQLException s) {
			System.out.println("Excecpcio SQL");
			s.printStackTrace();
		}
	}

	public static void mostrarBases(ResultSet rs,Statement st) throws SQLException {
		rs=st.executeQuery("show databases");
		System.out.println("+--------------------------------------------+");
		System.out.println("|------------- BASES DE DATOS ---------------|");
		System.out.println("+--------------------------------------------+");
		while(rs.next()) {
		System.out.println(rs.getString(1));
		}
	}
	public static void mostrarTablas(ResultSet rs,Statement st) throws SQLException {
		rs=st.executeQuery("show tables from farmville");
		System.out.println("+--------------------------------------------+");
		System.out.println("|----------- TABLAS DE FARMVILLE ------------|");
		System.out.println("+--------------------------------------------+");
		while(rs.next()) {
		System.out.println(rs.getString(1));
		}
	}
	public static void ordenarDinero(ResultSet rs,Statement st,ArrayList<Granjero> array) throws SQLException {
		Granjero g;
		rs=st.executeQuery("select * from granjeros order by dinero");
		while(rs.next()) {
			g=new Granjero(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getInt(6));
			array.add(g);
		}
		System.out.println("+--------------------------------------------+");
		System.out.println("|------- ARRAY ORDENADOR POR DINERO ---------|");
		System.out.println("+--------------------------------------------+");
		for (Granjero z:array) {
			System.out.println(z.getId()+" | "+z.getNombre()+" | "+z.getDescripcion()+" | "+z.getDinero()+" | "+z.getPuntos()+" | "+z.getDinero());
		}
	}
	public static void ordenarNombre(ArrayList<Granjero> array) {
		array.sort(comp);
		System.out.println("+--------------------------------------------+");
		System.out.println("|-------- ARRAY ORDENADO POR NOMBRE ---------|");
		System.out.println("+--------------------------------------------+");
		for (Granjero x:array) {
			System.out.println(x.getId()+" | "+x.getNombre()+" | "+x.getDescripcion()+" | "+x.getDinero()+" | "+x.getPuntos()+" | "+x.getDinero());
		}
	}
	public static void ordenarPuntos(ArrayList<Granjero> array) {
		array.sort(comp2);
		System.out.println("+--------------------------------------------+");
		System.out.println("|-------- ARRAY ORDENADO POR PUNTOS ---------|");
		System.out.println("+--------------------------------------------+");
		for (Granjero x:array) {
			System.out.println(x.getId()+" | "+x.getNombre()+" | "+x.getDescripcion()+" | "+x.getDinero()+" | "+x.getPuntos()+" | "+x.getDinero());
		}
	}
	public static void añadirGranjero(ResultSet rs,Statement st) throws SQLException {
		System.out.println("Añade el nombre del granjero");
		String nombreGranjero=sc.nextLine();
		st.execute("insert into granjeros(nombre,descripcion)values('"+nombreGranjero+"','"+null+"')");
		rs=st.executeQuery("select * from granjeros order by id desc limit 1");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getFloat(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
		}
	}
	public static void buscarGranjero(ResultSet rs,Statement st) throws SQLException {
		System.out.println("---------------------------------------------------------------");
		System.out.println("Por que parametro quieres buscar un granjero?");
		System.out.println("1. POR NOMBRE");
		System.out.println("2. POR DESCRIPCION");
		int opcio=sc.nextInt();
		if(opcio==1) {
			System.out.println("Introduce el nombre a buscar");
			String nombre=sc.next();
			rs=st.executeQuery("select * from granjeros where nombre ="+"'"+nombre+"'");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getFloat(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
			}
		}
		else if(opcio==2) {
			System.out.println("Introduce la descripcion a buscar");
			String descripcion=sc.next();
			rs=st.executeQuery("select * from granjeros where descripcion ="+"'"+descripcion+"'");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getFloat(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
			}
		}
		else {
			System.out.println("ERROR: Opcion invalida");
		}
	}
	public static void aumentarNivel(ResultSet rs,Statement st) throws SQLException {
		System.out.println("------------------------------------------------------------------");
		System.out.println("Introduce el nombre de un granjero a incrementar su nivel");
		String nombreGranjero=sc.nextLine();
		st.execute("update granjeros set nivel=nivel+1 where nombre="+"'"+nombreGranjero+"'");
		rs=st.executeQuery("select * from granjeros where nombre ="+"'"+nombreGranjero+"'");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getFloat(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
		}
	}
	public static void eliminarFila(ResultSet rs,Statement st){
		System.out.println("-----------------------------------------------------------------------");
		int aux=0;
		while (true) {
			System.out.println("Introduce el id de la fila a borrar, para salir introduce un -1");
			aux=sc.nextInt();
			if(aux==-1) {
				System.out.println("Hasta la proxima !");
				break;
			}
			try {
				//st.execute("delete from granjeros where id="+aux);
				System.out.println("Se han eliminado "+st.executeUpdate("delete from granjeros where id="+aux)+" filas");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
