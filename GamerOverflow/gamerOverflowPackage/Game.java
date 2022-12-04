import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public abstract class Game {
    
    

    /**
     * The ComputerTurn method is supposed to decide what the enemy will do in response
     * to the player's input. It will then display the results of the player's and enemy's actions.
     * 
     * @param npc This is an NPC Enemy Character to fight against
     */
    abstract void ComputerTurn(NPC npc);

    /**
     * The PlayerTurn Method is supposed to simply prompt the player with the actions that they 
     * can choose have their character do.
     * 
     * @param p Player character used in the game that performs the actions the player chooses
     * @param sca The scanner that parses the user's input 
     */
    abstract void PlayerTurn(Player p, Scanner sca);

    /**
     * Updates the in game score based on whatever scoring method your game uses
     * 
     * @return An int representing the current score 
     */
    abstract int UpdateScore();

    /**
     * Displays a message informing the player they win. 
     * Then updates the database of scores with the user's score.
     */
    abstract void VictoryEnd();

    /**
     * Displays a message informing the player they lose. 
     * Then updates the database of scores with the user's score.
     */
    abstract void LoseEnd();


    public void gameStart(Scanner scan, Player player1, NPC computerNpc){

        boolean gameOn = true;

        int player1Health = player1.getHealth();
        int npcHealth = computerNpc.getHealth();


        while(gameOn)
        {
            PlayerTurn(player1, scan);
            ComputerTurn(computerNpc);
            UpdateScore();

            if((player1Health <= 0))
            {
                gameOn = false;
                LoseEnd();
            }

            if((npcHealth <= 0))
            {
                gameOn = false;
                VictoryEnd();
            }
            
        }
    }

}
