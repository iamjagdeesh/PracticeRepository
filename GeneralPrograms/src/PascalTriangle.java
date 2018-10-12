import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle p = new PascalTriangle();
		List<List<Integer>> list = p.generate(4);
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        if(numRows == 0) return pascal;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        pascal.add(temp);
        while(pascal.size() != numRows) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            for(int i=1; i<temp.size(); i++){
                newList.add(temp.get(i-1) + temp.get(i));
            }
            newList.add(1);
            pascal.add(newList);
            temp = new ArrayList<Integer>(newList);
        }
        return pascal;
    }

}
