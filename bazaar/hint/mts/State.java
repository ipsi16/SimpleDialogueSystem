package bazaar.hint.mts;

import java.util.List;

public class State {
	
	Dialogue dialogue;
	private int visitCount;
    private double winScore;
	
	public State(State state) {
		this.dialogue = state.dialogue;
	}

	public State() {
		this.dialogue = new Dialogue("");
	}

	public Dialogue getDialogue() {
		return dialogue;
	}

	public void setDialogue(Dialogue dialogue) {
		this.dialogue = dialogue;
	}
	
	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public double getWinScore() {
		return winScore;
	}

	public void setWinScore(double winScore) {
		this.winScore = winScore;
	}

	public void randomPlay()
	{
		List<Integer> availableHints = this.dialogue.getUnusedHints();
        int totalPossibilities = availableHints.size();
        int selectRandom = (int) (Math.random() * ((totalPossibilities - 1) + 1));
        this.dialogue.utter(selectRandom);
	}
	
	public void incrementVisit()
	{
		this.visitCount+=1;
	}
}
