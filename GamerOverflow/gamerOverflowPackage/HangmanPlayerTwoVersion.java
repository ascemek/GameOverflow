import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class HangmanPlayerTwoVersion {

    private static void hidingWord() {

    }
    private static boolean printWordState(String word, List<Character> playerGuesses){

       String asterisk = new String(new char[word.length()]).replace("\0", "*");

        System.out.println("Please try to guess the word");
            asterisk.contains("*");
//            System.out.println("Guess any letter in the word");
            System.out.println(asterisk);



        int correctCount = 0; // counts how many are correct
        for (int i = 0; i < word.length(); i++) {

            if (playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i)); // this will print the character then the player guesses correctly
                correctCount++;
            } else System.out.print("-");
        }

        System.out.println();

        return (word.length() == correctCount);
    }
    private static boolean getPlayerGuess(Scanner keyBoardInput, String word, List<Character> playerGuesses){

        System.out.println("\nPlease enter a letter:");

        String letterGuess = keyBoardInput.nextLine(); // this gets the next string input from the user

        playerGuesses.add(letterGuess.charAt(0)); // this is for the first character

        return word.contains(letterGuess);
    }

    public void hangmanEngine() throws FileNotFoundException {
        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("Would you like 1 or 2 players? ");
        String players = keyBoardInput.nextLine();
        String word;

        if(players.equals("1")){

            Scanner scanner = new Scanner(new File("GamerOverflow/gamerOverflowPackage/alternativeWords.txt"));

            List<String> words= new ArrayList<>();

            while (scanner.hasNext()){
                words.add(scanner.nextLine()); // adding words to the list
            }
            Random random = new Random();

            // this is what we will change to get another player
            word = words.get(random.nextInt(words.size())); // this will give a random word in the list
        } else{
            System.out.println("Player 1, please enter your word");
            word = keyBoardInput.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready for player two, good luck!");
        }

        //System.out.println(word + " *****FIX THIS PART**** "); // this is printing random words from the list

        /**** HANGMAN GAME *********/

        List<Character> playerGuesses = new ArrayList<>();

        int wrongCount = 0;

        while (true){

            hangmanPicture(wrongCount);

            if(wrongCount >= 9){
                System.out.println("You lose the game sucker!");
                System.out.println("The word was: " + word);
                break;
            }

            if(!printWordState(word, playerGuesses)){
                wrongCount++;
            }

            getPlayerGuess(keyBoardInput, word, playerGuesses);

            if(printWordState(word, playerGuesses)){
                System.out.println("You won the game!");
                break;
            }

            System.out.println("Please enter your guess for the word:");

            // if the player guesses the correct word then they win the game
            if(keyBoardInput.nextLine().equals(word)){
                System.out.println("You won the game!");
                break;
            } else {
                System.out.println("Nope! Please try again.");
            }
        }
    }

    private static void hangmanPicture(Integer wrongCount){

        if(wrongCount >= 1){
            System.out.println("   ____________");
        }
        if(wrongCount >= 2){
            System.out.println("   |          _|_");
        }
        if(wrongCount >= 3){
            System.out.println("   |         /   \\");
        }
        if(wrongCount >= 4){
            System.out.println("   |        |     |");
        }
        if(wrongCount >= 5){
            System.out.println("   |         \\_ _/");
        }
        if(wrongCount >= 6){
            System.out.println("   |          _|_");
        }
        if(wrongCount >= 7){
            System.out.println("   |         / | \\");
        }
        if(wrongCount >= 8){
            System.out.println("   |          / \\ ");
        }
        if(wrongCount >= 9){
            System.out.println("___|___      /   \\");
        }
        System.out.println("");
        System.out.println("");
    }



}

