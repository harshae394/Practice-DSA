package assignment7;

public class Lab {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	int K = 1000000007;
	String s1 = "smart yekicmsmartplrplsmartrplplmrpsmartrpsmartwmrmsmartsmart";
	//s1 = "interviews interviewseiwcombvinterviewskrenlzp";
	s1 = "ds dsasajdsrjdsjdsjjj";
	s1 = "algo yalgoalgoalgopalgoaxalgoasaxalgolalgoalgoalgo";
	int res = patternMatchv2(s1.split(" ")[0],s1.split(" ")[1]);
		//patternMatch("dsfdfdsfds","ds");
	System.out.println(res);
	
    }
   /* private static int patternMatch(String A,String B){
        int res = 0;
        int N = A.length();//Whole String
        int M = B.length();//search String
        int K = 1000000007;
        int primearr[] = new int[M+1];
        primearr[0]=1;
        int pNum = 57;
        for(int i = 1; i<M;i++){
             primearr[i]= (primearr[i-1]*pNum)%K;
        }
        //for(int i =0; i<M; i++)
        //System.out.print(primearr[i]+" ");
       // System.out.println();
        long ha = 0l; long hb=0l;
        
        for(int i=0; i<M;i++){
            hb = (hb+ ( B.charAt(i) * primearr[M-i]) )%K; //Fixed search String
            System.out.println("searchString:  hb: "+hb);
        }
       
        for(int i= 0; i <M;i++){
            ha = (ha + ( A.charAt(i) * primearr[M-i]) )%K;//window 
        }
      
        if(ha==hb) res++;
        for(int i=M; i<N ;i++){
            ha = ( ( ( ha - A.charAt(i-M)*primearr[M] + A.charAt(i) )*pNum )%K + K )%K;
            hb = (hb * pNum) % K;
            if(ha==hb) res++;
            //System.out.println("wholeString: "+ha);
        }
        return res;
    }*/
    
    public static int patternMatchV1(String s1, String s2) {

	int M = s1.length();//Whole String
	int  N = s2.length();//search String
	int k = 1000000007;
	int PR[] = new int[M + 1];
	int P = 5;
	PR[0] = 1;
	for (int i = 1; i <=M; i++) {
	    PR[i] = (PR[i - 1] * P) % k;
	}

	long hashS1 = 0;
	long hashS2 = 0;
	for (int i = 0; i < M; i++) {
	    hashS1 = (hashS1 + (PR[M-i] * (int)(s1.charAt(i)))) % k;
	    hashS2 = (hashS2 + (PR[M-i] * (int)(s2.charAt(i)))) % k;
	}
	int count = 0;

	if (hashS2 == hashS1) {
	    count++;
	}

	for (int i = M; i < N; i++) {

	    // System.out.println("hashA =::"+hashA +" hashB::"+ hashB+
	    // "::i="+i+"::PR[M]=="+PR[M]);

	    System.out.println(hashS1 +" == " + hashS2 + "::i=" + (i - M + 1));
	    hashS2 = (((hashS2 - (s2.charAt(i - M) * PR[M]) + s2.charAt(i)) * P) % k + k) % k;
	    if (hashS2 == hashS1) {
		//System.out.println(hashS1 +" == " + hashS2 + "::i=" + (i - M + 1));
		count++;
	    }
	}
	return count;
    }
    
    private static int patternMatchv2(String B,String A) {
	long hA=0,haB=0;
	long prime=2;
	long prime1 = prime;
	int cnt=0;
	int mod=1000000009;
	int m=B.length(); //search string
	int n=A.length(); //given String
	 
	    for(int i=0;i<=m-1;i++)
	    {
	        hA = (hA%mod + ((A.charAt(i)*prime1)%mod)%mod);
	        haB = ( haB%mod + ((B.charAt(i)*prime1)%mod)%mod);
	       // System.out.println(haB +" = "+hA +", prime1 = "+prime1);
	        prime1= (prime1*prime)%mod;
	    }
	    
	     //for(int i=0;i<=m-1;i++) { haB = ( haB%mod + ((B.charAt(i)*prime)%mod)%mod); }
	     
	    if(hA==haB) cnt++;
	    long prime2 = prime;
	    long prime3 = prime1;
	    //System.out.println("haB = "+haB+", prime2 = "+prime2 +", prime3 = "+prime3);
	  // System.out.println("************");//dsasajdsrjjdsjjj
	    for(int i=m;i<n;i++)
	    {
		 //System.out.println("ha = "+hA +", i-m : "+A.charAt(i - m)+" = "+(A.charAt(i - m) * prime2) % mod+",i : "+A.charAt(i) +" = "+ (A.charAt(i) * prime3) % mod);
		hA = ((hA - ((A.charAt(i - m) * prime2) % mod) + (A.charAt(i) * prime3) % mod) + mod)% mod;
		//hA = (hA/prime1)%mod;
		haB= ((haB%mod)*(prime))%mod;
	        prime2 = ( (prime2 ) * (prime))%mod;//4 8 16 32 64
	        prime3 = ( (prime3 ) * (prime))%mod;//4 8 16 32 64
	        System.out.println(haB +" = "+hA);
	        if(hA==haB) {
	           // System.out.println("**match**");
	            cnt++;
	        }
	    }
	    return cnt;
    }
    
    
}
