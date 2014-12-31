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

    public void start (Basechar other) {

    }
}
