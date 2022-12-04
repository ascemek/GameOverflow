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

	public static Integer rollDie(){
		Random randomGenerator = new Random();
		int number = randomGenerator.nextInt(6) + 1;
		System.out.println(number);
		return number;
	}
	
}

