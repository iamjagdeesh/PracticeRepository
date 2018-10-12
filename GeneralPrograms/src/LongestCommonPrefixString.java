
public class LongestCommonPrefixString {

	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        char[] common = {'a','b'};
        int len = 0;
        char[] str;
        for(int i=0; i<strs.length; i++) {
            if(i == 0) {
                common = strs[i].toCharArray();
                len = common.length;
                continue;
            }
            if(len == 0) {
                break;
            }
            str = strs[i].toCharArray();
            int j=0;
            for(j=0; j<len && j<str.length; j++) {
                if(str[j] != common[j]) {
                    len = j;
                    break;
                }
            }
            if(j>=str.length) {
                len = j;
            }
        }
        return strs[0].substring(0,len);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefixString lcps = new LongestCommonPrefixString();
		String[] strs = {"asd", "as"};
		String s = lcps.longestCommonPrefix(strs);
		System.out.println(s);
	}

}
