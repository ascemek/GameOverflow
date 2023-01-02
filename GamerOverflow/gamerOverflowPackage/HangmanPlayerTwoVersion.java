import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class HangmanPlayerTwoVersion {
	 
	private List<Character> playerGuesses = new ArrayList<>();
    private int winCounter = 0;
    private int score = 9000;
    private int wrongCount = 0;
    private int guessesLeft = 9;
    private String word;
	private Scanner scanner = new Scanner(System.in);

    public void hangmanEngine() throws FileNotFoundException {

        introduction();
        word=getWord();
        boolean playingGame = true;

        while (playingGame){

        	boolean check=printWordState();
            if(!check){
                // this wrong count increment for each time the user makes an incorrect guess
                wrongCount++;
            }
            getPlayerGuess();

            if(printWordState()){
                System.out.println("You won the game!");
                playingGame = false;
            } System.out.println("Please enter your guess for the word:");
            
            
            if(playingGame && evaluateWord()) {
            playingGame = false;
           	handleWinning();
           	playingGame=askToPlayAgain();
            }
            
            
            if(playingGame) {
            hangmanPicture(wrongCount);
            playingGame = handleLosing();
            if(!playingGame) {
            playingGame=askToPlayAgain();
            }
            }
       
        }
      
    }
    
    private boolean getPlayerGuess(){

        System.out.println("\nPlease enter a letter:");
     
        String letterGuess = scanner.nextLine(); // this gets the next string input from the user

        playerGuesses.add(letterGuess.charAt(0)); // this is for the first character

        return word.contains(letterGuess);
    }
    
    
    private boolean printWordState(){

        String asterisk = new String(new char[word.length()]).replace("\0", "*");
         /**
          *
          * THIS HIDES THE WORD
          */
        
         //System.out.println("Please try to guess the word");
         //asterisk.contains("*");
         System.out.println(asterisk);


         /**
          * THIS SHOWS THE WORD!
          */
         //System.out.println(word);

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
     private void hangmanPicture(Integer wrongCount){

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
    private void introduction() {

        System.out.println();
    	System.out.println("Instructions for the game:");
    	System.out.println("Please ONLY enter one letter when the prompt asks for a letter.\n" +
                  "Try to guess the word after entering a letter. ");
    	System.out.println("If you select player 1, then try to guess the word. ");
    	System.out.println("If you select 2 players, then player 1 will enter a word while player 2 will attempt to guess the word.");
    	System.out.println("You are currently starting with 9000 points, and for each incorrect guess you will lose 1000 points.");
    	System.out.println("You have 9 total tries to guess the word. Good luck!\n");
    }
    private String getWord() throws FileNotFoundException {
        
        System.out.println("Would you like 1 or 2 players? ");
       String  players = scanner.nextLine();
    	String word;
    	  if(players.equals("1")){

              Scanner scanner = new Scanner(new File("gamerOverflowPackage/alternativeWords.txt"));

              List<String> words= new ArrayList<>();

              while (scanner.hasNext()){
                  words.add(scanner.nextLine()); // adding words to the list
              }
              Random random = new Random();

              // this is what we will change to get another player
              word = words.get(random.nextInt(words.size())); // this will give a random word in the list
          } else{
              System.out.println("Player 1, please enter your word");
              Scanner scanner = new Scanner(System.in);
              word =scanner.nextLine();
              System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
              System.out.println("Ready for player two, good luck!");
          }
    	  return word;
    }
    private boolean askToPlayAgain() throws FileNotFoundException {
    	 
    	System.out.println("\nDo you want to keep playing the game? Muahahaha!! \nPlease enter yes or no: ");
        String playAgain = scanner.nextLine();
        if(playAgain.equals("yes")){
        
        	
        	playerGuesses = new ArrayList<>();
            word = getWord();
            winCounter = 0;
            score = 9000;
            wrongCount = 0;
            guessesLeft = 9;
          

            return true;

        } else if (playAgain.equals("no")) {
            System.out.println("Thank you for playing :) " );
            return false;
           
        } else {
            System.out.println("Could not get what you said, peace!");
            return false;
        }

    }
    private void handleWinning() {
    	winCounter++;
       System.out.println("You won the game!");
       System.out.println("Your win streak is: " + winCounter + "/1");
       System.out.println("You total score for winning is: " + (score) + " pts");
       System.out.println("\n");
    }
    private boolean evaluateWord() throws FileNotFoundException {
    	 if(scanner.nextLine().equals(word) ){
      
            return true;
            
         } else {
             score = score - 1000;
             guessesLeft = guessesLeft -1;
             System.out.println("The current score: " + score);
             System.out.println("You have " + guessesLeft + " tries left!");
            return false;
         }
    }
    private boolean handleLosing() {
        if(wrongCount >= 9){
            System.out.println("Ouch! You guessed wrong " + wrongCount + " times!");
            System.out.println("You lose the game sucker!");
            System.out.println("The word was: " + word);
            System.out.println("Your current score is " + score);

            return false;
        }

        return true;
    }

    public int returnHangmanScore()
    {

        return score;
    }

}


