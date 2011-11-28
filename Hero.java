
abstract class Hero extends Figure{

	private static boolean[] thru = {false,true,true,false,false};
	private boolean[] trait;	// fm, holy, med, mil, strg, wT

	Hero(String nomen, int healths, Square start, boolean[] character){
		super(nomen, healths, 2, start, Hero.thru);
		start.add(this);
		this.isIn().add(this);
		this.trait = character;
	}

	boolean trt(int index){return this.trait[index];}
	void mkTrt(int index, boolean maybe){this.trait[index]=maybe;}

	void mvTo(int dir){
		Square origin = this.isAt();
		if(this.moveDir(dir)){
			origin.rem(this);
			this.isAt().add(this);
		}
	}

	void dies(){
		System.out.println(this.tag() + " dies...");
		new ZombieHero(this);
		this.isAt().rem(this);
		this.isAt().isIn().kill(this);
	}

	void fight(Undead zed){
		int[] hd = this.fRoll();
		int[] zd = zed.fRoll();

		if( (hd[0] > zd[0]) || ( (hd[0] == zd[0]) && this.trt(5)) ){
			System.out.println(this.tag() + " beats " + zed.tag() + "!");
			if( Dice.hasDubs(hd) ) zed.wound();
		}
		else{
			System.out.println(zed.tag() + " beats " + this.tag() + "...");
			this.wound();
		}
			
	}

}
