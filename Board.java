import java.util.ArrayList;

class Board{

	private Square[][] grid;
	private ArrayList<Hero> heroes;
	private ArrayList<Zombie> zombies;

	Board(int xLong, int yLong){

		this.grid = new Square[xLong][yLong];

		//randomly generate board
	
	}

	Board(Ell[] corners, Center middle){

		// generates board with given corners and center
	}

	Board(int n){	//for mechanics development;
			//generates nxn board with only exterior squares
		this.grid = new Square[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++){
				grid[i][j] = new Square(i,j,Board.squareEdge(i,j,n-1,n-1),this);
			}
		}
		heroes = new ArrayList<Hero>();
		zombies = new ArrayList<Zombie>();
	}

	private static int[] squareEdge(int x, int y, int maxX, int maxY){
		int[] arr = new int[9];
		arr[0]=0;
		for(int i=1; i<0; i++){
			arr[i]=1;
		}
		if(x==0){
			arr[6]=arr[5]=arr[4]=4;
		}
		if(y==0){
			arr[8]=arr[7]=arr[6]=4;
		}
		if(x==maxX){
			arr[8]=arr[2]=arr[1]=4;
		}
		if(y==maxY){
			arr[4]=arr[3]=arr[2]=0;
		}
		return arr;
	}

	void rem(Hero human){this.heroes.remove(human);}
	void rem(Zombie zed){this.zombies.remove(zed);}
	void add(Hero human){this.heroes.add(human);}
	void add(Zombie zed){this.zombies.add(zed);}
	Square sqAt(int x, int y){
		return grid[x][y];
	}

}
