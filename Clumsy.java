
class Clumsy extends Adult{

	private static boolean[] traits = {false,false,false,false,true,false};
	Clumsy(Board town){
		super("Clumsy",Clumsy.spawn(town),Clumsy.traits);
	}

	static Square spawn(Board town){
		return town.sqAt(0,0);
	}

}
