/**
 * @author Sami Cemek
 * @author Zach 
 * @author Sebastian
 * @date Nov 15 2022
 * @version 1.1
 */

public class Menu implements Observer{

    private String gameName;
    private Integer id;

    // constructor
	public Menu(String gameName, Integer id)
	{
		this.gameName = gameName;
		this.id = id;
	}

    @Override
    public void handle(PropertyChangedEvent args) {
        System.out.println(this.gameName + ": "
        + "(ID:" + this.id + ") "
          + args.propertyName + 
        " has a new score: " +  args.newValue);
        
    }
    
    
}
