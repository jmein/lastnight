
public class Board {
	
	Square[][] grid;
	
	Board(int xLong, int yLong){
		
		this.grid = new Square[xLong][yLong];
		
		//randomly generate board
		
	}
	
	Board(int n){	//movement development
		grid = new Square[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				grid[i][j] = new Square(i,j,edger(i,j,n-1,n-1),0,this);
			}
		}
	}
	
	private static int[] edger(int x, int y, int maxX, int maxY){
		int[] arr= new int[9];
		for(int i=0; i<9; i++)
			arr[i]=1;
		arr[4]=0;
		if(x==0){
			arr[0]=arr[3]=arr[6]=4;
		}
		if(x==maxX){
			arr[2]=arr[5]=arr[8]=4;
		}
		if(y==0){
			arr[0]=arr[1]=arr[2]=4;
		}
		if(y==maxY){
			arr[6]=arr[7]=arr[8]=4;
		}
		return arr;
	}
	
	Board(Ell[] ells){
		
		//generates board with four specified L's.
		
	}
	
	public Square squareAt(int x, int y){
		return grid[x][y]; 
	}
	
}
