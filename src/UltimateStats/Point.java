package UltimateStats;

import java.util.ArrayList;
import java.util.List;

public class Point implements PointInterface {
	
	private List<Pass> passes;
	private PointType type; 
	private boolean complete;
	private boolean win;
	private boolean poss; //possesion --> true means unc disc | false means opponent disc
	
	public Point(PointType p) {
		type = p;
		if (p == PointType.D) {
			poss = false;
		} else {
			poss = true;
		}
		passes = new ArrayList<Pass>();
		complete = false;
	}
	
	@Override
	public void addPass(Pass p) {
		passes.add(p);
		if (p.isGoal()) {
			complete = true;
			win = p.isUs();
		}
		if (p.isTurn()) {
			poss = !poss;
		}
	}
	
	@Override
	public void removeLastPass() {
		if (passes.size() != 0) {
			passes.remove(passes.size()-1);
		}
	}
	
	@Override
	public List<Pass> getPasses(){return passes;}
	
	@Override
	public PointType getType() {return type;}
	
	@Override
	public boolean isComplete() {return complete;}
	
	@Override
	public boolean isWin() {return win;}
	
	@Override
	public boolean ourPoss() {return poss;}
	
	@Override
	public String toShortString() {
		if (!complete) throw new IllegalArgumentException("Point is not over yet");
		
		if (win) {
			if (type == PointType.O) {
				return "Darkside Holds | " + passes.get(passes.size()-1).toCleanString();
			} else {
				return "Darkside Breaks | " + passes.get(passes.size()-1).toCleanString();
			}
		} else {
			if (type == PointType.O) {
				return "Darkside is Broken | " + passes.get(passes.size()-1).toCleanString();
			} else {
				return "Opponent Hold | " + passes.get(passes.size()-1).toCleanString();
			}
		}
	}
	
	@Override
	public String toString() {
		String storage = "";
		
		storage += Integer.toString(type.ordinal()) + "\n";
		storage += Integer.toString(win? 1:0) + "\n";
		
		for (Pass p: passes) {
			storage += p.toString() + "\n";
		}
		
		return storage;
	}
	
}
