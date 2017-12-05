package bazaar.hint.mts;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Integer> getUnusedHints()
	{
		ArrayList<Integer> unusedHints = new ArrayList<Integer>();
		for(int i=0;i<transcript.length();i+=2 )
		{
			int hint = Integer.parseInt(transcript.substring(i, i));
			if (!Interaction.hints.contains(hint))
				unusedHints.add(i);
		}
		return unusedHints;
	}
	public void utter(int hint)
	{
		transcript+=hint;
	}
}
