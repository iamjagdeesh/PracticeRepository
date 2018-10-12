
public class ConnectGame {
	
	private int[][] matrix;
	
	public ConnectGame(int n) {
		matrix = new int[n][n];
	}
	
	public int[] dropPiece(int playerId, int col) {
		int[] tuple = new int[2];
		for(int i=matrix.length-1; i>=0; i--) {
			if(matrix[i][col] == 0) {
				matrix[i][col] = playerId;
				tuple[0] = i;
				tuple[1] = col;
				break;
			}
		}
		
		/*for(int i=0; i<matrix.length; i++) {
			System.out.println("Row" + i);
			StringBuilder s = new StringBuilder();
			for(int j=0; j<matrix[0].length; j++) {
				s.append(matrix[i][j] + " ");
			}
			System.out.println(s);
		}*/
		
		return tuple;
	}
	
	public int checkWin(int playerId, int[] tuple) {
		boolean flag = false;
		int id = playerId;
		int i = tuple[0];
		int col = tuple[1];
		int count = 0;
		for(int j=0; j<matrix[0].length; j++) {
			if(matrix[i][j] == id) {
				count++;
				if(count >= 4) {
					return id;
				}
			}else {
				count = 0;
				continue;
			}
		}
		
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectGame connectGame = new ConnectGame(6);
		int[] tuple = connectGame.dropPiece(1, 1);
		//System.out.println(tuple[0]);
		//System.out.println(tuple[1]);
		System.out.println("Winner: " + connectGame.checkWin(1, tuple));
		//tuple = connectGame.dropPiece(2, 1);
		//System.out.println(tuple[0]);
		//System.out.println(tuple[1]);
		//System.out.println("Winner: " + connectGame.checkWin(1));
		tuple = connectGame.dropPiece(1, 0);
		tuple = connectGame.dropPiece(1, 2);
		tuple = connectGame.dropPiece(1, 3);
		System.out.println("Winner: " + connectGame.checkWin(1, tuple));
	}

}
