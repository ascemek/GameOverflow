import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */

public class Menu implements Observer{

    private String gameName;
    private Integer id;

    // constructor
	public Menu(String gameName, Integer id)
	{
		this.gameName = gameName;
		this.id = id;
	}

    @Override
    public void handle(PropertyChangedEvent args) {
        System.out.println(this.gameName + ": "
        + "(ID:" + this.id + ") "
          + args.propertyName + 
        " has a new score: " +  args.newValue);
        
    }
    
    public static void gameSelector(){
        try {
            HashMap<String, Integer> gameSelector = new HashMap<>();

            Scanner sc = new Scanner(System.in);

            // Adding elements to the Map
            // using standard put() method
            gameSelector.put("Punch-Out", 1);
            gameSelector.put("Pokemon", 2);
            gameSelector.put("Hangman", 3);


            System.out.println("Select a username: ");
            String username = sc.nextLine();// Read user input
            System.out.println("You current username is " + username);

            System.out.println("Hello, we have many games for you!");
            System.out.println("Please select from the following");


            System.out.println("-1.Punch-Out\n" + "-2.Pokemon battle\n" + "-3.Hangman\n");
            System.out.println("Enter a number:");
            String gameSelected = sc.nextLine();

            System.out.println("The game that you selected is: " + gameSelected + "\n" +
                    "Current gamer tag: " + username);  // Output user input
            sc.close();

        } catch (Exception e){
            System.out.println("Invalid user input, please enter a valid with in the range please");
        }
    }

    public static void main(String[] args) {

        gameSelector();
    }
    
    
}
