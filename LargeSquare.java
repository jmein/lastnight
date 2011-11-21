
class LargeSquare extends Square{
	private int x2;
	private int y2;

	/*
	 * edges:	05 04 03 02
	 * 		06 00 00 01
	 * 		07 00 00 12 
	 * 		08 09 10 11
	 */
	
	/*
	 * constructs a large square from the little square coordinates of
	 * its lower left fourth
	 */
	LargeSquare(int x, int y, int[] edges, Board gameBoard){
	       super(x, y, edges, gameBoard);
	       this.x2 = x+1;
	       this.y2 = y+1;
	}

	Square inDir(int dir){	//replace old function b/c more edges
		if(dir==12) return this.city().sqAt(this.x()+2, this.y());
		else if(dir==11) return this.city().sqAt(this.x()+2, this.y()-1);
		else if(dir==10) return this.city().sqAt(this.x()+1, this.y()-1);
		else if(dir==9) return this.city().sqAt(this.x(), this.y()-1);
		else if(dir==8) return this.city().sqAt(this.x()-1, this.y()-1);
		else if(dir==7) return this.city().sqAt(this.x()-1, this.y());
		else if(dir==6) return this.city().sqAt(this.x()-1, this.y()+1);
		else if(dir==5) return this.city().sqAt(this.x()-1, this.y()+2);
		else if(dir==4) return this.city().sqAt(this.x(), this.y()+2);
		else if(dir==3) return this.city().sqAt(this.x()+1, this.y()+2);
		else if(dir==2) return this.city().sqAt(this.x()+2, this.y()+2);
		else if(dir==1) return this.city().sqAt(this.x()+2, this.y()+1);
		else return this;
	}

}
