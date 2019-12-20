package UltimateStats;

public class Position {

	private int x, y;
	
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(String s) {
		String[] temp = s.split(" ");
		x = Integer.parseInt(temp[0]);
		y = Integer.parseInt(temp[1]);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double getDistance(Position p) {
		return Math.sqrt(Math.pow(x - p.getX(),2) + Math.pow(y - p.getY(),2));
	}
	
	public double getVerticalDistance(Position p) {
		return Math.abs(x - p.getX());
	}
	
	public double getHorozontalDistance(Position p) {
		return Math.abs(y - p.getY());
	}
	
	public String toString() {
		return x + " " + y;
	}
}
