public class Conversion{

    public int Converter(String str, int health){
	if (str.equals("sp")){
	    return 50;}
	if (str.equals("mp")){
	    return 80;}
	if (str.equals("bip")){
	    return 150;}
	if (str.equals("rp")){
	    return health/8;}
	if (str.equals("yp")){
	    return health/4;}
	if (str.equals("blp")){
	    return health/2;}
	if (str.equals("gp")){
	    return health;}
	return health; //won't be gotten to
}

}
