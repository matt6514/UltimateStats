package UltimateStats;

import java.util.List;

public class Pass implements PassInterface{
	
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
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, TurnType turntype, boolean g, boolean possesion) {
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
		us = possesion;
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
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, boolean us) {
		this(i,f,t,c,type,null,false, us);
	}
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, TurnType turntype, boolean us) {
		this(i,f,t,c,type,turntype,false, us);
	}
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, boolean g, boolean us) {
		this(i,f,t,c,type,null,true, us);
	}

	@Override
	public Position getInitial() {
		return initial;
	}
	
	@Override
	public Position getFinal() {
		return pfinal;
	}

	@Override
	public void setInitial(Position initial) {
		this.initial = initial;
	}
	
	@Override
	public void setFinal(Position pfinal) {
		this.pfinal = pfinal;
	}

	@Override
	public int getThrower() {
		return thrower;
	}

	@Override
	public void setThrower(int thrower) {
		this.thrower = thrower;
	}

	@Override
	public int getCatcher() {
		return catcher;
	}

	@Override
	public void setCatcher(int catcher) {
		this.catcher = catcher;
	}
	
	@Override
	public boolean isUs() {
		return us;
	}

	@Override
	public boolean isTurn() {
		return turn;
	}

	@Override
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	@Override
	public boolean isGoal() {
		return goal;
	}

	@Override
	public TurnType getTurnType() {
		return turnType;
	}

	@Override
	public void setTurnType(TurnType turnType) {
		this.turnType = turnType;
	}

	@Override
	public ThrowType getThrowType() {
		return throwType;
	}

	@Override
	public void setThrowType(ThrowType throwType) {
		this.throwType = throwType;
	}
	
	@Override
	public double getDistance() {
		return initial.getDistance(pfinal);
	}
	
	@Override
	public double getVerticalDistance() {
		return initial.getVerticalDistance(pfinal);
	}
	
	@Override
	public double getHorozontalDistance() {
		return initial.getHorozontalDistance(pfinal);
	}
	
	@Override
	public boolean isReset() {
		return getVerticalDistance() < 7.5;
	}
	
	@Override
	public boolean isHuck() {
		return getVerticalDistance() > 30;
	}
	
	@Override
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
	
	@Override
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
