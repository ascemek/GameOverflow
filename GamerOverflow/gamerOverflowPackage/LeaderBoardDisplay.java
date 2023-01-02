import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeaderBoardDisplay {

    //Database and information to be used 
    private static Database db;
   

    //Constructor to pass database
    public LeaderBoardDisplay(Database d1)
    {
        db = d1;
    }

    /**
     * Updates the info of the all the internal listings of scores and users.
     * This calls on the outside databse to update the internal hashmap of this object.
    

    /**
     * This method starts by making sure the information is updated, creates a 
     * sorted version of the info, and constructs a string that is the leaderboard.
     * 
     * This is then printed to an outside .txt file
     */
    public void leaderboardSingle(  String gamename)
    { 
    	String filepath;
    	HashMap<String, Integer> hash;
    
    	  if(gamename.equals("H")) {
    		 filepath="./hangmanScores.txt";
    		 hash=Database.getDatabase().passHang();
    	  }else if(gamename.equals("PO")) {
    		  filepath="./pokemonScores.txt";
     		 hash=Database.getDatabase().passPokemon();
    		
    	  }else {
    		  filepath="./punchoutScores.txt";
      		 hash=Database.getDatabase().passPunch();
    	  }
     

        String top  = gamename + "HIGH SCORES:\n----------------------------------------\n";
        String lead = "";
        int i = 1;

        HashMap<String, Integer> sorted = sortByValue(hash);
        
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();

            lead = i + ") " + key + " " + val + "\n----------------------------------------\n" + lead;
            i++;
        }

        String finalLead =  top + lead;
      
        printFile(finalLead, filepath);
    }

    /**
     * This method updates the leaderboards of all the different games
     */
    public void leaderDisplay()
    {
  
        leaderboardSingle( "H");
        leaderboardSingle("PO");
        leaderboardSingle("PU");
    }

    /**
     *  Takes a hashmap and sorts it by integer value. This section of code was taken
     *  from https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
     * @param hm the hashmap to be sorted
     * @return the hasmap that has been sorted.
     */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /**
     * This takes a string and a the filepath for the file we want to write to,
     * and then writes the string to that file
     * @param leaderboard this is the string to be written
     * @param filePath this is the file to write on
     */
    public static void printFile(String leaderboard, String filePath)
    {
        try
		{
            FileWriter writer = new FileWriter(filePath);
            writer.write(leaderboard);
            writer.close();
        }
        catch(IOException z)
        {
            System.out.println("An error occurred.");
            z.printStackTrace();
		}
    }
}
