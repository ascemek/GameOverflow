import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */
public class MenuAbsoluteLast implements Observer{

    //reference to the database we want to update.
    private static Database sami;

    //Constructor defines what database we are referencing
    public MenuAbsoluteLast(Database d1)
    {
        this.sami = d1;
    }

    public static void userSelection() throws IndexOutOfBoundsException {

        try {
            //HashMap<String, Integer> gameSelector = new HashMap<>();

            Scanner usernameObj = new Scanner(System.in);

            // Adding elements to the Map
            // using standard put() method
//            gameSelector.put("Punch-Out", 1);
//            gameSelector.put("Pokemon", 2);
//            gameSelector.put("Hangman", 3);

            System.out.println("\nGreetings, welcome to our game module! Please start by selecting a username. \n");
            System.out.println("Enter a username: ");
            String username = usernameObj.nextLine();// Read user input
            System.out.println("You current username is " + username);

            System.out.println("Hello, we have many games for you!");

            System.out.println("-1.Punch-Out\n" + "-2.Pokemon battle\n" + "-3.Hangman\n");

            System.out.println("Please type your game of choice. Either enter 1,2,or 3: ");
            String selection = usernameObj.nextLine();


            /*

                WE NEED AN OUT0OF-BOUNDS EXCEPTION
             */

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
                
                //SAMI INSTANTIATE YOUR POKEMON HERE AND DO LIKE I DID
                //int score = pokemon.gameStart(ab, p1, npc1);
                ///sami.updatePokemon(username, score);
                //sami.notifyAll(username, score);
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

    @Override
    public void handle(PropertyChangedEvent args) {
        System.out.println("New Score on the leaderboard!");
        System.out.println(args.propertyName +" got a score of: " + args.newValue);
        //DO WE WANT TO PRINT THE DATABASE TO A TEXT FILE???
    }

}
