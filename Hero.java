public class Hero extends Figure{

  public boolean winOnTie = false;
  public boolean student;
  public boolean strange;
  public boolean female;

  Hero(String moniker, boolean kid, boolean xx, int healthBoxes, Square start){
  
    this.name = moniker;
    this.health = this.maxHealth = healthBoxes;
    this.fightDice = 2;
    this.moveThrough = Hero.throughness();
    this.student = kid;
    this.female = xx;
    this.location = start;

  }
  
  public static boolean[] throughness(){
	  boolean[] answer = {true,true,true,false,false};
	  return answer;
  }
  
  public String answer(String question){
	  
	  if(question == "Where are you?"){
		  return("I'm at "+this.location.x+","+this.location.y);
	  }
	  else
		  return "...";
	  
  }

}
