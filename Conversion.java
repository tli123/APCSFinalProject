public class Conversion{

    public int Converter(String str, int health){
	if (str.equals("Small Potion")){
	    return 50;}
	if (str.equals("Medium Potion")){
	    return 80;}
	if (str.equals("Big Potion")){
	    return 150;}
	if (str.equals("Red Potion")){
	    return health/8;}
	if (str.equals("Yellow Potion")){
	    return health/4;}
	if (str.equals("Blue Potion")){
	    return health/2;}
	if (str.equals("Green Potion")){
	    return health;}
	return health; //won't be gotten to
}

}