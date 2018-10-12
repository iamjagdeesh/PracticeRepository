import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionWinnerTwitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] votes = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry",	"Alex", "Mary", "Mary"};
		System.out.println(electionWinner(votes));
	}
	
    // Complete the electionWinner function below.
    static String electionWinner(String[] votes) {
        Map<String, Integer> mapVoteCount = new HashMap<String, Integer>();
        int highest = 0;
        List<String> winners = null;
        int count = 0;
        for(String vote: votes) {
            count = mapVoteCount.getOrDefault(vote,0) + 1;
            if(count > highest) {
                winners = new ArrayList<String>();
                winners.add(vote);
                highest = count;
            } else if(count == highest) {
                winners.add(vote);
            }
            mapVoteCount.put(vote, count);
        }
        Collections.sort(winners);
        
        return winners.get(winners.size()-1);
    }



}
