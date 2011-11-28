import java.util.ArrayList;

class Square{
	private int x;
	private int y;
	private int building;
	private Board town;
	private Building house;
	private ArrayList<Hero> heroes;
	private ArrayList<Undead> zombies;
	private boolean pit;

	private int[] edge;/*	tells you the type of edge at connection (0 is self)
				4 3 2		edge[i] = 0 -> i=0
				5 0 1		edge[i] = 1 -> normal open edge
				6 7 8		edge[i] = 2 -> door (wall)
						edge[i] = 3 -> wall
						edge[i] = 4 -> board edge	*/

	Square(int x, int y, int[] edges, Board gameBoard){
		this.x = x;
		this.y = y;
		this.edge = edges;
		this.town = gameBoard;
		this.heroes = new ArrayList<Hero>();
		this.zombies = new ArrayList<Undead>();
		this.pit = false;
	}

	int[] isAt(){
		int[] where = {this.x,this.y};
		return where;}
	int x(){return this.x;}
	int y(){return this.y;}
	int zCt(){return this.zombies.size();}
	Building isPt(){return this.house;}
	Board isIn(){return this.town;}
	int edge(int dir){return this.edge[dir];}
	Undead zed(int index){return this.zombies.get(index);}

	boolean newPit(){
		if (this.pit == true) return false;
		else {
			this.pit = true;
			return true;
		}
	}

	void rem(Hero human){this.heroes.remove(human);}
	void rem(Undead zed){this.zombies.remove(zed);}
	void add(Hero human){this.heroes.add(human);}
	void add(Undead zed){this.zombies.add(zed);}

	void chEd(int edge, int type){
		this.edge[edge] = type;
	}

	Square inDir(int dir){
		if(dir==8) return this.town.sqAt(this.x+1, this.y-1);
		else if(dir==7) return this.town.sqAt(this.x, this.y-1);
		else if(dir==6) return this.town.sqAt(this.x-1, this.y-1);
		else if(dir==5) return this.town.sqAt(this.x-1, this.y);
		else if(dir==4) return this.town.sqAt(this.x-1, this.y+1);
		else if(dir==3) return this.town.sqAt(this.x, this.y+1);
		else if(dir==2) return this.town.sqAt(this.x+1, this.y+1);
		else if(dir==1) return this.town.sqAt(this.x+1, this.y);
		else return this;
	}

}
