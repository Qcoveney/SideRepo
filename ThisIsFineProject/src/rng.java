import java.util.Random;

public class rng
{
	private Random die;
	private int rolled[];
	
	/**
	 * Default constructor that initializes the RNG class.
	 */
	public rng() {
		die = new Random();
		rolled = new int[6];
	}
	
	/**
	 * Method that generates 6 random numbers between 3 and 18.
	 * The numbers are populated into the rolled array variable.
	 */
	public void roll() {
		for (int i = 0; i < this.rolled.length; i++)
			rolled[i] = die.nextInt(15) + 3; 
	}
	
	/**
	 * Returns the array of random numbers as an integer array.
	 * @return the array of random numbers as an integer array.
	 */
	public int[] toArray() {
		return this.rolled;
	}
	
	/**
	 * Returns the array of random numbers as a formatted String.
	 * @return the array of random numbers as a formatted String.
	 */
	@Override
	public String toString() {
		String output = rolled[0] + " " + rolled[1] + " " + rolled[2]
				+ " " + rolled[3] + " " + rolled[4] + " " + rolled[5] + "\n";
		return output;
	}
	
	/**
	 * Rolls another new set of numbers and populates the array
	 * before returning the new array.
	 * @return a newly populated random number array.
	 */
	public int[] rollArray() {
		roll();
		return this.rolled;
	}
	
	/**
	 * Rolls another new set of numbers and populates the array
	 * before returning the contents as a formatted String.
	 * @return a formatted String of new random numbers.
	 */
	public String rollString() {
		roll();
		String output = rolled[0] + " " + rolled[1] + " " + rolled[2]
				+ " " + rolled[3] + " " + rolled[4] + " " + rolled[5] + "\n";
		return output;
	}
}