import java.io.*;
import java.util.*;

public class Battle{

    public boolean battle(Basechar A, Basechar B){
	int HRestore = A.health;
	while (NotDead(A) || NotDead(B)){
	    System.out.println();
	    A.Status();
	    B.Status();
	    Scanner sc = new Scanner(System.in);
	    String Atk = sc.nextLine();
	    if (Atk.equals("quit")){
		System.exit(0);}
	    System.out.println(A.Attack(B));

	    if (A.weaponName.equals("bs")||A.weaponName.equals("ws")){
		A.AttackHeal(5, A.health);}
	    else if (A.weaponName.equals("ss")){
		B.LowerAccuracy(10, 5);}
	    else if (A.weaponName.equals("gs")){
		B.LowerAttack(15, 10);}
	    else if (A.weaponName.equals("ps")){
		B.LowerDefense(20, 25);}
	    else if (A.weaponName.equals("ds")){
		B.InstaKill(10);}
	    else if (A.weaponName.equals("fs")){
		B.Burn(5);}
	    else if (A.weaponName.equals("es")){
		B.LowerDefense(10,10);}
	    else if (A.weaponName.equals("gs")){
		B.LowerAccuracy(10,15);}
	    else if (A.weaponName.equals("d")){}
	    
	    
	    if (!NotDead(B)){
		A.health=HRestore;
		return true;}
	    System.out.println(B.Attack(A));
	    if (!NotDead(A)){
		System.out.println("You lose!");
		A.health=HRestore;
		return false;}
	}
	return false;
    }

    public boolean NotDead(Basechar A){
	if (A.health>0){
	    return true;}

	else{ return false;}
    }
    /*
    public void Effects(String type, String WeaponName){
	Random Rand = new Random();
	if (type.equals("warrior"){
		if (WeaponName.equals("Bronze Sword"){
		    }
		    }
	    else if (type.equals("rouge"){
		}
		else {
		    }

    */
    
	    }

    public static void main(String args[]){
	Battle b=new Battle();
	Warrior w1=new Warrior("Knight");
	Warrior w2=new Warrior("King");
	System.out.println(b.battle(w1, w2));
    }


}
