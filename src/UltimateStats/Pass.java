package UltimateStats;

public class Pass {
	
	private static boolean unc = false;
	
	private Position initial;
	private int thrower;
	private Position pfinal;
	private int catcher;
	private boolean turn;
	private boolean goal;
	private boolean us;
	private TurnType turnType;
	private ThrowType throwType;
	
	public Pass(Position i, Position f, Player t, Player c, ThrowType type, TurnType turntype, boolean g) {
		initial = i;
		thrower = t.getNumber();
		pfinal = f;
		catcher = c.getNumber();
		throwType = type;
		turnType = turntype;
		turn = (turnType == null);
		goal = g;
		us = unc;
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

	public Player getThrower() {
		return thrower;
	}

	public void setThrower(Player thrower) {
		this.thrower = thrower;
	}

	public Position getPfinal() {
		return pfinal;
	}

	public void setPfinal(Position pfinal) {
		this.pfinal = pfinal;
	}

	public Player getCatcher() {
		return catcher;
	}

	public void setCatcher(Player catcher) {
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
		return getVerticalDistance() > 35;
	}
	
	public String toString() {
		return 
	}
}
