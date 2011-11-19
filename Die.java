import java.util.Random;

public class Die{
	public static int rolld(int sides){
		return (new Random().nextInt(sides)+1);
	}
}
