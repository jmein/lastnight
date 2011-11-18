import java.util.Scanner;

public class TestMove {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("how big a board?");
		
		Board testBoard = new Board(in.nextInt());
		Hero clumsy = new Hero("Clumsy", false, false, 3, testBoard.squareAt(0, 0));
		
		while(true){
			System.out.println("Which way do you want to go?");
			clumsy.moveTo(in.nextByte());
			System.out.println(clumsy.answer("Where are you?"));
		}
		
	}
	
}
