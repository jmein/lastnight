
abstract class Undead extends Figure{

	Undead(String nomen, int healths, Square pit){
		super(nomen, healths, 1, pit, Undead.thru());
		pit.add(this);
		pit.city().add(this);
	}

	static boolean[] thru(){
		boolean[] answer = {true,true,true,true,false};
		return answer;
	}

	void dies(){
		System.out.println(this.tag() + " dies!");
		this.isAt().rem(this);
		this.isAt().city().rem(this);
	}

}
