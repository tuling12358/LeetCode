public class StringToInteger {

	public int myAtoi(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		//最终结果
		int finalResult = 0;
		//去除空格
		String str = s.trim();
		String temp = null;
		//符合数字格式
		if(isDight(str)){
			StringBuilder sb = new StringBuilder();
			//如果首位时 - 或 + 
			if(str.substring(0, 1).matches("[-+]")){
				sb.append(str.substring(0, 1));
				//剩余部分
				sb.append(str.substring(1));
				temp = sb.toString();
			}else{
				temp = str;
			}
			//判断是否溢出
			finalResult = OverFlow(temp);
		}else{	//不符合数字格式
			//判断是否有连续的数字
			temp = str;
			finalResult = returnLianXiShuZi(temp);
			if(temp.substring(0,1).matches("[-]")){
			      finalResult = 0 - finalResult;  
			}
			if(finalResult < Integer.MIN_VALUE){
			    finalResult = Integer.MIN_VALUE;
			}
			if(finalResult > Integer.MAX_VALUE){
			    finalResult = Integer.MAX_VALUE;
			}
			
		}
		return finalResult;
	}
	
	/**
	 * 判断是否符合数字格式
	 * @param s
	 * @return
	 */
	private boolean isDight(String s){
		char[] ch = s.toCharArray();
		boolean flag = true;
		int i = 0;
		while(i < ch.length){
			char c = ch[i];
			if(! Character.isDigit(c)){
				if(i == 0 && (c == '-' || c == '+')){
					if(s.length() > 1){	//判断是否仅有- 或 +
						i++;
						continue;
					}else{
						flag = false;
					}
					
				}else{
					flag = false;
					break;
				}
			}
			i++;
		}
		return flag;
	}
	
	/**
	 * 判断是否溢出
	 * @param s
	 * @return
	 */
	private int isOverFlow(String s, char c){
	    if(s.length() >= (Long.MAX_VALUE+"").length()){
	        return Integer.MAX_VALUE;
	    }
		long max = Long.parseLong(s);
		if(c == '-'){
		    max = 0 - max;
		}
		int result = 0;
		if(max < Integer.MIN_VALUE){
			result = Integer.MIN_VALUE;
		}else if(max > Integer.MAX_VALUE){
			result = Integer.MAX_VALUE;
		}else{
			result = Integer.parseInt(s);
		}
		return result;
	}
	
	private int OverFlow(String s){
	    if(s.length() >= (Long.MAX_VALUE+"").length()){
	        if(s.charAt(0) == '-'){
	            return Integer.MIN_VALUE;
	        }else{
	            return Integer.MAX_VALUE;
	        }
	    }
		long max = Long.parseLong(s);
		int result = 0;
		if(max < Integer.MIN_VALUE){
			result = Integer.MIN_VALUE;
		}else if(max > Integer.MAX_VALUE){
			result = Integer.MAX_VALUE;
		}else{
			result = Integer.parseInt(s);
		}
		return result;
	}
	
	
	private int returnLianXiShuZi(String s){
		StringBuilder sb = new StringBuilder();
		int result = 0;
			int i = 0;
			while(i < s.length()){
				char c = s.charAt(i);
				if(Character.isDigit(c)){
					i++;
					sb.append(c);
				}else{
					if(sb.length() >=1){
					    result = isOverFlow(sb.toString(),s.charAt(0));
						break;
					}else{
						sb.setLength(0);
						i++;
					}
				}
			}
		
	    return result;
	}
}
