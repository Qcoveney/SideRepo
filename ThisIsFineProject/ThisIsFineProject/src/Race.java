
public class Race {
	private String race;
	private String abilityScoreMod;
	private String size;
	private int speed;
	private boolean darkvision;
	private String specialTrait;
	
	/**
	 * Default constructor.
	 */
	public Race() {
		race = "none";
		abilityScoreMod = "0";
		size = "none";
		speed = 0;
		darkvision = false;
		specialTrait = "nothing yet";
	}
	
	/**
	 * Want to have your race be a Dwarf? Call this method!
	 */
	public void Dwarf() {
		race = "Dwarf";
		abilityScoreMod = "Con +2";
		size = "Medium";
		speed = 25;
		darkvision = true;
		specialTrait = "Dwarven Resilience: You have advantage on saving throws against poison,\n"
				+ "and you have resistance against poison damage (you take half damage if\n"
				+ "that damage is poison damage.\n";
	}
	
	/**
	 * Want to have your race be an Elf? Call this method!
	 */
	public void Elf() {
		race = "Elf";
		abilityScoreMod = "Dex +2";
		size = "Medium";
		speed = 30;
		darkvision = true;
		specialTrait = "Keen Senses: You have proficiency in the Perception skill (when rolling\n"
				+ "a perception check, roll twice and use the higher of the two rolls.)\n";
	}
	
	/**
	 * Want to have your race be a Halfling? Call this method!
	 */
	public void Halfling() {
		race = "Halfling";
		abilityScoreMod = "Dex +2";
		size = "Small";
		speed = 25;
		darkvision = false;
		specialTrait = "Lucky: When you roll a 1 on the d20 for an attack roll, ability check, or\n"
				+ "saving throw, you can reroll the die and must use the new roll\n";
	}
	
	/**
	 * Want to have your race be a Human? Call this method!
	 */
	public void Human() {
		race = "Human";
		abilityScoreMod = "All abilities +1";
		size = "Medium";
		speed = 30;
		darkvision = false;
		specialTrait = "None\n";
	}
	
	public String toString()  {
		return "Ability Score Modifier: " + abilityScoreMod + "\n" + "Size: " + size + "\n" 
				+ "Speed: " + speed + "\n" +"Darkvision: " + darkvision + "\n" + "Special Trait:\n" + specialTrait;
	}
}
