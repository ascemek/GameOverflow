import java.util.Random;
import java.util.Scanner;

/**
 * @author Sami Cemek
 * @date Nov 15 2022
 * @version 1.1
 */

public class Pokemon extends Game{

    private int totalScore = 0;
    private static int duelWon = 0;

    /**
     * Prints the instructions of the game
     */
    static void printInstructions(){

        System.out.println("Welcome to Pokemon Duel!");

        System.out.print("Are you ready to be the very best like no one ever was? ");
        System.out.println("Do you have what it takes to be the best Pokemon trainer?");
        System.out.println("Well, we shall see. Here are the rules:" + "\n");
        System.out.println("Your Pokemon is going to fight with 5 opponents.");
        System.out.println("You roll a die every round and based on the result your pokemon's stats will change.");
        System.out.println("1: attack point increase by 1");
        System.out.println("2: +attack point increase by 2");
        System.out.println("3: attack point increase by 3");
        System.out.println("4: attack point increase by 4");
        System.out.println("5: attack point increase by 5");
        System.out.println("6: attack point increase by 6" + "\n");
         
        System.out.println("Your Pokemon will start with the following stats:" + "\n" 
        + "Health = 100" + "\n"
        + "Defense = 10" + "\n"
        + "Attack = 12");

        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Name your Pokemon: ");

        String pokemonName = sc.nextLine();  // Read user input
        System.out.println("Pokemon is: " + pokemonName);  // Output user input
        //sc.close();
    }

     /**
     * Checks what the current game status is (this is decided based on user requirements)
     */
    @Override
    void checkVictory(Player p, NPC opp) {
        if (p.isDead() == true)
        {
            System.out.println("You lost the duel!");
            lose = true;
        }
        else if (opp.isDead() == true)
        {
            System.out.println("You beat your opponent!");
            victory = true;
        }
        else
        {
            System.out.println("The duel continues!");
        }
        
    }

    /**
     * The computerTurn method is supposed to decide what the enemy will do in response
     * to the player's input. It will then display the results of the player's and enemy's actions.
     * 
     * @param p Player character used in the game that performs the actions the player chooses
     * @param npc This is an NPC Enemy Character to fight against
     */
    @Override
    void computerTurn(Player p, NPC npc) {
        System.out.println("NPC attacks the Player");
    }

    /**
     * The playerTurn Method is supposed to simply prompt the player with the actions that they 
     * can choose have their character do.
     * 
     * @param p Player character used in the game that performs the actions the player chooses
     * @param sca The scanner that parses the user's input 
     */
    @Override
    void playerTurn(Player p, Scanner sca) {
        System.out.println("Player attacks the NPC");
    }

    /**
     * Updates the score by 100 and prints the totalScore
     */
    @Override
    public void updateScore() {
        totalScore = totalScore + 100;
        System.out.println("Your total score is: " + totalScore);
    }

    /**
     * Displays a message informing the player they win. 
     */
    @Override
    void victoryEnd() {
        System.out.println("You beat your opponent");
        System.out.println("Your total score is: " + totalScore);
        
    }

    /**
     * Displays a message informing the player they lose. 
     */
    @Override
    void loseEnd() {
        System.out.println("You lost agains this opponent!");
        System.out.println("Your total score is: " + totalScore);
        
    }

    /**
     * Return the total score 
     * @return totalScore
     */
    @Override
    int returnScore() {
        return totalScore;
    }

