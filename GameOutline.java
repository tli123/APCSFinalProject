import java.util.Scanner;

public class GameOutline{

    public static void main(String args[]) throws Exception{// GAME(){
	int LevelNumber = 1;
	int MonsterNum;
	// Introduction + Credits

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

	while(true){ // Overlord not dead

	    MonsterNum=LevelNumber;
	    while (MonsterNum>0){ //Dungeon not cleared
		//make monster
		CannonFodder A = new CannonFodder();
		A.Gen(LevelNumber);
		
		Battle fight = new Battle();
		if(fight.battle(B, A)){
		    MonsterNum-=1;
		    B.LevelingUp();	
		    if (B.Chance(LevelNumber)){
			B.WantWeapon(A.weaponStats);}
		    else{ System.out.println("You did not find a weapon");} 
		}
		System.out.println(MonsterNum+" monsters left");
		if (SL.LS(2)){
	    	    SL.Write(B.GetStats());}
		
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