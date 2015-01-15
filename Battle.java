import java.io.*;
import java.util.*;

public class Battle{

    //Conducts one battle, implements weapon effects from basechar
    public boolean battle(Basechar A, Basechar B){
	int HRestore = A.health;
	while (NotDead(A) || NotDead(B)){
	    System.out.println();
	    A.Status();
	    B.Status();
	    Scanner sc = new Scanner(System.in);
	    String Atk = sc.nextLine();
	    Atk=Atk.toUpperCase();
	    if (!Atk.equals("QUIT")&&!Atk.equals("ATTACK")&&!Atk.equals("STRONG ATTACK")&&!Atk.equals("")){
		System.out.println("You typed something wrong, your move has been invalided");}
	    else {
	    if (Atk.equals("QUIT")){
		System.exit(0);}
	    else if (Atk.equals("STRONG ATTACK")){
		System.out.println(A.StrongAttack(B));}
	    else{
		 System.out.println(A.Attack(B));}}

	    if (A.weaponName.equals("bs")||A.weaponName.equals("ws")){
		A.AttackHeal(5, A.health);
	    }
	    else if (A.weaponName.equals("ss")){
		B.LowerAccuracy(10, 5);
	    }
	    else if (A.weaponName.equals("gs")){
		B.LowerAttack(15, 10);
	    }
	    else if (A.weaponName.equals("ps")){
		B.LowerDefense(20, 25);
	    }
	    else if (A.weaponName.equals("ds")){
		B.InstaKill(10);
	    }
	    else if (A.weaponName.equals("fs")){
		B.Burn(5,5);
	    }
	    else if (A.weaponName.equals("es")){
		B.LowerDefense(10,10);
	    }
	    else if (A.weaponName.equals("gs")){
		B.LowerAccuracy(10,15);
	    }
	    else if (A.weaponName.equals("d")){
		B.Poison(2);
	    }
	    else if (A.weaponName.equals("dk")){
		//attack twice
	    }
	    else if (A.weaponName.equals("m")){
		B.LowerAttack(5, 5);
	    }
	    else if (A.weaponName.equals("lk")){
		B.LowerEvade(5,5);
	    }
	    else if (A.weaponName.equals("dlk")){
		//attack twice
		B.LowerDefense(10,5);
	    }
	    else if (A.weaponName.equals("tlk")){
		//attack thrice
		B.InstaKill(1);
	    }
	    else if (A.weaponName.equals("dk")){
		//attack twice
	    }
	    
	    if (!NotDead(B)){
		A.health = HRestore;
		return true;
	    }
	    System.out.println(B.Attack(A));
	    if (!NotDead(A)){
		System.out.println("You lose!");
		A.health=HRestore;
		return false;
	    }
	}
	return false;
    }

    //Allows player to heal if necessary
    public boolean NotDead(Basechar A){
	if (A.health>0){
	    return true;
	}
	else{ 
	    return false;
	}
    }
    
    //Main Function
    public static void main(String args[]){
	Battle b = new Battle();
	Warrior w1 = new Warrior("Knight");
	Warrior w2 = new Warrior("King");
	System.out.println(b.battle(w1, w2));
    }


}
