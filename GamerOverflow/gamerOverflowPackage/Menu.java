/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */

public class Menu implements Observer{

    private String name;
    private String id;

    @Override
    public void handle(PropertyChangedEvent args) {
        System.out.println(this.name + ": "
        + "(ID:" + this.id + ") "
          + args.propertyName + 
        " has released a new score: " +  args.newValue);
        
    }
    
    
}
