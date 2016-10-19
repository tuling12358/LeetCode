
/**
  Write a function to find the longest common prefix string amongst an array of strings.
  
*/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length < 2){
            return strs[0];
        }
        
        String minLengthString = strs[0];
        int minLengthStringIndex = 0;
        int minLengthStringLength = strs[0].length();
        boolean flag = true;
        //找到长度最小的字符串
        for(int i = 1;i<strs.length;i++){
            if(minLengthStringLength > strs[i].length()){
                minLengthString = strs[i];
                minLengthStringIndex = i;
                minLengthStringLength = strs[i].length();
            }
        }
           // 使用最小的字符串依次去和其余字符串比较，所有字符串均以最小字符串开始，则结果为最小的字符串
           // 若其余字符串中存在不以最小字符串开头的，则 重新计算最小字符串，方法为当前字符串长度减一后的字符串，依次类推
           while(minLengthStringLength != 0 && flag){
               boolean global = false;
               for(int j=0;j<strs.length;j++){
                    if(j == minLengthStringIndex && j != (strs.length -1)){
                        continue;
                    }
                    if(! (strs[j].startsWith(minLengthString))){
                        if(minLengthStringLength <=1){
                            minLengthString = "";
                        }else{
                            minLengthStringLength--;
                            minLengthString = minLengthString.substring(0,minLengthStringLength);
                        }
                        
                        break;
                    }else{
                       if(j == (strs.length -1)){
                            flag = false;
                       }
                    }
                    
                }
          }
         return  minLengthString;
    }
}
