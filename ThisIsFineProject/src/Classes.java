// Don't do anything with this yet. It's nowhere even near started
public class Classes {
	private String name;
	private String hitDice;
	private String hitPoints;
	private String proficiencies;
	private String equipment;
	private String featsAndSpells;
	
	/**
	 * Default Constructor to initialize the variables.
	 */
	public Classes() {
		name = "0";
		hitDice = "0";
		hitPoints = "0";
		proficiencies = "0";
		equipment = "0";
		featsAndSpells = "0";
	}
	
	/**
	 * Want to make a bard? Call this and it will give you all the info!
	 */
	public void Bard() {
		name = "Bard";
		hitDice = "1d8 per Bard level";
		hitPoints = "8 + your Con modifier";
		proficiencies = "Light armor, simple weapons, hand crossbows,\n"
				+ "longswords, rapiers, shortswords, three musical\n"
				+ "instruments of your choice, Dexterity saving throws,\n"
				+ "Charisma saving throws, any three skills of your choice.\n";
		equipment = "One rapier, longsword, or any simple weapon.\n"
				+ "A diplomat's pack or an entertainer's pack.\n"
				+ "A lute or other instrument.\n"
				+ "Leather armor and a dagger.\n";
		featsAndSpells = "Feats: Spellcasting, Bardic Inspiration\n"
				+ "Spells: Dancing Lights, Mage Hand, Charm Person, Thunderwave\n";
	}
	
	/**
	 * Want to make a cleric? Call this and it will give you all the info!
	 */
	public void Cleric() {
		name = "Cleric";
		hitDice = "1d8 per Cleric level";
		hitPoints = "8 + your Con modifier";
		proficiencies = "Light armor, medium armor, shields,\n"
				+ "simple weapons, Wisdom saving throws,\n"
				+ "Charisma saving throws, two skills from:\n"
				+ "History, Insight, Medicine, Persuasion, Religion.\n";
		equipment = "One mace or a warhammer.\n"
				+ "Scale mail, leather armor, or chain mail.\n"
				+ "A light crossbow with 20 bolts, or any simple weapon.\n"
				+ "A priest's pack or an explorer's pack.\n"
				+ "A shield and a holy symbol.\n";
		featsAndSpells = "Feats: Spellcasting, Divine Domain\n"
				+ "Spells: Mending, Sacred Flame, Spare the Dying,\n"
				+ "        Bless, Healing Word\n";
	}
	
	/**
	 * Want to make a fighter? Call this and it will give you all the info!
	 */
	public void Fighter() {
		name = "Fighter";
		hitDice = "1d10 per Fighter level";
		hitPoints = "10 + your Con modifier";
		proficiencies = "All armor, shields, simple weapons,\n"
				+ "martial weapons, Strength saving throws,\n"
				+ "Constitution saving throws, two skills from:\n"
				+ "Acrobatics, Animal Handling, Athletics,\n"
				+ "History, Insight, Intimidation, Perception,\n"
				+ "Survival.\n";
		equipment = "Chain mail or, leather armor with a longbow and 20 arrows.\n"
				+ "A martial weapon and a shield or two martial weapons.\n"
				+ "A light crossbow and 20 bolts or two handaxes.\n"
				+ "A dungeoneer's pack or an explorer's pack.\n";
		featsAndSpells = "Feats: Fighting style, Second Wind\n";
	}
	
	/**
	 * Want to make a Rogue? Call this and it will give you all the info!
	 */
	public void Rogue() {
		name = "Rogue";
		hitDice = "1d8 per Rogue Level";
		hitPoints = "8 + your Con modifier";
		proficiencies = "Light armor, Simple weapons, hand crossbows,\n"
				+ "longswords, rapiers, short swords, thieves' tools,\n"
				+ "Dexterity saving throws, Intelligence saving throws,\n"
				+ "four skills from: Acrobatics, Athletics, Deception,\n"
				+ "Insight, Intimidation, Investigation, Perception,\n"
				+ "Performance, Persuasion, Sleight of Hand, Stealth.\n";
		equipment = "A rapier or a shortsword.\n"
				+ "A shortbow and a quiver of 20 arrows or a shortsowrd.\n"
				+ "A burglar's pack, a dungeoneer's pack, or an explorer's pack.\n"
				+ "Leather armor, two daggers, and thieves' tools.\n";
		featsAndSpells = "Feats: Expertise, Sneak Attack, Thieves' Cant\n";
	}
	
	/**
	 * This returns all the info for your class as a formatted string :)
	 */
	@Override
	public String toString() {
		return "Hit Dice: " + hitDice + "\n"
				+ "Hit Points: " + hitPoints + "\n"
				+ "Proficiencies: " + proficiencies
				+ "Equipment: " + equipment
				+ "Feats and Spells: " + featsAndSpells;
	}
}