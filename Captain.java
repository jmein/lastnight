
class Captain extends Hero{

	private static boolean[] traits = {false,false,false,true,false,false};
	Captain(Board town){
		super("Captain Awesomepants", 4, Captain.spawn(town), Captain.traits);
	}

	static Square spawn(Board town){
		return town.sqAt(0,0);
	}

}
