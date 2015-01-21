import java.util.*;
import java.io.*;

public class Basechar {

    //Instance Variables
    public int health;
    public int attack;
    public int defense;
    public int accuracy;
    public int evade;
    public String name;
    public String weaponName;
    public int weaponStats;
    public String type;
    public int coins;
    public String armorName;
    public int armorPoints;
    public ArrayList<String> inventory;

    //Constructor
    public Basechar(int h, int a, int d, int acc, int e, int WS, String n, String t, int c, String aN, int aP) {
	this.health = h;
	this.attack = a;
	this.defense = d;
	this.accuracy = acc;
	this.evade = e;
	this.weaponStats = WS;
	this.name = n;
       	this.type = t;
	this.coins = c;
	this.armorName = aN;
	this.armorPoints = aP;
    }

    //Attacks
    public String Attack(Basechar other){
	if (didHit(accuracy)){
	    other.health = other.health - this.attack;
	    return (name+ " attacked " +other.name + " and dealt " +attack+ " damage, " + other.name + " now has " + other.health + " left");
	}
	else {
	    return (name+ " attacked and missed");
	}
    }
    public String StrongAttack(Basechar other){
	if (didHit(accuracy/2)){
	    other.health = other.health - this.attack -this.attack -this.attack ;
	    return (name+ " attacked " +other.name + " recklessly and dealt " +attack+ " damage, " + other.name + " now has " + other.health + " left");
	}
	else{
	    return (name+ " attacked and missed");
	}
    }

    public String QuickAttack(Basechar other){
	if (didHit(accuracy+accuracy/10)){
	    other.health = other.health - ((this.attack * 4)/5) ;
	    return (name+ " attacked " +other.name + " quickly dealt " +attack+ " damage, " + other.name + " now has " + other.health + " left");
	}
	else{
	    return (name+ " attacked and missed");
	}
    }
    

    //Uses accuracy and dexterity to determine if the attack hit
    public boolean didHit(int chance){
	Random r = new Random();
	if (r.nextInt(100)>chance){
	    return false;
	}
	else {
	    return true;
	}
    }

    //Prints out the stats of the current person playing
    public void Stats(){
	System.out.println("Name: " + name);
	System.out.println("Health: " + health);
	System.out.println("Attack: " + attack);
	System.out.println("Defense: " + defense);
	System.out.println("Accuracy: " + accuracy);
	System.out.println("Evade: " + evade);
	System.out.println("Weapon Damage: " + weaponStats);
	System.out.println("Class: " + type);
	System.out.println("Coins: " + coins);
    }

