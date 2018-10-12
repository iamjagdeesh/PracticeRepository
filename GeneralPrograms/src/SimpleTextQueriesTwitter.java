import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleTextQueriesTwitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> sentences = new ArrayList<String>();
		sentences.add("jim likes mary");
		sentences.add("kate likes tom");
		sentences.add("tom does not like jim");
		List<String> queries = new ArrayList<String>();
		queries.add("jim tom");
		queries.add("likes");
		textQueries(sentences, queries);
	}
	
    // Complete the textQueries function below.
    static void textQueries(List<String> sentences, List<String> queries) {
        int m = sentences.size();
        int n = queries.size();
        List<Map<String, Integer>> maps = new ArrayList<Map<String, Integer>>();
        for(int i=0; i<m; i++) {
            String sentence = sentences.get(i);
            String[] wordsOfSentence = sentence.split("\\s");
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(int j=0; j<wordsOfSentence.length; j++) {
                map.put(wordsOfSentence[j], map.getOrDefault(wordsOfSentence[j], 0) + 1);
            }
            maps.add(map);
        }
        
        for(int i=0; i<n; i++) {
            String query = queries.get(i);
            String[] wordsOfQuery = query.split("\\s");
            StringBuilder outputStr = new StringBuilder();
            for(int j=0; j<m; j++) {
                Map<String, Integer> map = maps.get(j);
                int count = Integer.MAX_VALUE;
                for(String word: wordsOfQuery) {
                    if(map.containsKey(word)) {
                        count = Math.min(count, map.get(word));
                    } else {
                        count = 0;
                        break;
                    }
                }
                for(int c=0; c<count; c++) {
                    if(outputStr.length() != 0) {
                        outputStr.append(" ");
                    }
                    outputStr.append(j);
                }
            }
            if(outputStr.length() == 0) {
                System.out.println(-1);
            } else {
                System.out.println(outputStr.toString());
            }
        }

    }



}
