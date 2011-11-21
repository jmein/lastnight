import java.util.Arrays;

abstract class Dice{

	static int sum(int sides, int rolls){
		int sum = 0;
		for(int i=0; i<rolls; i++){
			sum += Die.rolld(sides);
		}
		return sum;
	}

	static int sum(int[] sides){
		int sum = 0;
		for(int i=0; i<sides.length; i++){
			sum += Die.rolld(sides[i]);
		}
		return sum;
	}

	static int[] roll(int sides, int rolls){
		int[] dice = new int[rolls];
		for(int i=0; i<rolls; i++){
			dice[i] = Die.rolld(sides);
		}
		return dice;
	}

	static int[] roll(int[] sides){
		int[] dice = new int[sides.length];
		for(int i=0; i<sides.length; i++){
			dice[i] = Die.rolld(sides[i]);
		}
		return dice;
	}
	static int[] sort(int sides, int rolls){
		int[] dice = new int[rolls];
		for(int i=0; i<rolls; i++){
			dice[i] = Die.rolld(sides);
		}
		return Dice.revSort(dice);
	}

	static int[] sort(int[] sides){
		int[] dice = new int[sides.length];
		for(int i=0; i<sides.length; i++){
			dice[i] = Die.rolld(sides[i]);
		}
		return Dice.revSort(dice);
	}

	static int max(int[] dice){
		int maximum = dice[0];
		for(int i=0; i<dice.length; i++){
			if(dice[i]>maximum){
				maximum = dice[i];
			}
		}
		return maximum;
	}

	static int min(int[] dice){
		int minimum = dice[0];
		for(int i=0; i<dice.length; i++){
			if(dice[i]>minimum){
				minimum = dice[i];
			}
		}
		return minimum;
	}

	static boolean hasDubs(int[] dice){
		for(int i=0; i<(dice.length-1); i++){
			for(int j=1; j<(dice.length); j++){
				if(dice[i] == dice[j]){
					return true;
				}
			}
		}
		return false;
	}

	private static int[] revSort(int[] dice){
		Arrays.sort(dice);
		int[] newDice = new int[dice.length];
		for(int i=0; i<dice.length; i++){
			newDice[i] = dice[dice.length-1-i];
		}
		return newDice;
	}

	static int[] addRoll(int[] dice, int sides){
		int[] allDice = new int[dice.length + 1];
		for(int i=0; i<dice.length; i++){
			allDice[i] = dice[i];
		}
		allDice[dice.length] = Die.rolld(sides);
		return allDice;
	}

	static int[] addRolls(int[] dice, int sides, int rolls){
		int[] allDice = new int[dice.length + 1];
		for(int i=0; i<dice.length; i++){
			allDice[i] = dice[i];
		}
		for(int i=dice.length; i<dice.length + rolls; i++){
			allDice[i] = Die.rolld(sides);
		}
		return allDice;
	}

	static int[] addSort(int[] dice, int sides){
		int[] allDice = new int[dice.length + 1];
		for(int i=0; i<dice.length; i++){
			allDice[i] = dice[i];
		}
		allDice[dice.length] = Die.rolld(sides);
		return revSort(allDice);
	}

	static int[] addSorts(int[] dice, int sides, int rolls){
		int[] allDice = new int[dice.length + 1];
		for(int i=0; i<dice.length; i++){
			allDice[i] = dice[i];
		}
		for(int i=dice.length; i<dice.length + rolls; i++){
			allDice[i] = Die.rolld(sides);
		}
		return revSort(allDice);
	}
}
