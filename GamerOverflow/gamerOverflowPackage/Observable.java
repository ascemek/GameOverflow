import java.util.ArrayList;
import java.util.List;

/**
 * @author Sami Cemek
 * @date Nov 22 2022
 * @version 1.1
 */

public abstract class Observable {
	
	// Have a list that keeps track of the observers
	private List<Observer> observers;
	
	public Observable(){
		observers = new ArrayList<Observer>();
	}
	
	// add a new observer to the list
	public void subscribe(Observer newObs)
	{
		observers.add(newObs);
	}
	
	// remove an observer from the list
	public void unsubscribe(Observer rObs)
	{
		observers.remove(rObs);
	}
	
	// notify all of the observers when a field changes
	public void notifyAll(String propertyName, Object newValue)
	{
		for(Observer o: observers){
			o.handle(new PropertyChangedEvent(propertyName, newValue));
		}
	}

    
}
