import java.util.Collections;
import java.util.HashMap;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 * 
 * This is the singleton database that contains all the 
 */
public class Database extends Observable{
    
   //Database class should have only one instance therefore we are going to use Singleton Pattern

    // I need to have one database for sure so I will use Eager Initialization
    private static Database instance = new Database();

    /**
     * This returns the singleton database instance
     * @return the database instance
     */
    public static Database getDatabase()
    {
        return instance;
    }

    /**
     * This notifies the subscribed object that the score needs to be updated.
     * 
     * @param name the name of the user
     * @param updatedScore the number of their score
     */
	public void updateNewScore(String name, Integer updatedScore)
	{
		notifyAll(name, updatedScore); //notify all of the observers
	}
    
    //These are the hashmaps that contain the data for each game's scoreboard/users
    private HashMap<String, Integer> pokemon = new HashMap<String, Integer>();
    private HashMap<String, Integer> punchout = new HashMap<String, Integer>();
    private HashMap<String, Integer> hangman = new HashMap<String, Integer>();

    //This is an array that contains them
    private HashMap[] scores = {hangman, pokemon, punchout}; 

    /**
     * This updates the pokemon hashmap with a new entry
     * @param name name of the user
     * @param score their score
     */
    public void updatePokemon(String name, Integer score)
    {
        pokemon.put(name, score);
    }

    /**
     * This updates the punchout hashmap with a new entry
     * @param name name of the user
     * @param score their score
     */
    public void updatePunchOut(String name, Integer score)
    {
        punchout.put(name, score);
    }

    /**
     * This updates the hangman hashmap with a new entry
     * @param name name of the user
     * @param score their score
     */
    public void updateHangman(String name, Integer score)
    {
        hangman.put(name, score);
    }
    

    /**
     * This returns the internal hashmap data for pokemon
     * @return the pokemon hashmap
     */
    public HashMap<String, Integer> passPokemon()
    {
        return pokemon;
    }

    /**
     * This returns the internal hashmap data for punchout
     * @return the punchout hashmap
     */
    public HashMap<String, Integer> passPunch()
    {
        return punchout;
    }

    /**
     * This returns the internal hashmap data for hangman
     * @return the hangman hashmap
     */
    public HashMap<String, Integer> passHang()
    {
        return hangman;
    }


}
