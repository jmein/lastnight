
abstract class Student extends Hero{
	
	Student(String nomen, Square start, boolean[] character){
		super(nomen, 2, start, character);
	}
	static Square spawn(Board town){
		return town.sqAt(0,0);
	}

	void rest(){
		this.heal(1);
	}

}
