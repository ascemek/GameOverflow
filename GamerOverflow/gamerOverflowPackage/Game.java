import java.util.Scanner;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 * 
 * This is the abstract class that contains the template methods and algorithm
 * used by two other subclasses (different games) in the program.
 */
public abstract class Game {

    boolean victory = false;
    boolean lose = false;

    /**
     * Checks what the current game status is (this is decided based on user requirements)
     */
    abstract void checkVictory(Player p1, NPC e);

    /**
     * Sets the current state to victory.
     */
    public void setVictory()
    {
        victory = true;
    }

    /**
     * Sets the current state to lost. 
     */
    public void setLose()
    {
        lose = true;
    }

    /**
     * The computerTurn method is supposed to decide what the enemy will do in response
     * to the player's input. It will then display the results of the player's and enemy's actions.
     * 
     * @param npc This is an NPC Enemy Character to fight against
     */
    abstract void computerTurn(Player p, NPC npc);

    /**
     * The playerTurn Method is supposed to simply prompt the player with the actions that they 
     * can choose have their character do.
     * 
     * @param p Player character used in the game that performs the actions the player chooses
     * @param sca The scanner that parses the user's input 
     */
    abstract void playerTurn(Player p, Scanner sca);

    /**
     * Updates the in game score based on whatever scoring method your game uses
     */
    abstract void updateScore();

    /**
     * Displays a message informing the player they win. 
     */
    abstract void victoryEnd();

    /**
     * Displays a message informing the player they lose. 
     */
    abstract void loseEnd();
    
    /**
     * This is used to pass the game's score onto another class for use in updating
     * the database.
     * @return an int value representing the game's score
     */
    abstract int returnScore();

    /**
     * This is the template method that contains the algorithm of multiple game 
     * subclasses. It also records the score the player has and then passes it to
     * the menu in order to update the leaderboard/database of scores
     * 
     * @param scan a scanner we pass from the menu. Used to take input.
     * @param player1 the player object to be controlled by the player (holds stats)
     * @param computerNpc the npc object to be controlled by the computer (holds stats)
     * @return returns the final score of the player 
     */
    public void gameStart(Scanner scan, Player player1, NPC computerNpc){

        boolean gameOn = true;

        while(gameOn)
        {
            playerTurn(player1, scan);
            computerTurn(player1, computerNpc);

            checkVictory(player1, computerNpc);
            updateScore();

            if((victory == true))
            {
                victoryEnd();
                gameOn = false;
            }

            else if ((lose == true))
            {
                loseEnd();
                gameOn = false;
            }
        }
    }
}
