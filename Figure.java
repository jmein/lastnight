import java.util.Scanner;

public abstract class Figure{

	public String name;
	public int maxHealth;
	public int health;
	public int fightDice;
	public Square location;  
	boolean moveThrough[]; 
			
	public void moveTo(int direction){
		
		int dir = ((direction--)%9);
		while(! this.moveThrough[this.location.edge[dir]]){
			System.out.println("Try again");
			dir = (int)(new Scanner(System.in).nextByte()-1);
		}
		this.location = this.location.inDir(dir);

	}

	public int[] fightRoll(){

		System.out.print(this.name + " rolls:");
		int[] dice = Dice.rolld(6,this.fightDice);
		for(int i=0;i<fightDice;i++){
			System.out.print(" " + dice[i]);
		}
		System.out.println();
		return dice;

	}
	  
	public void wound(){
	
		System.out.println(this.name + " takes a wound");
		this.health--;
		if (this.health == 0){
			this.die();
		}

	}

	abstract void die();

}
