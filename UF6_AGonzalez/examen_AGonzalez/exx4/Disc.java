package exx4;

public class Disc {
	private String nom;
	private String estil;
	private int cancons;
	private int stock;
	private double preu;
	private String grup;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEstil() {
		return estil;
	}
	public void setEstil(String estil) {
		this.estil = estil;
	}
	public int getCancons() {
		return cancons;
	}
	public void setCancons(int cancons) {
		this.cancons = cancons;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPreu() {
		return preu;
	}
	public void setPreu(double preu) {
		this.preu = preu;
	}
	public String getGrup() {
		return grup;
	}
	public void setGrup(String grup) {
		this.grup = grup;
	}
	public Disc() {
		super();
	}
	public Disc(String nom, String estil, int cancons, int stock, double preu, String grup) {
		super();
		this.nom = nom;
		this.estil = estil;
		this.cancons = cancons;
		this.stock = stock;
		this.preu = preu;
		this.grup = grup;
	}
	@Override
	public String toString() {
		return "Disc [nom=" + nom + ", estil=" + estil + ", cancons=" + cancons + ", stock=" + stock + ", preu=" + preu
				+ ", grup=" + grup + "]";
	}
	
}
