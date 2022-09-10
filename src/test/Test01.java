package test;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "134452X-/-1X 2/--36";
		// "13 44 52 X -/ -1 X 2/ -- 36";
		//frame = 2*rolls
		int score = 0;
		//17x+10+2 next rolls
		//4 + 8 +7+10+10+10+1+10+10+2+8+3+6=91
		//4+8+7=>17+10--+10+1+10+2+10+9
		Map<Character,Integer> map = new HashMap<>();
		map.put('X', 20);
		map.put('/', 10);
		map.put('-', 0);
		int frame = 0;
		int cnt = 0;
		for(int i = 0; i<str.length() ; i++) {
			if(frame==2) {
				frame =0;
				cnt=0;
			}
			String strike = str.charAt(i)+"";
			if(strike.equalsIgnoreCase("XX") ) {
				cnt+= map.get(str.charAt(i));
				cnt = cnt>10 ?10:cnt;
			}
			if(strike.equalsIgnoreCase("//")) {
				cnt+= map.get(str.charAt(i));
				cnt = cnt>10 ?10:cnt; 
			}
			cnt+= str.charAt(i);
			
			frame++;
			score = cnt;
		}
		System.out.println(score);
		

	}

}
