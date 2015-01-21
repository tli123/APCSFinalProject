import java.util.*;
import java.io.*;

public class CombinedGameOutline {

    //to be used in shop
    public String[] gitems;
    public String[] witems;
    public String[] mitems;
    public String[] ritems;
    public int[] priceg;
    public int[] price;
    public int[] power;

    public CombinedGameOutline() {
	gitems = new String[]{"small potion", "medium potion", "big potion", "red potion", "yellow potion", "blue potion", "green potion"};
	priceg = new int[] {40, 60, 130, 100, 200, 400, 800};
	witems = new String[]{"copper sword", "bronze sword", "silver sword", "gold sword", "platinum sword", "diamond sword", "copper armor", "bronze armor", "silver armor", "golden armor"};
	mitems = new String[]{"wooden staff", "fire staff", "water staff", "earth staff", "ice staff", "golden staff", "fire robe", "aqua robe", "nature robe", "icy robe"};
	ritems = new String[]{"dagger","double knives", "machete", "long knife", "double long knife", "triple long knives", "leather armor", "black armor", "koskin armor", "ninja armor"};
	price = new int[]{600, 900, 1400, 2500, 5000, 10000, 1500, 1800, 2200, 5000};
	power = new int[]{10, 20, 30, 40, 50, 60, 15, 30, 45, 60};
    }



    public static void main(String args[]) throws Exception{// GAME(){
	boolean battleWon=false;
	int LevelNumber = 1;
	int MonsterNum;
	// Introduction + Credits

	//Loads + Saves files
	SaveLoad SL = new SaveLoad();
	Warrior B = new Warrior("Rong");

	if (SL.LS(1)){
	    B.ImpleStats(SL.Load());
	    String[] LevAndMon= SL.Load2();
	    LevelNumber=Integer.valueOf(LevAndMon[0]);
	    MonsterNum=Integer.valueOf(LevAndMon[1]);
	    B.inventory=SL.InventoryLoad();}

	else{
	    GetName N=new GetName();
	    String name=N.Name();
	    B = new Warrior(name);
	    B.inventory=SL.InitialInventoryLoad();
	    MonsterNum=LevelNumber*2;}

	System.out.println();

	//Add a background info, i.e. why storm the dungeon

	//Initiates Battle, get coins, etc
	while(true){ // Overlord not dead

	    while(LevelNumber<10){

		while (MonsterNum>0){ //Dungeon not cleared
		    System.out.println("There are "+MonsterNum+" monsters left");
		    Battle fight = new Battle();
		    int MCoins;

		    GameOutline GO = new GameOutline();
		    int pick = GO.MonPicker(LevelNumber);

		    if (pick==1){
			CannonFodder A= new CannonFodder();
			A.Gen(LevelNumber);
			MCoins=A.coins;
			battleWon=fight.battle(B, A);}
		    else if (pick==2){
			Imp C = new Imp();
			C.Gen(LevelNumber);
			MCoins=C.coins;
			battleWon=fight.battle(B, C);}
		    else if (pick==3){
			Ogre D = new Ogre();
			D.Gen(LevelNumber);
			MCoins=D.coins;
			battleWon=fight.battle(B, D);}
		    else if (pick==4){
			Troll E = new Troll();
			E.Gen(LevelNumber);
			MCoins=E.coins;
			battleWon=fight.battle(B, E);}
		    else{
			MiniOverlord F = new MiniOverlord();
			F.Gen(LevelNumber);
			MCoins=F.coins;
			battleWon=fight.battle(B, F);}

		    if(battleWon){
			MonsterNum-=1;
			System.out.println("You have found "+MCoins+" coins.");
			B.coins+=MCoins;
			B.LevelingUp();

			//shop

			System.out.println("Do you want to enter the shop? Please type yes or no.");
			while (true) {
			    Scanner scan = new Scanner(System.in);
			    String buy = scan.nextLine().toLowerCase();
			    if (buy.equals("yes")) {
				while (true) {
				    System.out.println("Welcome to the shop! Do you wish to purchase something for your class or the general shop?"); 
				    Scanner shopping = new Scanner(System.in);
				    String shopchoice = shopping.nextLine().toLowerCase();
				    if (shopchoice.equals("class")) {
					if (B.type.equals("Warrior")) {
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
					    while (true) {
						Scanner theitem = new Scanner(System.in);
						String choice = theitem.nextLine().toLowerCase();
						while (true) {
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
						if (B.coins < price[Find(choice)]) {
						    System.out.println("You do not have enough coins to purchase this item.");
						}
						else {
						    if (Find(choice) < 6) {
							B.weaponName = choice;
							B.weaponStats = power[Find(choice)];
							B.coins - price[Find(choice)];
						    }
						    else {
							B.armorName = choice;
							B.armorStats = power[Find(choice)];
							B.coins - price[Find(choice)];
						    }
						}
					    }
					}
					
					if (B.type.equals("Mage")) {
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
						Scanner theitem = new Scanner(System.in);
						String choice = theitem.nextLine().toLowerCase();
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
						if (B.coins < price[Find(choice)]) {
						    System.out.println("You do not have enough coins to purchase this item.");
						}
						else {
						    if (Find(choice) < 6) {
							B.weaponName = choice;
							B.weaponStats = power[Find(choice)];
							B.coins - price[Find(choice)];
						    }
						    else {
							B.armorName = choice;
							B.armorStats = power[Find(choice)];
							B.coins - price[Find(choice)];
						    }
						}
					    }
					}
					if (B.type.equals("Rogue")) {
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
						Scanner theitem = new Scanner(System.in);
						String choice = theitem.nextLine().toLowerCase();
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
						if (B.coins < price[Find(choice)]) {
						    System.out.println("You do not have enough coins to purchase this item.");
						}
						else {
						    if (Find(choice) < 6) {
							B.weaponName = choice;
							B.weaponStats = power[Find(choice)];
							B.coins - price[Find(choice)];
						    }
						    else {
							B.armorName = choice;
							B.armorStats = power[Find(choice)];
							B.coins - price[Find(choice)];
						    }
						}
					    }
					}
				    }
				    if (shopchoice.equals("general")) {
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
					    Scanner theitem = new Scanner(System.in);
					    String choice = theitem.nextLine().toLowerCase();
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
					    if (B.coins < price[Find(choice)]) {
						System.out.println("You do not have enough coins to purchase this item.");
					    }
					    else {
						    B.coins - price[Find(choice)];
						    B.inventory.add(choice);
						}
					    }
					}
				    }
				    if (shopchoice.equals("quit")) {
					break;
				    }
				    else {
					System.out.println("Invalid choice. Please type general, class, or quit.");
				    }
				}
			    }
			    if (buy.equals("no")) {
				break;
			    }
			    else {
				System.out.println("Invalid input. Please type yes or no.");
			    }
			}
			if (SL.LS(2)){
			    SL.Write(B.GetStats(), LevelNumber, MonsterNum);
			    SL.InventoryWrite(B.inventory);
			    System.out.println("You saved the game.");
			}
		    }//upper fighting if
		    else {
			LevelNumber -= 1;
			MonsterNum=LevelNumber*2;
		    }
		}//MonsterNum>0

