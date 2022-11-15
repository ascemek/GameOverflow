/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public abstract class Game {
    
    public abstract void ComputerTurn();

    public abstract void PlayerTurn();

    public abstract int UpdateScore();

    /**
	 * This method will print the winner between the player1 and player2
	 * @param player1 is the first player object
	 * @param player2 is the second player object
	 */
	public static void fight(Player player1, Player player2){

        boolean gameOn = true;

        int player1Health = player1.getHealth();
        int player2Health = player2.getHealth();


        while(gameOn){

            //player1 attacks player 2
            player2Health = player2Health - (player1.getAttack());
            System.out.println("Player2 health is: " + player2Health);

            //player2 attacks player 1
            player1Health = player1Health - (player2.getAttack());
            System.out.println("Player1 health is: " + player1Health);

            if((player1Health <= 0)){
                //winner is player2
                gameOn = false;
                System.out.println("The winner is: player2");
            }

           if((player2Health <= 0)){
                //winner is player1
                gameOn = false;
                System.out.println("The winner is: player1");
            }
           
        }
        
    }














}
