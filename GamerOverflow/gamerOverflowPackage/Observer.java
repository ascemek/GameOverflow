/**
 * @author Sami Cemek
 * @date Nov 22 2022
 * @version 1.1
 */

public interface Observer {
    
    public void handle(PropertyChangedEvent args);
    
}

// Keep track of which value is changing
class PropertyChangedEvent{
	
	public String propertyName;
	public Object newValue;
	
	
	public PropertyChangedEvent( 
		String propertyName, Object newValue) {
		
		this.propertyName = propertyName;
		this.newValue = newValue;
	}
	
}
