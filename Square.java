import java.util.ArrayList;

class Square{

	private int x;
	private int y;
	private int building;	//0 -> exterior
	private Board town;
	private Building house;
	private ArrayList<Hero> heroes;
	private ArrayList<Zombie> zombies;

	private int edge[];	/*type of edge over connection at index:
				   4 3 2	edge[] = 0 -> this square
				   5 0 1	edge[] = 1 -> normal edge
				   6 7 8	edge[] = 2 -> door (wall)
				 		edge[] = 3 -> wall
				 		edge[] = 4 -> board edge
				*/

	Square(int x, int y, int[]edges, Board gameBoard){
		this.x = x;
		this.y = y;
		this.edge = edges;
		this.town = gameBoard;
	
		this.heroes = new ArrayList<Hero>();
		this.zombies = new ArrayList<Zombie>();
	}

	Square(){}
	
	int[] isAt(){
		int[] xy = {this.x,this.y};
		return xy;
	}
	void add(Hero human){this.heroes.add(human);}
	void rem(Hero human){this.heroes.remove(human);}
	void add(Zombie zed){this.zombies.add(zed);}
	void rem(Zombie zed){this.zombies.add(zed);}
	Board city(){return this.town;}
	Building isIn(){return this.house;}

	int edge(int dir){
		return edge[dir];
	}

	Square inDir(int dir){
		if(dir == 8)
			return this.town.sqAt(this.x+1,this.y-1);
		else if(dir == 7)
			return this.town.sqAt(this.x,this.y-1);
		else if(dir == 6)
			return this.town.sqAt(this.x-1,this.y-1);
		else if(dir == 5)
			return this.town.sqAt(this.x-1,this.y);
		else if(dir == 4)
			return this.town.sqAt(this.x-1,this.y+1);
		else if(dir == 3)
			return this.town.sqAt(this.x,this.y+1);
		else if(dir == 2)
			return this.town.sqAt(this.x+1,this.y+1);
		else if(dir == 1)
			return this.town.sqAt(this.x+1,this.y);
		else
			return this;
	}

	void ched(int dir, int type){
		if( (dir/8 == 0) && (type/5 == 0) && (dir != 0) && (type != 0)){
			this.edge[dir] = type;
		}
	}

}
