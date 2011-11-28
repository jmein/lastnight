
class Speedy extends Student{

	static private boolean[] traits = {false,false,false,false,false,false};
	Speedy(Board town){
		super("Speedy",Student.spawn(town),Speedy.traits);
	}

}
