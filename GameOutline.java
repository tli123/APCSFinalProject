import java.util.Scanner;

public class GameOutline{
    
    int LevelNumber = 1;
    int MonsterNum;

    public void GAME(){
	// Introduction + Credits
	
	//New or load game
	while(true){ // Overlord not dead
	    MonsterNum=LevelNumber;
	    while (MonsterNum>0){ //Dungeon not cleared
		//make monster
		CannonFodder A = new CannonFodder();
		//process it

		Warrior B = new Warrior("Knight");
		
		Battle fight = new Battle();
		if(fight.battle(B, A)){
		    MonsterNum-=1;}
		System.out.println(MonsterNum+" monsters left");
		
	    }
	    LevelNumber+=1;
	    System.out.println("You are not on level "+LevelNumber);
	    if (LevelNumber>9){
		System.out.println("You win the game");
		break;}
	}
	    

    }

    public static void main(String args[]){
	GameOutline Game = new GameOutline();
	Game.GAME();
}



}