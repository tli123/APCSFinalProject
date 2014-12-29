import java.io.*;
import java.util.*;

public class SaveLoad{


    /* This works by reading a file and returning an arrayList of each line, 
        from there, all stats will be assigned a number or string from it in 
        the character generator */
    public String[] Load(){
	File file = new File("save.txt");
	String[] Arr = new String [5]; //This is the number of stats
	int i=0;
	try{
	    Scanner scanner = new Scanner(file);
	    while (scanner.hasNextLine()){
		Arr[i]=scanner.nextLine();
		System.out.println(Arr[i]);
		i++;
	    }
	    scanner.close();
	} catch (Exception e) {
	    System.out.println("File not found");}
	
	/* Used to check if it acutally works, but otherwise
	    useless as a String[] is better than a String. */
	/*
	String s="";
	for (int z=0; z<Arr.length;z++){
	    s+=Arr[z];
	}
	*/

	return Arr;
    }


    public void Write(String[] Arr) throws Exception{
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


    public static void main(String args[]) throws Exception{
	SaveLoad Demo=new SaveLoad();
	String[] things = {"12", "22","52","52","52"};
	Demo.Write(things);
	System.out.println(Demo.Load());
		
    }

}