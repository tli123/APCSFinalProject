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



}
