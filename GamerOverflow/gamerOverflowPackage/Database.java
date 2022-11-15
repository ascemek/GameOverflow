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
    
}
