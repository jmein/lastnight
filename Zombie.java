
class Zombie extends Figure{

	Zombie(Square pit){
		super("Zombie", 1, 1, pit, Zombie.thru());

		pit.add(this);
		pit.city().add(this);
	}

	private static boolean[] thru(){
		boolean[] answer = {true,true,true,true,false};
		return answer;
	}

	void dies(){
		System.out.println(this.tag() + " dies!");
		this.isAt().rem(this);
		this.isAt().city().rem(this);
	}

}
