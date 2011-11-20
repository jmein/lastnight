
class Center{

	private Square[][] squares;
	private Board town;

	Center(Board gameBoard, boolean largeSquares){
		if (largeSquares){
			this.squares = new LargeSquare[3][3];
		}
		else {
			this.squares = new Square[6][6];
		}
		this.town = gameBoard;
	}

}
