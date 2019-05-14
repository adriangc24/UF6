package ex2_3_4;

public class Llegenda {
	private int id;
	private String name;
	private String type;
	private int totalWins;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}
	public Llegenda() {
		super();
	}
	public Llegenda(int id, String name, String type, int totalWins) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.totalWins = totalWins;
	}
	@Override
	public String toString() {
		return "Llegenda [id=" + id + ", name=" + name + ", type=" + type + ", totalWins=" + totalWins + "]";
	}
	
	

}
