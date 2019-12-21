package UltimateStats;

public class Player {

	private int number;
	private String firstName;
	private String lastName;
	
	public Player(String first, String last, int num) {
		number = num;
		firstName = first;
		lastName = last;
	}
	
	public Player(String s) {
		String[] data = s.split("-");
		number = Integer.parseInt(data[0]);
		firstName = data[1];
		lastName = data[2];
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int num) {
		number = num;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String first) {
		firstName = first;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String last) {
		lastName = last;
	}
	
	public boolean equals(Player p) {
		return p.getNumber() == number;
	}
	
	public boolean equals(int n) {
		return number == n;
	}
	
	public String toCleanString() {
		return firstName + " " + lastName + " (#" + number + ")";
	}
	
	public String toString() {
		return number + "-" + firstName + "-" + lastName;
	}
}
