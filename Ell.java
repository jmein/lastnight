
class Ell{

	private Square[][] squares = new Square[6][6];
	private Building[] bldgList;

	Ell(){}

	Square sq(int x, int y){return this.squares[x][y];}

	void rotate(){
		Square[][] nwSq = new Square[6][6];
		for(int i=0; i<6; i++){
			for(int j=0; j<6; j++){
				nwSq[i][j] = this.squares[5-j][i];
				int[] nEdge = new int[9];
				for(int k=2; k<8; k++){
					nEdge[k] = nwSq[i][j].edge(k-1);
				}
				nEdge[1] = nwSq[i][j].edge(8);
				nEdge[0] = nwSq[i][j].edge(7);
				for(int k=0; k<8; k++){
					nwSq[i][j].chEd(k+1,nEdge[k]);
				}
			}
		}
		this.squares = nwSq;
	}

}
