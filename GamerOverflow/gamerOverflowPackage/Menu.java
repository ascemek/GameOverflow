import java.io.IOException;
import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */


public class Menu {

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
                    PunchOutTestMenu punchOutTestMenu = new PunchOutTestMenu();
                    punchOutTestMenu.punchOut();
                    selectionTest = false;
                }

                if(selection.equals("2")){
                    PokemonTestMenu pokemonTestMenu = new PokemonTestMenu();
                    pokemonTestMenu.printInstructions();
                    selectionTest = false;
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

}
