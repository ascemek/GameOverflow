import java.io.IOException;
import java.util.Scanner;
import java.util.function.ObjDoubleConsumer;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */


public class Menu implements Observer{

    //reference to the database we want to update.
    private static Database sami;

    //Constructor defines what database we are referencing
    public Menu(Database d1)
    {
        this.sami = d1;
    }

    public static void userSelection() throws IndexOutOfBoundsException {

        try {
            Scanner usernameObj = new Scanner(System.in);

            System.out.println("\nGreetings, welcome to our game module! Please start by selecting a username. \n");
            System.out.println("Enter a username: ");
            String username = usernameObj.nextLine();// Read user input
            System.out.println("You current username is " + username);

            System.out.println("Hello, we have many games for you!");

            System.out.println("-1.Punch-Out\n" + "-2.Pokemon battle\n" + "-3.Hangman\n");

            // this is valid here for the user to see
            System.out.println("Please type your game of choice. Either enter 1,2,or 3: ");
            String selection = usernameObj.nextLine();

            boolean selectionTest = true;

            while (selectionTest){

                if(selection.equals("1")){
                    Player p1 = new Player(1, 25, 100, 5);
                    NPC npc1 = new NPC(1, 25, 100, 5);
    
                    Scanner ab = new Scanner(System.in);
                    System.out.println("Start Punch-Out:");
            
                    Game punch = new PunchOut();
                    int score = punch.gameStart(ab, p1, npc1);
                    sami.updatePunchOut(username, score);
                    sami.notifyAll(username, score);
                }

                if(selection.equals("2")){
                    /*PokemonTestMenu pokemonTestMenu = new PokemonTestMenu();
                    pokemonTestMenu.printInstructions();
                    selectionTest = false;*/
                }

                if(selection.equals("3")) {

                    // when the user selects 3 then the hangman game will be implemented
                    HangmanPlayerTwoVersion hangmanPlayerTwoVersion = new HangmanPlayerTwoVersion();
                    hangmanPlayerTwoVersion.hangmanEngine();
                    selectionTest = false;

                } else {
                    System.out.println("You did something wrong sucker, please try again!");
                    System.out.println("Please type your game of choice. Either enter 1, 2, or 3: ");
                     selection = usernameObj.nextLine();
                }
            }
            usernameObj.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void handle(PropertyChangedEvent args) {
        System.out.println("New Score on the leaderboard!");
        System.out.println(args.propertyName +" got a score of: " + args.newValue);
        //DO WE WANT TO PRINT THE DATABASE TO A TEXT FILE???
    }


}
