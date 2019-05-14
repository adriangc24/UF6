package exx5;
import java.sql.*;
public class Empleado {
	private String nDIEmp;
	private String nom;
	private String sexEmp;
	private String fecNac;
	private String fecIncorporacion;
	private float salEmp;
	private float comisionE;
	private String cargoE;
	private String jefeID;
	private String CodDepto;
	public String getnDIEmp() {
		return nDIEmp;
	}
	public void setnDIEmp(String nDIEmp) {
		this.nDIEmp = nDIEmp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSexEmp() {
		return sexEmp;
	}
	public void setSexEmp(String sexEmp) {
		this.sexEmp = sexEmp;
	}
	public String getFecNac() {
		return fecNac;
	}
	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}
	public String getFecIncorporacion() {
		return fecIncorporacion;
	}
	public void setFecIncorporacion(String fecIncorporacion) {
		this.fecIncorporacion = fecIncorporacion;
	}
	public float getSalEmp() {
		return salEmp;
	}
	public void setSalEmp(float salEmp) {
		this.salEmp = salEmp;
	}
	public float getComisionE() {
		return comisionE;
	}
	public void setComisionE(float comisionE) {
		this.comisionE = comisionE;
	}
	public String getCargoE() {
		return cargoE;
	}
	public void setCargoE(String cargoE) {
		this.cargoE = cargoE;
	}
	public String getJefeID() {
		return jefeID;
	}
	public void setJefeID(String jefeID) {
		this.jefeID = jefeID;
	}
	public String getCodDepto() {
		return CodDepto;
	}
	public void setCodDepto(String codDepto) {
		CodDepto = codDepto;
	}
	public Empleado() {
		super();
	}
	public Empleado(String nDIEmp, String nom, String sexEmp, String fecNac, String fecIncorporacion, float salEmp,
			float comisionE, String cargoE, String jefeID, String codDepto) {
		super();
		this.nDIEmp = nDIEmp;
		this.nom = nom;
		this.sexEmp = sexEmp;
		this.fecNac = fecNac;
		this.fecIncorporacion = fecIncorporacion;
		this.salEmp = salEmp;
		this.comisionE = comisionE;
		this.cargoE = cargoE;
		this.jefeID = jefeID;
		CodDepto = codDepto;
	}
	@Override
	public String toString() {
		return "Empleat [nDIEmp=" + nDIEmp + ", nom=" + nom + ", sexEmp=" + sexEmp + ", fecNac=" + fecNac
				+ ", fecIncorporacion=" + fecIncorporacion + ", salEmp=" + salEmp + ", comisionE=" + comisionE
				+ ", cargoE=" + cargoE + ", jefeID=" + jefeID + ", CodDepto=" + CodDepto + "]";
	}
	






}
