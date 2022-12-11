/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 * 
 * This is the Demo class that creates the menu and database. It starts the program.
 */
public class Demo {

    public static void main(String[] args) {

        Database d1 = Database.getDatabase();

        Menu menu1 = new Menu(d1);
        d1.subscribe(menu1);

        menu1.userSelection();
    
        
    }
}
