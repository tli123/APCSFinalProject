public class Shop {

    System.out.println("Welcome to the shop!");
    System.out.println("Here, you can spend all the coins you won from defeating monsters.");
    System.out.println("General Shop:");
    System.out.println("Small Potion: Restores 50 health. (40 coins)");
    System.out.println("Medium Potion: Restores 80 health. (60 coins)");
    System.out.println("Big Potion: Restores 150 health. (130 coins)");
    System.out.println("Red Potion: Restores 1/8 of your health. (100 coins)");
    System.out.println("Yellow Potion: Restores 1/4 of your health. (200 coins)");
    System.out.println("Blue Potion: Restores 1/2 of your health. (400 coins)");
    System.out.println("Green Potion. Restores all of your health. (800 coins)");
    System.out.println("");

    if (this.type.equals("Warrior")) {
	System.out.println("Warrior Shop:");
	System.out.println("Copper Sword: A crude, somewhat sturdy sword. Does not have any special effects. Does slightly more damage than the Basic Sword (6

00 coins)");
	System.out.println("Bronze Sword: A smooth blade with a blunt point. Has a 5% chance of healing you of 50% of the damage dealt. Does slightly more damage than the Copper Sword (900 coins)");
	System.out.println("Silver Sword: A firm, sturdy sword. Lowers the accuracy of the opponent by 5% with a 10% chance. Much stronger than the Bronze Sword. (1400 coins)");
	System.out.println("Gold Sword: A shiny, precious sword valued by all men. There is a 15% chance that the attack of the monster will be lowered by 10%. Much stronger than the Silver Sword (2500 coins)");
	System.out.println("Platinum Sword: A tough, destructive sword than can only be wielded by the strongest. Each hit of the sword has a 20% chance to drop the opponent's defense by 25%. Stronger than the Gold Sword (5000 coins)");
	System.out.println("Diamond Sword: The most destructive sword of all. There is a 10% chance you will instantly knock out the opponent. Does not work on bosses. Much stronger than the Platinum Sword. (10000 coins)");
    }

    if (this.type.equals("Mage")) {
	System.out.println("Mage Shop:");
	System.out.println("Wooden Staff (600)");
	System.out.println("Fire Staff (900)");
	System.out.println("Water Staff (1400)");
	System.out.println("Earth Staff (2500)");
	System.out.println("Ice Staff (5000)");
	System.out.println("Golden Staff (10000)");
    }

    if (this.type.equals("Rogue")) {
	System.out.println("Rogue Shop");
	System.out.println("Dagger (600)");
	System.out.println("Double Knives (900)");
	System.out.println("");
	System.out.println("");
	System.out.println("");
    }
