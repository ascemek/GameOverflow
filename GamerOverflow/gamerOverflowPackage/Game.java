/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public abstract class Game {
    
    abstract void Player2Turn(Player p2);
    abstract void ComputerTurn(NPC npc);
    abstract void PlayerTurn(Player p);

    abstract int UpdateScore();

    abstract void VictoryEnd();
    abstract void LoseEnd();

    /**
	 * This method will print the winner between the player1 and player2
	 * @param player1 is the first player object
	 * @param player2 is the second player object
	 */
	public void gameStart(Player player1, Player player2){

        boolean gameOn = true;

        int player1Health = player1.getHealth();
        int player2Health = player2.getHealth();


        while(gameOn){
            PlayerTurn(player1);
            Player2Turn(player2);
            UpdateScore();

            if((player1Health <= 0))
            {
                gameOn = false;
                LoseEnd();
            }

            if((player2Health <= 0))
            {
                gameOn = false;
                VictoryEnd();
            }
        }
    }

    public void gameStart(Player player1, NPC computerNpc){

        boolean gameOn = true;

        int player1Health = player1.getHealth();
        int npcHealth = computerNpc.getHealth();


        while(gameOn)
        {
            PlayerTurn(player1);
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
