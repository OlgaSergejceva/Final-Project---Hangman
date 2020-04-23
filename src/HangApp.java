/*
 1.Generate random word from String wordsArray[];
 2.Convert each letter in the word to stars ***;
 3.Show the game status to the user;
 4.User enter letter to try to guess the word;
 5.Compare letters provided by user if letters is in the secretWord;
 6.Loop working until attempts >0 and secretWord not guessed;
 7.show the user statistic results (lost, won games);
 8.Ask the user to continue a game or end game;
 */

import java.util.Random;
import java.util.Scanner;

public class HangApp {

    public static void main(String[] args) {

        //declare a local variables
        int attempts;
        int gamesWon = 0;
        int gamesLost = 0;
        String agree = "yes";
        String theWord = "";
        String secretWord;
        String letters = "";
        char choosenLetter;
        
        //initializing array
        String wordsArray[] = {
        		"Toyota", 
        		"Lexus", 
        		"Mazda", 
        		"Subaru", 
        		"Infinity", 
        		"Hyundai", 
        		"Genesis", 
        		"Acura", 
        		"Nissan", 
        		"Honda", 
        		"Kia", 
        		"Mitsubishi", 
        		"Isuzu"
        };

        //output to start
        System.out.println("Hello, welcome to my Hangman game! ");
        System.out.println("You have to guess the Asian car brand!");
        System.out.println("==================================");

        do {

            //declare an object "game"
            HangLetters game = new HangLetters();

            //input Scanner
            Scanner sc = new Scanner(System.in);
            System.out.println("Press ENTER to START: ");
            sc.nextLine();

            //1.Generate random word from String wordsArray[]
            Random random = new Random();
            int randomWord = random.nextInt(wordsArray.length);
            theWord = wordsArray[randomWord];
            secretWord = game.stars(wordsArray[randomWord]);

            attempts = 6;
            boolean gameFinished = false;

			//6.Loop working until attempts >0 and secretWord not guessed
            while (attempts > 0 && !gameFinished) {
				//3.Show the game status to the user
                System.out.println("Word: " + secretWord);
                System.out.println("Lives: " + attempts);
                System.out.println("Used letters: ");
                
                letters = game.getLetters();

                if (letters.length() == 0) {
                    System.out.println("No letters entered yet");
                } else {
                    game.usedLetters();
                    System.out.println();
                }
                
    			//4.User enter letter to try to guess the word
                choosenLetter = ' ';
                boolean letterUsed;
    
                do {
                    //ask the user to guess a letter
                    System.out.println("Guess your letter: ");
                    choosenLetter = Character.toLowerCase(sc.next().charAt(0));
        			
                    //check if letter was already used
                    letterUsed = false;
                    for (char i = 0; i < letters.length(); i++) {
                        if (letters.charAt(i) == choosenLetter) {
                            letterUsed = true;
                            System.out.println("The letter " + choosenLetter + " was used!");
                        }
                    }
                    
                } while (letterUsed == true);
                
                boolean newLetter = false;
                
                //5.Compare letters provided by user if letters is in the secretWord
                //convert secretWord to char Array and check if the letter is in theWord
                char[] showLettersInTheWord = secretWord.toCharArray();
                for (char i = 0; i < showLettersInTheWord.length; i++) {
                    if (Character.toLowerCase(theWord.charAt(i)) == choosenLetter) {
                        showLettersInTheWord[i] = choosenLetter;
                        newLetter = true;
                    }
                }
                
                secretWord = String.copyValueOf(showLettersInTheWord);
    
                //minus 1 attempt if the letter is not guessed
                if (newLetter == false) {
                    attempts--;
                }
                game.usedLettersLine(choosenLetter);
    
                gameFinished = true;
                //if there are still stars in the word the game is not finished
                for (char i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == '*') {
                        gameFinished = false;
                    }
                }
            }

            //the game is lost if there are no more attempts
            if (attempts == 0) {
                gamesLost++;
                System.out.println("Unfortunately, you lost! The word was: " + theWord);
                System.out.println();

            } else {
                gamesWon++;
                System.out.println("Congratulations! The word was: " + theWord);
            }
            //7.Show the user statistic results (lost, won games)
            System.out.println("Statistics: ");
            System.out.println("Games lost: " + gamesLost);
            System.out.println("Games won: " + gamesWon);

            //8.Ask the user to continue a game or end game
            System.out.println("Do you want to play again (yes/no)?");
            agree = sc.next().toLowerCase();

            if (agree.equals("no")) {
                System.out.println("Thank you for the game, bye bye!");
            }

        } while (agree.equals("yes"));

        
    } //end main
} //end class
	