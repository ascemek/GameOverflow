public class NPC {
    private int attack;
	private int health;
	private int defend;
	private int id;

    // consturctor 
	public NPC(int id, int attack, int health, int defend)
	{
		this.id = id;
		this.attack = attack;
		this.health = health;
		this.defend = defend;
	}
	
	
	// set health
	public void setHealth(int hp) {
		
		this.health -= hp;
	}
	
	// get health
	public int getHealth() {
		
		return this.health;
	}
	
	// get id
	public int getId() {
		
		return this.id;
	}
	
	// set id
	public void setId(int id) {
		
		this.id = id;
	}
	
	// get attack
	public int getAttack() {
		
		return this.attack;
	}
	
	public int getDefense()
	{
		return this.defend;
	}

	/**
	 * @return true or false depending on the health point
	 */
	public boolean isDead() {
		if(health > 0)
			return false;
		else
			return true;
	}

    
}
