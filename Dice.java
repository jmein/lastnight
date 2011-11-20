import java.util.Arrays;

class Dice {
	
	static int sumd(int sides, int rolls){
		int sum = 0;
		for(int i=0; i<rolls; i++){
			sum += Die.rolld(sides);
		}
		return sum;
	}
	
	static int sumd(int[] sides){
		int sum=0;
		for(int i=0; i<sides.length; i++){
			sum += Die.rolld(sides[i]);
		}
		return sum;
	}
	
	static int[] rolld(int sides, int rolls){
		int[] dice = new int[rolls];
		for(int i=0; i<rolls; i++){
			dice[i]=Die.rolld(sides);
		}
		return revSort(dice);
	}
	
	static int[] rolld(int[] sides){
		int[] dice = new int[sides.length];
		for(int i=0; i<sides.length; i++){
			dice[i]=Die.rolld(sides[i]);
		}
		return revSort(dice);
	}
	
	static int max(int[] dice){
		int maximum = dice[0];
		for(int i=1; i<dice.length; i++){
			if(dice[i]>maximum){
				maximum=dice[i];
			}
		}
		return maximum;
	}
	
	static int min(int[] dice){
		int minimum = dice[0];
		for(int i=1; i<dice.length; i++){
			if(dice[i]>minimum){
				minimum=dice[i];
			}
		}
		return minimum;
	}
	
	static boolean hasDoubles(int[] dice){
		for(int i=0; i<(dice.length-1); i++){
			for(int j=(i+1); j<dice.length; j++){
				if(dice[i] == dice[j])
					return true;
			}
		}
		return false;
	}

	private static int[] revSort(int[] dice){
		Arrays.sort(dice);
		int[] newDice = new int[dice.length];
		for(int i=0; i<dice.length; i++){
			newDice[i]=dice[dice.length-1-i];
		}
		return newDice;
	}
	
}
