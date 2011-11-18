
public class Square {
	
	int x;
	int y;
	int building;		//building 0 is exterior
	Board home;
	
	byte[] edge;		/*
									stores connections to squares:
									
									6 7 8
									3 4 5	edge[4] is the square itself;
									0 1 2
									
									edge[i]=0 -> i=4
									edge[i]=1 -> i is open edge
									edge[i]=2 -> i is a door(in wall)
									edge[i]=3 -> i is wall
									edge[i]=4 -> i is board edge
									
									*/
	
	public Square(int x, int y, byte[] edges, int building, Board gameBoard){
		this.x = x;
		this.y = y;
		this.building = building;
		this.edge = edges;
		this.home = gameBoard;
	}
	
	public Square inDir(byte dir){
		if(dir == 0)
			return this.home.squareAt(this.x-1, this.y-1);
		else if (dir == 1)
			return this.home.squareAt(this.x, this.y-1);
		else if (dir == 2)
			return this.home.squareAt(this.x+1, this.y-1);
		else if (dir == 3)
			return this.home.grid[this.x-1][this.y];
		else if (dir == 4)
			return this;
		else if (dir == 5)
			return this.home.grid[this.x+1][this.y];
		else if (dir == 6)
			return this.home.grid[this.x-1][this.y+1];
		else if (dir == 7)
			return this.home.grid[this.x][this.y+1];
		else if (dir == 8)
			return this.home.grid[this.x+1][this.y+1];
		else
			return this;
	}
	
	public void fight(Hero living, Zombie undead){
		int[] hd = Dice.rolld(6, living.fightDice);
		System.out.print(living.name + " rolls: ");
		for(int i=0; i<living.fightDice; i++){
			System.out.print(hd[i]+" ");
		}
		int hdMax = Dice.max(hd);
		int[] zd = Dice.rolld(6, undead.fightDice);
		System.out.print(undead.name + " rolls: ");
		for(int i=0; i<undead.fightDice; i++){
			System.out.print(zd[i]+" ");
		}int zdMax = Dice.max(zd);
		if((hdMax>zdMax) || ((hdMax == zdMax) && (living.winOnTie))) {
			System.out.println(living.name + " won the fight!");
			if(Dice.hasDoubles(hd)){
				System.out.println(living.name + " wounds "+ undead.name);
				undead.health--;
				if(undead.health == 0){
					System.out.println(living.name + " kills " + undead.name +"!");
				}
			}
		}
		else {
			System.out.println(living.name + " lost the fight...");
			living.health--;
			if(living.health == 0){
				System.out.println(living.name + " died...");
			}
		}
	}
		
}
