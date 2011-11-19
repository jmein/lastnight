import java.util.ArrayList;

public class Square {
	
	int x;
	int y;
	int building;		//building 0 is exterior
	Board town;
	Building house;
	java.util.ArrayList<Hero> herolist;
	java.util.ArrayList<Zombie> zombielist;
	
	int[] edge;
	
	public Square(int x, int y, int[] edges, int building, Board gameBoard){
		this.x = x;
		this.y = y;
		this.building = building;
		this.edge = edges;
		this.town = gameBoard;
		this.herolist = new java.util.ArrayList<Hero>();
		this.zombielist = new java.util.ArrayList<Zombie>();
	}
	
	public Square inDir(int dir){
		if(dir == 0)
			return this.town.squareAt(this.x-1, this.y-1);
		else if (dir == 1)
			return this.town.squareAt(this.x, this.y-1);
		else if (dir == 2)
			return this.town.squareAt(this.x+1, this.y-1);
		else if (dir == 3)
			return this.town.grid[this.x-1][this.y];
		else if (dir == 4)
			return this;
		else if (dir == 5)
			return this.town.grid[this.x+1][this.y];
		else if (dir == 6)
			return this.town.grid[this.x-1][this.y+1];
		else if (dir == 7)
			return this.town.grid[this.x][this.y+1];
		else if (dir == 8)
			return this.town.grid[this.x+1][this.y+1];
		else
			return this;
	}

}
