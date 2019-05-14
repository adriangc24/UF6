package exx5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main implements DBConntrack{
	static ArrayList<Departamento>ar1=new ArrayList<Departamento>();
	static ArrayList<Empleado>ar2=new ArrayList<Empleado>();
	static String aux;
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregat correctament");
			
			Connection con = DriverManager.getConnection(url, usuario, password);
			Statement stm = con.createStatement();
			PreparedStatement ps=null;
			
			stm= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("Conectado correctamente");
			Statement st = con.createStatement();
			ResultSet rs = null;
			
			Departamento d;
			Empleado e;
			
			Departamento d2=new Departamento("1","ventas","barcelona","33");
			Departamento d3=new Departamento("2","i+d","madrid","34");
			Departamento d4=new Departamento("3","hr","bilbao","35");
			
			Empleado e1= new Empleado("1","adrian","h","24/02/2000","6/8/2015",43000,3,"programador","100","1");
			Empleado e2= new Empleado("2","claudia","m","2/03/2001","1/22019",66000,2,"ingeniera industrial","102","2");
			Empleado e3= new Empleado("3","jose","h","1/05/2002","12/3/2018",55000,1,"tecnico en sistemas","103","3");
			
			
			ar1.add(d2);
			ar1.add(d3);
			ar1.add(d4);
			
			ar2.add(e1);
			ar2.add(e2);
			ar2.add(e3);
			
			/*
			inserirFilaEmp(ps, con);
			inserirFilaDept(ps, con);
			*/
			
			mostrarEmpleats(st, rs);
			aux="333.333.333";
			modificarSalari(ps, rs, aux,con);
			eliminarEmpleat(ps, rs, aux, con);
			
		} catch (ClassNotFoundException ee) {
			System.out.println("No se encontro el driver");
		} catch (SQLException s) {
			System.out.println("Excecpcio SQL");
			s.printStackTrace();
		}
		

	}
	public static void inserirFilaDept(PreparedStatement ps,Connection con) throws SQLException {
		for (Departamento dx:ar1) {
			aux="insert into departamentos values(?,?,?,?)";
			ps=con.prepareStatement(aux);
			ps.setString(1, dx.getCodDepto());
			ps.setString(2, dx.getNombreDpto());
			ps.setString(3, dx.getCiudad());
			ps.setString(4, dx.getCodDirector());
			ps.executeUpdate();
		}
	}
	public static void inserirFilaEmp(PreparedStatement ps,Connection con) throws SQLException {
		for (Empleado ex:ar2) {
			aux="insert into empleados values(?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(aux);
			ps.setString(1, ex.getnDIEmp());
			ps.setString(2, ex.getNom());
			ps.setString(3, ex.getSexEmp());
			ps.setString(4, ex.getFecNac());
			ps.setString(5, ex.getFecIncorporacion());
			ps.setFloat(6, ex.getSalEmp());
			ps.setFloat(7, ex.getComisionE());
			ps.setString(8, ex.getCargoE());
			ps.setString(9, ex.getJefeID());
			ps.setString(10, ex.getCodDepto());

		}
	}
	public static void mostrarEmpleats(Statement st,ResultSet rs) throws SQLException {
		aux="select nomEmp,cargoE from empleados";
		rs=st.executeQuery(aux);
		ResultSetMetaData rsmd = rs.getMetaData(); // para sacar informacion de las columnas
		System.out.println(rsmd.getColumnName(1)+"--------------------||"+rsmd.getColumnName(2));
		while(rs.next()) {
			System.out.println("|"+rs.getString(1)+"------||"+rs.getString(2));
		}
		
	}
	public static void modificarSalari(PreparedStatement ps,ResultSet rs,String id,Connection con) throws SQLException {
		aux="update empleados set salEmp=? where nDIEmp=?";
		String salari="1000000";
		ps=con.prepareStatement(aux);
		ps.setString(1, salari);
		ps.setString(2, id);
		ps.executeUpdate();
		
	}
	public static void eliminarEmpleat(PreparedStatement ps,ResultSet rs,String id,Connection con) throws SQLException {
		id="'"+id+"'";
		aux="delete from empleados where nDIEmp=?";
		ps=con.prepareStatement(aux);
		ps.setString(1, id);
		ps.executeUpdate();
		
	}


}
