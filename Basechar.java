import java.util.*;
import java.io.*;

public class Basechar {
    
    public int health;
    public int attack;
    public int defense;
    public int accuracy;
    public int evade;
    public String name;
    public int weaponName;
    public int weaponStats;

    public Basechar(int h, int a, int d, int acc, int e, int WS, String n) {
	this.health = h;
	this.attack = a;
	this.defense = d;
	this.accuracy = acc;
	this.evade = e;
	this.weaponStats=WS;
	this.name = n;
    }

    public String Attack(Basechar other){
	if (didHit(accuracy)){
	    other.health=other.health-this.attack;
	    return (name+" attacked "+other.name+" and dealt "+attack+" damage, "+other.name+" now has "+other.health+" left");}
	else{
	    return(name+" attacked and missed");}
    }

    public boolean didHit(int chance){
	Random r = new Random();
	if (r.nextInt(100)>chance){
	    return false;}
	else {return true;}
    }

    public void Stats(){
	System.out.println("Name: "+name);
	System.out.println("Health: "+health);
	System.out.println("Attack: "+attack);
	System.out.println("Defense: "+defense);
	System.out.println("Accuracy: "+accuracy);
	System.out.println("Evade: "+evade);
	System.out.println("Weapon Damage: "+weaponStats);
    }

    public void LevelingUp(){
	System.out.println("You won the battle!");
	System.out.println();
	System.out.println("Your curent stats are:");
	Stats();
	System.out.println();
	System.out.println("Pick a skill would you like to increase:");
	System.out.println("Health, Attack, Accuracy, or Evade");

	String Choice = "";
	boolean Correct=true;
	while (Correct){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.next();
	    Choice=Choice.toUpperCase();
	    String[] Check = {"HEALTH", "ATTACK", "ACCURACY", "EVADE", "QUIT"};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("This is not listed above. Enter something correct ");}
	    else{ Correct=false;}}
	if (Choice.equals("QUIT")){
	    System.exit(0);}
	if (Choice.equals("HEALTH")){
	    health+=5;}
	else if (Choice.equals("ATTACK")){
	    attack+=1;}
	else if (Choice.equals("ACCURACY")){
	    accuracy+=2;}
	else{
	    evade+=2;}
	System.out.println();
	System.out.println("Now your stats are the following:");
	Stats();
    }

    public boolean Chance(int Num){
	Random R=new Random();
	if (R.nextInt(Num)==0){
	    return true;}
	return false;
    }

    public void WantWeapon(int WeaponStats){
	System.out.println();
	System.out.println("You found an item!");
	System.out.println("Your curent weapon does +"+weaponStats+" damage");
	System.out.println("The weapon you found does +"+WeaponStats+" damage");
	System.out.println("Would you like to replace your weapon? Yes or No?");

	String Choice = "";
	boolean Correct=true;
	while (Correct){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.next();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"YES", "NO", "QUIT"};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("Type yes or no only");}
	    else{ Correct=false;}}
	if (Choice.equals("QUIT")){
	    System.exit(0);}
	if (Choice.equals("YES")){
	    weaponStats=WeaponStats;
	    System.out.println();
	    System.out.println("Your new stats are:");
	    Stats();}
	else {
	    System.out.println();
	    System.out.println("Your stats have not changed.");}
    }

    public void Gen(int Level){
	health+=(health/2)*Level;
	attack+=(attack/2)*Level;
	defense+=Level;
	accuracy+=Level;
	evade+=Level;
	weaponStats=weaponStats*Level;

	Random R=new Random();
	health+=R.nextInt(Level*3);
	attack+=R.nextInt(Level*3);
	defense+=R.nextInt(Level*3);
	accuracy+=R.nextInt(Level*3);
	evade+=R.nextInt(Level*3);
	weaponStats=R.nextInt(Level*3);
    }

    public void Status(){
	System.out.println(name);
	System.out.println("Health: "+health);
}

    public void ImpleStats(String[] Stats){
	health=Integer.valueOf(Stats[0]);
	attack=Integer.valueOf(Stats[1]);
	defense=Integer.valueOf(Stats[2]);
	accuracy=Integer.valueOf(Stats[3]);
	evade=Integer.valueOf(Stats[4]);
	weaponStats=Integer.valueOf(Stats[5]);
	name=Stats[6];
    }

    public String[] GetStats(){
	String[] Stat = new String[7];
	Stat[0]=String.valueOf(health);
	Stat[1]=String.valueOf(attack);
	Stat[2]=String.valueOf(defense);
	Stat[3]=String.valueOf(accuracy);
	Stat[4]=String.valueOf(evade);
	Stat[5]=String.valueOf(weaponStats);
	Stat[6]=name;
	return Stat;
    }


    public void start (Basechar other) {

    }
}
