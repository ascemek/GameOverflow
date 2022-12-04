import java.util.Scanner;

/**
 * @author Sami Cemek
 * @date Nov 15 2022
 * @version 1.1
 */

public class Pokemon extends Game{

    class Character{

    }


    @Override
    void ComputerTurn(NPC npc) {
        // TODO Auto-generated method stub
        
    }

    @Override
    void PlayerTurn(Player p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    int UpdateScore() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    void VictoryEnd() {
        // TODO Auto-generated method stub
        
    }

    @Override
    void LoseEnd() {
        // TODO Auto-generated method stub
        
    }

    @Override
    void Player2Turn(Player p2) {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) {

        
        // There are 5 enemies 
        Player Pikachu =  new Player(0, 0, 0, 0);
        Player Evee = new Player(0, 0, 0, 0);
        Player Piplup = new Player(0, 0, 0, 0);
        Player Charmander = new Player(0, 0, 0, 0);
        Player Charizard = new Player(0, 0, 0, 0);
        
        Player[] enemyArr= {Pikachu, Evee, Piplup, Charmander, Charizard};

        printInstructions();


    }

    static void printInstructions(){
        System.out.println("Welcome to Pokemon Duel!");

        System.out.print("Are you ready to be the very best like no one ever was? ");
        System.out.println("Do you have what it takes to be the best Pokemon trainer?");
        System.out.println("Well, we shall see. Here are the rules:" + "\n");
        System.out.println("Your Pokemon is going to fight with 5 opponents.");
        System.out.println("You roll a die every round and");
        System.out.println("1: Divide your stats by 2");
        System.out.println("2: +10 health points to both Pokemons");
        System.out.println("3: -20 health points of your Pokemon");
        System.out.println("4: Multiply your stats by 2");
        System.out.println("5: +20 your defense point");
        System.out.println("6: +100 to your overall score" + "\n");
         


        System.out.println("Your Pokemon will start with the following stats:" + "\n" 
        + "Health = 100" + "\n"
        + "Defense = 10" + "\n"
        + "Attack = 12");

        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Name your Pokemon: ");

        String pokemonName = sc.nextLine();  // Read user input
        System.out.println("Pokemon is: " + pokemonName);  // Output user input
        sc.close();
    }







    


}