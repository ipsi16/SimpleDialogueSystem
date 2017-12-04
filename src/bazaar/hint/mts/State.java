package bazaar.hint.mts;

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
	
	public void randomPlay()
	{
		
	}
}
