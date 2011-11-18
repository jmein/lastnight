import java.util.Scanner;

public class Figure{

	public String name;
	public int maxHealth;
	public int health;
	public int fightDice;
	public Square location;  //maybe just coordinates?
                            //and then Square location = Board.squareAt(int x, int y) ?
	
	boolean moveThrough[]; 
			
	public void moveTo(byte direction){
		byte dir = (byte)(direction -1);
		System.out.println("That edge is "+this.location.edge[dir]+".");
		while(! this.moveThrough[this.location.edge[dir]]){
			System.out.println("Try again");
			dir = (new Scanner(System.in).nextByte());
		}
		this.location = this.location.inDir(dir);
	}

}
