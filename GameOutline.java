import java.util.*;
import java.io.*;

public class GameOutline{

    public static void main(String args[]) throws Exception{// GAME(){
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
	    MonsterNum=Integer.valueOf(LevAndMon[1]);}

	else{
	    GetName N=new GetName();
	    String name=N.Name();
	    B = new Warrior(name);
	    MonsterNum=LevelNumber*5;}

	System.out.println();

	//Add a background info, i.e. why storm the dungeon

	//Initiates Battle, get coins, etc
	while(true){ // Overlord not dead

	while(LevelNumber<10){

	    while (MonsterNum>0){ //Dungeon not cleared
		CannonFodder A = new CannonFodder();
		A.Gen(LevelNumber);
		
		Battle fight = new Battle();
		if(fight.battle(B, A)){
		    MonsterNum-=1;
		    System.out.println("You have found "+A.coins+"coins.");
		    B.coins+=A.coins;
		    B.LevelingUp();
		    if (SL.LS(2)){
			SL.Write(B.GetStats(), LevelNumber, MonsterNum);
			System.out.println("You saved the game.");
		    }
		}//upper fighting if
		else {
		    LevelNumber -= 1;
		    MonsterNum=LevelNumber*5;
		}
	    }//MonsterNum>0

	    Battle Fight = new Battle();
	    Boss A = new Boss();
	    A.BossGen(LevelNumber);

	    if(Fight.battle(B, A)){
		B.LevelingUp();
		B.coins+=A.coins;
	    System.out.println("You defeated the boss");

	    GameOutline M = new GameOutline();
	    LevelNumber = M.Moving(LevelNumber);
	    MonsterNum=LevelNumber*5;
	    }else{//fight lost
		LevelNumber-=1;}

	    MonsterNum=LevelNumber*5;
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

/*
    public static void main(String args[]){
	GameOutline Game = new GameOutline();
	Game.GAME();
    }
*/



}
