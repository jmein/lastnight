
public class TestFight {
	
	public static void main(String args[]){

		Square testSquare = new Square(0,0,new int[9],0,new Board(1));
		Hero[] heroes = new Hero[2];

		heroes[0] = new Hero("Clumsy",false,false,3,testSquare);
		heroes[1] = new Hero("Sammy",false,false,4,testSquare);

		for(int i=0; i<(2*Die.rolld(3)); i++){
			new Zombie(testSquare);
		}

		for(int i=0; (testSquare.herolist.size() > 0 && testSquare.zombielist.size() > 0);i++){
			System.out.println("\nRound " + i + ":");
			for(int j=0; j<testSquare.zombielist.size(); j++){
				testSquare.herolist.get(j%testSquare.herolist.size()).fight(testSquare.zombielist.get(j));
			}
		}

	}
}
