import java.util.Random;

/**
 * @author Sami Cemek
 * @date Dec 4 2022
 * @version 1.1
 */

public class RandomIntegerGenerator{
	/**
	 * rollDie() method generates a number that is between 1 and 6
	 * @return number(int) that is between 1 and 6
	 */

	public static void rollDie(Player p, NPC opp){
		Random randomGenerator = new Random();
		int number = randomGenerator.nextInt(6) + 1;
		System.out.println(number);

		if(number == 1){
			int healthP1 = p.getHealth() / 2;
			int attackP1 = p.getAttack() / 2;
			int defenseP1 = p.getDefense() / 2;
			System.out.println("1: Divide your stats by 2");
		}else if(number == 2){
			int healthP1 = p.getHealth() + 10;
			int healthOpp = opp.getHealth() + 10;
			System.out.println("2: +10 health points to both Pokemons");
		}else if(number == 3){
			int healthP1 = p.getHealth() - 20;
			System.out.println("3: -20 health points of your Pokemon");
		}else if(number == 4){
			int healthP1 = p.getHealth() * 2;
			int attackP1 = p.getAttack() * 2;
			int defenseP1 = p.getDefense() * 2;
			System.out.println("4: Multiply your stats by 2");
		}else if(number == 5){
			int defenseP1 = p.getDefense() + 20;
			System.out.println("5: +20 your defense point");
		}else{
			//Pokemon.updateScore();
			System.out.println("6: +100 to your overall score" + "\n");
		}
		//return number;

	}

	public static void main(String[] args) {
		System.out.println(Math.round(Math.random()));
		//Math.round(Math.random());
	}

	


	
}

