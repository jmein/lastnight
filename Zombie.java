public class Zombie extends Figure{

	Zombie(Square pit){
		this.name = "Zombie";
		this.health = this.maxHealth = 1;
		this.fightDice = 1;
		this.moveThrough =/*{true,true,true,true,false}*/Zombie.throughness();
		this.location = pit;
		pit.zombielist.add(this);
	}

	public static boolean[] throughness(){
		boolean[] answer = {true,true,true,true,false};
		return answer;
	}

	void die(){
		System.out.println(this.name + " dies!");
		this.location.zombielist.remove(this);
	}

}
