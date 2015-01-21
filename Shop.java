import java.util.*;
import java.io.*;

public class Shop{

    public String[] gitems;
    public String[] witems;
    public String[] mitems;
    public String[] ritems;
    public int[] priceg;
    public int[] price;
    public int[] power;

    public Shop() {
	gitems = new String[]{"small potion", "medium potion", "big potion", "red potion", "yellow potion", "blue potion", "green potion"};
	priceg = new int[] {40, 60, 130, 100, 200, 400, 800};
	witems = new String[]{"copper sword", "bronze sword", "silver sword", "gold sword", "platinum sword", "diamond sword", "copper armor", "bronze armor", "silver armor", "golden armor"};
	mitems = new String[]{"wooden staff", "fire staff", "water staff", "earth staff", "ice staff", "golden staff", "fire robe", "aqua robe", "nature robe", "icy robe"};
	ritems = new String[]{"dagger","double knives", "machete", "long knife", "double long knife", "triple long knives", "leather armor", "black armor", "koskin armor", "ninja armor"};
	price = new int[]{600, 900, 1400, 2500, 5000, 10000, 1500, 1800, 2200, 5000};
	power = new int[]{10, 20, 30, 40, 50, 60, 15, 30, 45, 60};
    }

    public void check(String name, String type){
        int pos = Search(name);
	if (type.equals("weapon")) {
	    this.weaponName = name;
	    this.coins = coins - price[pos];
	    this.weaponStats = power[pos];
	}
	if (type.equals("armor")) {
	    this.armorName = name;
	    this.coins = coins - price[pos];
	    this.armorStats = power[pos];
	}	
	if (type.equals("potion")) {
	    this.coins = coins - priceg[pos];
	}
    }

    public int Search(String Name){
	if (Arrays.asList(witems).contains(Name)){
	    for (int i=0;i<witems.length; i++){
		if (witems[i].equals(Name)) {
		    return i;
		}
	    }
	}
	if (Arrays.asList(mitems).contains(Name)){
	    for (int i=0;i<mitems.length; i++){
		if (mitems[i].equals(Name)) {
		    return i;
		}
	    }
	}
	if (Arrays.asList(ritems).contains(Name)){
	    for (int i=0;i<ritems.length; i++){
		if (ritems[i].equals(Name)) {
		    return i;
		}
	    }	
	}
	
	if (Arrays.asList(gitems).contains(Name)){
	    for (int i=0;i<gitems.length; i++){
		if (gitems[i].equals(Name)) {
		    return i;
		}
	    }	
	}
    }

