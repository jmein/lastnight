public class Hero extends Figure{

	public boolean winOnTie;
	public boolean student;
	public boolean female;

	Hero(String moniker, boolean kid, boolean xx, int healthBoxes, Square start){

		this.name = moniker;
		this.health = this.maxHealth = healthBoxes;
		this.fightDice = 2;
		this.moveThrough = Hero.throughness();
		this.student = kid;
		this.female = xx;
		this.location = start;
		start.herolist.add(this);

	}
	
	public static boolean[] throughness(){
		boolean answer = {true,true,true,false,false};
		return answer;
	}

	public void die(){
		System.out.println(this.name + " dies...");
		new ZombieHero(this);
	}

	public void fight(Zombie undead){
		
		int[] hd = this.fightRoll();
		int[] zd = undead.fightRoll();

		if( (hd[0] > zd[0]) || ( (hd[0] == zd[0]) && this.winOnTie) ){
			System.out.println(this.name + " wins!");
			if( Dice.hasDoubles(hd) ){
				undead.wound();
			}
		}
		else {
			this.wound();
		}

	}
}
