package farmville;

import java.util.Comparator;

public class Granjero {
	private int id;
	private String nombre;
	private String descripcion;
	private double dinero;
	private int puntos;
	private int nivel;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public Granjero() {
		super();
	}
	public Granjero(int id, String nombre, String descripcion, double dinero, int puntos, int nivel) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dinero = dinero;
		this.puntos = puntos;
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "Granjero [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", dinero=" + dinero
				+ ", puntos=" + puntos + ", nivel=" + nivel + "]";
	}
	
	static Comparator<Granjero> comp = new Comparator<Granjero>() {

		public int compare(Granjero g1, Granjero g2) {
			// TODO Auto-generated method stub
			return g1.getNombre().compareTo(g2.getNombre());
		}
		
	};
	static Comparator<Granjero> comp2 = new Comparator<Granjero>() {

		public int compare(Granjero g1, Granjero g2) {
			// TODO Auto-generated method stub
			return g1.getPuntos()-g2.getPuntos();
		}
		
	};
	
	Comparator <Granjero> comp3 = new Comparator<Granjero>() {

		@Override
		public int compare(Granjero o1, Granjero o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	
	
	
}
