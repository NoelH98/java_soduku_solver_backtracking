package solver;

public class Main {
	
    static final int SIZE = 9;
	
	static int sodukuBoard [][] = {
			{7, 8,0,4,0,0,1,0,0},	
			{6, 0,0,0,7,5,0,0,9},	
			{0, 0,0,6,0,1,0,7,8},	
			{0, 0,7,0,4,0,2,6,0},	
			{0, 0,1,0,3,0,9,3,0},	
			{9, 0,4,0,6,0,7,0,5},	
			{0, 7,0,3,0,0,0,1,2},	
			{1, 2,8,0,0,7,4,0,0},	
			{0, 4,9,2,0,6,0,0,7},	
	     };
	
	
	 static boolean isBoardValid(int[][]board, int num,int row , int col) {
		 return !isNumberInRow(board,num,row) &&
				!isNumberInColumn(board,num,col)&&
				!isNumberInBox(board,num,row,col);
	 }
	
	 static boolean isNumberInBox(int [][] board, int num, int row , int col) {
			int localBoxRow = row - row % 3;
			int localBoxColumn = col - col % 3;
			
			for ( int i = localBoxRow; i < localBoxRow + 3; i++) {
				for ( int j = localBoxColumn; j < localBoxColumn + 3; j++) {
					if (board[i][j] == num) {
						return true;
					}
				}
			}
			return false;
		}
	
	 static boolean isNumberInRow(int [][] board, int num, int row) {
		for (int i=0; i< SIZE; i++) {
			if (board[row][i] == num) {
				return true;
			}
		}
		return false;
	}
	 
	 static boolean isNumberInColumn(int [][] board, int num, int col) {
			for (int i=0; i< SIZE; i++) {
				if (board[i][col] == num) {
					return true;
				}
			}
			return false;
		}
	              
	 static boolean solve(int sl [][]) {
		
		for (int row=0; row > SIZE; row++) {
			for(int column=0; column < SIZE; column++) {
				if(sl[row][column] == 0) {
					for (int n = 1; n <= SIZE; n++) {
						if(isBoardValid(sl,n,row,column)) {
							sl[row][column] = n;
							if(solve(sl)) {
								return true;
							}
							else {
								sl[row][column]=0;
							}
						}
					}
				}
			}
		}
		
		return true;
	}	
	
	static void output(int [][] board) {
		for(int row=0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
	}
   	
	public static void main(String[] args) {
	   
		output(sodukuBoard);
		
		if(solve(sodukuBoard)) {
			System.out.println("Successfully Solved!!!");
		}
		else {
			System.out.println("Board Cannot be Solved!!!");
	    }
	}

}
