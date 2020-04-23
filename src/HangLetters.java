import java.util.Arrays;

public class HangLetters {
	
    //declare a local variables
    private String word;
    private String letters = "";

    //constructor without parameters
    public HangLetters() {}

    //StringBuffer 
    StringBuffer sb = new StringBuffer();

    //2.Method to convert each letter to stars by using StringBuffer
    public String stars(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                sb.append('*');
            }
        }
        return sb.toString();
    }

    //method to show letters which were used
    public void usedLetters() {
        for (char i = 0; i < letters.length(); i++) {
            System.out.println("Used letters: " + letters.charAt(i));
        }
    }

    //method to add a letter to the line of used letters
    public void usedLettersLine(char nextLetter) {
        letters = letters + nextLetter;
        char[] lettersArray = letters.toCharArray();
        letters = String.copyValueOf(lettersArray);

    }
    
    public String getLetters() {
        return letters;
    }

} //end class