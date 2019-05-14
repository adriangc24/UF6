package pt1;

public class Pilot implements Comparable<Pilot>{
	
	private String name;
	private int points;
	public Pilot() {
		super();
	}
	public Pilot(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}
	public Pilot(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Pilot [name=" + name + ", points=" + points + "]";
	}
	@Override
	public int compareTo(Pilot arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
