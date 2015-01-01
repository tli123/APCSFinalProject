import java.util.Scanner;

public class GameOutline{

    public static void main(String args[]){// GAME(){
	int LevelNumber = 1;
	int MonsterNum;
	// Introduction + Credits
	
	//New or load game
	Warrior B = new Warrior("Knight");
	
	while(true){ // Overlord not dead
	    MonsterNum=LevelNumber;
	    while (MonsterNum>0){ //Dungeon not cleared
		//make monster
		CannonFodder A = new CannonFodder();
		A.Gen(LevelNumber);
		
		Battle fight = new Battle();
		if(fight.battle(B, A)){
		    MonsterNum-=1;
		    B.LevelingUp();}
		System.out.println(MonsterNum+" monsters left");
		
	    }
	    LevelNumber+=1;
	    System.out.println("You are now on level "+LevelNumber);
	    if (LevelNumber>9){
		System.out.println("You win the game");
		break;}
	}
	    

    }

/*
    public static void main(String args[]){
	GameOutline Game = new GameOutline();
	Game.GAME();
    }
*/



}