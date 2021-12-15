/**
 * This is the list of backgrounds we can choose from.
 * Basically, we can use this to print out the details for the player to see.
 * @author Qcove
 *
 */
public class Backgrounds {
	private String background;
	
	/**
	 * Default constructor
	 */
	public Backgrounds() {
		background = "No background!\n";
	}
	
	/**
	 * Sets your background to a Charlatan.
	 */
	public void Charlatan() {
		background = "Charlatan - You know people on the inside and out. You know what makes\n"
				+ "them tick, and use this to your advantage.\n"
				+ "\n"
				+ "Proficiencies: Deception, Sleight of Hand\n";
	}
	
	/**
	 * Sets your background to an Entertainer.
	 */
	public void Entertainer() {
		background = "Entertainer - You thrive in front of an audience. You know how to\n"
				+ "entrance them, entertain them, and even inspire them.\n"
				+ "\n"
				+ "Proficiencies: Acrobatics, Performance\n";
	}
	
	/**
	 * Sets your background to a Hermit.
	 */
	public void Hermit() {
		background = "Hermit - You lived in seclusion. Either in a sheltered community\n"
				+ "such as a monastery, or entirely alone.\n"
				+ "\n"
				+ "Proficiencies: Medicine, Religion\n";
	}
	
	/**
	 * Sets your background to a Soldier.
	 */
	public void Soldier() {
		background = "Soldier - War has been your life for as long as you care to remember.\n"
				+ "You have been training your whole life for this moment.\n"
				+ "\n"
				+ "Proficiencies: Athletics, Intimidation\n";
	}
	
	/**
	 * Returns the background as a formatted string.
	 */
	@Override
	public String toString() {
		return background;
	}
}
