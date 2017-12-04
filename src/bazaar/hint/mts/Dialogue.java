package bazaar.hint.mts;

public class Dialogue {
	
	public static int ANSWERED_CORRECTLY = 2;
	public static int IN_PROGRESS = 0;
	public static int TERMINATE = 1;
	String transcript;
	
	
	Dialogue(String transcript)
	{
		this.transcript = transcript;	
	}
	
	public int checkStatus()
	{
		//check last value in dialogue and cross-verify if its the correct answer
		int totalHintsGiven = transcript.length()/2;
		if (transcript.substring(transcript.length()-1).equals(Interaction.correctAns) )
			return ANSWERED_CORRECTLY;
		if(totalHintsGiven>=Interaction.totalNoHints)
			return TERMINATE;
		return IN_PROGRESS;
	}
}
