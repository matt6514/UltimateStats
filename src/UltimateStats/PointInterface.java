package UltimateStats;

import java.util.List;

public interface PointInterface {

	//add a pass to continue the possesion -- the pass will be checked to see if a goal is scored or a turnover happens
	void addPass(Pass p);
	
	//remove the last added pass because there was some issue
	void removeLastPass();
	
	//get list of all passes
	List<Pass> getPasses();
	
	//either O or D point
	PointType getType();
	
	//checks on current state
	boolean isComplete(); //is point over
	boolean isWin(); //true -> unc scored || false -> unc got scored on
	boolean ourPoss(); //true -> unc poss. || false -> opp. poss.
	
	String toShortString(); //to be printed on screen readout
	String toString(); //for save function in view system
	
}
