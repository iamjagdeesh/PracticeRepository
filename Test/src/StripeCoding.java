import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StripeCoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String>();
		lines.add("API: amount=1000&merchant=123456789&destination[account]=111111&destination[amount]=877");
		lines.add("BAL: merchant=123456789");
		lines.add("BAL: merchant=111111");
		List<Integer> res = balance(lines);
	}
	
	static List<Integer> balance(List<String> lines) {
		List<Integer> res = new ArrayList<Integer>();
        Map<String, Integer> accountBalance = new HashMap<>();
        for(String line: lines) {
            if(line.substring(0,3).equals("BAL")) {
                String acc = line.substring(14);
                System.out.println(line.substring(14));
                res.add(accountBalance.getOrDefault(acc, 0));
            } else {
            	Map<String, String> detailsMap = new HashMap<String, String>();
                String[] tuples = line.substring(5).split("&");
                for(String tuple: tuples) {
                	String[] tupleArray = tuple.split("\\=");
                	detailsMap.put(tupleArray[0], tupleArray[1]);
                }
                String merchant = detailsMap.get("merchant");
                Integer amount = Integer.valueOf(detailsMap.get("amount"));
                Integer stripeCut = (int)(amount * 0.029 + 30);
                Integer driverCut = Integer.valueOf(detailsMap.getOrDefault("destination[amount]", "0"));
                Integer balance = amount - stripeCut - driverCut;
                accountBalance.put(merchant, accountBalance.getOrDefault(merchant, 0) + balance);
                if(detailsMap.containsKey("destination[account]")) {
                	accountBalance.put(detailsMap.get("destination[account]"), accountBalance.getOrDefault("destination[account]", 0) + driverCut);
                }
            }
        }
        return res;
    }


}
