/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public class DemoAbsoluteLast {

    public static void main(String[] args) {
        
        boolean infinite = true;

        Database d1 = Database.getDatabase();
        MenuAbsoluteLast menu = new MenuAbsoluteLast(d1);
        d1.subscribe(menu);


        Menu menu1 = new Menu();
        menu1.userSelection();
    }
}
