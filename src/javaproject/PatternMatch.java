package javaproject;

import java.util.HashMap;
import java.util.Stack;

public class PatternMatch {

	class Solution {
	    public boolean isValid(String s) {
	        
	        if(s!=null && s!=""){
          
                Stack<Character> st = new Stack<Character>();
               // st.push(s.charAt(0));
                
                    for(int i =0 ; i<s.length(); i++){
                    	char ch = s.charAt(i);
                    	if('n'!=getMatch(ch)) {
                    		if(st.isEmpty() || st.pop()!=getMatch(ch)) {//()
                    			//if(st.isEmpty()) 
                    				return false;
                    			//st.pop();
                    		}
                    	}else {
                    		st.push(ch);
                    	}
                    }
                    return st.isEmpty();
                    
	              }
			return false;
	    }
	    public char getMatch(char pat){
	        Character c = null;
	        /*if('('==pat) return new Character(')');
	        if('{'==pat) return new Character('}');
	        if('['==pat) return new Character(']');*/
	        if(')'==pat) return new Character('(');
	        if('}'==pat) return new Character('{');
	        if(']'==pat) return new Character('[');
	        return 'n';
	    }
	}
	public static void main(String[] args) {
		PatternMatch sl = new PatternMatch();
		String pat = "()";
		System.out.println(sl.isValid(pat));
		System.out.println(sl.new Solution().isValid(pat));

	}

	 public boolean isValid(String s) {
	        HashMap<Character,Character> maps=new HashMap<Character,Character>();
	        maps.put(')','(');
	        maps.put(']','[');
	        maps.put('}','{');
	        Stack<Character> stack=new Stack<Character>();
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            if(maps.containsKey(c)){
	                if(stack.empty()||stack.pop()!=maps.get(c))
	                	return false;
	            }
	            else
	                stack.push(c);
	        }
	        return stack.empty();
	    }
	}

