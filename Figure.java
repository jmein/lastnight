import java.util.Scanner;

public abstract class Figure{

	public String name;
	public int maxHealth;
	public int health;
	public int fightDice;
	public Square location;  //maybe just coordinates?
                            //and then Square location = Board.squareAt(int x, int y) ?
	
	boolean moveThrough[]; 
			
	public void moveTo(byte direction){
		byte dir = (byte)(direction -1);
		while(! this.moveThrough[this.location.edge[dir]]){
			System.out.println("Try again");
			dir = (byte)(new Scanner(System.in).nextByte()-1);
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
		if (this.health == 0)
			this.die();
	
	}

	abstract void die();

}
