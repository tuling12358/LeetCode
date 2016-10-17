import java.util.HashSet;

/**
 * 使用hashset 求最长字符串
 * @author tuling12358
 *
 */
public class LongestSubstringWithHashSet {

	public int lengthOfLongestSubstring(String x){
		if(x == null || x.length() == 0){
			return 0;
		}
		int i = 0;
		int start = 0;
		int max = 0;	//用来保存最大值
		HashSet<Character> set = new HashSet<Character>();
		while(i < x.length()){
			char c = x.charAt(i);
			if(!set.contains(c)){	//如果 set 中没有c,则添加到set
				set.add(c);
			}else{	// set 中已经有 c
				max = Math.max(max, set.size());
				while(start < i && x.charAt(start)!= c){
					set.remove(x.charAt(start));
					start++;
				}
				start++;
			}
			i++ ;
		}
		max = Math.max(max, set.size());
		return max;
	}
	
	public static void main(String[] args){
		
		LongestSubstringWithHashSet demo = new LongestSubstringWithHashSet();
		String str = "afdasfd";
		int length = demo.lengthOfLongestSubstring(str);
		System.out.println(length);
	}
}
