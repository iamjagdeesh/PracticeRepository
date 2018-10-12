import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length - 1;
        if(matrix.length < 0) {
            return res;
        }
        int n = matrix[0].length - 1;
        int m_i = 0;
        int n_i = 0;
        int dir = 0;
        System.out.println("Dir: "+dir+" M_i: "+m_i+" m: "+m+" N_i: "+n_i+" n: "+n);
        int total_size = (m+1)*(n+1);
        while(res.size() < total_size) {
            if(dir == 0) {
                for(int i=n_i; i<=n; i++) {
                    res.add(matrix[m_i][i]);
                }
                dir = (dir + 1) % 4;
                m_i++;
                System.out.println("Dir: "+dir+" M_i: "+m_i+" m: "+m+" N_i: "+n_i+" n: "+n);
            } else if(dir == 1) {
                for(int i=m_i; i<=m; i++) {
                    res.add(matrix[i][n]);
                }
                dir = (dir + 1) % 4;
                n--;
                System.out.println("Dir: "+dir+" M_i: "+m_i+" m: "+m+" N_i: "+n_i+" n: "+n);
            } else if(dir == 2) {
                for(int i=n; i>=n_i; i--) {
                    res.add(matrix[m][i]);
                }
                dir = (dir + 1) % 4;
                m--;
                System.out.println("Dir: "+dir+" M_i: "+m_i+" m: "+m+" N_i: "+n_i+" n: "+n);
            } else if(dir == 3){
                for(int i=m; i>=m_i; i--) {
                    res.add(matrix[i][n_i]);
                }
                dir = (dir + 1) % 4;
                n_i++;
                System.out.println("Dir: "+dir+" M_i: "+m_i+" m: "+m+" N_i: "+n_i+" n: "+n);
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//List<Integer> res = spiralOrder(matrix);
		System.out.println(-1);
	}

}
