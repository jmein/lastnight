import java.util.Scanner;

abstract class Figure{

	private String name;
	private int maxHP;
	private int hp;
	private int fDice;
	private Square here;
	private boolean[] thru;

	Figure(String nomen, int healths, int dices, Square where, boolean[] move){
		this.name = nomen;
		this.hp = this.maxHP = healths;
		this.fDice = dices;
		this.here = where;
		this.thru = move;
	}

	String tag(){return this.name;}
	int[] hasHP(){int[] healths = {this.hp, this.maxHP};return healths;}
	int dices(){return this.fDice;}
	Square isAt(){return this.here;}

	void moveTo(Square dest){
		//sounds good;
	}

	boolean moveDir(int dir){
		if(this.thru[this.here.edge(dir)]){
			this.here = this.here.inDir(dir);
			return true;
		}
		else return false;
	}

	int[] fRoll(){
		System.out.print(this.name + " rolls");
		int[] dice = Dice.sort(6, this.fDice);
		for(int i=0; i<this.fDice; i++){
			System.out.print(" " + dice[i]);
		}
		System.out.println();
		return dice;
	}

	public void wound(){
		System.out.println(this.name + " takes a wound");
		this.hp--;
		if(this.hp == 0) this.dies();
	}

	void dies(){
	}

}

