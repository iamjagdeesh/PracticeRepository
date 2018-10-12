import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'findSchedules' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER workHours
     *  2. INTEGER dayHours
     *  3. STRING pattern
     */

    public static List<String> findSchedules(int wH, int dayHours, String pattern) {
    
        List<String> result = new ArrayList<>();
        char[] c = pattern.toCharArray();
        int len = c.length, alloted = 0;
        int workHours = wH;
        
        int exitingSum = 0;
        for (char ch: c) {
            int val = Character.getNumericValue(ch);
            if (val != -1) {
                workHours -= val;
                alloted++;
                exitingSum += val;
            }
        }
        
        int left = 7 - alloted;
        
        /*if (workHours/left == dayHours) {
            pattern = pattern.replace('?', (char)(dayHours + '0'));
            System.out.println(pattern);
            result.add(pattern);
        }*/
        
        int p2 = Math.min((wH - exitingSum), dayHours);
        int p1 = 0;
        
        return result;
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int workHours = Integer.parseInt(bufferedReader.readLine().trim());

        int dayHours = Integer.parseInt(bufferedReader.readLine().trim());

        String pattern = bufferedReader.readLine();*/
    	int workHours = 24;
    	int dayHours = 4;
    	String pattern = "08??840";

        List<String> result = Result.findSchedules(workHours, dayHours, pattern);

        /*bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );*/
        
       /* bufferedReader.close();
        bufferedWriter.close();*/
    }
}