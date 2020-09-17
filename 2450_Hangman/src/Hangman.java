import java.util.Random;
import java.util.Scanner; 

public class Hangman {
	
	private static String word;
	private static String[] guessWord, answerList, usedLetter = new String[26];
	private static int lives;
	private static String finalAnswer, result, guess;
	private static boolean check;
	private static Scanner scn = new Scanner(System.in);


	public static void main(String[] args) {
		do {
		Preparation();
		Game();
		End();
		} while (finalAnswer.equalsIgnoreCase("Yes"));
		System.out.println("Thanks for Playing");
	}
	public static void Preparation() {
		lives = 6;
		String[] wordList = {"ENTERTAINMENT", "HURRICANE", "UNIVERSE", "HELICOPTER", "CONTROLLER", "BALONEY", "FIREFIGHTER", "CONSTRUCTION", "CONTINUITY"};
		Random rnd = new Random();
		int num = rnd.nextInt(9);
		word = wordList[num];
		
		guessWord = new String[word.length()];
		answerList = new String[word.length()];
		for (int i = 0; i < word.length(); i++)
		{
			guessWord[i] = word.substring(i, i + 1);
			answerList[i] = "_";
		}
	}
	public static void Game() {
		for (int r = 0; r < 26; r++) {
				usedLetter[r] = null;
		}
		do {
			System.out.println("\n\n\n");
			if (lives == 0) {
				System.out.println("Game Over\nThe answer was: ");
				for (int h=0; h<word.length();h++) {
					System.out.print(guessWord[h] + " ");
					}
					break;
				}
			
		int counter = 0; check = false;
		System.out.println(" |___	Lives: " + lives);
		if (lives < 6) System.out.println(" |  O			"); else System.out.println(" |  			");
		if (lives < 5) {if (lives < 4) {if (lives < 3) {System.out.println(" | /|\\			");} else System.out.println(" | /|			");} else System.out.println(" |  |			");} else System.out.println(" |  			");
		if (lives < 2) {if (lives < 1) {System.out.println(" | / \\			");} else System.out.println(" | /			");} else System.out.println(" |  			");
		System.out.println("_|______			\n");
		for(int f = 0; f < word.length(); f++) {
			System.out.print(answerList[f] + " ");
		}
		do {
		System.out.print("\nEnter a letter: ");
	    guess = scn.next();
		result = checkMechanic(guess);
		if (result.equalsIgnoreCase("bad"))
		{
			System.out.println("You already used this letter. Please try again");
		}
		} while (result.equalsIgnoreCase("bad"));
		
		for (int g = 0; g < word.length(); g++) {
			if (guess.equalsIgnoreCase(guessWord[g]))
			{
				answerList[g] = guess.toUpperCase();
				counter++;
			}
		}
		if (counter == 0) {
			lives--;
		}
		
		for (int y = 0; y < word.length(); y++) {
			if (guessWord[y].equalsIgnoreCase(answerList[y])) {
				check = true;
			} else {
				check = false;
				break;
				}
			}
		
		} while (check != true);
		if (check == true) {
		 System.out.println("\nCongratulation, You Won");
		 for (int h=0; h<word.length();h++) {
				System.out.print(guessWord[h] + " ");
				}
		}

	}
	public static String checkMechanic(String a) {
		for (int r = 0; r < 26; r++) {
			if (usedLetter[r] == null) {
				usedLetter[r] = a;
				break;
			}
			if (usedLetter[r].equalsIgnoreCase(a)) {
				return "bad";
			}
		}
		return "good";
	}
	public static void End() {
		System.out.println("\nWould you like to play again? Yes/No");
		finalAnswer = scn.next();
	}

}
