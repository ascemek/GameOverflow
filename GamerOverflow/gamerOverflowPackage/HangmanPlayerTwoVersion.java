import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class HangmanPlayerTwoVersion {
    private static boolean printWordState(String word, List<Character> playerGuesses){

       String asterisk = new String(new char[word.length()]).replace("\0", "*");

        /**
         *
         * THIS HIDES THE WORD
         */
//        System.out.println("Please try to guess the word");
//        asterisk.contains("*");
//        System.out.println("Guess any letter in the word");
//        System.out.println(asterisk);

        /**
         * THIS SHOWS THE WORD!
         */
        System.out.println(word);


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

        System.out.println("Thank you for choosing Hangman!\n");
        System.out.println("Instructions for the game:");
        System.out.println("Please ONLY enter one letter when the prompt asks for a letter.\n" +
                "Try to guess the word after entering a letter. ");
        System.out.println("If you select player 1, then try to guess the word. ");
        System.out.println("If you select 2 players, then player 1 will enter a word while player 2 will attempt to guess the word.");
        System.out.println("You are currently starting with 9000 points, and for each incorrect guess you will lose 900 points.");
        System.out.println("Good luck!\n");

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


        /**** HANGMAN GAME *********/

        List<Character> playerGuesses = new ArrayList<>();

        // let's start with 1000 score and reduce the score for each wrong letter or word guess

        int winCounter = 0; // I do not think this is working

       // this is not being used
       int score = 9000;

       int wrongCount = 0;  // we want the winCounter to work

        boolean playingGame = true;

        // playingGame loop
        while (playingGame){

            hangmanPicture(wrongCount);

            if(wrongCount >= 9){
                System.out.println("You lose the game sucker!");
                System.out.println("The word was: " + word);

                playingGame = false;
            }

            if(!printWordState(word, playerGuesses)){
                wrongCount++;
            }

            getPlayerGuess(keyBoardInput, word, playerGuesses);

            if(printWordState(word, playerGuesses)){
                System.out.println("You won the game!");
//                winCounter++; // my win counter  is wrong
//                System.out.println("Your total score for the correct guesses: " );

                playingGame = false;
            }

            System.out.println("Please enter your guess for the word:");

            // if the player guesses the correct word then they win the game
            if(keyBoardInput.nextLine().equals(word) ){
                System.out.println("You won the game!");
                winCounter++; // my win counter are wrong
                System.out.println("Your win streak is: " + winCounter + "/1");
                System.out.println("You total score for winning is: " + (score) + " pts");
                System.out.println("\n");
                System.out.println("Do you want to keep playing the game? Muahahaha!! \nPlease enter yes or no: ");


                // scanner here to read an input
                // if yes then call hangManEngine
                // if no playing game = false
                // this is taking an input from the user
                // if the user enters yes then call the hangman engine i.e., start the game over
                Scanner scanner = new Scanner(System.in);

                String testingSomething = scanner.nextLine();

                if(testingSomething.equals("yes")){
                    // this is going to call the function to start the game again
                    hangmanEngine();

                } else if (testingSomething.equals("no")) {
                    System.out.println("Thank you for playing :) " );
                    playingGame = false;
                    scanner.close();
                    /**
                     * CLOSING THE SCANNER IS CAUSING AN ERROR HERE 
                     */


                } else {
                    System.out.println("Could not get what you said, peace!");
                    playingGame = false;
                }

            } else {
                System.out.println("Nope! Please try again.");
                score = score - 900;
                System.out.println("The current score: " + score);

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


