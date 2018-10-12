import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dates {

	public static int compareDates(String d1, String d2) {

		Map<String, Integer> monthMap = new HashMap<String, Integer>();
		monthMap.put("Jan", 1);
		String[] date1 = d1.split(" ");
		String[] date2 = d2.split(" ");

		return 0;
	}

	public static List<String> sortDates(List<String> dates) {

		Map<String, String> map = new HashMap<>();
		map.put("Jan", "01");
		map.put("Feb", "02");
		map.put("Mar", "03");
		map.put("Apr", "04");
		map.put("May", "05");
		map.put("Jun", "06");
		map.put("Jul", "07");
		map.put("Aug", "08");
		map.put("Sep", "09");
		map.put("Oct", "10");
		map.put("Nov", "11");
		map.put("Dec", "12");

		List<String> list = new ArrayList<>();
		int i = 0;

		for (String date : dates) {
			String newDate = date.substring(0, 2) + "-" + map.get(date.substring(3, 6)) + "-" + date.substring(7);
			list.add(newDate);
		}

		Collections.sort(list, new Comparator<String>() {
			private SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");

			@Override
			public int compare(String o1, String o2) {
				int result = -1;

				try {
					result = sdf.parse(o1).compareTo(sdf.parse(o2));
				} catch (ParseException ex) {
					ex.printStackTrace();
				}

				return result;
			}
		});

		List<String> res = new ArrayList<>();

		for (String s : list) {
			String key = getKey(map, s.substring(3, 5));
			s = s.substring(0,3) + key + s.substring(5);
			//s = s.replace(s.substring(3, 5), key);
			s = s.replace('-', ' ');
			res.add(s);
		}

		return res;
	}

	public static String getKey(Map<String, String> hm, String value) {
		for (String o : hm.keySet()) {
			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dates = new ArrayList<String>();
		dates.add("07 Jun 2016");
		dates.add("06 Jun 2016");
		dates = sortDates(dates);
		System.out.println(dates);
	}

}
