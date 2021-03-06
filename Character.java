public class Character extends Basechar {

    public Character(String Name) {
	super(10, 2, 0, 75, 5, 2, "Epic Boss 2k14", "Boss", 30, "", 0);
	if (Name.equals("CannonFodder")) {
	    health=10;
	    attack = 2;
	    evade = 5;
	    name = "Cannon Fodder";
	    type = "Monster";
	    coins = 10;
	}
	else if (Name.equals("Imp")) {
	    health=12;
	    attack = 4;
	    evade = 5;
	    name = "Imp";
	    type = "Monster";
	    coins = 15;
	}
	else if (Name.equals("MiniOverlord")) {
	    health=25;
	    attack = 10;
	    evade = 15;
	    name = "MiniOverlord";
	    type = "Monster";
	    coins = 30;
	}
	else if (Name.equals("Ogre")) {
	    health=15;
	    attack = 6;
	    evade = 5;
	    name = "Ogre";
	    type = "Monster";
	    coins = 20;
	}
	if (Name.equals("Overlord")) {
	    health=50;
	    attack = 10;
	    accuracy = 100;
	    evade = 25;
	    weaponStats=10;
	    name = "Mr. JonAlf Dryland-Weaver";
	    type = "BOSS";
	    coins = 150;
	}

	if (Name.equals("Troll")) {
	    health=20;
	    attack = 8;
	    evade = 5;
	    name = "Troll";
	    type = "Monster";
	    coins = 25;
	}

    }
    public Character(int Name, String charname) {
	super(0, 0, 0, 0, 0, 0, "", "", 0, "", 0);
	if (Name==1) {
	    armorPoints = 0;
	    weaponStats = 0;
	    health=50;
	    attack = 10;
	    accuracy = 80;
	    evade = 7;
	    weaponStats=10;
	    name = charname;
	    coins=0;
	    type = "Warrior";
	    armorName="Basic Armor";
	    weaponName = "Basic Sword";
	}
	if (Name==3) {
	    health= 35;
	    attack = 9;
	    defense = 5;
	    accuracy = 90;
	    evade = 15;
	    name = charname;
	    type = "Rogue";
	    coins = 0;
	    armorName= "Brittle Armor";
	    armorPoints = 0;
	    weaponStats = 0;
	    weaponName = "Knife";
	}
	if (Name==2) {
	    health=40;
	    attack = 12;
	    defense = 4;
	    accuracy = 90;
	    evade = 10;
	    name = charname;
	    type = "Mage";
	    coins = 0;
	    armorPoints = 0;
	    weaponStats = 0;
	    armorName = "Basic Robe";
	    weaponName = "Basic Staff";
	}
    }
}