    public void Store() {
	System.out.println("Welcome to the shop!");
	System.out.println("Here, you can spend all the coins you won from defeating monsters.");
	System.out.println("Which option do you want:");
	System.out.println("Option One: Weapons and Armor");
	System.out.println("Option Two: Potions");

	while (true) {
	    Scanner sc = new Scanner(System.in);
	    String Choice = sc.nextLine();
	    Choice = Choice.toLowerCase();
	    if (Choice.equals("one") || Choice.equals("two")) {
		if (Choice.equals("one")) {
		    if (this.type.equals("Warrior")) {
			System.out.println("Warrior Shop:");
			System.out.println("Copper Sword: A crude, somewhat sturdy sword. Does not have any special effects. Does slightly more damage than the Basic Sword (600 coins)");
			System.out.println("Bronze Sword: A smooth blade with a blunt point. Has a 5% chance of healing you of 50% of the damage dealt. Does slightly more damage than the Copper Sword (900 coins)");
			System.out.println("Silver Sword: A firm, sturdy sword. Lowers the accuracy of the opponent by 5% with a 10% chance. Much stronger than the Bronze Sword. (1400 coins)");
			System.out.println("Gold Sword: A shiny, precious sword valued by all men. There is a 15% chance that the attack of the monster will be lowered by 10%. Much stronger than the Silver Sword (2500 coins)");
			System.out.println("Platinum Sword: A tough, destructive sword than can only be wielded by the strongest. Each hit of the sword has a 20% chance to drop the opponent's defense by 25%. Stronger than the Gold Sword (5000 coins)");
			System.out.println("Diamond Sword: The most destructive sword of all. There is a 10% chance you will instantly knock out the opponent. Does not work on bosses. Much stronger than the Platinum Sword. (10000 coins)");
			System.out.println("Copper Armor (1500 coins)");
			System.out.println("Bronze Armor (1800 coins)");
			System.out.println("Silver Armor (2200 coins)");
			System.out.println("Golden Armor (5000 coins)\n");
			System.out.println("What would you like to purchase? ");
			while (true) { //Not done with store
			    Scanner sca = new Scanner(System.in);
			    String choice = sca.nextLine();
			    choice = choice.toLowerCase();
			    while (true) {//Right choice
				if (!Arrays.asList(witems).contains(choice) || choice.equals("back")) {
				    System.out.println("This is not listed above. Enter something correct: ");
				}
				else {
				    break;
				}
			    }
			    if (choice.equals("back")) {
				break;
			}
			    if (coins < price[Search(choice)]) {
				System.out.println("You do not have enough coins to purchase this item.");
			    }
			    else {
				if (Search(choice) < 6) {
				    check(choice, "weapon");
				}
				else {
				    check(choice, "armor");
				}
			    }				
			}
		    }

		    if (this.type.equals("Mage")) {
			System.out.println("Mage Shop:");
			System.out.println("Wooden Staff: A basic, wooden staff. Does not have any special effects. Does slightly more damage than the Basic Staff. (600 coins)");
			System.out.println("Fire Staff: A staff that glows and is warm to the touch. Has a 5% chance to burn the opponent. Bosses cannot be burned with this staff. Slightly more powerful than the Wooden Staff. (900 coins)");
			System.out.println("Water Staff: A staff that is cool and refreshing to the touch. Has a 5% chance to heal you for half the damage you dealt to the monster. Much more powerful than the Fire Staff. (1400 coins)");
			System.out.println("Earth Staff: A staff that radiates the power of nature. Has a 10% chance to drop the opponent's defense by 10%. Slightly more powerful than  the Water staff. (2500 coins)");
			System.out.println("Ice Staff: A staff, when not handled properly, can freeze the best of mages. Has a 3% chance to freeze the opponent for 1 turn. Bosses cannot be frozen. Much more powerful than the Earth Staff. (5000 coins)");
			System.out.println("Golden Staff: A staff that radiates brilliance. Has a 10% chance to lower the opponent's accuracy by 15%. Does not work on bosses. Much stronger than the Ice Staff. (10000 coins)");
			System.out.println("Flaming Robe (1500 coins)");
			System.out.println("Aqua Robe (1800 coins)");
			System.out.println("Nature Robe (2200 coins)");
			System.out.println("Icy Robe (5000 coins)\n");
			System.out.println("What would you like to purchase? ");
			while (true) {
			    Scanner sca = new Scanner(System.in);
			    String choice = sca.nextLine();
			    choice = choice.toLowerCase();
			    while (true) {
				if (!Arrays.asList(mitems).contains(choice) || choice.equals("back")) {
				    System.out.println("This is not listed above. Enter something correct: ");
				}
				else {
				    break;
				}
			    }
			    if (choice.equals("back")) {
				break;
			    }
			    if (coins < price[Search(choice)]) {
				System.out.println("You do not have enough coins to purchase this item.");
			    }
			    else {
				if (Search(choice) < 6) {
				    check(choice, "weapon");
				}
				else {
				    check(choice, "armor");
				}
			    }
			}
		    }

		    if (this.type.equals("Rogue")) {
			System.out.println("Rogue Shop");
			System.out.println("Dagger: A blunt dagger that has a 2% chance to poison the opponent. Does slightly more damage than the knife. (600 coins)");
			System.out.println("Double Knives: Allows you to attack twice in one turn. Combined damage does slightly more than the Dagger. (900 coins)");
			System.out.println("Machete: A larger knife that has a 5% chance to lower the opponent's attack by 5%. Much stronger than the Double Knife. (1400 coins)");
			System.out.println("Long Knife: A thinner, longer knife that can lower the opponent's dexterity by 5% with a 5% chance. Stronger than the Machete. (2500 coins)");
			System.out.println("Double Long Knives: Allows you to attack twice in one turn. Each hit has 10% chance to lower the defense of the opponent by 5%. (5000 coins)");
			System.out.println("Triple Long Knives: Allows you to attack three times in one turn. Each knife has a 1% chance to instantly knock out the opponent. Does not work on bosses. (10000 coins)");
			System.out.println("Leather Armor (1500 coins)");
			System.out.println("Black Armor (1800 coins)");
			System.out.println("Koskin Armor (2500 coins");
			System.out.println("Ninja Armor (5000 coins)\n");
			System.out.println("What would you like to purchase? ");
			while (true) {
			    Scanner sca = new Scanner(System.in);
			    String choice = sca.nextLine();
			    choice = choice.toLowerCase();
			    while (true) {
				if (!Arrays.asList(ritems).contains(choice) || choice.equals("back")) {
				    System.out.println("This is not listed above. Enter something correct: ");
				}
				else {
				    break;
				}
			    }
			    if (choice.equals("back")) {
				break;
			    }
			    if (coins < price[Search(choice)]) {
			    System.out.println("You do not have enough coins to purchase this item.");
			    }
			    else {
				if (Search(choice) < 6) {
				    check(choice, "weapon");
				}
				else {
				    check(choice, "armor");
				}
			    }
			}
		    }
		}
		if (Choice.equals("two")) {
		    System.out.println("General Shop:");
		    System.out.println("Small Potion: Restores 50 health. (40 coins)");
		    System.out.println("Medium Potion: Restores 80 health. (60 coins)");
		    System.out.println("Big Potion: Restores 150 health. (130 coins)");
		    System.out.println("Red Potion: Restores 1/8 of your health. (100 coins)");
		    System.out.println("Yellow Potion: Restores 1/4 of your health. (200 coins)");
		    System.out.println("Blue Potion: Restores 1/2 of your health. (400 coins)");
		    System.out.println("Green Potion. Restores all of your health. (800 coins)\n");
		    System.out.println("What would you like to purchase? ");
		    while (true) {
			Scanner sca = new Scanner(System.in);
			String choice = sca.nextLine();
			choice = choice.toLowerCase();
			while (true) {
			    if (!Arrays.asList(gitems).contains(choice) || choice.equals("back")) {
				System.out.println("This is not listed above. Enter something correct: ");
			    }
			    else {
				break;
			    }
			}
			if (choice.equals("back")) {
			    break;
			}
			if (coins < price[Search(choice)]) {
			    System.out.println("You do not have enough coins to purchase this item.");
			}
			else {
			    check(choice, "potion");
			}
		    }
		}
		else {
		    System.out.println("Please input one, two, or quit.");
		}
	    }
	}
    }

    public static void main (String[] args) {
	Shop s = new Shop();
        
    }
}