    /**
     * Used to roll a die that generates a number between 1 and 6
     * @return number that is between 1 and 6
     */
    public static int rollDieLast(){
		Random randomGenerator = new Random();
		int number = randomGenerator.nextInt(6) + 1;
		//System.out.println(number);
		return number;

	}
    /**
     * Makes the player1 and player2 fight
     * @param player1 the player object to be controlled by the player (holds stats)
     * @param player2 the npc object to be controlled by the computer (holds stats)
     */
    public static void fight(Player player1, NPC player2){

        boolean gameOn = true;

        // access the values of the parameters
        int player1Health = player1.getHealth();
        int player2Health = player2.getHealth();

        int player1Defense = player1.getDefense();
        int player2Defense = player2.getDefense();

        int player1Attack = player1.getAttack();
        int player2Attack = player2.getAttack();

        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        while(gameOn){

            //player1 attacks player 2
            System.out.println("Player attacks to NPC");

            System.out.println("Wanna roll a die?: (1: YES, 0: NO)");
            int wannaRoll = sc.nextInt();  // Read user input

            if(wannaRoll == 1){

                int num = rollDieLast();

                if(num == 1){
                    player1Attack = player1Attack + 1;
                    System.out.println("Player rolled a die and attack point increase by 1.");
                }else if(num == 2){
                    player1Attack = player1Attack + 2;
                    System.out.println("Player rolled a die and attack point increase by 2.");
                }else if(num == 3){
                    player1Attack = player1Attack + 3;
                    System.out.println("Player rolled a die and attack point increase by 3.");
                }else if(num == 4){
                    player1Attack = player1Attack + 4;
                    System.out.println("Player rolled a die and attack point increase by 4.");
                }else if(num == 5){
                    player1Attack = player1Attack + 5;
                    System.out.println("Player rolled a die and attack point increase by 5.");
                }else if(num == 6){
                    player1Attack = player1Attack + 6;
                    System.out.println("Player rolled a die and attack point increase by 6.");
                }
                
            }
            
            System.out.println("player 1 attack point " + player1Attack);
            System.out.println("NPC defense: " + player2Defense);

            player2Health = player2Health - player1Attack + player2Defense;
            System.out.println("NPC health is: " + player2Health);
            System.out.println("Damage hit: " + (player1Attack - player2Defense) + "\n" );

            if((player2Health <= 0)){
                //winner is player1
                gameOn = false;
                System.out.println("The winner is: player1");
                //sc.close();  // DONT CLOSE THE SCANNER BECAUSE WE WILL COME BACK TO USE IT LATER
                duelWon++;
                System.out.println("~~~~~~~~~~~CONGRATULATIONS!! YOU WON THE DUEL " +  duelWon + " ~~~~~~~~~~~");
                //poki.updateScore(); //TRYNA UPDATE THE SCORE LIKE THIS, I MIGHT FELT CUTE
                break;
            }

            System.out.println("-------------------------------------------------------");

            //player2 attacks player 1
            System.out.println("NPC attacks to player");
            // generate die roll for the NPC - will generate 0 or 1
            int wannaRollNPC = (int) Math.round(Math.random()); 
            System.out.println("NPC wanna roll a die (1: YES, 0: NO): " + wannaRollNPC);
            
            if(wannaRollNPC == 1){
                int num2 = rollDieLast();

                if(num2 == 1){
                    player2Attack = player2Attack + 1;
                    System.out.println("attack point increase by 1.");
                }else if(num2 == 2){
                    player2Attack = player2Attack + 2;
                    System.out.println("attack point increase by 2.");
                }else if(num2 == 3){
                    player2Attack = player2Attack + 3;
                    System.out.println("attack point increase by 3.");
                }else if(num2 == 4){
                    player2Attack = player2Attack + 4;
                    System.out.println("attack point increase by 4.");
                }else if(num2 == 5){
                    player2Attack = player2Attack + 5;
                    System.out.println("attack point increase by 5.");
                }else if(num2 == 6){
                    player2Attack = player2Attack + 6;
                    System.out.println("attack point increase by 6.");
                }
            }
            
            System.out.println("NPC attack point: " + player2Attack);
            System.out.println("Player defense:: " + player1Defense);

            player1Health = player1Health - player2Attack + player1Defense;
            System.out.println("Player health is: " + player1Health);
            System.out.println("Damage hit: " + (player2Attack - player1Defense) + "\n");

            if((player1Health <= 0)){
                //winner is NPC
                gameOn = false;
                System.out.println("The winner is: NPC");
                System.out.println("Your not that guy pal trust me your not that guy.");
                //sc.close(); // DONT CLOSE THE SCANNER BECAUSE WE WILL COME BACK TO USE IT LATER
                break;
            }

        }
    }

    /**
     * Create the player and the NPCs and make them fight
     */
    public void runCode(){

        printInstructions();

        // Main player character with the base stats
        Player player = new Player(0, 12, 100, 8);

        // NCP opponents
        NPC opp1 =  new NPC(1, 10, 100, 7, "Pikachu");
        NPC opp2 = new NPC(2, 11, 110, 8, "Evee");
        NPC opp3 = new NPC(3, 12, 115, 9, "Piplup");
        NPC opp4 = new NPC(4, 13, 120, 10, "Charmander");
        NPC opp5 = new NPC(5, 14, 135, 11, "Charizard");

        NPC[] enemyArr= {opp1, opp2, opp3, opp4, opp5};

        System.out.println("\n" + "You will fight with the following opponents in order: ");
        for (NPC oppPokemon : enemyArr) 
        { 
            System.out.println(oppPokemon.toString());
        }
        
        // Make Pokemons fight based on the number of duels won.
        if(duelWon == 0){
            System.out.println( "\n" + "Round 1: Now you are facing: " + opp1.toString());
            fight(player,opp1);
        }
        if(duelWon == 1){
            updateScore();
            System.out.println( "\n" + "Round 2: Now you are facing: " + opp2.toString());
            fight(player,opp2);
        } 
        if(duelWon == 2){
            updateScore();
            System.out.println( "\n" + "Round 3: Now you are facing: " + opp3.toString());
            fight(player,opp3);
        }
        if(duelWon == 3){
            updateScore();
            System.out.println( "\n" + "Round 4: Now you are facing: " + opp4.toString());
            fight(player,opp4);
        }
        if(duelWon == 4){
            updateScore();
            System.out.println( "\n" + "Round 5: Now you are facing: " + opp5.toString());
            fight(player,opp5);
        }

    }

}