import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */


public class Menu {


    private static void userSelection(int condition){




        // this needs to return something



    }

    public static void userSelection() throws IndexOutOfBoundsException {

        try {
            //HashMap<String, Integer> gameSelector = new HashMap<>();

            Scanner usernameObj = new Scanner(System.in);

            // Adding elements to the Map
            // using standard put() method
            // gameSelector.put("Punch-Out", 1);
            // gameSelector.put("Pokemon", 2);
            // gameSelector.put("Hangman", 3);

            System.out.println("\nGreetings, welcome to our game module! Please start by selecting a username. \n");
            System.out.println("Enter a username: ");
            String username = usernameObj.nextLine();// Read user input
            System.out.println("You current username is " + username);

            System.out.println("Hello, we have many games for you!");

            System.out.println("-1.Punch-Out\n" + "-2.Pokemon battle\n" + "-3.Hangman\n");

            System.out.println("Please type your game of choice. Either enter 1,2,or 3: ");
            String selection = usernameObj.nextLine();


            /*

                WE NEED AN OUT-OF-BOUNDS EXCEPTION

                a switch variable
                a while loop to keep checking that switch variable
                a function
             */



            if(selection.equals("1")){
                PunchOutTestMenu punchOutTestMenu = new PunchOutTestMenu();
                punchOutTestMenu.punchOut();
            }

            if(selection.equals("2")){
                PokemonTestMenu testClassForMenu = new PokemonTestMenu();
                testClassForMenu.testingMenu();
            }

            if(selection.equals("3")) {
                System.out.println("Thank you for choosing Hangman:");

                HangmanPlayerTwoVersion hangmanPlayerTwoVersion = new HangmanPlayerTwoVersion();
                hangmanPlayerTwoVersion.hangmanEngine();

            } //else if (!(selection.equals("1") && selection.equals("2")  && selection.equals("1"))) throw new IndexOutOfBoundsException();

            usernameObj.close();

        } catch (Exception e){
            System.out.println("Invalid user input, please enter a valid with in the range please");
        }
    }

}
