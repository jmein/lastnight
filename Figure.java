import java.util.Scanner;

class Figure{

	private String name;
	private int maxHP;
	private int hp;
	private int fDice;
	private Square here;
	private boolean[] thru;

	Figure(String nomen, int healths, int dices, Square place, boolean[] move){

		this.name = nomen;
		this.hp = this.maxHP = healths;
		this.fDice = dices;
		this.here = place;
		this.thru = move;

	}

	void makeName(String newName){this.name = newName;}
	void setHP(int healths){this.hp = this.maxHP = healths;}
	String tag(){return this.name;}
	int[] hasHP(){
		int[] answer = {this.hp, this.maxHP};
		return answer;
	}
	int rolls(){return this.fDice;}
	Square isAt(){return this.here;}

	boolean moveTo(int dir){

		if(this.thru[this.here.edge(dir)]){
			this.here = this.here.inDir(dir);
			return true;
		}
		else {
			return false;
		}

	}

	int[] fRoll(){

		System.out.print(this.name + "rolls:");
		int[] dice = Dice.rolld(6, this.fDice);
		for(int i=0; i<fDice; i++){
			System.out.print(" " + dice[i]);
		}
		System.out.println();
		return dice;

	}

	void wound(){

		System.out.println(this.name + " takes a wound");
		this.hp--;
		if(this.hp == 0){
			this.dies();
		}

	}

	void heal(){this.hp = this.maxHP;}
	void heal(int pts){
		this.hp += pts;
		if (this.hp > this.maxHP)
			hp = maxHP;
	}

	void dies(){}

}
