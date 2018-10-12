
public class Simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simple sim = new Simple();
		int c = sim.numDecodings("01");
		System.out.println(c);
	}
	
	public int numDecodings(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        if(len == 1 && s.charAt(0) == '0'){
            return 0;
        }
        int[] temp = new int[len+1];
        temp[0] = 1;
        temp[1] = 1;
        for(int i=2; i<=len; i++){
            temp[i] = 0;
            char last = s.charAt(i-1);
            char beforeLast = s.charAt(i-2);
            if (last != '0'){
                temp[i] = temp[i] + temp[i-1];
            }
            if ((beforeLast == '2' && last <= '6') || beforeLast == '1'){
                temp[i] += temp[i-2];
            }
        }
        return temp[len];
    }

}
