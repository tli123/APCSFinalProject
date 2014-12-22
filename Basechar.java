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

    public void start (Basechar other) {

    }
}
