import java.util.*;

public class GetName{

    //Allows player to name character 
    public String Name(){
	boolean Unconfirm = true;
	String Choice;
	while (true){
	    System.out.println("What would you like to name your character?");
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.nextLine();
	    System.out.println("Are you sure you want to name it " + Choice+ "?");
	    Scanner SC = new Scanner(System.in);
	    String Confirmation = sc.nextLine();
	    if (Confirmation.toUpperCase().equals("YES")){
		break; 
	    }
	}
	return Choice;
    }
    //Allows player to pick class
    public int ClassPicker(){
	System.out.println("Please enter the class you want to be: Warrior, Mage, or Rogue");
	String Choice = "";
	while (true){
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.nextLine();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"ROGUE", "MAGE", "WARRIOR", "", "QUIT"};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("This is not listed");}
	    else {break;}
	}
	if (Choice.equals("QUIT")){
	    System.exit(0);
	}
	if (Choice.equals("ROGUE")){
	    return 3;
	}
	else if (Choice.equals("MAGE")){
	    return 2;
	}
	else{
	    return 1;
	}
    }



}
