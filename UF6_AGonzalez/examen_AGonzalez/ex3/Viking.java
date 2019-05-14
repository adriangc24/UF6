package ex3;

public class Viking {
	private String nom;
	private int edat;
	private boolean valhalla;
	private int fills;
	private boolean lider;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public boolean isValhalla() {
		return valhalla;
	}
	public void setValhalla(boolean valhalla) {
		this.valhalla = valhalla;
	}
	public int getFils() {
		return fills;
	}
	public void setFils(int fils) {
		this.fills = fils;
	}
	public boolean isLider() {
		return lider;
	}
	public void setLider(boolean lider) {
		this.lider = lider;
	}
	public Viking() {
		super();
	}
	public Viking(String nom, int edat, boolean valhalla, int fils, boolean lider) {
		super();
		this.nom = nom;
		this.edat = edat;
		this.valhalla = valhalla;
		this.fills = fils;
		this.lider = lider;
	}
	@Override
	public String toString() {
		return "Viking [nom=" + nom + ", edat=" + edat + ", valhalla=" + valhalla + ", fills=" + fills + ", lider="
				+ lider + "]";
	}
	
	



}
