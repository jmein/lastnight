import java.util.Random;

public class Die{
	  
	  public static int rolld(int sides){
	    Random roller=new Random();
	    return (roller.nextInt(sides)+1);
	  }

	//  public static int d6(){
//	    return (new Random().nextInt(6)+1);
	//  }

	}
