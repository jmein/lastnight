
class Hero extends Figure{

	private boolean winTie;
	private boolean stdnt;
	private boolean fm;
	private boolean law;
	private boolean mil;
	private boolean strg;
	private boolean med;
	private boolean holy;

	Hero(String moniker, int healths, Square start){
		super(moniker, healths, 2, start, Hero.thru());
	
		start.add(this);
		start.city().add(this);
	
	}

	static boolean[] thru(){
		boolean[] answer = {true,true,true,false,false};
		return answer;
	}

	void dies(){
	
		System.out.println(this.tag() + " dies...");
		new ZombieHero(this);
		this.isAt().rem(this);
		this.isAt().city().rem(this);
	
	}

	void fight(Zombie undead){

		int[] hd = this.fRoll();
		int[] zd = undead.fRoll();

		if( (hd[0] > zd[0]) || ( (hd[0] == zd[0]) && this.winTie) ){
			System.out.println(this.tag() + " wins!");
			if( Dice.hasDoubles(hd) ){
				undead.wound();
			}
		}
		else{
			this.wound();
		}

	}

}
