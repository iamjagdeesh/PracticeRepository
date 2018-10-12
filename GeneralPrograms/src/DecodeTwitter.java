
public class DecodeTwitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encoded = new String("23511011501782351112179911801562340161171141148");
		System.out.println(decode(encoded));
	}
	
    // Complete the decode function below.
    static String decode(String encoded) {
        StringBuilder input = new StringBuilder();
        input.append(encoded);
        input = input.reverse();
        encoded = input.toString();
        int n = encoded.length();
        int i=0;
        String digit = null;
        StringBuilder output = new StringBuilder();
        char temp = '0';
        while(i<n) {
            if(encoded.charAt(i) == '1') {
                digit = encoded.substring(i, i+3);
                i = i+3;
            } else {
                digit = encoded.substring(i, i+2);
                i = i+2;
            }
            temp = (char)Integer.parseInt(digit);
            output.append(temp);
        }
        return output.toString();
    }



}
