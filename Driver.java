import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
	System.out.println("Welcome to Stuyablo!");
	while (true){
	    System.out.println("Do you want to load your save file? Y or N?");
	    Scanner user_input = new Scanner(System.in);
	    String answer = user_input.next();
	    if (answer.equals("N")) {
		break;
		while (true) {
		    System.out.println("Do you want to be a Warrior, Mage, Rogue?");
		    Scanner user_input = new Scanner(System.in);
		    String response = user_input.next();
		    if (response.equals("Warrior")) {
			Warrior w = new Warrior([enter stats here]);
			break;
		    }
		    if (response.equals("Mage")) {
			Mage m = new Mage([Enter stats here]);
			break;
		    }
		    if (response.equals("Rogue")) {
			Rogue r = new Rogue([Enter stats here]);
			break;
		    }
		    System.out.println("Invalid input!");
		}
	    }
	    if (answer.equals("Y")) {
		//add save load here
	    }
	}
