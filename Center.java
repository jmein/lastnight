
class Center{

	private Square[][] grid;

	Center(boolean largeSquares){
		if(largeSquares) this.grid = new LargeSquare[3][3];
		else this.grid = new Square[6][6];
	}

}
