import java.util.*;
import java.io.*;

public class GameOutline{

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

/*
    public static void main(String args[]){
	GameOutline Game = new GameOutline();
	Game.GAME();
    }
*/



}
