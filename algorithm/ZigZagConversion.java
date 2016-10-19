
/**
  锯齿形字符串
*/
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <=numRows || numRows <=1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        //第0行，同一行中，两个字符的下标间隔为 2*(numRows -1)，因此后一个字符的 下标=前一个字符的下标+(numRows -1)*2, 最后一行同理
        for(int i=0;i<s.length();i+=(numRows-1)*2){
            sb.append(s.charAt(i));
        }
        
        //中间行
        for(int i=1;i<numRows -1;i++){
            for(int j=i;j<s.length();j+=(numRows-1)*2){
                sb.append(s.charAt(j));
                if((j+(numRows-1-i)*2) < s.length()){ //中间行，下标在 j+(numRows-1)*2 和 j+(numRows -1-i)*2 之间切换，画图看，字符下标从0开始，依次往后，然后找规律
                    sb.append(s.charAt(j+(numRows-1-i)*2));
                }
            }
        }
        
        //最后一行，同一行中，两个字符的下标间隔为 2*(numRows -1)，因此后一个字符的 下标=前一个字符的下标+(numRows -1)*2
        for(int i = numRows -1;i<s.length();i+=(numRows-1)*2){
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
