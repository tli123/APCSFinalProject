import java.util.*;
import java.io.*;

public class Basechar {
    
    public int health;
    public int attack;
    public int defense;
    public int accuracy;
    public int evade;
    public String name;
    public String weaponName;
    public int weaponStats;
    public String type;
    public int coins;
    public String armorName;
    public int armorPoints;
    public ArrayList<String> inventory;

    public Basechar(int h, int a, int d, int acc, int e, int WS, String n, String t, int c, String aN, int aP) {
	this.health = h;
	this.attack = a;
	this.defense = d;
	this.accuracy = acc;
	this.evade = e;
	this.weaponStats=WS;
	this.name = n;
       	this.type = t;
	this.coins = c;
	this.armor
	this.armorPoints = aP;
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
	System.out.println("Class: " + type);
	System.out.println("Coins: " + coins);
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

    public void BossGen(int Level){
        health+=health*Level;
	attack+=attack*Level;
	defense+=2*Level;
	accuracy+=2*Level;
	evade+=2*Level;
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
	type=Stats[7];
	coins=Integer.valueOf(Stats[8]);
    }

    public String[] GetStats(){
	String[] Stat = new String[11];
	Stat[0]=String.valueOf(health);
	Stat[1]=String.valueOf(attack);
	Stat[2]=String.valueOf(defense);
	Stat[3]=String.valueOf(accuracy);
	Stat[4]=String.valueOf(evade);
	Stat[5]=String.valueOf(weaponStats);
	Stat[6]=weaponName;
	Stat[7]=String.valueOf(armorPoints);
	Stat[8]=armorName;
	Stat[9]=name;
	Stat[10]=type;
	Stat[11]=String.valueOf(coins);
	return Stat;
    }

    public void Consolidate(){
	for (int i=1; i<inventory.size()-1;i++){
	    if (inventory.get(i)!=null && inventory.get(i-1)==null){
		inventory.set(i-1, inventory.get(i));
		inventory.set(i, null);
	    }
	}
    }

    public boolean IsInt(String str){
	try {Integer.valueOf(str); return true;}
	catch (Exception e){return false;}
	    }

    public void InventoryWork(){
	System.out.println("This is your inventory:");
	for (int i=0; i<inventory.size(); i++){
	    System.out.println(i+". "+inventory.get(i));}
	System.out.println("Type the number corresponding to the item you want to use");
	System.out.println("Type -1 to go back");
	
	int choice=0;
	String Choice = "";
	boolean Correct=true;
	while (Correct){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.next();
	    
	    if (!IsInt(Choice)) {
		System.out.println("This is not a corresponding number.");}
	    else{
		choice = Integer.valueOf(Choice);
		if (choice <-1 || choice >= inventory.size()){
		    System.out.println("This is not a corresponding number.");}
	   	else{ Correct=false;}}//else
	}
	
	Conversion Con= new Conversion();
	
	int LimitHealth=health;
	health=Con.Converter(inventory.get(choice), health);

	if (health>LimitHealth){
	    health=LimitHealth;}

	inventory.remove(choice);
	Consolidate();

    }//lower accuracy, healing, lower attack, lower defense
    //burn, drop defense freeze, lower accuracy
    //poison, attack twice, lower attack, atack twice and lower attack, attack 3 time and instantly knock out
    public void LowerAccuracy(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    accuracy-=accuracy*PercentLowerBy;}
    }
    public void AttackHeal(int Chance, int MaxHealth){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    health+=health/10;}
	if (health>MaxHealth){
	    health=MaxHealth;}
    }
    public void LowerAttack(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    attack-=attack*PercentLowerBy;}
    }
    public void LowerDefense(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    defense-=defense*PercentLowerBy;}
    }
    public void Burn(int Chance, int PercentLowerBy){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    health-=health/10;}
    }
    public void Poison(int Chance){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    health-=health/10;}
    }
    public void InstaKill(int Chance){
	Random Rand = new Random();
	if (Chance>Rand.nextInt(100)){
	    health=0;}
    }
	
}
