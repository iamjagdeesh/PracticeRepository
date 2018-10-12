import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TournamentTree {
	
	private HashMap<Integer, List<Integer>> losersOfPlayers;
	private Integer bestPlayer;
	private Integer matches;

	public TournamentTree() {
		this.losersOfPlayers = new HashMap<Integer, List<Integer>>();
		this.bestPlayer = 0;
		this.matches = 0;
	}

	public Integer bestPlayer(List<Integer> players) {
		Integer winner=0,loser=0;
		List<Integer> playersRemaining = new ArrayList<Integer>();
		System.out.println("Level");
		for (int i = 0, j = players.size() - 1; i<=j; i++,j--) {
			List<Integer> losersList = new ArrayList<Integer>();
			//Accounting for odd number of players left
			if(i==j) {
				playersRemaining.add(players.get(i));
				continue;
			}
			if (players.get(i) < players.get(j)) {
				winner = players.get(j);
				loser = players.get(i);
			}else {
				winner = players.get(i);
				loser = players.get(j);
			}
			System.out.println("(Winner,loser)="+"("+winner+","+loser+")");
			this.matches++;
			playersRemaining.add(winner);
			if (losersOfPlayers.containsKey(winner)) {
				losersList = losersOfPlayers.get(winner);
			}
			losersList.add(loser);
			losersOfPlayers.put(winner, losersList);
			//System.out.println(losersOfPlayers);
		}
		if(playersRemaining.size() != 1) {
			bestPlayer(playersRemaining);
		}else {
			this.bestPlayer = playersRemaining.get(0);
		}
		return 0;
	}
	
	public boolean judgeCircle(String moves) {
        char[] a_moves = moves.toCharArray();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for(int i=0; i<a_moves.length; i++){
            Integer val = countMap.get(a_moves[i]);
            if(val == null){
                countMap.put(a_moves[i], 1);
            }else{
                countMap.put(a_moves[i], val+1);
            }
        }
        Integer u = countMap.get('U');
        Integer d = countMap.get('D');
        Integer l = countMap.get('L');
        Integer r = countMap.get('R');
        System.out.println(u);
        System.out.println(d);
        System.out.println(l);
        System.out.println(r);
        if (u.intValue() == d.intValue()){
            if (l.intValue() == r.intValue()){
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TournamentTree obj = new TournamentTree();
		/*HashMap<Integer, List<Integer>> losersMap = new HashMap<Integer, List<Integer>>();
		List<Integer> players = new ArrayList<Integer>();
		int a[] = {10,9,8,2,4,11,5,3,6,7,1,31,43,33,50,49};
		for (int i : a) {
			players.add(i);
		}
		obj.bestPlayer(players);
		System.out.println("Best player = "+obj.bestPlayer);
		System.out.println(obj.losersOfPlayers.get(obj.bestPlayer));
		obj.bestPlayer(obj.losersOfPlayers.get(obj.bestPlayer));
		System.out.println("Second Best player = "+obj.bestPlayer);
		System.out.println("Number of matches = "+obj.matches);
		Double nlognminus2 = a.length + (Math.log10(a.length)/Math.log10(2)) - 2;
		System.out.println(nlognminus2);*/
		String moves = "RULDDLLDLRDUUUURULRURRRRLRULRLULLLRRULULDDRDLRULDRRULLUDDURDLRRUDRUDDURLLLUUDULRUDRLURRDRLLDDLLLDLRLLRUUDUURDRLDUDRUDRLUDULRLUDRLDDUULDDLDURULUDUUDDRRDUURRLRDLDLRLLDRRUUURDLULLURRRRDRRURDUURDLRRUULRURRUULULUUDURUDLRDDDDDURRRLRUDRUULUUUULDURDRULLRRRUDDDUUULUURRDRDDRLLDRLDULDLUUDRDLULLDLDDRUUUUDDRRRDLLLLURUURLRUUULRDDULUULUURDURDDDRRURLURDLLLRLULRDLDDLRDRRRRLUURRRRLDUDLLRUDLDRDLDRUULDRDULRULRRDLDLLLUDLDLULLDURUURRLLULUURLRLRDUDULLDURRUDDLDDLLUDURLLRLDLDUDLURLLDRRURRDUDLDUULDUDRRUDULLUUDURRRURLULDDLRRURULUURURRDULUULDDDUUDRLDDRLULDUDDLLLDLDURDLRLUURDDRLUDRLUDLRRLUUULLDUUDUDURRUULLDDUDLURRDDLURLDRDRUDRLDDLDULDRULUDRRDRLLUURULURRRUDRLLUURULURRLUULRDDDRDDLDRLDRLDUDRLDRLDDLDUDDURUDUDDDLRRDLUUUDUDURLRDRURUDUDDRDRRLUDURULDULDDRLDLUURUULUDRLRLRLLLLRLDRURRRUULRDURDRRDDURULLRDUDRLULRRLLLDRLRLRRDULDDUDUURLRULUUUULURULDLDRDRLDDLRLURRUULRRLDULLUULUDUDRLDUDRDLLDULURLUDDUURULDURRUURLRDRRRLDDULLLLDDRRLRRDRDLRUDUUDLRLDRDRURULDLULRRDLLURDLLDLRDRURLRUDURDRRRULURDRURLDRRRDUDUDUDURUUUUULURDUDDRRDULRDDLULRDRULDRUURRURLUDDDDLDRLDLLLLRLDRLRDRRRLLDRDRUULURLDRULLDRRDUUDLURLLDULDUUDLRRRDDUDRLDULRDLLULRRUURRRURLRRLDDUDDLULRUDULDULRDUDRLRDULRUUDDRUURUDLDRDUDDUULLUDDLLRLURURLRRULLDDDLURDRRDLLLLULLDLUDDLURLLDDRLDLLDDRDRDDUDLDURLUUUUUDLLLRLDULDDRDDDDRUDLULDRRLLLDUUUDDDRDDLLULUULRRULRUDRURDDULURDRRURUULDDDDUULLLURRRRDLDDLRLDDDRLUUDRDDRDDLUDLUUULLDLRDLURRRLRDRLURUURLULLLLRDDLLLLRUDURRLDURULURULDDRULUDRLDRLLURURRRDURURDRRUDLDDLLRRDRDDLRLRLUDUDRRUDLLDUURUURRDUDLRRLRURUDURDLRRULLDLLUDURUDDRUDULLDUDRRDDUDLLLDLRDRUURLLDLDRDDLDLLUDRDDRUUUDDULRUULRDRUDUURRRURUDLURLRDDLUULRDULRDURLLRDDDRRUDDUDUDLLDDRRUUDURDLLUURDLRULULDULRUURUDRULDRDULLULRRDDLDRDLLLDULRRDDLDRDLLRDDRLUUULUURULRULRUDULRULRUURUDUUDLDUDUUURLLURDDDUDUDLRLULDLDUDUULULLRDUDLDRUDRUULRURDDLDDRDULRLRLRRRRLRULDLLLDDRLUDLULLUUDLDRRLUDULRDRLLRRRULRLRLLUDRUUDUDDLRLDRDDDDRDLDRURULULRUURLRDLLDDRLLRUDRRDDRDUDULRUDULURRUDRDLRDUUDDLDRUDLLDDLRLULLLRUUDRRRRUULLRLLULURLDUDDURLRULULDLDRURDRLLURRDLURRURLULDLRLDUDLULLLDRDLULDLRULLLUDUDUDUDLDDDDDRDLUDUULLUDRLUURDRLULD";
		Boolean t = obj.judgeCircle(moves);
		
		
	}

}
