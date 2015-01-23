import java.util.*;
import java.io.*;

public class GameOutline{

    public static void main(String args[]) throws Exception{// GAME(){
	boolean battleWon=false;
	int LevelNumber = 1;
	int MonsterNum;
	
	//Intro

	System.out.println("\n\n\n   ______");
	System.out.println("  |       \\");
	System.out.println("  |       |             ____    ____     _____    _____     ____    _____");
	System.out.println("  |       |  |     |  |/    \\  /    \\|  /     \\  /     \\  |/    \\  /");
	System.out.println("  |       |  |     |  |     |  |     |  |_____/  |     |  |     |  |____");
	System.out.println("  |       |  |     |  |     |  |     |  |        |     |  |     |       |");
	System.out.println("  |______/   \\____/|  |     |  \\_____|  \\_____   \\_____/  |     |  _____/");
	System.out.println("                                     |");
	System.out.println("                                     |");
	System.out.println("                               ______|");
	System.out.println("");
	System.out.println("                       |                 |");
	System.out.println("                       |                 |");
	System.out.println("_____     ____    _____|      _____      | _____    _____     ____    _____");
	System.out.println("     \\  |/    \\  /     \\           \\     |/     \\  /     \\  |/    \\  /     \\");
	System.out.println(" ____|  |     |  |     |       ____|     |      |  |_____/  |        |     |");
	System.out.println("/    |  |     |  |     |      /    |     |      |  |        |        |     |");
	System.out.println("\\____|  |     |  \\____/|      \\____|     |      |  \\_____/  |        \\_____/");
	System.out.println("\nBy Rong Yu and Tommy Li, Period 1");

	HoldUp(2500);

	String First="\nIt was simply a day in Mr. Zamansky's first period APCS class. The class was working on the 'cruel and unusual punishment', better known as homework.\n\nSuddenly, the room grew dark. Everyone scrambled around in the darkness.\n\nAt the sound of the warning bell, all was well again. The students turned off their computers, and prepared to exit the class. Staring in front of the room, however, they realized something was amiss.\n\nMr. Mike Zamansky was nowhere to be seen. You, the hero, rushed up to his desk, to find that his computer has been wiped cleaned. Except  a txt file named 'Period 1'.\n\nYou, the hero, open the file to discover the following contents:\n\nGreetings. As you may have already seen, your computer science teacher as been captured by yours truly, and stored in an encrypted file in this computer. I have heard how incompetent he is at teaching students. To free him, beat my computer generated dungeons and monsters, and maybe I'll release him. Then I can see if he has taught you anything. For now, however, I rule as the supreme leader of the computing world.\n~Mr. JonAlf Dryland-Weaver\n";
	String Second ="P.S. A once great man said pressing enter can make life a lot easier. To add onto that, entering quit while in battle, or entering back in store is also very helpful.";

	for(int i=0; i<First.length(); i++){
	    System.out.print(First.substring(i,i+1));
	    HoldUp(50);}
	System.out.println();
	for(int i=0; i<Second.length();i++){
	    System.out.print(Second.substring(i,i+1));
	    HoldUp(50);
	}
	System.out.println("\n\n");
	
	//Loads + Saves files
	SaveLoad SL = new SaveLoad();
	Character B = new Character(1, "Rong");

	if (SL.LS(1)){
	    B.ImpleStats(SL.Load());
	    String[] LevAndMon= SL.Load2();
	    LevelNumber=Integer.valueOf(LevAndMon[0]);
	    MonsterNum=Integer.valueOf(LevAndMon[1]);
	    B.inventory=SL.InventoryLoad();}

	else{
	    GetName N=new GetName();
	    B = new Character(N.ClassPicker(), N.Name());
	    B.inventory=SL.InitialInventoryLoad();
	    MonsterNum=LevelNumber*2+1;}

	System.out.println();

	//Add a background info, i.e. why storm the dungeon

	//Initiates Battle, get coins, etc
	while(true){ // Overlord not dead

	while(LevelNumber<10){

	    while (MonsterNum>1){ //Dungeon not cleared
		System.out.println("There are "+MonsterNum+" monsters left");
		Battle fight = new Battle();
		int MCoins;

		GameOutline GO = new GameOutline();
		int pick = GO.MonPicker(LevelNumber);

		if (pick==1){
		    Character A= new Character("CannonFodder");
		    A.Gen(LevelNumber);
		    MCoins=A.coins;
		    battleWon=fight.battle(B, A);}
		else if (pick==2){
		    Character C = new Character("Imp");
		    C.Gen(LevelNumber);
		    MCoins=C.coins;
		    battleWon=fight.battle(B, C);}
		else if (pick==3){
		    Character D = new Character("Ogre");
		    D.Gen(LevelNumber);
		    MCoins=D.coins;
		    battleWon=fight.battle(B, D);}
		else if (pick==4){
		    Character E = new Character("Troll");
		    E.Gen(LevelNumber);
		    MCoins=E.coins;
		    battleWon=fight.battle(B, E);}
		else{
		    Character F = new Character("MiniOverlord");
		    F.Gen(LevelNumber);
		    MCoins=F.coins;
		    battleWon=fight.battle(B, F);}

		if(battleWon){
		    MonsterNum-=1;
		    System.out.println("You have found "+MCoins+" coins.");
		    B.coins+=MCoins;
		    B.LevelingUp();
		    if (SL.LS(2)){
			SL.Write(B.GetStats(), LevelNumber, MonsterNum);
			SL.InventoryWrite(B.inventory);
			System.out.println("You saved the game.");
		    }
		}//upper fighting if
		else {
		    LevelNumber -= 1;
		    MonsterNum=LevelNumber*2+1;
		}
	    }//MonsterNum>0

	    Battle Fight = new Battle();
	    Character  A = new Character("Boss");
	    A.BossGen(LevelNumber);

	    if(Fight.battle(B, A)){
		B.LevelingUp();
		B.coins+=A.coins;
	    System.out.println("You defeated the boss");

	    B.Shop();
	    B.Store();

	    GameOutline M = new GameOutline();
	    LevelNumber = M.Moving(LevelNumber);
	    MonsterNum=LevelNumber*2+1;
	    }else{//fight lost
		LevelNumber-=1;}

	    MonsterNum=LevelNumber*2+1;
	    System.out.println("You are now on level "+LevelNumber);
	    
	    
	}//while(LevelNumber<10
	System.out.println("You are now on the last level of the game.....");
	System.out.println("You have done a good job getting this far.....");
	System.out.println("But everything ends NOW! You will have no choice but to defeat me, the ultimate Mr. DW, in battle!");

	Character A = new Character("Overlord");
	A.Gen(LevelNumber);
	Battle fight = new Battle();
	if (fight.battle(B,A)){
	    B.LevelingUp();
	    B.coins+=A.coins;
	    System.out.println("You have defeated the OverLord, Mr. DW!\nYou have rescued Mr. Zamansky from his prison, and you can continue your computer science class once more in peace.\n");
	    System.out.println("Your game has been saved and once you load, you will be back on level 9");
	    System.out.println("Thanks for playing!");
	    SL.Write(B.GetStats(), LevelNumber-1, LevelNumber*2-1);
	    System.exit(0);}
	else {
	    LevelNumber -= 1;
	    MonsterNum=LevelNumber*2+1;
	}
    	}//while(true)
	    
    }

    public int Moving(int Level){
	System.out.println("You defeated the dungeon!");
	System.out.println("Would you like to advance a level, retreat a level, or stay on the same level?");

	String Choice = "";
	while (true){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.nextLine();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"QUIT", "ADVANCE", "RETREAT", "STAY", ""};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("This is not advance, retreat, nor stay.");}
	    else {break;}
	}
	if (Choice.equals("QUIT")){
	    System.exit(0);
	}
	else if (Choice.equals("RETREAT")){
	    if (Level==1){
		System.out.println("You can't go below level one, loser.");
		return 1;
	    }
	    return Level-=1;
	}
	else if (Choice.equals("STAY")){
	    return Level;}
	else {
	    return Level+=1;}
	return 1;
    }

    public int MonPicker(int LevelNumber){
	Random R = new Random();
	int Picker = R.nextInt(LevelNumber)+LevelNumber;
	if (Picker<3){
	    return 1;
	}
	else if (Picker<6){
	    return 2;
	}
	else if (Picker<10){
	    return 3;
	}
	else if (Picker<14){
	    return 4;
	}
	else{
	    return 5;
	}
    }

    public static void HoldUp(int n) {
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
}
