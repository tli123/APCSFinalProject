import java.util.Scanner;

public class GameOutline{

    public static void main(String args[]) throws Exception{// GAME(){
	int LevelNumber = 1;
	int MonsterNum;
	// Introduction + Credits

	//Loads + Saves files
	SaveLoad SL = new SaveLoad();
	Warrior B = new Warrior("Rong");
	if (SL.LS(1)){
	    B.ImpleStats(SL.Load());}
	else{
	    GetName N=new GetName();
	    String name=N.Name();
	    B = new Warrior(name);}

	System.out.println();

	//Add a background info, i.e. why storm the dungeon

	//Initiates Battle, get coins, etc
	while(true){ // Overlord not dead

	    MonsterNum=LevelNumber*5;
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
			SL.Write(B.GetStats());
			System.out.println("You saved the game.");
		    }
		}
		else {
		    LevelNumber -= 1;
		    MonsterNum=LevelNumber*5;
		}
		
	    }
	    Battle Fight = new Battle();
	    Boss A = new Boss();
	    A.BossGen(LevelNumber);
	    if(Fight.battle(B, A)){
		B.LevelingUp();
		B.coins+=A.coins;
	    }
	    
	    System.out.println("You defeated the boss");

		
	    LevelNumber+=1;
	    System.out.println("You are now on level "+LevelNumber);
	    if (LevelNumber>9){
		System.out.println("You win the game");
		break;
	    }
	}
	    

    }

/*
    public static void main(String args[]){
	GameOutline Game = new GameOutline();
	Game.GAME();
    }
*/



}
