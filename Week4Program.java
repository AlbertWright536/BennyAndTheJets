import java.util.Scanner;

class Week4Program {
	
	static final String[][] dictionary = {{"hello", "ahoy"}, {"you", "ye"}, {"are", "be"}};

	public String translateEnglish2Pirate( String englishSentence ) {
		Scanner scanner = new Scanner(englishSentence);
		String translated = "";
		while (scanner.hasNext()) {
			String word = scanner.next();
			for (int i = 0; i < dictionary.length; i++) {
				if (word.contains(dictionary[i][0])) {
					word = word.replace(dictionary[i][0], dictionary[i][1]);
				}
			}
			translated = translated + word + " ";
		}
		return translated;
	}

	public static void main(String[] args) {
		Week4Program program = new Week4Program();
		System.out.println(program.translateEnglish2Pirate("Hello, how are you?"));
	}
}