		Battle Fight = new Battle();
		Boss A = new Boss();
		A.BossGen(LevelNumber);

		if(Fight.battle(B, A)){
		    B.LevelingUp();
		    B.coins+=A.coins;
		    System.out.println("You defeated the boss");

		    B.Shop();
		    B.Store();

		    GameOutline M = new GameOutline();
		    LevelNumber = M.Moving(LevelNumber);
		    MonsterNum=LevelNumber*2;
		}else{//fight lost
		    LevelNumber-=1;}

		MonsterNum=LevelNumber*2;
		System.out.println("You are now on level "+LevelNumber);
	    
	    
	    }//while(LevelNumber<10
	    System.out.println("You are now on the last level of the game.....");
	    System.out.println("You have done a good job getting this far.....");
	    System.out.println("But everything ends NOW!");

	    Overlord A=new Overlord();
	    A.Gen(LevelNumber);
	    Battle fight = new Battle();
	    if (fight.battle(B,A)){
		B.LevelingUp();
		B.coins+=A.coins;
		System.out.println("You have defeated the OverLord");
		System.out.println("Your game has been saved and once you load, you will be back on level 9");
		System.out.println("Thanks for playing");
		SL.Write(B.GetStats(), LevelNumber-1, LevelNumber*5-5);
		System.exit(0);}
	    else {
		LevelNumber -= 1;
		MonsterNum=LevelNumber*5;
	    }
    	}//while(true)
	    
    }

    public int Find(String Name) {
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


    public int Moving(int Level){
	System.out.println("You defeated the dungeon!");
	System.out.println("Would you like to advance a level, retreat a level, or stay on the same level?");

	String Choice = "";
	while (true){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.next();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"QUIT", "ADVANCE", "RETREAT", "STAY"};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("This is not advance, retreat, nor stay");}
	    else {break;}
	}
	if (Choice.equals("QUIT")){
	    System.exit(0);
	}
	if (Choice.equals("ADVANCE")){
	    return Level+=1;
	}
	else if (Choice.equals("RETREAT")){
	    return Level-=1;
	}
	else{
	    return Level;}}

    public int MonPicker(int LevelNumber){
	Random R = new Random();
	int Picker = R.nextInt(LevelNumber)+LevelNumber;
	if (Picker<3){return 1;}
	else if (Picker<6){return 2;}
	else if (Picker<10){return 3;}
	else if (Picker<14){return 4;}
	else{return 5;}
    }
}
