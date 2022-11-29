import java.util.HashMap;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public class Database extends Observable{
    
   //Database class should have only one instance therefore we are going to use Singleton Pattern

    // I need to have one database for sure so I will use Eager Initialization
    private Database db;
    private int score;
    private String playerName;

    Database(String playerName){
        this.score = 0;
        this.playerName = playerName;
    }

    // set the latest score to given score as a parameter if it wasn't set before
	public void updateNewScore(Integer updatedScore)
	{
		if(this.score != 0 && 
				this.score > (score))
			return;
		
		this.score = updatedScore;
		notifyAll(playerName, updatedScore); //notify all of the observers
		
	}

    //getter
    public String getName() { return playerName; }
	// return the name of the Player
	public String toString() { return playerName + " Player Name"; }

    //private static Database instance = new Database();

    /* 
    public static Database getDatabase(){
        return instance;
    }
    */

    private HashMap<String, Integer> pokemon = new HashMap<String, Integer>();
    private HashMap<String, Integer> punchout = new HashMap<String, Integer>();
    private HashMap<String, Integer> hangman = new HashMap<String, Integer>();

    private HashMap[] scores = {hangman, pokemon, punchout}; 

    public void updatePokemon(String name, Integer score)
    {
        pokemon.put(name, score);
    }

    public void updatePunchOut(String name, Integer score)
    {
        punchout.put(name, score);
    }

    public void updateHangman(String name, Integer score)
    {
        hangman.put(name, score);
    }
    
    /*
        public String getPokemonName(){
        return name;
        }

        public void setPokemonName{
        this.name = name;
        }

        public Integer getPokemonScore(){
        return score;
        }

        public void setPokemonScore(){
        this.score = score;
        }
     */



    






    
}
