/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public class Demo {

    public static void main(String[] args) {

        Database d1 = new Database();
        Menu menu = new Menu(d1);

        d1.subscribe(menu);
        menu.userSelection();
        
    }
}
