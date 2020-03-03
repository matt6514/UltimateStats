package UltimateStats;

public interface PassInterface {

	Position getInitial(); //position of the thrower
	Position getFinal(); //position of the catcher
	
	void setInitial(Position initial); //setters
	void setFinal(Position pfinal);
	
	int getThrower(); //number of thrower
	void setThrower(int thrower);
	
	int getCatcher(); //number of the catcher
	void setCatcher(int catcher);
	
	boolean isUs(); //true -> unc pass || false -> opp. pass
	boolean isTurn(); //true -> yes is it a turn || false -> no turn
	void setTurn(boolean turn); //alter turn value
	
	boolean isGoal(); //true -> one of the teams scored
	
	TurnType getTurnType();
	void setTurnType(TurnType turnType);
	ThrowType getThrowType();
	void setThrowType(ThrowType throwTytpe);
	
	double getDistance(); //true distance
	double getVerticalDistance(); //vertical component of distance
	double getHorozontalDistance(); //horozontal component of distance
	boolean isReset(); //true -> is a reset throw (vertical distance is less than 7.5 yards forward)
	boolean isHuck(); //true -> farther than 40 yards true distance
	String toCleanString(); //display string
	String toString(); //for save function of database
}
