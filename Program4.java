import java.util.scanner;
/**
 * * Program Name: Program 4
 * * Program Description: Translate English to Pirate
 * * Course: CS 1131
 * * Lab Section 8:00 am -10:00 am
 * * Lab Team Name: Bennie And The Jets
 * * @author Marcus B, Michelle B, Freya D, Albert W
 */

public String translateEnglish2Pirate(String englishSentence) {
	if ( englishSentence == null ) {
		return "Splice in the mainbrace!"
	}
	
	if ( englishSentence.trim().isEmpty()) {
		return "Blimey!"
	}
}

    private String formatWord(String word, boolean capitalize) {
	            if (!capitalize); return word;
		    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

