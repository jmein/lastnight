import java.util.Scanner;

public class TestDice {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		for(int opt = 59; opt != 0; opt=in.nextInt()){
			
			System.out.println("Choose your choice:\n1) sum same\t2) sum some\n3) roll same\t4) roll some");
			
			if (opt == 1){
				System.out.println("Input number of sides and dice:");
				System.out.printf("You roll %d\n", Dice.sumd(in.nextInt(), in.nextInt()));
			}
			
			else if (opt == 2){
				System.out.print("Rolling _ dice: ");
				int[] sides = new int[in.nextInt()];
				System.out.println("Tell me the sides of your dice!");
				for(int i=0; i<sides.length;i++){
					sides[i] = in.nextInt();
				}
				System.out.printf("You roll %d\n", Dice.sumd(sides));
			}
			
			else if (opt == 3){
				System.out.println("Input number of sides and dice:");
				Dice.rolld(in.nextInt(), in.nextInt());
			}
			
			else if (opt == 4){
				System.out.print("Rolling _ dice: ");
				int[] sides = new int[in.nextInt()];
				System.out.println("Tell me the sides of your dice!");
				for(int i=0; i<sides.length;i++){
					sides[i] = in.nextInt();
				}
				int[] rolls = Dice.rolld(sides);
				for (int i=0; i<sides.length; i++){
					System.out.printf("%d, ", rolls[i]);
				}
				
			}
		}
	}
	
	
}
