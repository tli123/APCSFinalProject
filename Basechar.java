import java.util.*;
import java.io.*;

public class Basechar {
    
    public int health;
    public int attack;
    public int defense;
    public int accuracy;
    public int evade;
    public String name;

    public Basechar(int h, int a, int d, int acc, int e, String n) {
	this.health = h;
	this.attack = a;
	this.defense = d;
	this.accuracy = acc;
	this.evade = e;
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
    }

    public void LevelingUp(){
	System.out.println("You won the battle!");
	System.out.println("Your curent stats are:");
	Stats();
	System.out.println("Pick a skill would you like to increase:");
	System.out.println("Health, Attack, Accuracy, or Evade");

	String Choice = "";
	boolean Correct=true;
	while (Correct){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.next();
	    String[] Check = {"Health", "Attack", "Accuracy", "Evade"};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("This is not listed above. Enter something correct ");}
	    else{ Correct=false;}}
	if (Choice.equals("Health")){
	    health+=5;}
	else if (Choice.equals("Attack")){
	    attack+=1;}
	else if (Choice.equals("Accuracy")){
	    accuracy+=2;}
	else{
	    evade+=2;}
	System.out.println("Now your stats are the following:");
	Stats();
    }

    public void Gen(int Level){
	health+=(health/2)*Level;
	attack+=(attack/2)*Level;
	defense+=Level;
	accuracy+=Level;
	evade+=Level;
    }

    public void Status(){
	System.out.println(name);
	System.out.println("Health: "+health);
}

    public void start (Basechar other) {

    }
}
