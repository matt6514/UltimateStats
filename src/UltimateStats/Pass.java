package UltimateStats;

import java.util.List;

public class Pass {
	
	private static boolean unc = false;
	
	private Position initial;
	private int thrower;
	private Player p1;
	private Position pfinal;
	private int catcher;
	private Player p2;
	private boolean turn;
	private boolean goal;
	private boolean us;
	private TurnType turnType;
	private ThrowType throwType;
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, TurnType turntype, boolean g) {
		initial = i;
		thrower = t.getNumber();
		p1 = t;
		pfinal = f;
		catcher = c.getNumber();
		p2 = c;
		throwType = type;
		turnType = turntype;
		turn = (turnType == null);
		goal = g;
		us = unc;
	}
	
	public Pass(String s, List<Player> rostor) {
		String[] data = s.split(",");
		
		if (data.length != 9) throw new IllegalArgumentException("Illegal string to pass");
		
		thrower = Integer.valueOf(data[0]);
		catcher = Integer.valueOf(data[1]);
		for (Player p: rostor) {
			if (p.equals(thrower)) {
				p1 = p;
			}
			if (p.equals(catcher)) {
				p2 = p;
			}
		}
		initial = new Position(data[2]);
		pfinal = new Position(data[3]);
		turn = Integer.valueOf(data[4]) == 1;
		goal = Integer.valueOf(data[5]) == 1;
		us = Integer.valueOf(data[6]) == 1;
		throwType = ThrowType.values()[Integer.valueOf(data[7])];
		if (turn) {
			turnType = TurnType.values()[Integer.valueOf(data[8])];
		} else {
			turnType = null;
		}
		
	}
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type){
		this(i,f,t,c,type,null,false);
	}
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, TurnType turntype){
		this(i,f,t,c,type,turntype,false);
		unc = !unc;
	}
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, boolean g){
		this(i,f,t,c,type,null,true);
	}

	public Position getInitial() {
		return initial;
	}

	public void setInitial(Position initial) {
		this.initial = initial;
	}

	public int getThrower() {
		return thrower;
	}

	public void setThrower(int thrower) {
		this.thrower = thrower;
	}

	public Position getPfinal() {
		return pfinal;
	}

	public void setPfinal(Position pfinal) {
		this.pfinal = pfinal;
	}

	public int getCatcher() {
		return catcher;
	}

	public void setCatcher(int catcher) {
		this.catcher = catcher;
	}
	
	public boolean isUs() {
		return us;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public static void unc() {
		unc = true;
	}
	
	public static void them() {
		unc = false;
	}

	public boolean isGoal() {
		return goal;
	}

	public void setGoal(boolean goal) {
		this.goal = goal;
	}

	public TurnType getTurnType() {
		return turnType;
	}

	public void setTurnType(TurnType turnType) {
		this.turnType = turnType;
	}

	public ThrowType getThrowType() {
		return throwType;
	}

	public void setThrowType(ThrowType throwType) {
		this.throwType = throwType;
	}
	
	public double getDistance() {
		return initial.getDistance(pfinal);
	}
	
	public double getVerticalDistance() {
		return initial.getVerticalDistance(pfinal);
	}
	
	public double getHorozontalDistance() {
		return initial.getHorozontalDistance(pfinal);
	}
	
	public boolean isReset() {
		return getVerticalDistance() < 7.5;
	}
	
	public boolean isHuck() {
		return getVerticalDistance() > 30;
	}
	
	public String toCleanString() {
		if (!turn) {
			if (us) {
				return p1.toCleanString() + " " + getDistance() + " yards to " + p2.toCleanString() + ": " + initial.toCleanString() + " -> " + pfinal.toCleanString(); 
			} else {
				return p1.toCleanString() + "Man " + getDistance() + " yards to " + p2.toCleanString() + "Man : " + initial.toCleanString() + " -> " + pfinal.toCleanString();
			}
		} else {
			switch(turnType) {
			case CATCH:
				return p1.toCleanString() + " " + getDistance() + " yards to " + p2.toCleanString() + " Dropped: " + initial.toCleanString() + " -> " + pfinal.toCleanString(); 
			case THROW:
				return p1.toCleanString() + " Misthrown" + getDistance() + " yards to " + p2.toCleanString() + ": " + initial.toCleanString() + " -> " + pfinal.toCleanString(); 
			case STALL:
				return p1.toCleanString() + " Stalled out";
			default:
				return p1.toCleanString() + " Misthrown huck" + getDistance() + " yards to " + p2.toCleanString() + ": " + initial.toCleanString() + " -> " + pfinal.toCleanString(); 
			}
		}
	}
	
	public String toString() {
		String storage = "";
		storage += thrower + "," + catcher + "," + initial.toString() + "," + pfinal.toString() + ",";
		storage += (turn? 1:0) + ",";
		storage += (goal? 1:0) + ",";
		storage += (us? 1:0) + ",";
		storage += throwType.ordinal() + ",";
		if (turnType != null) {
			storage += turnType.ordinal();
		}
		return storage;
	}
}
