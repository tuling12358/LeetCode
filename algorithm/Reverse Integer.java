/**
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class Solution {
    public int reverse(int x) {
        String str = x+"";
        char[] ch = null;
        StringBuilder sb = new StringBuilder();
        if(str.substring(0,1).matches("[-+]")){
            sb.append(str.substring(0,1));
            ch = str.substring(1,str.length()).toCharArray();
        }else{
            ch = str.toCharArray();
        }
        for(int i=ch.length -1;i>=0;i--){
            sb.append(ch[i]);
        }
        // 防止溢出
        long newx = Long.parseLong(sb.toString());
        // 溢出则返回0
        if(newx > Integer.MAX_VALUE || newx < Integer.MIN_VALUE ){
            newx = 0;
        }
        return (int)newx; 
    }
}
