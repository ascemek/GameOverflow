/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 09 2022
 * @version 1.1
 */

public class Demo {

    public static void main(String[] args) {

        //TEST Observer and Observable
        //Observable
        Database db1 = new Database("Sami"); // WE ARE SUPPOSE TO READ THE PLAYER NAME FROM A USER INPUT OR (TEXT FILE)*
        //Observer
        Menu menu1 =  new Menu("Punch Out", 111); // WE ARE SUPPOSE TO READ THE GAME NAME FROM A USER INPUT OR (TEXT FILE)**

        db1.subscribe(menu1);
        db1.updateNewScore(1000); // WE ARE SUPPOSE TO READ THIS VALUE FROM A TEXT FILE ***
    }

    // * I NEED A COMPLETE MENU TO FINISH THIS PART. I'LL USE THE SCANNER VARIABLES TO CHANGE THE FIXED VALUES
    // SOMETHING LIKE Database db1 = new Database(username);
    
}
