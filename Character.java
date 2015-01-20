public class Character extends Basechar {

    public Character(String name, String charname) {
	if (name.equals("Boss")) {
	    super(10, 2, 0, 75, 5, 2, "Epic Boss 2k14", "Boss", 30, "", 0);
	}
	if (name.equals("CannonFodder")) {
	    super(10, 2, 0, 75, 5, 2, "Cannon Fodder", "Monster", 10, "", 0);
	}
	if (name.equals("Imp")) {
	    super(12, 4, 0, 75, 4, 1, "Cannon Fodder", "Monster", 15, "", 0);
	}
	if (name.equals("Mage")) {
	    super(80, 12, 4, 90, 10, 1, charname, "Mage", 0, "", 0);
	    weaponName = "Basic Staff";
	}
	if (name.equals("MiniOverlord")) {
	    super(25, 10, 0, 75, 15, 8, "Mini-Overlord", "Monster", 30, "", 0);
	}
	if (name.equals("Ogre")) {
	    super(15, 6, 0, 75, 5, 3, "Ogre", "Monster", 20, "", 0);
	}
	if (name.equals("Overlord")) {
	    super(50, 10, 5, 300, 25, 10, "Epic Overlord", "Boss", 150, "", 10);
	}
	if (name.equals("Rogue")) {
	    super(75, 9, 5, 90, 15, 1, charname, "Rogue", 0, "", 0);
	    weaponName = "Knife";
	}
	if (name.equals("Troll")) {
	    super(20, 8, 0, 75, 10, 5, "Troll", "Monster", 25, "", 0);
	}
	if (name.equals("Warrior")) {
	    super(100, 10, 7, 80, 10, 1, charname, "Warrior", 0, "Basic Armor", 0);
	    weaponName = "Basic Sword";
	}
    }
}
