import java.io.IOException;
import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 * 
 * This is the Menu class. It is the main object that controls input, starting games,
 * and updating the database. 
 */
public class Menu implements Observer{

    //reference to the database we want to update.
    private static Database sami;

    //Constructor defines what database we are referencing
    public Menu(Database d1)
    {
        this.sami = d1;
    }

    /**
     * This is the main interaction point of the system. It prompts the player
     * for their information, and lets them choose the game they want to play. 
     * 
     * It starts said game, runs it, and returns the score. It then takes that score
     * and adds it to the leaderboards. This repeats indefinitely.
     * @throws IndexOutOfBoundsException if there's an out of bounds issue it throws an error
     */
    public static void userSelection() throws IndexOutOfBoundsException {

        Scanner usernameObj = new Scanner(System.in);
        try {

            boolean selectionTest = true;
            while (selectionTest){
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("\nGreetings, welcome to our game module! Please start by selecting a username. \n");
                System.out.println("Enter a username: ");
                String username = usernameObj.nextLine();// Read user input
                System.out.println("You current username is " + username);

                System.out.println("Hello, we have many games for you!");

                System.out.println("-1.Punch-Out\n" + "-2.Pokemon battle\n" + "-3.Hangman\n");

                // this is valid here for the user to see
                System.out.println("Please type your game of choice. Either enter 1,2,or 3: ");
            

                String selection = usernameObj.nextLine();

                if(selection.equals("1")){
                    Player p1 = new Player(1, 25, 100, 5);
                    NPC npc1 = new NPC(1, 25, 100, 5);
    
                    Scanner ab = new Scanner(System.in);
                    System.out.println("Start Punch-Out:");
            
                    Game punch = new PunchOut();
                    punch.gameStart(ab, p1, npc1);
                    int score = punch.returnScore();

                    sami.updatePunchOut(username, score);
                    sami.updateNewScore(username,score);

                }

                else if(selection.equals("2")){
                    /*PokemonTestMenu pokemonTestMenu = new PokemonTestMenu();
                    pokemonTestMenu.printInstructions();*/
                }

                else if(selection.equals("3")) {

                    // when the user selects 3 then the hangman game will be implemented
                    HangmanPlayerTwoVersion hangmanPlayerTwoVersion = new HangmanPlayerTwoVersion();
                    hangmanPlayerTwoVersion.hangmanEngine();
                } 
                else {
                    System.out.println("You did something wrong sucker, please try again!");
                    System.out.println("Please type your game of choice. Either enter 1, 2, or 3: ");
                }
            }
            usernameObj.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * This is the handle method for the menu. This is activated whenever the
     * databse that this menu is observing updates/ calls notifyAll().
     * 
     * It basically just displays the score and calls the leaderboard to be updated.
     */
    @Override
    public void handle(PropertyChangedEvent args) {
        System.out.println("------------------------------------------------------");
        System.out.println("New Score on the leaderboard!");
        System.out.println(args.propertyName +" got a score of: " + args.newValue);
        System.out.println("------------------------------------------------------");

        LeaderBoardDisplay updater = new LeaderBoardDisplay(sami);
        updater.leaderDisplay();
    }
}
