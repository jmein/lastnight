public class Zombie extends Figure{

  Zombie(Square pit){
	  this.name = "Zombie";
    this.health = this.maxHealth = 1;
    this.fightDice = 1;
    this.moveThrough = /*{true,true,true,true,false};*/Zombie.throughness();
    this.location = pit;
  
  }
  
  public static boolean[] throughness(){
	  boolean[] answer = {true,true,true,true,false};
	  return answer;
  }
  
  void answer(String question){
	  System.out.println("Urgh....");
  }

}
