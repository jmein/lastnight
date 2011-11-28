import java.util.Scanner;

class Lucky extends Student{
	static private boolean traits[] = {true,false,false,false,false,false};
	Lucky(Board town){
		super("Lucky",Student.spawn(town), Lucky.traits);
	}
	static Square spawn(Board town){
		return town.sqAt(0,0);
	}
	
	void fight(Undead zed){
		int[] hd = this.fRoll();
		int[] zd = zed.fRoll();

		System.out.println("Force reroll?(#truth) ");
		if( new Scanner(System.in).nextInt() != 0 ) zd = zed.fRoll();
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
