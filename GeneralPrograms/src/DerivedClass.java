import java.util.ArrayList;
import java.util.List;

public class DerivedClass extends BaseClass{
	
	public void show() {
		System.out.println("Derived Show");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseClass b = new DerivedClass();
		b.show();
		int a[] = {1,2,3};
		System.out.println(a.length);
		String s = new String("Good");
		s.length();
		List<Integer> aList = new ArrayList<Integer>();
		aList.size();
	}

}
