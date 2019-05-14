package ex1;

public class Perro implements Comparable{
	
	private String nombre;
	private String raza;
	private double peso;
	private int edad;
	private String lugarNacimiento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	public Perro(String nombre, String raza, double peso, int edad, String lugarNacimiento) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.peso = peso;
		this.edad = edad;
		this.lugarNacimiento = lugarNacimiento;
	}
	public Perro() {
		super();
	}
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", peso=" + peso + ", edad=" + edad + ", lugarNacimiento="
				+ lugarNacimiento + "]";
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int mayorPeso(Perro p1,Perro p2) {
		return (int)(p1.getPeso()-p2.getPeso());
	}
	
	
	
}
