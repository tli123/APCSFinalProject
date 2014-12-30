import java.util.Random;

public class MonsterGen{

    public void Gen(int Level){

	//PROCESS THE MONSTER BY ADDING STATS

	CannonFodder Monster= new CannonFodder();
	int[] MonStats=Monster.GetStats();
	MonStats[0]+=(MonStats[0]/2)*Level;
	MonStats[1]+=(MonStats[1]/2)*Level;
	MonStats[2]+=Level;
	MonStats[3]+=Level;
	MonStats[4]+=Level;
	Monster.ImpleStats(MonStats);
	Monster.Stats();
    }

/*NOTE: The code above will be added to the main Stuyablo following 
	the outline, and this class will be scrapped */


    public static void main(String args[]){
	MonsterGen Make = new MonsterGen();
	Make.Gen(10);
    }

}