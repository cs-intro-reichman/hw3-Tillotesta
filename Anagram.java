/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		//int j = 0;

		for (int i = 0; i < str1.length(); i++) {
			char char1i = str1.charAt(i);
			if (str2.indexOf(char1i) == -1) {
			return false;
			} 
		}

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String pre = str;
		pre = pre.toLowerCase();
		pre = pre.replaceAll(" ", "");
		str = "";

		//Lowers case in ASCII 97-122
		for (int i = 0; i < pre.length(); i++){
			char chari = pre.charAt(i);
			int ascii = (int) chari;

			if (ascii >= 97 && ascii <= 122) {//We add to str only if its a lowercase
				str += chari;
			}
		}
		return str;
	} 
	
	

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		str = preProcess(str);

 		String random = "";
		char[] letters = str.toCharArray();
		int n = letters.length;
	
		//We are implementing the Fisher-Yates (Knuth) Shuffle algorithm

		for (int i = n - 1; i > 0; i--) {
			int j = (int) (Math.random() * i);
			char temp = letters[i];
			letters[i] = letters[j];
			letters[j] = temp;
		}

		return new String(letters);
	}
}
