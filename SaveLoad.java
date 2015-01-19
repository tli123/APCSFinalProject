import java.io.*;
import java.util.*;

public class SaveLoad{

//1.Health 2.Attack 3.Defense 4.Accuracy 5.Evade 6. WeaponsStats 7.Name 8. Type 9.Coins

    /* This works by reading a file and returning an arrayList of each line, 
        from there, all stats will be assigned a number or string from it in 
        the character generator */

    public String[] Load(){
	File file = new File("save.txt");
	String[] Arr = new String [12]; //This is the number of stats
	try{
	    Scanner scanner = new Scanner(file);
	    scanner.nextLine();
	    scanner.nextLine();
	    for (int i=0; i<12; i++){ //first two are level and monster left
		//while (scanner.hasNextLine()){
		Arr[i]=scanner.nextLine();
	    }
	    scanner.close();
	} catch (Exception e) {
	    System.out.println("File not found");
	}
	return Arr;
    }

    public String[] Load2(){
	File file = new File("save.txt");
	String[] Arr = new String [2];
	try{
	    Scanner scanner = new Scanner(file);
	    for (int i=0; i<2; i++){ //Level, then Monsters left
		Arr[i]=scanner.nextLine();
	    }
	    scanner.close();
	} catch (Exception e) {
	    System.out.println("File not found");
	}
	return Arr;
    }

//1.Health 2.Attack 3.Defense 4.Accuracy 5.Evade 6. weaponsStats
//Copied from 2 StackOverflow questions and deleted a few lines

    public void Write(String[] Arr, int Level, int MonLeft) throws Exception{
	/*deletes everything inside*/
	PrintWriter writer = new PrintWriter("save.txt");
	writer.print("");
	writer.close();

	BufferedReader bfr;
	String line;    
	bfr=new BufferedReader(new InputStreamReader(System.in));
	File file=new File("save.txt");  
	
	try{
	    bfr=new BufferedReader(new FileReader(file));
	    FileWriter fw=new FileWriter(file,true);    

	    fw.append(String.valueOf(Level));
	    fw.append("\n");
	    fw.append(String.valueOf(MonLeft));
	    fw.append("\n");

	    for (int i = 0; i<Arr.length; i++){
		fw.append(String.valueOf(Arr[i]));
		fw.append("\n");
	    }
	    bfr.close();
	    fw.close();
	} catch(Exception e){
	    System.out.println("file not found");
	}
    }

    public ArrayList<String> InventoryLoad(){
	File file = new File("inventory.txt");
	ArrayList<String> Stuff = new ArrayList<String>();
	try{
	    Scanner scanner = new Scanner(file);
	    while (scanner.hasNextLine()){
		Stuff.add(scanner.nextLine());
	    }
	    scanner.close();
	} catch (Exception e) {
	    System.out.println("File not found");}
	return Stuff;
    }
    
    public void InventoryWrite(ArrayList<String> Stuff) throws Exception{
	/*deletes everything inside*/
	PrintWriter writer = new PrintWriter("inventory.txt");
	writer.print("");
	writer.close();

	BufferedReader bfr;
	String line;    
	bfr=new BufferedReader(new InputStreamReader(System.in));
	File file=new File("inventory.txt");  
	
	try{
	    bfr=new BufferedReader(new FileReader(file));
	    FileWriter fw=new FileWriter(file,true);    
	    for (int i = 0; i<Stuff.size(); i++){
		fw.append(String.valueOf(Stuff.get(i)));
		fw.append("\n");
	    }
	    bfr.close();
	    fw.close();
	} catch(Exception e){
	    System.out.println("file not found");
	}
    }


    public boolean LS(int num){
	boolean Unconfirm=true;
	String Choice;
	//while(true){

	while (true){
	    if (num==1){System.out.println("Would you like to load the save file?");}
	    else {System.out.println("Would you like to save your stats?");}
	    Scanner sc = new Scanner(System.in);
	    Choice = sc.nextLine();
	    Choice = Choice.toUpperCase();
	    String[] Check = {"YES", "NO", "QUIT", ""};
	    if (!Arrays.asList(Check).contains(Choice)) {
		System.out.println("Type yes or no only");}
	    else if (Choice.equals("QUIT")){
		System.exit(0);}
	    else if (Choice.equals("NO")){
		return false;}
	    else{return true;}	
	}
	
	/*
	while(true){
	    System.out.println("Are you sure?");
	    Scanner SC = new Scanner(System.in);
	    String Confirmation = SC.nextLine();
	    if (Confirmation.toUpperCase().equals("YES")){
		if (Choice.equals("YES")){return true;}
		if (Choice.equals("QUIT")){System.exit(0);}
		else{ return false;}
	    }

	    else{break;}
	}
	*/
	//}
    }
/*
    public static void main(String args[]) throws Exception{
	SaveLoad Demo=new SaveLoad();
	//Basechar BChar = new Basechar(10, 10, 10,10,10,10,"Rong", "Warrior");
	//Demo.Write(BChar.GetStats());
	BChar.ImpleStats(Demo.Load());
	
		
    }
*/
}
