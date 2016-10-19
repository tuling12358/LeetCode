/**
  判断一个 Integer 是否是回文
  e.g. 12321，  123321
*/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String sx = x+"";
        boolean flag = true;
        // 计算比较的次数
        int length = sx.length()/2;
        // sx.length() -1 -i  表示与i 对应的末尾的索引
        for(int i=0;i< length;i++){
            if(sx.charAt(i) != (sx.charAt(sx.length()-1-i))){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
