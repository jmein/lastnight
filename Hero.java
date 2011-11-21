
class Hero extends Figure{

	private boolean winTie;
	private boolean young;
	private boolean fm;
	private boolean mil;
	private boolean med;
	private boolean holy;
	private boolean strg;

	Hero(String nomen, int healths, Square start){
		super(nomen, healths, 2, start, Hero.thru());
		start.add(this);
		start.city().add(this);
	}

	static boolean[] thru(){
		boolean[] answer = {false,true,true,false,false};
		return answer;
	}

	void dies(){
		System.out.println(this.tag() + " dies...");
		new ZombieHero(this);
		this.isAt().rem(this);
		this.isAt().city().rem(this);
	}

	void fight(Undead zed){
		int[] hd = this.fRoll();
		int[] zd = zed.fRoll();

		if( (hd[0] > zd[0]) || ( (hd[0] == zd[0]) && this.winTie) ){
			System.out.println(this.tag() + " beats " + zed.tag() + "!");
			if( Dice.hasDubs(hd) ) zed.wound();
		}
		else{
			System.out.println(zed.tag() + " beats " + this.tag() + "...");
			this.wound();
		}
			
	}

}
