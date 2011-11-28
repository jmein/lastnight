import java.util.ArrayList;

class Board{

	private Square[][] grid;
	private ArrayList<Hero> heroes;
	private ArrayList<Undead> zombies;
	private int hDeath;
	private int zDeath;
	private int zPool;
	
	Board(int xLong, int yLong){
		this.grid = new Square[xLong][yLong];
		//random board
	}

	Board(){
		this.grid = new Square[4][4];
		for(int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				this.grid[i][j] = new Square(i,j,Board.rcEd(i,j,3,3),this);
			}
		}
		grid[1][1]=grid[1][2]=grid[2][1]=grid[2][2]= new LargeSquare(1,1,Board.lgEd(),this);
	}

	Board(int n){	//square exterior board for mechanics testing
		this.grid = new Square[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				this.grid[i][j] = new Square(i,j,Board.rcEd(i,j,n-1,n-1),this);
			}
		}
		this.heroes = new ArrayList<Hero>();
		this.zombies = new ArrayList<Undead>();
	}

	Board(Ell[] corners, Center middle){
		//generate board with given corners, center
	}

	Hero hero(int index){return this.heroes.get(index);}
	Undead zed(int index){return this.zombies.get(index);}

	void rem(Hero human){this.heroes.remove(human);}
	void rem(Undead zed){this.zombies.remove(zed);}
	void add(Hero human){this.heroes.add(human);}
	void add(Undead zed){this.zombies.add(zed);}
	void kill(Hero human){
		hDeath++;
		this.rem(human);
	}
	void kill(Undead zed){
		zDeath++;
		this.rem(zed);
	}

	Square sqAt(int x, int y){
		return this.grid[x][y];
	}

	private static int[] lgEd(){
		int[] arr = new int[13];
		arr[0]=0;
		for(int i=1; i<13; i++){
			arr[i]=1;
		}
		return arr;
	}

	private static int[] rcEd(int x, int y, int maxX, int maxY){
		int[] arr = new int[9];
		arr[0] = 0;
		for(int i=1; i<9; i++){
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
			arr[4]=arr[3]=arr[2]=4;
		}
		return arr;
	}

}
