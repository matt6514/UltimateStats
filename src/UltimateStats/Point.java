package UltimateStats;

import java.util.ArrayList;
import java.util.List;

public class Point {
	
	private List<Pass> passes;
	private PointType type;
	private boolean complete;
	private boolean win;
	
	public Point(PointType p) {
		type = p;
		if (p == PointType.D) {
			Pass.unc();
		} else {
			Pass.them();
		}
		passes = new ArrayList<Pass>();
		complete = false;
	}
	
	public void addPass(Pass p) {
		passes.add(p);
		if (p.isGoal()) {
			complete = true;
			win = p.isUs();
		}
	}
	
	public void removeLastPass() {
		if (passes.size() != 0) {
			passes.remove(passes.size()-1);
		}
	}
	
	public List<Pass> getPasses(){
		return passes;
	}
	
	public PointType getType() {
		return type;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
	public boolean isWin() {
		return win;
	}
	
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
	
}
