import java.util.HashMap;

/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public class Database {
    
   //Database class should have only one instance therefore we are going to use Singleton Pattern

    // I need to have one database for sure so I will use Eager Initialization
    private Database db;
    private static Database instance = new Database();

    public static Database getDatabase(){
        return instance;
    }

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

    






    
}
