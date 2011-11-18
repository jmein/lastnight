
public class TestFight {
	
	public static void main(String args[]){
		
		Square testSquare = new Square(0,0,new byte[9],0,new Board(1));
		Hero hero0 = new Hero("Clumsy",false,false,3,testSquare);
		
		while(hero0.health > 0){
			testSquare.fight(hero0, new Zombie(testSquare));
		}
		
		ZombieHero zh0 = new ZombieHero(hero0);
		hero0 = new Hero("Sammy",false,false,4,testSquare);
		
		while((hero0.health>0) && (zh0.health>0)){
			testSquare.fight(hero0,zh0);
			testSquare.fight(hero0, new Zombie(testSquare));
		}
		
	}
	
}
