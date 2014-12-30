public class CannonFodder extends Basechar{

    public CannonFodder(){
	super(10, 2, 0, 75, 5, "Cannon Fodder");
    }

    public int[] GetStats(){
	int[] Stat = new int[5];
	Stat[0]=health;
	Stat[1]=attack;
	Stat[2]=defense;
	Stat[3]=accuracy;
	Stat[4]=evade;
	return Stat;
    }

    public void ImpleStats(int[] Stats){
	health=Stats[0];
	attack=Stats[1];
	defense=Stats[2];
	accuracy=Stats[3];
	evade=Stats[4];
    }


    public void Stats(){
	System.out.println("Health: "+health);
	System.out.println("Attack: "+attack);
	System.out.println("Defense: "+defense);
	System.out.println("Accuracy: "+accuracy);
	System.out.println("Evade: "+evade);
	System.out.println("Name: "+name);
    }

    public static void main(String args[]){
	CannonFodder CF = new CannonFodder();
	CF.Stats();

    }


}