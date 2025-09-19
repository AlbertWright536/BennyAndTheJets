import java.util.Scanner;
/**
 * * Program Name: Program 4
 * * Program Description: Translate English to Pirate
 * * Course: CS 1131
 * * Lab Section 8:00 am -10:00 am
 * * Lab Team Name: Bennie And The Jets
 * * @author Marcus B, Michelle B, Freya D, Albert W
 */
public class Program4 {
	static final String dictionary [][] = {{"a", "after", "am", "and", "any", "are", "attention", "attractive", "bank", "bathroom", "beautiful", "beer", "beverage", "beyond", "captain", "cheat", "child", "children", "close", "coins", "cola", "companion", "crazy", "die", "died", "dinner", "dog", "dollar", "dollars", "drunk", "eat", "enemy", "far", "find", "flag", "food", "forward", "friend", "frown", "girl", "happy", "hat", "heaven", "hello", "here", "hi", "hotel", "how do you", "idiot", "is", "jerk", "just", "kill", "killed", "know", "lake", "lean", "leave", " left", "lol", "mad", "madam", "mall", "man", "miss", "money", "mother", "my", "nap", "nearby", "nonsense", "nose", "not", "ocean", "of", "officer", "old", "pardon me", "pardon", "pretty", "professor", "pub", "quick", "quickly", "restaurant", "restroom", "right", "sailor", "ship", "shutup", "sir", "sleep", "soda", "song", "stop", "stranger", "student", "stupid", "talking", "tell", "the", "there", "to", "told", "want", "where", "whip", "woman", "yes", "yonder", "you", "your", ".", "!", ""}, {"a briny", "aft", "be", "an", "godforsaken", "be", "Avast!", "comely", "treasure chest", "head", "comely", "grog", "grog", "yon", "cap'n", "hornswoggle", "sprog", "sprogs", "broadside", "pieces of eight", "hair of the dog", "ol'Rumpot", "addled", "visit Davey Jones' Locker", "visited Davey Jones' Locker", "grub", "cur", "doubloon", "dubloons", "loaded to the gunwales", "gobble", "scallywag", "many leagues", "come across", "jack", "grub", "for", "bucko", "hang the jib", "lass", "grog-filled", "tricorn hat", "fiddlers green", "ahoy", "hither", "yo-ho-ho", "fleabag inn", "know ye", "squiffy", "be", "scurvy dog", "jus'", "keel-haul", "keel-hauled", "be knowin'", "sunless sea", "careen", "weigh anchor", "port", "Har!", "addled", "proud beauty", "market", "landlubber", "comely wench", "booty", "dear ol' mum", "me", "but of a lie down", "broadside", "bilge", "prow", "nah", "briny deep", "o'", "foul blaggart", "barnacle-covered", "avast", "avast", "comely", "cap'n", "skull and scuppers", "smart", "smartly", "galley", "head", "starboard", "jack", "furner", "belay that talk", "matey", "take a caulk", "grog", "shantey", "belay", "survey dog", "swab", "addled", "blabberin'", "be tellin'", "th'", "thar", "t'", "tol'", "be needin'", "whar", "cat o' nine tails", "lass", "aye", "yon", "ye", "yer", ". Arrr.", "!Shiver me timbers!", "Blimey!"}};
	public String translateEnglish2Pirate(String englishSentence){
		if (englishSentence.equals(null)) {
			return "Splice in the mainbrace!";
		}
	
		if ( englishSentence.trim().isEmpty()) {
			return "Blimey!";
		}

		Scanner scanner = new Scanner(englishSentence);
		String translated = "";
		while (scanner.hasNext()) {
			String word = scanner.next();
			word = word.replaceAll("[^\\sa-zA-z0-9]", "");
			for (int i = 0; i < dictionary[0].length; i++) {
				if (word.trim().toLowerCase().equals(dictionary[0][i])) {
					boolean capitalize = false;
					if (Character.isUpperCase(word.charAt(0))) {
						capitalize = true;
					}
					word = dictionary[1][i];
					word = formatWord(word, capitalize);
				}
			}
			translated = translated + word + " ";
		}
		return translated;
		
	}
	private String formatWord(String word, boolean capitalize) {
	   if (!capitalize) return word;
			return Character.toUpperCase(word.charAt(0)) + word.substring(1);
	}
	public static void main(String [] args){
		Program4 program = new Program4();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(program.translateEnglish2Pirate(input.nextLine()));
		}
	}	
}


    