    //Levelling up system that lets player upgrade their stats
    public void LevelingUp(){
	System.out.println("You won the battle!");
	System.out.println();
	System.out.println("Your curent stats are:");
	Stats();
	System.out.println();
	System.out.println("Pick a skill would you like to increase:");
	System.out.println("Health, Attack, Accuracy, or Evade");

	String Choice = "";
	boolean Correct = true;
	while (Correct){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.nextLine();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"HEALTH", "ATTACK", "ACCURACY", "EVADE", "QUIT", ""};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("This is not listed above. Enter something correct ");
	    }
	    else{ 
		Correct=false;
	    }
	}
	if (Choice.equals("QUIT")){
	    System.exit(0);
	}
	if (Choice.equals("HEALTH")){
	    health+=5;
	}
	else if (Choice.equals("EVADE	")){
	    evade+=2;
	}
	else if (Choice.equals("ACCURACY")){
	    accuracy+=2;
	}
	else{
	    attack+=1;
	}
	System.out.println();
	System.out.println("Now your stats are the following:");
	Stats();
    }

    //Random Number generator that will be used whenever something involves chance
    public boolean Chance(int Num){
	Random R = new Random();
	if (R.nextInt(Num) == 0){
	    return true;
	}
	return false;
    }
    
    //Generation of monster levels + stats
    public void Gen(int Level){
	health+=(health/2)*Level;
	attack+=(attack/2)*Level;
	defense+=Level;
	accuracy+=Level;
	evade+=Level;
	weaponStats=weaponStats*Level;
	coins=coins*Level;

	Random R=new Random();
	health+=R.nextInt(Level*3);
	attack+=R.nextInt(Level*3);
	defense+=R.nextInt(Level*3);
	accuracy+=R.nextInt(Level*3);
	evade+=R.nextInt(Level*3);
	weaponStats=R.nextInt(Level*3);
	coins+=R.nextInt(Level*3);
    }

    //Generation of boss stats
    public void BossGen(int Level){
        health+=health*Level;
	attack+=attack*Level;
	defense+=2*Level;
	accuracy+=2*Level;
	evade+=2*Level;
	weaponStats=weaponStats*Level;
	coins=coins*Level;

	Random R=new Random();
	health+=R.nextInt(Level*3);
	attack+=R.nextInt(Level*3);
	defense+=R.nextInt(Level*3);
	accuracy+=R.nextInt(Level*3);
	evade+=R.nextInt(Level*3);
	weaponStats=R.nextInt(Level*3);
	coins+=R.nextInt(Level*3);
    }

    //Prints name and health of player
    public void Status(){
	System.out.println(name);
	System.out.println("Health: "+health);
    }

    //Takes stats in the save file and updates them to Basechar
    public void ImpleStats(String[] Stats){
	//for (int i=0;i<Stats.length;i++){
	//System.out.println(Stats[i]);}
	health=Integer.valueOf(Stats[0]);
	attack=Integer.valueOf(Stats[1]);
	defense=Integer.valueOf(Stats[2]);
	accuracy=Integer.valueOf(Stats[3]);
	evade=Integer.valueOf(Stats[4]);
	weaponStats=Integer.valueOf(Stats[5]);
	weaponName=Stats[6];
	armorPoints=Integer.valueOf(Stats[7]);
	armorName=Stats[8];
	name=Stats[9];
	type=Stats[10];
	coins=Integer.valueOf(Stats[11]);
    }

    //Gets the stats to prep to put into save file
    public String[] GetStats(){
	String[] Stat = new String[12];
	Stat[0]=String.valueOf(health);
	Stat[1]=String.valueOf(attack);
	Stat[2]=String.valueOf(defense);
	Stat[3]=String.valueOf(accuracy);
	Stat[4]=String.valueOf(evade);
	Stat[5]=String.valueOf(weaponStats);
	Stat[6]=weaponName;
	Stat[7]=String.valueOf(armorPoints);
	Stat[8]=armorName;
	Stat[9]=name;
	Stat[10]=type;
	Stat[11]=String.valueOf(coins);
	return Stat;
    }

    //Checks if input is a number
    public boolean IsInt(String str){
	try {
	    Integer.valueOf(str); 
	    return true;
	}
	catch (Exception e){
	    return false;
	}
    }
    //Opens inventory to use
    public void InventoryWork(){
	while (true){
	    System.out.println("This is your inventory:");
	    System.out.println(inventory.size());
	    for (int i=0; i<inventory.size(); i++){
		System.out.println(i+". "+inventory.get(i));
	    }
	    if (inventory.size()==0){
		System.out.println("Your inventory is empty!");}

	    System.out.println("Type the number corresponding to the item you want to use");
	    System.out.println("Type -1 to go back");
	
	    int choice = 0;
	    String Choice = "";
	    boolean Correct = true;
	    while (Correct){
		Scanner sc = new Scanner(System.in);
		Choice = sc.next();
		if (!IsInt(Choice)) {
		    System.out.println("This is not a corresponding number.");
		}
		else{
		    choice = Integer.valueOf(Choice);
		    if (choice <-1 || choice >= inventory.size()){
			System.out.println("This is not a corresponding number.");
		    }
		    else{ 
			Correct=false;
		    }
		}
	    }
	
	    int LimitHealth = health;
	    if (choice!=-1){
		int Con=Conversion(inventory.get(choice));
		health+= Con;
		System.out.println("You used "+ inventory.remove(choice));}
	    else{ break;}

	    if (health > LimitHealth){
		health = LimitHealth;}
	
	}//While loop
    }

    public int Conversion(String str) {
	if (str.equals("sp")){	
	    return 50;
	}
	if (str.equals("mp")){
	    return 80;
	}
	if (str.equals("bip")){
	    return 150;
	}
	if (str.equals("rp")){
	    return health/8;
	}
	if (str.equals("yp")){
	    return health/4;
	}
	if (str.equals("blp")){
	    return health/2;
	}
	if (str.equals("gp")){
	    return health;
	}
	return 10;
    }
    //Askes whether or not to open Inventory
    public boolean WantInventory(){
	System.out.println("Would you like to view your inventory?");
	String Choice = "";
	while (true){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.nextLine();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"QUIT", "YES", "NO"};
	    if (!Choice.equals("QUIT")&&!Choice.equals("YES")&&!Choice.equals("NO")&&!Choice.equals("")) {
		System.out.println("You did not answer the question");}
	    else {break;}}
	if (Choice.equals("QUIT")){System.exit(0);}
	if (Choice.equals("NO")){return false;}
	if (Choice.equals("YES")){return true;}
	else{return false;} //I'm lazy
    }

    //SPECIAL EFFECTS OF WEAPONS (See shop)
    //lower accuracy, healing, lower attack, lower defense
    //burn, drop defense freeze, lower accuracy
    //poison, attack twice, lower attack, atack twice and lower attack, attack 3 time and instantly knock out
    public void LowerAccuracy(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    accuracy -= accuracy*PercentLowerBy;
	}
    }
    public void AttackHeal(int Chance, int MaxHealth){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    health += health/10;
	}
	if (health > MaxHealth){
	    health = MaxHealth;
	}
    }
    public void LowerAttack(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    attack -= attack*PercentLowerBy;
	}
    }
    public void LowerDefense(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    defense -= defense*PercentLowerBy;
	}
    }
    public void LowerEvade(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    evade -= evade*PercentLowerBy;
	}
    }
    public void Burn(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    health -= health/10;
	}
    }
    public void Poison(int Chance){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    health -= health/10;
	}
    }
    public void InstaKill(int Chance){
	Random Rand = new Random();
	if (Chance > Rand.nextInt(100)){
	    health = 0;
	}
    }
    //////////////////////////////////////////////////////////////////////////////
    //All down is shop
    public String[] gitems;
    public String[] witems;
    public String[] mitems;
    public String[] ritems;
    public int[] priceg;
    public int[] price;
    public int[] power;



    public void check(String name, String typeitem){
        int pos = Search(name);
	if (typeitem.equals("weapon")) {
	    weaponName = name;
	    coins = coins - price[pos];
	    weaponStats = power[pos];
	}
	if (typeitem.equals("armor")) {
	    armorName = name;
	    coins = coins - price[pos];
	    armorPoints = power[pos];
	}	
	if (typeitem.equals("potion")) {
	    coins = coins - priceg[pos];
	}
	inventory.add(name);
	System.out.println("You have successfully purchased " + name + "!");
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
	}return 0;
    }
    public void Shop(){
	gitems = new String[]{"small potion", "medium potion", "big potion", "red potion", "yellow potion", "blue potion", "green potion"};
	priceg = new int[] {40, 60, 130, 100, 200, 400, 800};
	witems = new String[]{"copper sword", "bronze sword", "silver sword", "gold sword", "platinum sword", "diamond sword", "copper armor", "bronze armor", "silver armor", "golden armor"};
	mitems = new String[]{"wooden staff", "fire staff", "water staff", "earth staff", "ice staff", "golden staff", "fire robe", "aqua robe", "nature robe", "icy robe"};
	ritems = new String[]{"dagger","double knives", "machete", "long knife", "double long knife", "triple long knives", "leather armor", "black armor", "koskin armor", "ninja armor"};
	price = new int[]{600, 900, 1400, 2500, 5000, 10000, 1500, 1800, 2200, 5000};
	power = new int[]{10, 20, 30, 40, 50, 60, 15, 30, 45, 60};
    }

    public void Store() {
	while (true) {
	    System.out.println("Welcome to the shop!");
	    System.out.println("Here, you can spend all the coins you won from defeating monsters.");
	    System.out.println("Which option do you want:");
	    System.out.println("Option One: Weapons and Armor");
	    System.out.println("Option Two: Potions");
	    System.out.println("Option Three: Back");

	    Scanner sc = new Scanner(System.in);
	    String Choice = sc.nextLine();
	    Choice = Choice.toLowerCase();
	    if (Choice.equals("one") || Choice.equals("two")||Choice.equals("three")) {
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
			    String choice;
			    while (true) {
				Scanner sca = new Scanner(System.in);
				choice = sca.nextLine();
				choice = choice.toLowerCase();
				if (!Arrays.asList(witems).contains(choice) && !choice.equals("back")) {
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
			    String choice;
			    while (true) {
				Scanner sca = new Scanner(System.in);
				choice = sca.nextLine();
				choice = choice.toLowerCase();
				if (!Arrays.asList(mitems).contains(choice) && !choice.equals("back")) {
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
				if (!Arrays.asList(ritems).contains(choice) && !choice.equals("back")) {
				    System.out.println("This is not listed above. Enter something correct: ");
				}
				else {
				    break;
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
			
			String choice;			
			while (true) {
			    Scanner sca = new Scanner(System.in);
			    choice = sca.nextLine();
			    choice = choice.toLowerCase();
			    if (!Arrays.asList(gitems).contains(choice) && !choice.equals("back")) {
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
		else{
		    break;}
	    }
	    else {
		System.out.println("Type either one, two, or three");}
	}
    }
}
