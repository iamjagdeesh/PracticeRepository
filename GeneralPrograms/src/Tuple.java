
public class Tuple implements Comparable<Tuple> {

	int x;
	int y;
	int val;

	public Tuple(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple that) {
		// TODO Auto-generated method stub
		return this.val - that.val;
	}

}
