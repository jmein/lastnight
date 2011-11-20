import java.util.Random;

class Die{
	static int rolld(int sides){
		return (new Random().nextInt(sides)+1);
	}
}
