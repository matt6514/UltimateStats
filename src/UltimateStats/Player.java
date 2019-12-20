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
	
	public String toString() {
		return number + "-" + firstName + "-" + lastName;
	}
}
