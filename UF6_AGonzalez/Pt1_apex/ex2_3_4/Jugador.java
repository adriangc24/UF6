package ex2_3_4;

public class Jugador implements Comparable{
	private String name;
	private int idLegend;
	private int kills;
	private int totalDamage;
	private int timesTop3;
	private int totalWins;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdLegend() {
		return idLegend;
	}
	public void setIdLegend(int idLegend) {
		this.idLegend = idLegend;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getTotalDamage() {
		return totalDamage;
	}
	public void setTotalDamage(int totalDamage) {
		this.totalDamage = totalDamage;
	}
	public int getTimesTop3() {
		return timesTop3;
	}
	public void setTimesTop3(int timesTop3) {
		this.timesTop3 = timesTop3;
	}
	public int getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}
	public Jugador() {
		super();
	}
	public Jugador(String name, int idLegend, int kills, int totalDamage, int timesTop3, int totalWins) {
		super();
		this.name = name;
		this.idLegend = idLegend;
		this.kills = kills;
		this.totalDamage = totalDamage;
		this.timesTop3 = timesTop3;
		this.totalWins = totalWins;
	}
	@Override
	public String toString() {
		return "Jugador [name=" + name + ", idLegend=" + idLegend + ", kills=" + kills + ", totalDamage=" + totalDamage
				+ ", timesTop3=" + timesTop3 + ", totalWins=" + totalWins + "]";
	}
	public int compareTop3(Jugador j1,Jugador j2) {
		if(j1.getTimesTop3()<j2.getTimesTop3()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
