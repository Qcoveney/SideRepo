
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ProjectTestCases {
	
	// Tests for the RNG class.
	@SuppressWarnings("deprecation")
	@Test
	void testRng() {
		rng random = new rng();
		int actual = random.dice();
		int expected = 6;
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRngRoll() {
		rng random = new rng();
		random.roll();
		int array[] = random.toArray();
		boolean expected = true, actual = true;
		
		for (int i = 0; i<6; i++)
			if (array[i] > 18 && array[i] < 3)
				actual = false;
				
		
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRngToArray() {
		rng random = new rng();
		int array[] = random.toArray();
		int actual = array.length;
		int expected = 6;
		
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRngToString() {
		rng random = new rng();
		String actual = random.toString();
		String expected = "0 0 0 0 0 0\n";
		Assert.assertEquals(expected, actual);
	}
	
	// Tests for the Races class.
	@SuppressWarnings("deprecation")
	@Test
	void testRace() {
		Race race = new Race();
		String actual = race.toString();
		String expected = "Ability Score Modifier: 0\nSize: none\n"
				+ "Speed: 0\nDarkvision: false\nSpecial Trait:\nnothing yet";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRaceDwarf() {
		Race race = new Race();
		race.Dwarf();
		String actual = race.toString();
		String expected = "Ability Score Modifier: Con +2\nSize: Medium\n"
				+ "Speed: 25\nDarkvision: true\nSpecial Trait:\nDwarven Resilience: You have advantage on saving throws against poison,\n"
				+ "and you have resistance against poison damage (you take half damage if\n"
				+ "that damage is poison damage.\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRaceElf() {
		Race race = new Race();
		race.Elf();
		String actual = race.toString();
		String expected = "Ability Score Modifier: Dex +2\nSize: Medium\n"
				+ "Speed: 30\nDarkvision: true\nSpecial Trait:\nKeen Senses: You have proficiency in the Perception skill (when rolling\n"
								+ "a perception check, roll twice and use the higher of the two rolls.)\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRaceHalfling() {
		Race race = new Race();
		race.Halfling();
		String actual = race.toString();
		String expected = "Ability Score Modifier: Dex +2\nSize: Small\n"
				+ "Speed: 25\nDarkvision: false\nSpecial Trait:\nLucky: When you roll a 1 on the d20 for an attack roll, ability check, or\n" 
				+ "saving throw, you can reroll the die and must use the new roll\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testRaceHuman() {
		Race race = new Race();
		race.Human();
		String actual = race.toString();
		String expected = "Ability Score Modifier: All abilities +1\nSize: Medium\n"
				+ "Speed: 30\nDarkvision: false\nSpecial Trait:\nNone\n";
		Assert.assertEquals(expected, actual);
	}
	
	// Tests for the Backgrounds class.
	@SuppressWarnings("deprecation")
	@Test
	void testBackgrounds() {
		Backgrounds background = new Backgrounds();
		String actual = background.toString();
		String expected = "No background!\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testBackgroundsCharlatan() {
		Backgrounds background = new Backgrounds();
		background.Charlatan();
		String actual = background.toString();
		String expected = "Charlatan - You know people on the inside and out. You know what makes\n"
				+ "them tick, and use this to your advantage.\n"
				+ "\n"
				+ "Proficiencies: Deception, Sleight of Hand\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testBackgroundsEntertainer() {
		Backgrounds background = new Backgrounds();
		background.Entertainer();
		String actual = background.toString();
		String expected = "Entertainer - You thrive in front of an audience. You know how to\n"
				+ "entrance them, entertain them, and even inspire them.\n"
				+ "\n"
				+ "Proficiencies: Acrobatics, Performance\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testBackgroundsHermit() {
		Backgrounds background = new Backgrounds();
		background.Hermit();
		String actual = background.toString();
		String expected = "Hermit - You lived in seclusion. Either in a sheltered community\n"
				+ "such as a monastery, or entirely alone.\n"
				+ "\n"
				+ "Proficiencies: Medicine, Religion\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testBackgroundsSoldier() {
		Backgrounds background = new Backgrounds();
		background.Soldier();
		String actual = background.toString();
		String expected = "Soldier - War has been your life for as long as you care to remember.\n"
				+ "You have been training your whole life for this moment.\n"
				+ "\n"
				+ "Proficiencies: Athletics, Intimidation\n";
		Assert.assertEquals(expected, actual);
	}
	
	// Tests for the Classes class.
	@SuppressWarnings("deprecation")
	@Test
	void testClasses() {
		Classes classes = new Classes();
		String actual = classes.toString();
		String expected = "Hit Dice: 0\n"
				+ "Hit Points: 0\n"
				+ "Proficiencies: 0\n"
				+ "Equipment: 0\n"
				+ "Feats and Spells: 0\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testClassesBard() {
		Classes classes = new Classes();
		classes.Bard();
		String actual = classes.toString();
		String expected = "Hit Dice: 1d8 per Bard level\n"
				+ "Hit Points: 8 + your Con modifier"
				+ "Proficiencies: Light armor, simple weapons, hand crossbows,\n"
				+ "longswords, rapiers, shortswords, three musical\n"
				+ "instruments of your choice, Dexterity saving throws,\n"
				+ "Charisma saving throws, any three skills of your choice.\n"
				+ "Equipment: One rapier, longsword, or any simple weapon.\n" 
				+ "A diplomat's pack or an entertainer's pack.\n"
				+ "A lute or other instrument.\n"
				+ "Leather armor and a dagger.\n"
				+ "Feats and Spells: Feats: Spellcasting, Bardic Inspiration\n"
				+ "Spells: Dancing Lights, Mage Hand, Charm Person, Thunderwave\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testClassesCleric() {
		Classes classes = new Classes();
		classes.Cleric();
		String actual = classes.toString();
		String expected = "Hit Dice: 1d8 per Cleric level\n"
				+ "Hit Points: 8 + your Con modifier"
				+ "Proficiencies: Light armor, medium armor, shields,\n"
				+ "simple weapons, Wisdom saving throws,\n"
				+ "Charisma saving throws, two skills from:\n"
				+ "History, Insight, Medicine, Persuasion, Religion.\n"
				+ "Equipment: One mace or a warhammer.\n"
				+ "Scale mail, leather armor, or chain mail.\n"
				+ "A light crossbow with 20 bolts, or any simple weapon.\n"
				+ "A priest's pack or an explorer's pack.\n"
				+ "A shield and a holy symbol.\n"
				+ "Feats and Spells: Feats: Spellcasting, Divine Domain\n"
				+ "Spells: Mending, Sacred Flame, Spare the Dying,\n"
				+ "        Bless, Healing Word\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testClassesFighter() {
		Classes classes = new Classes();
		classes.Fighter();
		String actual = classes.toString();
		String expected = "Hit Dice: 1d10 per Fighter level\n"
				+ "Hit Points: 10 + your Con modifier"
				+ "Proficiencies: All armor, shields, simple weapons,\n"
				+ "martial weapons, Strength saving throws,\n"
				+ "Constitution saving throws, two skills from:\n"
				+ "Acrobatics, Animal Handling, Athletics,\n"
				+ "History, Insight, Intimidation, Perception,\n"
				+ "Survival.\n"
				+ "Equipment: Chain mail or, leather armor with a longbow and 20 arrows.\n"
				+ "A martial weapon and a shield or two martial weapons.\n" 
				+ "A light crossbow and 20 bolts or two handaxes.\n"
				+ "A dungeoneer's pack or an explorer's pack.\n"
				+ "Feats and Spells: Feats: Fighting style, Second Wind\n";
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testClassesRogue() {
		Classes classes = new Classes();
		classes.Rogue();
		String actual = classes.toString();
		String expected = "Hit Dice: 1d8 per Rogue Level\n"
				+ "Hit Points: 8 + your Con modifier"
				+ "Proficiencies: Light armor, Simple weapons, hand crossbows,\n"
				+ "longswords, rapiers, short swords, thieves' tools,\n"
				+ "Dexterity saving throws, Intelligence saving throws,\n"
				+ "four skills from: Acrobatics, Athletics, Deception,\n"
				+ "Insight, Intimidation, Investigation, Perception,\n"
				+ "Performance, Persuasion, Sleight of Hand, Stealth.\n"
				+ "Equipment: A rapier or a shortsword.\n"
				+ "A shortbow and a quiver of 20 arrows or a shortsowrd.\n"
				+ "A burglar's pack, a dungeoneer's pack, or an explorer's pack.\n"
				+ "Leather armor, two daggers, and thieves' tools.\n"
				+ "Feats and Spells: Feats: Expertise, Sneak Attack, Thieves' Cant\n";
		Assert.assertEquals(expected, actual);
	}
}
